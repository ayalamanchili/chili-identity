/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.probationeval;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.employee.ProbationPeriodEvaluationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluationStage;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author anuyalamanchili
 */
public class ProbationPeriodEvaluationProcess implements TaskListener {
    
    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            probationEvalTaskCreated(task);
            new GenericTaskCreateNotification().notify(task);
        }
        if ("complete".equals(task.getEventName())) {
            probationEvalTaskCompleted(task);
            new GenericTaskCompleteNotification().notify(task);
        }
        
    }
    
    protected void probationEvalTaskCreated(DelegateTask task) {
        saveProbationEvaluation(task);
        if (task.getTaskDefinitionKey().equals("managerReviewTask")) {
            assignManagerReviewTask(task);
        }
    }
    
    protected void saveProbationEvaluation(DelegateTask task) {
        ProbationPeriodEvaluation entity = getProbationEvaluationFromTask(task);
        if (entity != null) {
            if ("managerReviewTask".equals(task.getTaskDefinitionKey())) {
                entity.setStage(ProbationPeriodEvaluationStage.Manager_Review);
            } else if ("employeeAcceptTask".equals(task.getTaskDefinitionKey())) {
                entity.setStage(ProbationPeriodEvaluationStage.Employee_Acceptance);
            } else if ("hrFinalApprovalTask".equals(task.getTaskDefinitionKey())) {
                entity.setStage(ProbationPeriodEvaluationStage.HR_Approval);
            }
            entity = ProbationPeriodEvaluationDao.instance().save(entity);
            task.getExecution().setVariable("entity", entity);
            task.getExecution().setVariable("entityId", entity.getId());
        }
    }
    
    protected void assignManagerReviewTask(DelegateTask task) {
        Employee emp = getProbationEvaluationFromTask(task).getEmployee();
        Employee manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Perf_Eval_Manager");
        if (manager == null) {
            manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        }
        if (manager != null) {
            task.addCandidateUser(manager.getEmployeeId());
        } else {
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name());
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_PRB_EVALUATIONS_MANAGER.name());
        }
    }
    
    protected void probationEvalTaskCompleted(DelegateTask task) {
        ProbationPeriodEvaluation entity = getProbationEvaluationFromTask(task);
        if (entity == null) {
            return;
        }
        if ("managerReviewTask".equals(task.getTaskDefinitionKey())) {
            if (entity.getQuestions().size() <= 4) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.complete.mgr.eval.task", "Please go to MyOffice-->Employee-->Reports-->Probation Evaluations to complete Manager Review before completing the task.");
            }
            Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
            entity.setApprovedBy(currentUser.getEmployeeId());
            entity.setApprovedDate(new Date());
            entity.setEvaluationDate(new Date());
        } else if ("employeeAcceptTask".equals(task.getTaskDefinitionKey())) {
            entity.setAcceptDate(new Date());
        } else if ("hrFinalApprovalTask".equals(task.getTaskDefinitionKey())) {
            Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
            String notes = (String) task.getExecution().getVariable("hrNotes");
            entity.setHrApprovalBy(currentUser.getEmployeeId());
            entity.setHrApprovalDate(new Date());
            entity.setHrNotes(notes);
            entity.setStage(ProbationPeriodEvaluationStage.Complete);
        }
        ProbationPeriodEvaluationDao.instance().save(entity);
    }
    
    protected ProbationPeriodEvaluation getProbationEvaluationFromTask(DelegateTask task) {
        Long tsId = (Long) task.getExecution().getVariable("entityId");
        if (tsId != null) {
            return ProbationPeriodEvaluationDao.instance().findById(tsId);
        }
        return null;
    }
}
