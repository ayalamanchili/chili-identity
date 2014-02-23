/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class ConsultantEmpLeaveRequestProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            leaveRequestTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            leaveRequestTaskCompleted(task);
        }
    }

    protected void leaveRequestTaskCreated(DelegateTask task) {
        ConsultantTimeSheet ts = (ConsultantTimeSheet) task.getExecution().getVariable("leaveRequest");
        ts.setStatus(TimeSheetStatus.Pending);
        ts = ConsultantTimeSheetDao.instance().save(ts);
        task.getExecution().setVariable("leaveRequest", ts);
        new GenericTaskCreateNotification().notify(task);
    }

    protected void leaveRequestTaskCompleted(DelegateTask task) {
        ConsultantTimeSheet ts = (ConsultantTimeSheet) task.getExecution().getVariable("leaveRequest");
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            ts.setStatus(TimeSheetStatus.Approved);
        } else {
            ts.setStatus(TimeSheetStatus.Rejected);
            //TODO should this be deleted?
        }
        ConsultantTimeSheetDao.instance().save(ts);
        new GenericTaskCompleteNotification().notify(task);
    }
}
