/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.address;

import com.google.common.base.Strings;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.dao.profile.AddressDao;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class HomeAddressChangeProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            addressChangeTaskCreated();
        }
        if ("complete".equals(task.getEventName())) {

        }
    }

    protected void addressChangeTaskCreated(DelegateTask task) {
        String taskName = task.getName();

        switch (taskName) {
            case "updateAddressPayrollTask":
                String payrollDeptNotes = (String) task.getExecution().getVariable("payrollDeptNotes");
                addComment(payrollDeptNotes, getRequestFromTask(task));
                break;
            case "updateAddressImmigrationTask":
                String immigrationDeptNotes = (String) task.getExecution().getVariable("immigrationDeptNotes");
                addComment(immigrationDeptNotes, getRequestFromTask(task));
                break;
            case "updateHealthInsuranceTask":
                String healthInsuranceDeptNotes = (String) task.getExecution().getVariable("healthInsuranceDeptNotes");
                addComment(healthInsuranceDeptNotes, getRequestFromTask(task));
                break;
            case "updateAddressHRAdminTask":
                String hrAdminDeptNotes = (String) task.getExecution().getVariable("hrAdminDeptNotes");
                if (!Strings.isNullOrEmpty(hrAdminDeptNotes)) {
                    addComment(hrAdminDeptNotes, getRequestFromTask(task));
                }
                break;
            default:
        }
        new GenericTaskCreateNotification().notify(task);
    }

    protected void addressChangeTaskCreated(DelegateTask task) {
        new GenericTaskCompleteNotification().notify(task);
    }

    protected void addComment(String notes, Address entity) {
        CommentDao.instance().addComment(notes, entity);
    }

    protected Address getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return AddressDao.instance().findById(entityId);
        }
        return null;
    }
}
