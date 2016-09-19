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
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.time.CorporateTimeSummary;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.security.AccessCheck;
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
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class CorporateTimeService {

    @Autowired
    protected CorporateTimeSheetDao corporateTimeSheetDao;

    public void submitLeaveRequest(CorporateTimeSheet entity) {
        Employee emp = null;
        Map<String, Object> vars = new HashMap<>();
        validateRequest(entity);
        if (entity.getEmployee().getId() != null) {
            emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
        } else {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        entity.setEmployee(emp);
        if (TimeSheetCategory.PTO_USED.equals(entity.getCategory())) {
            BigDecimal ptoAvailable = CorporateTimeSheetDao.instance().getPTOAccruedTimeSheet(emp).getHours();
            if (entity.getHours().doubleValue() > ptoAvailable.doubleValue()) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "insufficient.PTO.hours", "You may not have sufficient PTO");
            }
        }
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        vars.put("summary", getYearlySummary(emp));
        if (entity.getId() != null) {
            vars.put("status", "update");
        }
        vars.put("notifyEmployees", entity.getNotifyEmployees());
        OfficeBPMService.instance().startProcess("corp_emp_leave_request_process", vars);
    }

    public void categoryLeaveUpdateRequest(CorporateTimeSheet entity) {
        Employee emp = null;
        if (entity.getEmployee().getId() != null) {
            emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
        } else {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        if (Branch.Hyderabad.equals(emp.getBranch())) {
            if (TimeSheetCategory.PTO_ACCRUED.equals(entity.getCategory())) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "not.change.to.accrued", "You may not change category to Pto_Accrued");
            }
            OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
            submitLeaveRequest(entity);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "You don't have Access", "You don't have access");
        }
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
        Map<String, Object> vars = new HashMap<>();
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
        //PTO
        summary.setUsedPTOHours(String.valueOf(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.PTO_USED, TimeSheetStatus.Approved, new Date())));
        summary.setAvailablePTOHours(String.valueOf(corporateTimeSheetDao.getPTOAccruedTimeSheet(employee).getHours()));
        summary.setTotalAccumulatedPTOHours(String.valueOf(corporateTimeSheetDao.getPTOAccruedInYear(employee)));

        summary.setUsedUnpaidHours(String.valueOf(corporateTimeSheetDao.getHoursInYear(employee, TimeSheetCategory.Unpaid, TimeSheetStatus.Approved, new Date())));
        summary.setEmployee(employee.getFirstName() + " " + employee.getLastName());
        summary.setStartDate(new SimpleDateFormat("MM/dd/yyyy").format(employee.getStartDate()));
        return summary;
    }

    @AccessCheck(employeePropertyName = "employee", companyContacts = {"Reports_To"}, roles = {"ROLE_HR_ADMINSTRATION", "ROLE_CORPORATE_TIME_REPORTS"})
    public Response getReport(CorporateTimeSheet entity) {
        CorporateTimeSummary summary = getYearlySummary(entity.getEmployee());
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/corp-ts-template.pdf");
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getCreatedTimeStamp()), employeeDao.getPrimaryEmail(preparedBy), null);
        data.getSignatures().add(preparedBysignature);
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("employeeName", prepareByStr);
//        data.getData().put("totalPTOHours", summary);
        if (entity.getCreatedTimeStamp() != null) {
            data.getData().put("requestedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getCreatedTimeStamp()));
        }
        data.getData().put("startDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getStartDate()));
        data.getData().put("endDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getEndDate()));
        if (entity.getHours() != null) {
            data.getData().put("hours", entity.getHours().toString());
        }
        if (entity.getStatus() != null) {
            data.getData().put("status", entity.getStatus().toString());
        }
        if (entity.getCategory() != null) {
            data.getData().put("category", entity.getCategory().toString());
        }
        data.getData().put("notes", entity.getNotes());
        if (summary.getTotalAccumulatedPTOHours() != null) {
            data.getData().put("totalPTOHours", summary.getTotalAccumulatedPTOHours().toString());
        }
        if (summary.getAvailablePTOHours() != null) {
            data.getData().put("availablePTOHours", summary.getAvailablePTOHours().toString());
        }
        if (summary.getUsedPTOHours() != null) {
            data.getData().put("usedPTOHours", summary.getUsedPTOHours().toString());
        }
        if (entity.getApprovedBy() != null) {
            Employee approver = employeeDao.findEmployeWithEmpId(entity.getApprovedBy());
            Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approverSignature", DateUtils.dateToCalendar(entity.getCreatedTimeStamp()), employeeDao.getPrimaryEmail(approver), null);
            data.getSignatures().add(approvedBysignature);
        }
        String empCompanyLogo = "";
        if (preparedBy.getCompany() != null) {
            empCompanyLogo = preparedBy.getCompany().getLogoURL().replace("entityId", preparedBy.getCompany().getId().toString());
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
    public void getAllEmployeesSummaryReport(String email) {
        List<CorporateTimeSummary> summary = new ArrayList<>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE)) {
            summary.add(getYearlySummary(emp));
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(summary, "corporate-time-summary", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    public static CorporateTimeService instance() {
        return SpringContext.getBean(CorporateTimeService.class);
    }
}
