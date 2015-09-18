/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.onboarding;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("prototype")
@Transactional
public class OnBoardingEmployeeProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        if ("create".equals(task.getEventName()) || "assignment".equals(task.getEventName())) {
            new GenericTaskCreateNotification().notify(task);
        }
        if ("complete".equals(task.getEventName())) {
            employeeOnBoardingTaskCompleted(task);
        }
    }

    private void employeeOnBoardingTaskCompleted(DelegateTask dt) {
        Employee entity = getRequestFromTask(dt);
        if (entity == null) {
            return;
        }
        //Notes
        String notes = (String) dt.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.expenseReport", "You cannot approve your expenseReport task");
        }
        //Status
        String status = (String) dt.getExecution().getVariable("status");
        if (dt.getTaskDefinitionKey().equals("onBoardingFormsAndDataValidationTask")) {
            if (status.equalsIgnoreCase("approved")) {
                System.out.println("APPROVED APPROVED");
            } else {
                System.out.println("REJECTED REJECTED");
            }
        }

    }

    protected Employee getRequestFromTask(DelegateTask task) {
        Employee entity = (Employee) task.getExecution().getVariable("entity");
        if (entity != null) {
            return entity;
        }
        return null;
    }

}
