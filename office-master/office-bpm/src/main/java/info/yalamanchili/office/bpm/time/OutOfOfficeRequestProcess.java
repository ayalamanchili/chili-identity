/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.OutOfOfficeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.entity.time.OutOfOfficeRequestStatus;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author Ramana.Lukalapu
 */
public class OutOfOfficeRequestProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
        if ("complete".equals(task.getEventName())) {
            outOfOfficeTaskCompleted(task);
        }
    }

    protected void outOfOfficeTaskCompleted(DelegateTask task) {
        OutOfOfficeRequest entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.travelauthorization", "You cannot approve your travel authorization task");
        }
        if (task.getTaskDefinitionKey().equals("outOfOfficeMgrApprovalTask")) {
            managerApprovalTaskComplete(entity, task);
        }
    }

    protected void managerApprovalTaskComplete(OutOfOfficeRequest entity, DelegateTask task) {
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(OutOfOfficeRequestStatus.APPROVED);
        } else {
            entity.setStatus(OutOfOfficeRequestStatus.REJECTED);
        }
        OutOfOfficeDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
    }

    protected OutOfOfficeRequest getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return OutOfOfficeDao.instance().findById(entityId);
        }
        return null;
    }
}
