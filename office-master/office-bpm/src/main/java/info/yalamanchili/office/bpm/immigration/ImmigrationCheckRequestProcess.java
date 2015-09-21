/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.immigration;

import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.dao.expense.chkreq.ImmigrationCheckRequisitionDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisitionStatus;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author Sadipan.B
 */
public class ImmigrationCheckRequestProcess extends RuleBasedTaskDelegateListner {

   @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
        if ("complete".equals(task.getEventName())) {
            immigrationCheckRequestTaskCompleted(task);
        }
    }

    protected void immigrationCheckRequestTaskCompleted(DelegateTask task) {
        ImmigrationCheckRequisition entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        switch (task.getTaskDefinitionKey()) {
            case "checkRequestApprovalTask":
                approvalTaskComplete(entity, task);
                break;
            case "accountDeptDispatchTask":
                accountsDispatchTaskComplete(entity, task);
                break;
        }
    }

    protected void approvalTaskComplete(ImmigrationCheckRequisition entity, DelegateTask task) {
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(ImmigrationCheckRequisitionStatus.PENDING_ACCOUNTS_PAYABLE_DISPATCH);
            entity.setApprovedBy(OfficeSecurityService.instance().getCurrentUserName());
            entity.setApprovedDate(new Date());
            entity.setAccountDeptReceivedDate(new Date());
        } else {
            entity.setStatus(ImmigrationCheckRequisitionStatus.REJECTED);
            new GenericTaskCompleteNotification().notify(task);
        }
        ImmigrationCheckRequisitionDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
    }

    protected void accountsDispatchTaskComplete(ImmigrationCheckRequisition entity, DelegateTask task) {
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(ImmigrationCheckRequisitionStatus.COMPLETE);
            entity.setAccountedBy(OfficeSecurityService.instance().getCurrentUserName());
            entity.setCheckIssuedDate(new Date());
        } else {
            entity.setStatus(ImmigrationCheckRequisitionStatus.REJECTED);
        }
        ImmigrationCheckRequisitionDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
        new GenericTaskCompleteNotification().notifyWithMoreRoles(task, OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
    }

    protected void assignImmigrationCheckRequisitionTask(DelegateTask task) {
        //TODO figure out the correct assignment
        task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
    }

    protected ImmigrationCheckRequisition getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ImmigrationCheckRequisitionDao.instance().findById(entityId);
        }
        return null;
    }
}
