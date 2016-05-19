/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.OutOfOfficeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.entity.time.OutOfOfficeRequestStatus;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author Ramana.Lukalapu
 */
public class OutOfOfficeRequestProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            outOfOfficeTaskCreated(task);
            new GenericTaskCreateNotification().notify(task);
        }
        if ("complete".equals(task.getEventName())) {
            outOfOfficeTaskCompleted(task);
            new GenericTaskCompleteNotification().notify(task);
        }

    }

    protected void outOfOfficeTaskCreated(DelegateTask task) {
        saveOutOfOfficeTask(task);
        if (task.getTaskDefinitionKey().equals("outOfOfficeMgrApprovalTask")) {
            assignManagerReviewTask(task);
        }
    }

    protected void saveOutOfOfficeTask(DelegateTask task) {
        OutOfOfficeRequest entity = getOutOfOfficeTask(task);
        if (entity != null) {
            if ("managerReviewTask".equals(task.getTaskDefinitionKey())) {
                entity.setStatus(OutOfOfficeRequestStatus.PENDING_MANAGER_APPROVAL);
            }
            entity = OutOfOfficeDao.instance().save(entity);
            task.getExecution().setVariable("entity", entity);
            task.getExecution().setVariable("entityId", entity.getId());
        }
    }

    protected void assignManagerReviewTask(DelegateTask task) {
        Long id = getOutOfOfficeTask(task).getEmployee().getId();
        Employee emp = EmployeeDao.instance().findById(id);
        Employee manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (manager != null) {
            task.addCandidateUser(manager.getEmployeeId());
        } else {
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name());
        }
    }

    protected void outOfOfficeTaskCompleted(DelegateTask task) {
        OutOfOfficeRequest entity = getOutOfOfficeTask(task);
        if (entity == null) {
            return;
        }
        String status = (String) task.getExecution().getVariable("status");
        if ("managerReviewTask".equals(task.getTaskDefinitionKey())) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(OutOfOfficeRequestStatus.APPROVED);
            } else {
                entity.setStatus(OutOfOfficeRequestStatus.REJECTED);
            }
        }
        OutOfOfficeDao.instance().save(entity);
    }

    protected OutOfOfficeRequest getOutOfOfficeTask(DelegateTask task) {
        Long tsId = (Long) task.getExecution().getVariable("entityId");
        if (tsId != null) {
            return OutOfOfficeDao.instance().findById(tsId);
        }
        return null;
    }
}
