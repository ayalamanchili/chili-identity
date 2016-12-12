/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.perfeval;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.employee.PerformanceEvaluationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.employee.PerformanceEvaluationStage;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class CorporatePerfEvalProcess implements TaskListener {
    
    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            perfEvalTaskCreated(task);
            new GenericTaskCreateNotification().notify(task);
        }
        if ("complete".equals(task.getEventName())) {
            perfEvalTaskCompleted(task);
            new GenericTaskCompleteNotification().notify(task);
        }
        
    }
    
    protected void perfEvalTaskCreated(DelegateTask task) {
        savePerformanceEvaluation(task);
        if (task.getTaskDefinitionKey().equals("managerReviewTask")) {
            assignManagerReviewTask(task);
        }
    }
    
    protected void savePerformanceEvaluation(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        PerformanceEvaluation entity = getPerformanceEvaluationFromTask(task);
        if (entity != null) {
            if ("managerReviewTask".equals(task.getTaskDefinitionKey())) {
                entity.setStage(PerformanceEvaluationStage.Manager_Review);
            } else if ("employeeAcceptTask".equals(task.getTaskDefinitionKey())) {
                entity.setStage(PerformanceEvaluationStage.Employee_Acceptance);
            } else if ("hrFinalApprovalTask".equals(task.getTaskDefinitionKey())) {
                entity.setStage(PerformanceEvaluationStage.HR_Approval);
            } else {
                entity.setEvaluationDate(new Date());
            }
            entity = PerformanceEvaluationDao.instance().save(entity);
            task.getExecution().setVariable("entity", entity);
            task.getExecution().setVariable("entityId", entity.getId());
        }
    }
    
    protected void assignManagerReviewTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        Employee manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Perf_Eval_Manager");
        if (manager == null) {
            manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        }
        if (manager != null) {
            task.addCandidateUser(manager.getEmployeeId());
        } else {
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name());
        }
    }
    
    protected void perfEvalTaskCompleted(DelegateTask task) {
        PerformanceEvaluation entity = getPerformanceEvaluationFromTask(task);
        if (entity == null) {
            return;
        }
        if ("managerReviewTask".equals(task.getTaskDefinitionKey())) {
            if (entity.getQuestions().size() <= 4) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.complete.mgr.eval..task", "Please go to MyOffice-->Employee-->Reports-->Performance Evaluations to complete Manager Review before completing the task.");
            }
            String notes = (String) task.getExecution().getVariable("managerNotes");
            Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
            entity.setApprovedBy(currentUser.getEmployeeId());
            entity.setApprovedDate(new Date());
            entity.setManagerComments(notes);
        } else if ("employeeAcceptTask".equals(task.getTaskDefinitionKey())) {
            String notes = (String) task.getExecution().getVariable("employeeNotes");
            entity.setEmployeeComments(notes);
            entity.setAcceptDate(new Date());
        } else if ("hrFinalApprovalTask".equals(task.getTaskDefinitionKey())) {
            String notes = (String) task.getExecution().getVariable("hrNotes");
            Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
            entity.setHrApprovalBy(currentUser.getEmployeeId());
            entity.setHrApprovalDate(new Date());
            entity.setHrComments(notes);
            entity.setStage(PerformanceEvaluationStage.Complete);
        }
        PerformanceEvaluationDao.instance().save(entity);
    }
    
    protected PerformanceEvaluation getPerformanceEvaluationFromTask(DelegateTask task) {
        Long tsId = (Long) task.getExecution().getVariable("entityId");
        if (tsId != null) {
            return PerformanceEvaluationDao.instance().findById(tsId);
        }
        return null;
    }
}
