/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.perfeval;

import com.google.common.base.Strings;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.employee.PerformanceEvaluationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.employee.PerformanceEvaluationStage;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
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
public class AssociatePerfEvalProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
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
        PerformanceEvaluation entity = getPerformanceEvaluationFromTask(task);
        if ("eemApprovalTask".equals(task.getTaskDefinitionKey())) {
            entity.setStage(PerformanceEvaluationStage.Manager_Review);
        } else if ("hrReviewTask".equals(task.getTaskDefinitionKey())) {
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
        if ("eemApprovalTask".equals(task.getTaskDefinitionKey())) {
            String notes = (String) task.getExecution().getVariable("managerNotes");
            Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
            entity.setApprovedBy(currentUser.getEmployeeId());
            entity.setApprovedDate(new Date());
            if (!Strings.isNullOrEmpty(notes)) {
                entity.setManagerComments(notes);
            }
            entity.setStage(PerformanceEvaluationStage.Complete);
        } else if ("hrReviewTask".equals(task.getTaskDefinitionKey())) {
            String notes = (String) task.getExecution().getVariable("hrNotes");
            Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
            entity.setHrApprovalBy(currentUser.getEmployeeId());
            entity.setHrApprovalDate(new Date());
            entity.setStage(PerformanceEvaluationStage.Manager_Review);
            if (!Strings.isNullOrEmpty(notes)) {
                entity.setHrComments(notes);
            }
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
