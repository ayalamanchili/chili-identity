/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.immigration;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.expense.ImmigrationCheckRequisitionDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.chili.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisitionStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author Sadipan.B
 */
public class ImmigrationCheckRequestProcess implements TaskListener  {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            immigrationCheckRequestTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            immigrationCheckRequestTaskCompleted(task);
        }
    }

    protected void immigrationCheckRequestTaskCreated(DelegateTask task) {
        if (task.getTaskDefinitionKey().equals("payrollDeptApprovalTask")) {
            saveImmigrationCheckRequisition(task);
            assignImmigrationCheckRequisitionTask(task);
        }
        new GenericTaskCreateNotification().notify(task);
    }

    protected void immigrationCheckRequestTaskCompleted(DelegateTask task) {
        ImmigrationCheckRequisition entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getSubmittedBy().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.immigrationCheckrequisition", "You cannot approve your immigrationCheckrequisition task");
        }        
        switch (task.getTaskDefinitionKey()) {
            case "payrollDeptApprovalTask":
                payrollApprovalTaskComplete(entity, task);
                break;
            case "accountDeptDispatchTask":
                accountsDispatchTaskComplete(entity, task);
                break;
        }
    }

    protected void payrollApprovalTaskComplete(ImmigrationCheckRequisition entity, DelegateTask task) {
        String approvedAmountVar = (String) task.getExecution().getVariable("approvedAmount");
        BigDecimal approvedAmount;
        try {
            approvedAmount = new BigDecimal(approvedAmountVar);
        } catch (NumberFormatException ex) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.approved.amount", "Approved amount must be a valid amount eg: 99.99 ");
        }
        entity.setAmount(approvedAmount);
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(ImmigrationCheckRequisitionStatus.Pending_Final_Approval);
            entity.setApprovedBy(OfficeSecurityService.instance().getCurrentUser());
            entity.setApprovedDate(new Date());
            entity.setAccountDeptReceivedDate(new Date());
        } else {
            entity.setStatus(ImmigrationCheckRequisitionStatus.Rejected);
            new GenericTaskCompleteNotification().notify(task);
        }
        ImmigrationCheckRequisitionDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
    }

    protected void accountsDispatchTaskComplete(ImmigrationCheckRequisition entity, DelegateTask task) {
        String approvedAmountVar = (String) task.getExecution().getVariable("approvedAmount");
        BigDecimal approvedAmount;
        try {
            approvedAmount = new BigDecimal(approvedAmountVar);
        } catch (NumberFormatException ex) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.approved.amount", "Approved amount must be a valid amount eg: 99.99 ");
        }
        entity.setAmount(approvedAmount);
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(ImmigrationCheckRequisitionStatus.Approved);
            entity.setAccountedBy(OfficeSecurityService.instance().getCurrentUser());
            entity.setCheckIssuedDate(new Date());
            notifyAccountsPayableDept(entity);
        } else {
            entity.setStatus(ImmigrationCheckRequisitionStatus.Rejected);
        }
        ImmigrationCheckRequisitionDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
        new GenericTaskCompleteNotification().notifyWithMoreRoles(task, OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
    }

    protected void saveImmigrationCheckRequisition(DelegateTask task) {        
        ImmigrationCheckRequisitionDao dao = ImmigrationCheckRequisitionDao.instance();
        ImmigrationCheckRequisition entity = (ImmigrationCheckRequisition) task.getExecution().getVariable("entity");
        entity.setBpmProcessId(task.getExecution().getProcessInstanceId());
        entity.setStatus(ImmigrationCheckRequisitionStatus.Pending_Initial_Approval);
        entity.setRequestedDate(new Date());
        entity = dao.save(entity);
        CommentDao.instance().addComment("Save Immigration Check", entity);
        task.getExecution().setVariable("entity", entity);
        task.getExecution().setVariable("entityId", entity.getId());
    }

    protected void assignImmigrationCheckRequisitionTask(DelegateTask task) {
//        Employee emp = (Employee) task.getExecution().getVariable("submittedBy");
        task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
    }

    public void notifyAccountsPayableDept(ImmigrationCheckRequisition entity) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name()));
        email.setSubject("Immigration Requisition Approved For Employee" + entity.getEmployee());
        email.setBody("Immigration Requisition Approved For Employee" + entity.getEmployee());
        messagingService.sendEmail(email);

    }

    protected ImmigrationCheckRequisition getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ImmigrationCheckRequisitionDao.instance().findById(entityId);
        }
        return null;
    }    
}
