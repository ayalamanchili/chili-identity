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
import info.yalamanchili.office.dao.profile.CompanyDao;
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
        Employee emp;
        Map<String, Object> vars = new HashMap<>();
        if (request.getEmployee().getId() != null) {
            emp = EmployeeDao.instance().findById(request.getEmployee().getId());
        } else {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        BigDecimal ptoAvailable = ConsultantTimeSheetDao.instance().getPTOAccruedTimeSheet(emp).getHours();
        BigDecimal ptoPending = ConsultantTimeSheetDao.instance().getHours(emp, TimeSheetCategory.PTO_USED, TimeSheetStatus.Pending);
        if (ptoAvailable.subtract(ptoPending).compareTo(BigDecimal.ONE) >= 0 && TimeSheetCategory.Unpaid.equals(request.getCategory())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "use.pto.hours", "Please use available PTO Hours before using Unpaid hours");
        }
        request.setEmployee(emp);

        vars.put("leaveRequest", request);
        vars.put("summary", getYearlySummary(emp));
        vars.put("currentEmployee", emp);
        vars.put("submittedBy", OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
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
        summary.setUsedPTOHours(String.valueOf(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_USED, TimeSheetStatus.Approved, DateUtils.getNextYear(new Date(), -1)).floatValue()));
        summary.setAvailablePTOHours(String.valueOf(consultantTimeSheetDao.getPTOAccruedTimeSheet(employee).getHours().floatValue()));
        summary.setTotalPTOHours(summary.getAvailablePTOHours());
        //Total
        summary.setTotalAccumulatedHours(String.valueOf(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.getEarnedCategories(), TimeSheetStatus.Approved, DateUtils.getNextYear(new Date(), -1)).floatValue()));
        summary.setTotalUsedHours(String.valueOf(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.getLeaveSpentCheckedCategories(), TimeSheetStatus.Approved, DateUtils.getNextYear(new Date(), -1)).floatValue()));

        summary.setUsedUnpaidHours(String.valueOf(consultantTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Unpaid, TimeSheetStatus.Approved, DateUtils.getNextYear(new Date(), -1)).floatValue()));
        summary.setEmployee(employee.getFirstName() + " " + employee.getLastName());
        if (employee.getStartDate() != null) {
            summary.setStartDate(new SimpleDateFormat("MM/dd/yyyy").format(employee.getStartDate()));
        }
        summary.setWorkStatus(employee.getWorkStatus());
        if (employee.getCompany() != null) {
            summary.setCompany(employee.getCompany());
        }
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
        data.setTemplateUrl("templates/pdf/assoc-ts-template.pdf");
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
        if (entity.getCreatedTimeStamp() != null) {
            data.getData().put("createdTimeStamp", new SimpleDateFormat("MM-dd-yyyy").format(entity.getCreatedTimeStamp()));
        }
        data.getData().put("notes", entity.getNotes());
        if (entity.getApprovedBy() != null) {
            Employee approver = employeeDao.findEmployeWithEmpId(entity.getApprovedBy());
            Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approverSignature", DateUtils.dateToCalendar(entity.getApprovedDate()), employeeDao.getPrimaryEmail(approver), null);
            data.getSignatures().add(approvedBysignature);
        }
        String empCompanyLogo = "";
        if (emp.getCompany() != null) {
            empCompanyLogo = emp.getCompany().getLogoURL().replace("entityId", emp.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);

        return Response.ok(pdf)
                .header("content-disposition", "filename = leave-request.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    @Async
    @Transactional(readOnly = true)
    public void getAllConsultantEmployeesSummaryReport(String email) {
        List<ConsultantTimeSummary> summary = new ArrayList<ConsultantTimeSummary>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Employee")) {
            summary.add(getYearlySummary(emp));
        }
        String[] columnOrder = new String[]{"employee", "startDate", "availablePTOHours", "usedPTOHours", "totalPTOHours", "usedUnpaidHours", "totalUsedHours"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(summary, "Consultants-Time-Summary", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);

    }

    public static ConsultantTimeService instance() {
        return SpringContext.getBean(ConsultantTimeService.class);
    }
}
