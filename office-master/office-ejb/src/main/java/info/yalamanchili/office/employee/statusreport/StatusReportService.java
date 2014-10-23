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
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.employee.statusreport.StatusReportDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.statusreport.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.employee.statusreport.StatusReportStage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
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

    public StatusReportDto read(Long id) {
        StatusReport entity = statusReportDao.findById(id);
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        StatusReportDto dto = mapper.map(new Gson().fromJson(entity.getReport(), StatusReportDto.class), StatusReportDto.class);
        mapper.map(entity, dto);
        return dto;
    }

    public String save(StatusReportDto dto, Boolean submitForApproval) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        StatusReport entity = mapper.map(dto, StatusReport.class);
        Gson gson = new Gson();
        entity.setReport(gson.toJson(dto));
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

    public Response getReport(Long id) {
        StatusReport entity = statusReportDao.findById(id);
        StatusReportDto reportDto = new Gson().fromJson(entity.getReport(), StatusReportDto.class);
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
        data.setTemplateUrl(OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "/templates/status-report-template.pdf");
        data.getData().put("title", "Monthly Task Report by " + prepareByStr + " (for System Soft Technologies LLC");
        data.getData().put("projectDescription", reportDto.getProjectDescription());
        data.getData().put("projectStatus", entity.getStatus().name());
        data.getData().put("projectDuration", entity.getReportStartDate() + " - " + entity.getReportEndDate());
        data.getData().put("distribution", "System Soft Technologies LLC");
        //Phase 1
        data.getData().put("projectPhase1Name", reportDto.getProjectPhase1Name());
        data.getData().put("projectPhase1Deliverrable", reportDto.getProjectPhase1Deliverable());
        data.getData().put("projectPhase1ComplationDate", reportDto.getProjectPhase1EndDate());
        data.getData().put("projectPhase1Status", reportDto.getProjectPhase1Status());
        //Phase 2
        data.getData().put("projectPhase2Name", reportDto.getProjectPhase2Name());
        data.getData().put("projectPhase2Deliverrable", reportDto.getProjectPhase2Deliverable());
        data.getData().put("projectPhase2ComplationDate", reportDto.getProjectPhase2EndDate());
        data.getData().put("projectPhase2Status", reportDto.getProjectPhase2Status());
        //Phase 3
        data.getData().put("projectPhase3Name", reportDto.getProjectPhase3Name());
        data.getData().put("projectPhase3Deliverrable", reportDto.getProjectPhase3Deliverable());
        data.getData().put("projectPhase3ComplationDate", reportDto.getProjectPhase3EndDate());
        data.getData().put("projectPhase3Status", reportDto.getProjectPhase3Status());
        //Phase 4
        data.getData().put("projectPhase4Name", reportDto.getProjectPhase4Name());
        data.getData().put("projectPhase4Deliverrable", reportDto.getProjectPhase4Deliverable());
        data.getData().put("projectPhase4ComplationDate", reportDto.getProjectPhase4EndDate());
        data.getData().put("projectPhase4Status", reportDto.getProjectPhase4Status());

        data.getData().put("status", reportDto.getStatusDescription());
        data.getData().put("accomplishments", reportDto.getAccomplishments());
        data.getData().put("scheduledActivities", reportDto.getScheduledActivities());
        data.getData().put("preparedBy", prepareByStr);

        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = status-report.pdf")
                .header("Content-Length", pdf)
                .build();
    }

    public static StatusReportService instance() {
        return SpringContext.getBean(StatusReportService.class
        );
    }
}
