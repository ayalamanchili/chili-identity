/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.offboarding;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.activiti.engine.delegate.DelegateTask;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author radhika.mukkala
 */
public class ProjectOffboardingProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        if ("create".equals(task.getEventName()) || "assignment".equals(task.getEventName())) {
            projectOffboardingTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            projectOffboardingTaskCompleted(task);
        }
    }

    public void projectOffboardingTaskCreated(DelegateTask task) {
        ClientInformation entity = getRequestFromTask(task);
        if (entity.getStatus().equals(ClientInformationStatus.COMPLETED)) {
            entity.setStatus(ClientInformationStatus.PENDING_CLOSING);
            entity.setBpmProcessId(task.getExecution().getProcessInstanceId());
        }
        new GenericTaskCreateNotification().notify(task);
    }

    public void projectOffboardingTaskCompleted(DelegateTask task) {
        ClientInformation entity = getRequestFromTask(task);
        String notes = (String) task.getExecution().getVariable("notes");
        if (StringUtils.isBlank(notes)) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "notes.empty", "Please enter notes. Notes cannot be empty.");
        } else {
            attachComment(task, entity);
        }
        switch (task.getTaskDefinitionKey()) {
            case "projectOffboardingContractsAdminTask":
                projectOffboardingContractsAdminTask(task, entity);
                break;
            case "projectOffboardingValidationTask":
                entity.setStatus(ClientInformationStatus.CLOSED);
                break;
            default:
                break;
        }
        new GenericTaskCompleteNotification().notify(task);
        ClientInformationDao.instance().save(entity);
    }

    public void projectOffboardingContractsAdminTask(DelegateTask task, ClientInformation entity) {
        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String date = task.getExecution().getVariable("endDate").toString();
        try {
            Date endDate = sdf.parse(date);
            entity.setEndDate(endDate);
        } catch (ParseException ex) {
            Logger.getLogger(ProjectOffboardingProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void attachComment(DelegateTask task, ClientInformation entity) {
        String notes = (String) task.getExecution().getVariable("notes");
        String taskName = null;
        switch (task.getTaskDefinitionKey()) {
            case "projectOffboardingContractsAdminTask":
                taskName = "Project Offboarding Contracts Admin Task";
                break;
            case "projectOffboardingBillingAdminTask":
                taskName = "Project Offboarding Billing Admin Task";
                break;
            case "projectOffboardingPayrollDeptTask":
                taskName = "Project Offboarding Payroll Dept Task";
                break;
            case "projectOffboardingAccountsPayableTask":
                taskName = "Project Offboarding Accounts Payable Task";
                break;
            case "projectOffboardingAccountsReceivableTask":
                taskName = "Project Offboarding Accounts Receivable Task";
                break;
            case "projectOffboardingImmigrationDeptTask":
                taskName = "Project Offboarding Immigration Dept Task";
                break;
            case "projectOffboardingRecruitingDeptTask":
                taskName = "Project Offboarding Recruiting Dept Task";
                break;
            case "projectOffboardingValidationTask":
                taskName = "Project Offboarding Validation Task";
                break;
            default:
                taskName = "";
                break;
        }
        CommentDao.instance().addComment(taskName + " Completion Notes: " + notes, entity);
    }

    protected ClientInformation getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ClientInformationDao.instance().findById(entityId);
        }
        return null;
    }
}
