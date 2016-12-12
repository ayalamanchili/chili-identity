/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.prospect;

import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author sudharani.bandaru
 */
public class RequestProspectOnboardingProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            new GenericTaskCreateNotification().notify(task);
        }
        if ("complete".equals(task.getEventName())) {
            prospectTaskCompleted(task);
            new GenericTaskCompleteNotification().notify(task);
        }
    }

    protected void prospectTaskCompleted(DelegateTask task) {
        Prospect entity = (Prospect) task.getExecution().getVariable("prospect");
        entity = ProspectDao.instance().findById(entity.getId());
        if (entity == null) {
            return;
        }
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        entity.setStatus(ProspectStatus.CLOSED_ONBOARDING_REQUESTED);
        ProspectDao.instance().save(entity);
        CommentDao.instance().addComment(notes, entity);
    }

}
