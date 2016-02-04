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
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
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

    protected void onBoardingFormsAndDataValidationTaskCompleted(Employee entity, DelegateTask dt) {
        String status = (String) dt.getExecution().getVariable("status");
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findByEmployeeId(entity.getId());
        if (status.equalsIgnoreCase("approved")) {
            if (entity.getEmployeeType().getName().equalsIgnoreCase("Corporate Employee")) {
                empOnBoarding.setStatus(OnBoardingStatus.Pending_Background_Check);
                new GenericTaskCompleteNotification().notify(dt);
            } else {
                empOnBoarding.setStatus(OnBoardingStatus.Pending_EVerify);
                new GenericTaskCompleteNotification().notify(dt);
            }
        }
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
        dt.getExecution().setVariable("entity", entity);
    }

    protected void backgroundAndDrugScreeningTaskCompleted(Employee entity, DelegateTask dt) {
        String status = (String) dt.getExecution().getVariable("status");
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findByEmployeeId(entity.getId());
        if (status.equalsIgnoreCase("approved")) {
            empOnBoarding.setStatus(OnBoardingStatus.Pending_EVerify);
            new GenericTaskCompleteNotification().notify(dt);
        }
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
        dt.getExecution().setVariable("entity", entity);
    }

    protected void eVerifyTaskCompleted(Employee entity, DelegateTask dt) {
        String status = (String) dt.getExecution().getVariable("status");
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findByEmployeeId(entity.getId());
        if (status.equalsIgnoreCase("approved")) {
            empOnBoarding.setStatus(OnBoardingStatus.Pending_Payroll_Registration);
            new GenericTaskCompleteNotification().notify(dt);
        }
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
        dt.getExecution().setVariable("entity", entity);
    }

    protected void payrollRegistrationTaskCompleted(Employee entity, DelegateTask dt) {
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findByEmployeeId(entity.getId());
        if (entity.getEmployeeType().getName().equalsIgnoreCase("Corporate Employee")) {
            empOnBoarding.setStatus(OnBoardingStatus.Pending_Network_Department_Approval);
        }else{
            empOnBoarding.setStatus(OnBoardingStatus.Complete);
        }
        new GenericTaskCompleteNotification().notify(dt);
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
        dt.getExecution().setVariable("entity", entity);
    }

    protected void createServiceTicketForNetworkDept(Employee entity, DelegateTask dt) {
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findByEmployeeId(entity.getId());
        empOnBoarding.setStatus(OnBoardingStatus.Complete);
        new GenericTaskCompleteNotification().notify(dt);
        EmployeeOnBoardingDao.instance().save(empOnBoarding);
        dt.getExecution().setVariable("entity", entity);
    }

    protected Employee getRequestFromTask(DelegateTask task) {
        Employee entity = (Employee) task.getExecution().getVariable("entity");
        if (entity != null) {
            return entity;
        }
        return null;
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
            case "payrollRegistrationTask":
                payrollRegistrationTaskCompleted(entity, dt);
                break;
            case "ServiceTicketTaskforNetworkDept":
                createServiceTicketForNetworkDept(entity, dt);
        }
    }

}
