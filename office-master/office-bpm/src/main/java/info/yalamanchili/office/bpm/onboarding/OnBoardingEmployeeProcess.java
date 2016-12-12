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
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.company.CompanyContactTypeDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.company.CompanyContactType;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import info.yalamanchili.office.jms.MessagingService;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    protected MessagingService messagingService;

    @Override
    public void processTask(DelegateTask task) {
        if ("create".equals(task.getEventName()) || "assignment".equals(task.getEventName())) {
            onboardingTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            employeeOnBoardingTaskCompleted(task);
        }
    }

    protected void onboardingTaskCreated(DelegateTask task) {
        if (task.getTaskDefinitionKey().equals("NewEmployeeManagerTask")) {
            assignOnboardingTaskToManager(task);
        }
        new GenericTaskCreateNotification().notify(task);
    }

    protected void assignOnboardingTaskToManager(DelegateTask task) {
        String employeeId = (String) task.getExecution().getVariable("reportsToManager");
        task.addCandidateUser(employeeId);
    }

    private void employeeOnBoardingTaskCompleted(DelegateTask dt) {
        EmployeeOnBoarding entity = getRequestFromTask(dt);
        //Notes
        String notes = (String) dt.getExecution().getVariable("notes");
        CommentDao.instance().addComment(dt.getTaskDefinitionKey() + " Completed Notes:" + notes, entity);
        switch (dt.getTaskDefinitionKey()) {
            case "onBoardingFormsAndDataValidationTask":
                onBoardingFormsAndDataValidationTaskCompleted(entity, dt);
                break;
            case "backGroundScreeningTestTask":
                backgroundAndDrugScreeningTaskCompleted(entity, dt);
                break;
            case "drugScreeningTestTask":
                backgroundAndDrugScreeningTaskCompleted(entity, dt);
                break;
            case "eVerifyTask":
                eVerifyTaskCompleted(entity, dt);
                break;
            case "SetupManagerTask":
                setupManagerTask(entity, dt);
                break;
            case "NewEmployeeManagerTask":
                onboardingManagerApprovalTask(entity, dt);
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

    private void setupManagerTask(EmployeeOnBoarding entity, DelegateTask dt) {
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findById(entity.getId());
        Employee emp = empOnBoarding.getEmployee();
        //add reports-to contact to emp
        String managerId = (String) dt.getExecution().getVariable("reportsToManager");
        Employee employeeManager = EmployeeDao.instance().findEmployeWithEmpId(managerId);
        if (employeeManager == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.manager.id", "Invalid Manager Id");
        } else if (!EmployeeType.CORPORATE_EMPLOYEE.equals(employeeManager.getEmployeeType().getName())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "only.corporate.empId.allowed", "Only Corporate Employees can be Reporting Managers");
        }
        CompanyContact contact = new CompanyContact();
        CompanyContactType type = CompanyContactTypeDao.instance().findById(CompanyContactTypeDao.instance().getCompanyContactId("Reports_To"));
        contact.setType(type);
        contact.setEmployee(emp);
        contact.setContact(employeeManager);
        CompanyContactDao.instance().save(contact);
        empOnBoarding.setStatus(OnBoardingStatus.Pending_HR_Validation);
        new GenericTaskCompleteNotification().notify(dt);
        EmployeeOnBoardingDao.instance().save(entity);
    }

    private void onboardingManagerApprovalTask(EmployeeOnBoarding entity, DelegateTask dt) {
        String requirements = (String) dt.getExecution().getVariable("requirements");
        CommentDao.instance().addComment(dt.getTaskDefinitionKey() + " Requirements:" + requirements, entity);
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findById(entity.getId());
        Employee emp = empOnBoarding.getEmployee();
        EmployeeAdditionalDetails empAdditionalDetails = EmployeeAdditionalDetailsDao.instance().find(emp);
        if (empAdditionalDetails == null || empAdditionalDetails.getRolesAndResponsibilities() == null || empAdditionalDetails.getRolesAndResponsibilities().isEmpty()) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.complete.manager.task", "Please update Roles & Responsibilities through MyOffice -> Employees -> Search -> View -> Forms&Docs -> Joining Form -> Updates Roles & Responsibilities");
        }
        empOnBoarding.setStatus(OnBoardingStatus.Pending_HR_Validation);
        new GenericTaskCompleteNotification().notify(dt);
        EmployeeOnBoardingDao.instance().save(entity);
        dt.getExecution().setVariable("requirements", dt.getExecution().getVariable("requirements"));
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
