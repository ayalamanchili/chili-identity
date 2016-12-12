/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.statusreport;

import com.google.gson.Gson;
import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.chili.bpm.types.Task;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.employee.statusreport.StatusReportDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.employee.statusreport.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.employee.statusreport.ReportDocument;
import info.yalamanchili.office.entity.employee.statusreport.StatusReportStage;
import info.yalamanchili.office.security.AccessCheck;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class StatusReportService {

    @Autowired
    protected StatusReportDao statusReportDao;

    public StatusReport read(Long id) {
        StatusReport entity = statusReportDao.findById(id);
        entity.setReportDocument(new Gson().fromJson(entity.getReport(), ReportDocument.class));
        return entity;
    }

    public String save(StatusReport entity, Boolean submitForApproval) {
        if (entity.getId() == null && statusReportDao.findByDates(entity) != null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "status.report.dates.invalid", "Status Report with the entered dates already exists");
        }
        Gson gson = new Gson();
        entity.setReport(gson.toJson(entity.getReportDocument()));
        entity = statusReportDao.save(entity);
        if (submitForApproval && (StatusReportStage.Pending_Employee_Correction.equals(entity.getStage()) || StatusReportStage.Saved.equals(entity.getStage()))) {
            entity.setStage(StatusReportStage.Pending_HR_Approval);
            String bpmProcessId = startStatusReportProcess(entity);
            entity.setBpmProcessId(bpmProcessId);
        }
        return entity.getId().toString();
    }

    public String startStatusReportProcess(StatusReport entity) {
        OfficeBPMTaskService.instance().deleteTasksWithVariable("entityId", entity.getId(), "statusReportApprovalTask", true);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entityId", entity.getId());
        vars.put("entity", entity);
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        return OfficeBPMService.instance().startProcess("status_report_approval_process", vars);
    }

    //TODO move to commons
    protected Task getTaskForTicket(StatusReport statusReport) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(statusReport.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        StatusReport ticket = statusReportDao.findById(id);
        Task task = getTaskForTicket(ticket);
        if (task != null) {
            OfficeBPMTaskService.instance().deleteTask(task.getId());
        }
        statusReportDao.delete(id);
    }

    @AccessCheck(employeePropertyName = "employee", companyContacts = {}, roles = {"ROLE_H1B_IMMIGRATION", "ROLE_RELATIONSHIP"})
    public Response getReport(StatusReport entity) {
        ReportDocument reportDocument = new Gson().fromJson(entity.getReport(), ReportDocument.class);
        PdfDocumentData data = new PdfDocumentData();
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        if (entity.getApprovedBy() != null) {
            Employee approver = employeeDao.findEmployeWithEmpId(entity.getApprovedBy());
            Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approvedBySignature", DateUtils.dateToCalendar(entity.getApprovedDate()), employeeDao.getPrimaryEmail(approver), null);
            data.getSignatures().add(approvedBysignature);
        }
        Employee preparedBy = employeeDao.findEmployeWithEmpId(entity.getPreparedBy());
        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "preparedBySignature", DateUtils.dateToCalendar(entity.getSubmittedDate()), employeeDao.getPrimaryEmail(preparedBy), null);
        data.getSignatures().add(preparedBysignature);
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.setTemplateUrl("/templates/pdf/status-report-template.pdf");
        if (preparedBy.getCompany() != null && preparedBy.getCompany().getName().equals(Company.TECHPILLARS)) {
            data.getData().put("title", "Monthly Task Report by " + prepareByStr + " (for Tech Pillars) ");
        } else if (preparedBy.getCompany() != null && preparedBy.getCompany().getName().equals(Company.CGS_INC)) {
            data.getData().put("title", "Monthly Task Report by " + prepareByStr + " (for CGS INC) ");
        } else {
            data.getData().put("title", "Monthly Task Report by " + prepareByStr + " (for System Soft Technologies LLC) ");
        }
        data.getData().put("projectDescription", reportDocument.getProjectDescription());
        data.getData().put("projectStatus", entity.getStatus().name());
        data.getData().put("projectDuration", new SimpleDateFormat("MM-dd-yyyy").format(entity.getReportStartDate()) + " - " + new SimpleDateFormat("MM-dd-yyyy").format(entity.getReportEndDate()));
        if (preparedBy.getCompany() != null && preparedBy.getCompany().getName().equals(Company.TECHPILLARS)) {
            data.getData().put("distribution", "Tech Pillars");
        } else if (preparedBy.getCompany() != null && preparedBy.getCompany().getName().equals(Company.CGS_INC)) {
            data.getData().put("distribution", "CGS INC");
        } else {
            data.getData().put("distribution", "System Soft Technologies LLC");
        }

        //Phase 1
        data.getData().put("projectPhase1Name", reportDocument.getProjectPhase1Name());
        data.getData().put("projectPhase1Deliverrable", reportDocument.getProjectPhase1Deliverable());
        data.getData().put("projectPhase1ComplationDate", reportDocument.getProjectPhase1EndDate());
        data.getData().put("projectPhase1Status", reportDocument.getProjectPhase1Status());
        //Phase 2
        data.getData().put("projectPhase2Name", reportDocument.getProjectPhase2Name());
        data.getData().put("projectPhase2Deliverrable", reportDocument.getProjectPhase2Deliverable());
        data.getData().put("projectPhase2ComplationDate", reportDocument.getProjectPhase2EndDate());
        data.getData().put("projectPhase2Status", reportDocument.getProjectPhase2Status());
        //Phase 3
        data.getData().put("projectPhase3Name", reportDocument.getProjectPhase3Name());
        data.getData().put("projectPhase3Deliverrable", reportDocument.getProjectPhase3Deliverable());
        data.getData().put("projectPhase3ComplationDate", reportDocument.getProjectPhase3EndDate());
        data.getData().put("projectPhase3Status", reportDocument.getProjectPhase3Status());
        //Phase 4
        data.getData().put("projectPhase4Name", reportDocument.getProjectPhase4Name());
        data.getData().put("projectPhase4Deliverrable", reportDocument.getProjectPhase4Deliverable());
        data.getData().put("projectPhase4ComplationDate", reportDocument.getProjectPhase4EndDate());
        data.getData().put("projectPhase4Status", reportDocument.getProjectPhase4Status());

        data.getData().put("status", reportDocument.getStatusDescription());
        data.getData().put("accomplishments", reportDocument.getAccomplishments());
        data.getData().put("scheduledActivities", reportDocument.getScheduledActivities());
        data.getData().put("preparedBy", prepareByStr);

        String empCompanyLogo = "";
        if (preparedBy.getCompany() != null) {
            empCompanyLogo = preparedBy.getCompany().getLogoURL().replace("entityId", preparedBy.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);

        return Response.ok(pdf)
                .header("content-disposition", "filename = status-report.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static StatusReportService instance() {
        return SpringContext.getBean(StatusReportService.class);
    }
}
