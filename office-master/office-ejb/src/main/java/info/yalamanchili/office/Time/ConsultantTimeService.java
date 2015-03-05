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
import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.reporting.ReportGenerator;
import info.chili.security.Signature;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.dao.time.SearchConsultantTimeSheetDto;
import info.yalamanchili.office.dto.time.ConsultantTimeSummary;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.security.AccessCheck;
import info.yalamanchili.office.template.TemplateService;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        vars.put("summary", getYearlySummary(emp));
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
        //PTO
        summary.setUsedPTOHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_USED, TimeSheetStatus.Approved, new Date()).floatValue());
        summary.setAvailablePTOHours(consultantTimeSheetDao.getPTOAccruedTimeSheet(employee).getHours().floatValue());
        summary.setTotalPTOHours(summary.getAvailablePTOHours());
        //Total
        summary.setTotalAccumulatedHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.getEarnedCategories(), TimeSheetStatus.Approved, new Date()).floatValue());
        summary.setTotalUsedHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.getLeaveSpentCheckedCategories(), TimeSheetStatus.Approved, new Date()).floatValue());

        summary.setUsedUnpaidHours(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Unpaid, TimeSheetStatus.Approved, new Date()).floatValue());
        summary.setEmployee(employee.getFirstName() + " " + employee.getLastName());
        summary.setStartDate(employee.getStartDate());
        return summary;
    }

    public BigDecimal getYearlyPeronalBalance(Employee employee) {
        BigDecimal earned = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_Earned, TimeSheetStatus.Approved, new Date());
        BigDecimal spent = consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_Spent, TimeSheetStatus.Approved, new Date());
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
        byte[] pdf = PDFUtils.convertToPDF(html);
        File file = new File(OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "consultant-time-report.pdf");
        try {
            Files.write(pdf, file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return Response.ok("consultant-time-report.pdf".getBytes()).header("content-disposition", "filename = consultant-time-report.pdf")
                .header("Content-Length", "consultant-time-report.pdf".length()).build();
    }

    @AccessCheck(employeePropertyName = "employee", companyContacts = {}, roles = {"ROLE_H1B_IMMIGRATION", "ROLE_CONSULTANT_TIME_REPORTS", "ROLE_CONSULTANT_TIME_ADMIN"})
    public Response getReport(ConsultantTimeSheet entity) {
        PdfDocumentData data = new PdfDocumentData();
        Employee emp = entity.getEmployee();
        if (emp.getCompany() != null && emp.getCompany().getName().equals("TechPillars")) {
            data.setTemplateUrl("/templates/pdf/assoc-ts-template-techp.pdf");
        } else {
            data.setTemplateUrl("templates/pdf/assoc-ts-template.pdf");
        }
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getCreatedTimeStamp()), employeeDao.getPrimaryEmail(preparedBy), null);
        data.getSignatures().add(preparedBysignature);
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("employeeName", prepareByStr);
        if (entity.getCreatedTimeStamp() != null) {
            data.getData().put("requestedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getCreatedTimeStamp()));
        }
        data.getData().put("startDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getStartDate()));
        data.getData().put("endDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getEndDate()));
        data.getData().put("createdTimeStamp", new SimpleDateFormat("MM-dd-yyyy").format(entity.getCreatedTimeStamp()));
        data.getData().put("notes", entity.getNotes());
        if (entity.getApprovedBy() != null) {
            Employee approver = employeeDao.findEmployeWithEmpId(entity.getApprovedBy());
            Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approverSignature", DateUtils.dateToCalendar(entity.getApprovedDate()), employeeDao.getPrimaryEmail(approver), null);
            data.getSignatures().add(approvedBysignature);
        }
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = leave-request.pdf")
                .header("Content-Length", pdf)
                .build();
    }

    @Async
    @Transactional(readOnly = true)
    public void getAllConsultantEmployeesSummaryReport(String email) {
        List<ConsultantTimeSummary> summary = new ArrayList<ConsultantTimeSummary>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Employee")) {
            summary.add(getYearlySummary(emp));
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(summary, "consultants-time-summary", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    public static ConsultantTimeService instance() {
        return SpringContext.getBean(ConsultantTimeService.class);
    }
}
