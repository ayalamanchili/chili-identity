/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import com.google.common.io.Files;
import info.chili.commons.PDFUtils;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.dao.time.SearchConsultantTimeSheetDto;
import info.yalamanchili.office.dto.time.ConsultantTimeSummary;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.template.TemplateService;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ws.rs.core.Response;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
public class ConsultantTimeService {

    @Autowired
    protected ConsultantTimeSheetDao consultantTimeSheetDao;

    public void submitLeaveRequest(ConsultantTimeSheet request) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        request.setEmployee(emp);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("leaveRequest", request);
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("consultant_emp_leave_request_process", vars);
    }
//TODO move to commons

    public void updateLeaveRequest(ConsultantTimeSheet entity) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        //delete cancel request is exists
        List<Task> tasks = taskService.findTasksWithVariable("entityId", entity.getId());
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("consultantEmpLeaveRequestCancelTask")) {
                taskService.deleteTask(task.getId());
            }
        }
        submitLeaveRequest(entity);
    }

    public void cancelLeaveRequest(Long timesheetId, String cancelReason) {
        ConsultantTimeSheet cts = consultantTimeSheetDao.findById(timesheetId);
        validateExistingCanelRequests(timesheetId);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", cts);
        vars.put("entityId", cts.getId());
        vars.put("cancelReason", cancelReason);
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("consultant_emp_leave_cancel_request", vars);
    }

    protected void validateExistingCanelRequests(Long tsId) {
        List<Task> tasks = OfficeBPMTaskService.instance().findTasksWithVariable("entityId", tsId);
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("consultantEmpLeaveRequestCancelTask")) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cancel.request.pending", "Cancel Request Already Submitted ");
            }
        }
    }

    public ConsultantTimeSummary getYearlySummary(Employee employee) {
        ConsultantTimeSummary summary = new ConsultantTimeSummary();
        //vacation
        summary.setTotalVacationHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_Earned, TimeSheetStatus.Approved, new Date()));
        summary.setUsedVacationHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_Spent, TimeSheetStatus.Approved, new Date()));
        summary.setAvailableVacationHours(getYearlyVacationBalance(employee, new Date()));
        //Personal
        summary.setTotalPersonalHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Personal_Earned, TimeSheetStatus.Approved, new Date()));
        summary.setUsedPersonalHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Personal_Spent, TimeSheetStatus.Approved, new Date()));
        summary.setAvailablePersonalHours(getYearlyPeronalBalance(employee));
        //Sick
        summary.setTotalSickHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Sick_Earned, TimeSheetStatus.Approved, new Date()));
        summary.setUsedSickHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Sick_Spent, TimeSheetStatus.Approved, new Date()));
        summary.setAvailableSickHours(getYearlySickBalance(employee));
        //Total
        summary.setTotalAccumulatedHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.getEarnedCategories(), TimeSheetStatus.Approved, new Date()));
        summary.setTotalUsedHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.getLeaveSpentCheckedCategories(), TimeSheetStatus.Approved, new Date()));
        summary.setTotalAvailableHours(summary.getTotalAccumulatedHours().subtract(summary.getTotalUsedHours()));

        summary.setUsedUnpaidHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Unpaid, TimeSheetStatus.Approved, new Date()));
        summary.setEmployee(employee.getFirstName() + " " + employee.getLastName());
        summary.setStartDate(employee.getStartDate());
        return summary;
    }

    public BigDecimal getYearlySickBalance(Employee employee) {
        BigDecimal earned = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Sick_Earned, TimeSheetStatus.Approved, new Date());
        BigDecimal spent = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Sick_Spent, TimeSheetStatus.Approved, new Date());
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyPeronalBalance(Employee employee) {
        BigDecimal earned = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Personal_Earned, TimeSheetStatus.Approved, new Date());
        BigDecimal spent = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Personal_Spent, TimeSheetStatus.Approved, new Date());
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyVacationBalance(Employee employee, Date yearDate) {
        BigDecimal vacationEarned = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_Earned, TimeSheetStatus.Approved, yearDate);
        BigDecimal vacationCarryForward = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_CarryForward, TimeSheetStatus.Approved, yearDate);
        BigDecimal spent = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Vacation_Spent, TimeSheetStatus.Approved, yearDate);
        return vacationEarned.add(vacationCarryForward).subtract(spent);
    }

    public Response getReport(SearchConsultantTimeSheetDto dto) {
        String html = TemplateService.instance().process("consultant-time-report.xhtml", consultantTimeSheetDao.getReport(dto, 0, 10000));
        return ReportGenerator.createPDFReportFromHtml(html, "consultant-time-report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot());
    }

    public Response getReport(Long id) {
        String report = TemplateService.instance().process("consultant-emp-timesheet.xhtml", consultantTimeSheetDao.findById(id));
        byte[] pdf = PDFUtils.convertToPDF(report);
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = timesheet.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    @Async
    @Transactional(readOnly = true)
    public void getAllConsultantEmployeesSummaryReport(Employee currentEmp) {
        List<ConsultantTimeSummary> summary = new ArrayList<ConsultantTimeSummary>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Employee")) {
            summary.add(getYearlySummary(emp));
        }
        Collections.sort(summary, new Comparator<ConsultantTimeSummary>() {
            @Override
            public int compare(ConsultantTimeSummary dto1, ConsultantTimeSummary dto2) {
                return dto1.getEmployee().compareTo(dto2.getEmployee());
            }
        });
        String report = TemplateService.instance().process("cons-emp-summary.xhtml", summary);
        String fileName = "all-consultants-report" + UUID.randomUUID().toString() + ".pdf";
        try {
            Files.write(PDFUtils.convertToPDF(report), new File(OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + fileName));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        MessagingService.instance().emailReport(fileName, PDFUtils.convertToPDF(report), currentEmp.getPrimaryEmail().getEmail());
    }

    public static ConsultantTimeService instance() {
        return SpringContext.getBean(ConsultantTimeService.class);
    }
}
