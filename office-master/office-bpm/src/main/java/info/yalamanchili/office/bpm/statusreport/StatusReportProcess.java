/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.statusreport;

import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.dao.employee.StatusReportDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.employee.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author prasanthi.p
 */
public class StatusReportProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        StatusReport request = getRequestFromTask(dt);
        if (request == null) {
            return;
        }
        Employee currentUser = SecurityService.instance().getCurrentUser();
        String notes = (String) dt.getExecution().getVariable("notes");
        String status = (String) dt.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            request.setApprovedBy(currentUser.getEmployeeId());
        }
        new GenericTaskCompleteNotification().notify(dt);
    }

    protected StatusReport getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return StatusReportDao.instance().findById(entityId);
        }
        return null;
    }
}
