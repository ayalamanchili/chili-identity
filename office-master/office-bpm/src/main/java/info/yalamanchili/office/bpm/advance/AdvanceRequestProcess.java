/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.advance;

import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.expense.AdvanceRequisitionDao;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.AdvanceRequisitionStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class AdvanceRequestProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            advanceRequestTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            advanceRequestTaskCompleted(task);
        }
    }

    protected void advanceRequestTaskCreated(DelegateTask task) {
        if (task.getTaskDefinitionKey().equals("advanceRequisitionApprovalTask")) {
            saveAdvanceRequisition(task);
            assignAdvanceRequisitionTask(task);
        }
        new GenericTaskCreateNotification().notify(task);
    }

    protected void advanceRequestTaskCompleted(DelegateTask task) {
        AdvanceRequisition entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }

        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(AdvanceRequisitionStatus.Approved);
        } else {
            entity.setStatus(AdvanceRequisitionStatus.Rejected);
        }
        AdvanceRequisitionDao.instance().save(entity);
        if (task.getTaskDefinitionKey().equals("advanceRequisitionApprovalTask") && AdvanceRequisitionStatus.Approved.equals(entity.getStatus())) {
            return;
        }
        new GenericTaskCompleteNotification().notify(task);
    }

    protected void saveAdvanceRequisition(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        AdvanceRequisition entity = (AdvanceRequisition) task.getExecution().getVariable("entity");
        entity.setBpmProcessId(task.getExecution().getProcessInstanceId());
        entity.setStatus(AdvanceRequisitionStatus.Pending);
        entity.setEmployee(emp);
        entity.setDateRequested(new Date());
        entity = AdvanceRequisitionDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
        task.getExecution().setVariable("entityId", entity.getId());
    }

    protected void assignAdvanceRequisitionTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        //TODO
        task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_EXPENSE.name());
    }

    protected AdvanceRequisition getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return AdvanceRequisitionDao.instance().findById(entityId);
        }
        return null;
    }
}
