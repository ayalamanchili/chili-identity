/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.perfeval;

import info.yalamanchili.office.dao.employee.PerformanceEvaluationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.employee.PerformanceEvaluationStage;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
@Transactional
public class AssociatePerfEvalProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            perfEvalTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            perfEvalTaskCompleted(task);
        }
    }

    protected void perfEvalTaskCreated(DelegateTask task) {
        savePerformanceEvaluation(task);
    }

    protected void savePerformanceEvaluation(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        PerformanceEvaluation entity = (PerformanceEvaluation) task.getExecution().getVariable("entity");
        if ("eemReviewTask".equals(task.getTaskDefinitionKey())) {
            entity.setStage(PerformanceEvaluationStage.Manager_Review);
        } else if ("hrFinalApprovalTask".equals(task.getTaskDefinitionKey())) {
            entity.setStage(PerformanceEvaluationStage.HR_Approval);
        }
        entity.setEvaluationDate(new Date());
        entity = PerformanceEvaluationDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
        task.getExecution().setVariable("entityId", entity.getId());
    }

    protected void perfEvalTaskCompleted(DelegateTask task) {
        PerformanceEvaluation entity = getPerformanceEvaluationFromTask(task);
        if (entity == null) {
            return;
        }
        if ("eemReviewTask".equals(task.getTaskDefinitionKey())) {
            String notes = (String) task.getExecution().getVariable("managerNotes");
            Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
            entity.setApprovedBy(currentUser.getEmployeeId());
            entity.setManagersComments(notes);
        } else if ("hrFinalApprovalTask".equals(task.getTaskDefinitionKey())) {
            String notes = (String) task.getExecution().getVariable("hrNotes");
            //TODO add to manager notes
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
