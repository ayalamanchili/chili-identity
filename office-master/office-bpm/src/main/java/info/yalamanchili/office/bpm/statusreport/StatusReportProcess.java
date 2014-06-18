/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.statusreport;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.client.StatusReportDao;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.client.ProjectStatus;
import info.yalamanchili.office.entity.client.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author prasanthi.p
 */
public class StatusReportProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        if ("create".equals(dt.getEventName())) {
            statusReportTaskCreated(dt);
        }
        if ("complete".equals(dt.getEventName())) {
            statusReportTaskCompleted(dt);
        }
    }

    private void statusReportTaskCreated(DelegateTask dt) {
        if (dt.getTaskDefinitionKey().equals("statusReportApprovalTask")) {
            saveStatusReport(dt);
            assignStatusReportTask(dt);
        }
        new GenericTaskCreateNotification().notify(dt);
    }

    private void statusReportTaskCompleted(DelegateTask dt) {
        StatusReport request = getRequestFromTask(dt);
        if (request == null) {
            return;
        }

        Employee currentUser = SecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(request.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.advancerequisition", "You cannot approve your status report task");
        }

        String notes = (String) dt.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, request);
        //Status
        String status = (String) dt.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            request.setStatus(ProjectStatus.Approved);
        } else {
            request.setStatus(ProjectStatus.Rejected);
        }
        new GenericTaskCompleteNotification().notify(dt);

    }

    private void saveStatusReport(DelegateTask dt) {
        Employee emp = (Employee) dt.getExecution().getVariable("currentEmployee");
        StatusReportDao dao = StatusReportDao.instance();
        StatusReport entity = (StatusReport) dt.getExecution().getVariable("entity");
        entity.setBpmProcessId(dt.getExecution().getProcessInstanceId());
        entity.setStatus(ProjectStatus.Pending);
        entity.setEmployee(emp);
        entity = dao.save(entity);
        dt.getExecution().setVariable("entity", entity);
        dt.getExecution().setVariable("entityId", entity.getId());
    }

    private void assignStatusReportTask(DelegateTask dt) {
        Employee emp = (Employee) dt.getExecution().getVariable("currentEmployee");
        if (emp.getEmployeeType().equals("Employee")) {
            dt.addCandidateUser(CompanyContactDao.instance().getReportsToContactForEmployee(emp).getEmployeeId());
        } else {
            dt.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_RELATIONSHIP.name());
        }
    }

    protected StatusReport getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return StatusReportDao.instance().findById(entityId);
        }
        return null;
    }
}
