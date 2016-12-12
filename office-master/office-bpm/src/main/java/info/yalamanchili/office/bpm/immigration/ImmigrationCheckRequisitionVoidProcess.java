/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.immigration;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.expense.chkreq.ImmigrationCheckRequisitionDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisitionStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author radhika.mukkala
 */
public class ImmigrationCheckRequisitionVoidProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            immigrationCheckRequestVoidTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            immigrationCheckRequestVoidTaskCompleted(task);
        }
    }

    protected void immigrationCheckRequestVoidTaskCreated(DelegateTask task) {
        assignCheckVoidRequestTask(task);
        new GenericTaskCreateNotification().notifyWithMoreRoles(task, OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
    }

    protected void assignCheckVoidRequestTask(DelegateTask task) {
        task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name());
    }

    protected void immigrationCheckRequestVoidTaskCompleted(DelegateTask task) {
        ImmigrationCheckRequisition entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (entity.getEmployee() != null && currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.immigrationcheckrequisition", "You cannot approve your Immigration Check Requisition task");
        }
        String status = (String) task.getExecution().getVariable("status");
        if ("approved".equals(status)) {
            checkVoidRequestApproved(entity, task);
        } else {
            entity.setStatus(ImmigrationCheckRequisitionStatus.REJECTED);
        }
        ImmigrationCheckRequisitionDao.instance().save(entity);
        new GenericTaskCompleteNotification().notify(task);
    }

    protected void checkVoidRequestApproved(ImmigrationCheckRequisition entity, DelegateTask task) {
        entity.setStatus(ImmigrationCheckRequisitionStatus.VOIDED);
        entity.setApprovedBy(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
        entity.setApprovedDate(new Date());
    }

    protected ImmigrationCheckRequisition getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ImmigrationCheckRequisitionDao.instance().findById(entityId);
        }
        return null;
    }

}
