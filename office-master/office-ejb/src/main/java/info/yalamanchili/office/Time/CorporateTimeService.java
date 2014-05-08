/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.commons.FileIOUtils;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dto.time.CorporateTimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.template.TemplateService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("request")
public class CorporateTimeService {

    @Autowired
    protected CorporateTimeSheetDao corporateTimeSheetDao;

    public void submitLeaveRequest(CorporateTimeSheet entity) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);
        Employee emp = SecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        vars.put("summary", getYearlySummary(emp));
        if (entity.getId() != null) {
            vars.put("status", "update");
        }
        OfficeBPMService.instance().startProcess("corp_emp_leave_request_process", vars);
    }

    public void updateLeaveRequest(CorporateTimeSheet entity) {
        entity.setStatus(TimeSheetStatus.Pending);
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        //delete cancel request is exists
        List<Task> tasks = taskService.findTasksWithVariable("entityId", entity.getId());
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("corpEmpLeaveRequestCancelTask")) {
                taskService.deleteTask(task.getId());
            }
        }
        submitLeaveRequest(entity);
    }

    public void cancelLeaveRequest(Long timesheetId) {
        CorporateTimeSheet ts = corporateTimeSheetDao.findById(timesheetId);
        List<Task> tasks = OfficeBPMTaskService.instance().findTasksWithVariable("entityId", ts.getId());
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("corpEmpLeaveRequestCancelTask")) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cancel.request.pending", "Cancel Request Already Submitted ");
            }
        }
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", ts);
        vars.put("entityId", ts.getId());
        Employee emp = SecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        vars.put("summary", getYearlySummary(emp));
        OfficeBPMService.instance().startProcess("corp_emp_leave_cancel_request", vars);

    }

    public CorporateTimeSummary getYearlySummary(Employee employee) {
        CorporateTimeSummary summary = new CorporateTimeSummary();
        summary.setAvailablePersonalHours(getYearlyPeronalBalance(employee));
        summary.setAvailableSickHours(getYearlySickBalance(employee));
        summary.setAvailableVacationHours(getYearlyVacationBalance(employee));
        summary.setUsedUnpaidHours(corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Unpaid, TimeSheetStatus.Approved));
        summary.setEmployee(employee.getFirstName() + " " + employee.getLastName());
        summary.setStartDate(employee.getStartDate());
        return summary;
    }

    public void checkAccessToEmployeeTime(Employee emp) {
        Employee currentUser = SecurityService.instance().getCurrentUser();
        if (emp.getEmployeeId().equals(currentUser.getEmployeeId())) {
            return;
        }
        Employee reportsToEmp = CompanyContactDao.instance().getReportsToContactForEmployee(emp);
        if (reportsToEmp != null && currentUser.getEmployeeId().equals(reportsToEmp.getEmployeeId())) {
            return;
        }
        if (SecurityService.instance().hasAnyRole(OfficeRole.ROLE_HR_ADMINSTRATION.name(), OfficeRole.ROLE_CORPORATE_TIME_REPORTS.name())) {
            return;
        }
        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "permission.error", "you do not have permission to view this information");
    }

    public BigDecimal getYearlySickBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Sick_Earned, TimeSheetStatus.Approved);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Sick_Spent, TimeSheetStatus.Approved);
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyPeronalBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Personal_Earned, TimeSheetStatus.Approved);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Personal_Spent, TimeSheetStatus.Approved);
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyVacationBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Vacation_Earned, TimeSheetStatus.Approved);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Vacation_Spent, TimeSheetStatus.Approved);
        return earned.subtract(spent);
    }

    public Response getReport(Long id) {
        String report = TemplateService.instance().process("corp-timesheet.xhtml", corporateTimeSheetDao.findById(id));
        byte[] pdf = FileIOUtils.convertToPDF(report);
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = corp-timesheet.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public Response getAllEmployeesSummaryReport() {
        List<CorporateTimeSummary> summary = new ArrayList<CorporateTimeSummary>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee")) {
            summary.add(getYearlySummary(emp));
        }
        String report = TemplateService.instance().process("corp-emp-summary.xhtml", summary);
        return ReportGenerator.generatePDFReportFromHtml(report);
    }

    public static CorporateTimeService instance() {
        return SpringContext.getBean(CorporateTimeService.class);
    }
}
