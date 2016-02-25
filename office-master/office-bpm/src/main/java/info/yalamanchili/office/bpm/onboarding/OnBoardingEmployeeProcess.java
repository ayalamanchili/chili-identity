/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.onboarding;

import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
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
        EmployeeOnBoarding entity = getRequestFromTask(dt);
        //Notes
        String notes = (String) dt.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        switch (dt.getTaskDefinitionKey()) {
            case "onBoardingFormsAndDataValidationTask":
                onBoardingFormsAndDataValidationTaskCompleted(entity, dt);
                break;
            case "backGroundAndDrugScreeningTestTask":
                backgroundAndDrugScreeningTaskCompleted(entity, dt);
                break;
            case "eVerifyTask":
                eVerifyTaskCompleted(entity, dt);
                break;
            case "ServiceTicketTaskforNetworkDept":
                createServiceTicketForNetworkDept(entity, dt);
                break;
            case "onboardingFinalValidationTask":
                createFinalValidationTask(entity, dt);
                break;
            case "payrollRegistrationTask":
                payrollRegistrationTaskCompleted(entity, dt);
                break;
            case "employeeOrientationTask":
                createEmployeeOrientationTask(entity, dt);
                break;
        }
    }

    protected void onBoardingFormsAndDataValidationTaskCompleted(EmployeeOnBoarding entity, DelegateTask dt) {
        String status = (String) dt.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(OnBoardingStatus.Pending_HR_Validation);
            new GenericTaskCompleteNotification().notify(dt);
        } else {
            entity.setStatus(OnBoardingStatus.Rejected);
            new GenericTaskCompleteNotification().notify(dt);
        }
        EmployeeOnBoardingDao.instance().save(entity);
    }

    protected void backgroundAndDrugScreeningTaskCompleted(EmployeeOnBoarding entity, DelegateTask dt) {
        String status = (String) dt.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(OnBoardingStatus.Pending_HR_Validation);
            new GenericTaskCompleteNotification().notify(dt);
        } else {
            entity.setStatus(OnBoardingStatus.Rejected);
            new GenericTaskCompleteNotification().notify(dt);
        }
        EmployeeOnBoardingDao.instance().save(entity);
    }

    protected void eVerifyTaskCompleted(EmployeeOnBoarding entity, DelegateTask dt) {
        String status = (String) dt.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(OnBoardingStatus.Pending_HR_Validation);
            new GenericTaskCompleteNotification().notify(dt);
        } else {
            entity.setStatus(OnBoardingStatus.Rejected);
            new GenericTaskCompleteNotification().notify(dt);
        }
        EmployeeOnBoardingDao.instance().save(entity);
    }

    protected void createServiceTicketForNetworkDept(EmployeeOnBoarding entity, DelegateTask dt) {
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findById(entity.getId());
        empOnBoarding.setStatus(OnBoardingStatus.Pending_HR_Validation);
        new GenericTaskCompleteNotification().notify(dt);
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
    }

    protected void createFinalValidationTask(EmployeeOnBoarding entity, DelegateTask dt) {
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findById(entity.getId());
        empOnBoarding.setStatus(OnBoardingStatus.Pending_Payroll_Registration);
        new GenericTaskCompleteNotification().notify(dt);
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
        dt.getExecution().setVariable("entity", entity);
    }

    protected void payrollRegistrationTaskCompleted(EmployeeOnBoarding entity, DelegateTask dt) {
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findById(entity.getId());
        empOnBoarding.setStatus(OnBoardingStatus.Pending_Employee_Orientation);
        new GenericTaskCompleteNotification().notify(dt);
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
        dt.getExecution().setVariable("entity", entity);
    }

    protected void createEmployeeOrientationTask(EmployeeOnBoarding entity, DelegateTask dt) {
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findById(entity.getId());
        empOnBoarding.setStatus(OnBoardingStatus.Complete);
        new GenericTaskCompleteNotification().notify(dt);
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
    }

    protected EmployeeOnBoarding getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        EmployeeOnBoarding entity = EmployeeOnBoardingDao.instance().findById(entityId);
        if (entity != null) {
            return entity;
        } else {
            throw new RuntimeException("on boarding entity not found");
        }
    }
}
