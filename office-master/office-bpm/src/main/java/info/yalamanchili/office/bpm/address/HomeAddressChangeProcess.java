/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.address;

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

        }
        if ("complete".equals(task.getEventName())) {

        }
    }

    protected void addressChangeTaskCreated(DelegateTask task) {
        String taskName = task.getName();

        switch (taskName) {
            case "updateAddressPayrollTask":
                String payrollDeptNotes = (String) task.getExecution().getVariable("payrollDeptNotes");
                break;
            case "updateAddressImmigrationTask":
                String immigrationDeptNotes = (String) task.getExecution().getVariable("immigrationDeptNotes");
                break;
            case "updateHealthInsuranceTask":
                String healthInsuranceDeptNotes = (String) task.getExecution().getVariable("healthInsuranceDeptNotes");
                break;
            case "updateAddressHRAdminTask":
                String hrAdminDeptNotes = (String) task.getExecution().getVariable("hrAdminDeptNotes");
                break;
            default:

        }
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
