/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.time.CorporateTimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.security.AccessCheck;
import info.yalamanchili.office.template.TemplateService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class CorporateTimeService {

    @Autowired
    protected CorporateTimeSheetDao corporateTimeSheetDao;

    public void submitLeaveRequest(CorporateTimeSheet entity) {
        validateRequest(entity);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        vars.put("summary", getYearlySummary(emp));
        if (entity.getId() != null) {
            vars.put("status", "update");
        }
        vars.put("notifyEmployees", entity.getNotifyEmployees());
        OfficeBPMService.instance().startProcess("corp_emp_leave_request_process", vars);
    }

    protected void validateRequest(CorporateTimeSheet entity) {
        if (entity.getStartDate().after(DateUtils.getNextMonth(new Date(), 11)) || entity.getStartDate().before(DateUtils.getNextMonth(new Date(), -11))) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.startdate", "Start Date Invalid");
        }
        if (entity.getEndDate().after(DateUtils.getNextMonth(new Date(), 11)) || entity.getEndDate().before(DateUtils.getNextMonth(new Date(), -11))) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.enddate", "End Date Invalid ");
        }
    }

    public void updateLeaveRequest(CorporateTimeSheet entity) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        //delete cancel request is exists
        taskService.deleteTasksWithVariable("entityId", entity.getId(), "corpEmpLeaveRequestCancelTask", true);
        submitLeaveRequest(entity);
    }

    public void cancelLeaveRequest(Long timesheetId, String cancelReason) {
        CorporateTimeSheet ts = corporateTimeSheetDao.findById(timesheetId);
        validateExistingCanelRequests(timesheetId);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", ts);
        vars.put("entityId", ts.getId());
        vars.put("cancelReason", cancelReason);
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        vars.put("summary", getYearlySummary(emp));
        OfficeBPMService.instance().startProcess("corp_emp_leave_cancel_request", vars);

    }

    protected void validateExistingCanelRequests(Long tsId) {
        List<Task> tasks = OfficeBPMTaskService.instance().findTasksWithVariable("entityId", tsId);
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("corpEmpLeaveRequestCancelTask")) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cancel.request.pending", "Cancel Request Already Submitted ");
            }
        }
    }

    public CorporateTimeSummary getYearlySummary(Employee employee) {
        CorporateTimeSummary summary = new CorporateTimeSummary();
        //vacation
        summary.setTotalVacationHours(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_Earned, TimeSheetStatus.Approved, new Date()));
        summary.setUsedVacationHours(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_Spent, TimeSheetStatus.Approved, new Date()));
        summary.setAvailableVacationHours(getYearlyVacationBalance(employee, new Date()));
        //PTO
        summary.setTotalPTOHours(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_Earned, TimeSheetStatus.Approved, new Date()));
        summary.setUsedPTOHours(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_Spent, TimeSheetStatus.Approved, new Date()));
        summary.setAvailablePTOHours(getYearlyPeronalBalance(employee));
        //Total
        summary.setTotalAccumulatedHours(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.getEarnedCategories(), TimeSheetStatus.Approved, new Date()));
        summary.setTotalUsedHours(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.getLeaveSpentCheckedCategories(), TimeSheetStatus.Approved, new Date()));
//        summary.setTotalAvailableHours(summary.getTotalAccumulatedHours().subtract(summary.getTotalUsedHours()));
//        summary.setAvailablePTOHours(getYearlyPeronalBalance(employee));
//        summary.setAvailableVacationHours(getYearlyVacationBalance(employee, new Date()));
        summary.setUsedUnpaidHours(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Unpaid, TimeSheetStatus.Approved, new Date()));
        summary.setEmployee(employee.getFirstName() + " " + employee.getLastName());
        summary.setStartDate(employee.getStartDate());
        return summary;
    }

    public BigDecimal getYearlyPeronalBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_Earned, TimeSheetStatus.Approved, new Date());
        BigDecimal spent = corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_Spent, TimeSheetStatus.Approved, new Date());
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyVacationBalance(Employee employee, Date yearDate) {
        BigDecimal vacationEarned = corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_Earned, TimeSheetStatus.Approved, yearDate);
        BigDecimal vacationCarryForward = corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_CarryForward, TimeSheetStatus.Approved, yearDate);
        BigDecimal spent = corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_Spent, TimeSheetStatus.Approved, yearDate);
        return vacationEarned.add(vacationCarryForward).subtract(spent);
    }

    @AccessCheck(employeePropertyName = "employee", companyContacts = {"Reports_To"}, roles = {"ROLE_HR_ADMINSTRATION", "ROLE_CORPORATE_TIME_REPORTS"})
    public Response getReport(CorporateTimeSheet ts) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", ts);
        vars.put("summary", getYearlySummary(ts.getEmployee()));
        String report = TemplateService.instance().process("corp-timesheet.xhtml", vars);
        byte[] pdf = PDFUtils.convertToPDF(report);
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = corp-timesheet.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    @Async
    @Transactional(readOnly = true)
    public void getAllEmployeesSummaryReport(String email) {
        List<CorporateTimeSummary> summary = new ArrayList<CorporateTimeSummary>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee")) {
            summary.add(getYearlySummary(emp));
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(summary, "corporate-time-summary", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    public static CorporateTimeService instance() {
        return SpringContext.getBean(CorporateTimeService.class);
    }
}
