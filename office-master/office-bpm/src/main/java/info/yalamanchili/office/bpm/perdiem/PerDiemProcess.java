/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.perdiem;

import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.perdiem.PerDiemDao;
import info.yalamanchili.office.entity.expense.Perdiem.PerDiem;
import info.yalamanchili.office.entity.expense.Perdiem.PerDiemStatus;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author radhika.mukkala
 */
public class PerDiemProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        if ("create".equals(dt.getEventName())) {
            perDiemRequisitionTaskCreated(dt);
        }
        if ("complete".equals(dt.getEventName())) {
            perDiemRequisitionTaskCompleted(dt);
        }
    }

    private void perDiemRequisitionTaskCreated(DelegateTask dt) {
        new GenericTaskCreateNotification().notify(dt);
    }

    private void perDiemRequisitionTaskCompleted(DelegateTask dt) {
        PerDiem entity = getRequestFromTask(dt);
        if (entity == null) {
            return;
        }
       
        //Status
        String status = (String) dt.getExecution().getVariable("status");
        if (dt.getTaskDefinitionKey().equals("perDiemPayrollApprovalTask")) {
            if (status.equalsIgnoreCase("approved")) {
               entity.setStatus(PerDiemStatus.Completed);
            } else {
                entity.setStatus(PerDiemStatus.Rejected);
            }
        }
        PerDiemDao.instance().save(entity);
        new GenericTaskCompleteNotification().notify(dt);
    }

    protected PerDiem getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return PerDiemDao.instance().findById(entityId);
        }
        return null;
    }
}

