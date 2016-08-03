/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.advance;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.advreq.AdvanceRequisitionDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.chili.email.Email;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.AdvanceRequisitionStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class AdvanceRequestProcess extends RuleBasedTaskDelegateListner implements TaskListener {

    @Override
    public void processTask(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            advanceRequestTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            advanceRequestTaskCompleted(task);
        }
    }

    protected void advanceRequestTaskCreated(DelegateTask task) {
        if (task.getTaskDefinitionKey().equals("advanceRequisitionApprovalTask")) {
            saveAdvanceRequisition(task);
            assignAdvanceRequisitionTask(task);
        }
        new GenericTaskCreateNotification().notifyWithMoreRoles(task, OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name(), OfficeRole.ROLE_ACCOUNTS_PAYABLE.name());
    }

    protected void advanceRequestTaskCompleted(DelegateTask task) {
        AdvanceRequisition entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.advancerequisition", "You cannot approve your advancerequisition task");
        }
        switch (task.getTaskDefinitionKey()) {
            case "advanceRequisitionApprovalTask":
                payrollOrManagerApprovalTaskComplete(entity, task);
                break;
            case "advanceRequisitionFinalApprovalTask":
                ceoApprovalTaskComplete(entity, task);
                break;
            case "advanceRequisitionAccountsPayableTask":
                accountsPayableTaskComplete(entity, task);
                break;
        }
    }

    protected void payrollOrManagerApprovalTaskComplete(AdvanceRequisition entity, DelegateTask task) {
        String approvedAmountVar = (String) task.getExecution().getVariable("approvedAmount");
        BigDecimal approvedAmount;
        try {
            approvedAmount = new BigDecimal(approvedAmountVar);
        } catch (NumberFormatException ex) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.approved.amount", "Approved amount must be a valid amount eg: 99.99 ");
        }
        entity.setAmount(approvedAmount);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(AdvanceRequisitionStatus.Pending_CEO_Approval);
            entity.setApprovedBy(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
            entity.setApprovedDate(new Date());
        } else {
            entity.setStatus(AdvanceRequisitionStatus.Rejected);
            new GenericTaskCompleteNotification().notify(task);
        }
        AdvanceRequisitionDao.instance().save(entity);
    }

    protected void ceoApprovalTaskComplete(AdvanceRequisition entity, DelegateTask task) {
        String approvedAmountVar = (String) task.getExecution().getVariable("approvedAmount");
        BigDecimal approvedAmount;
        try {
            approvedAmount = new BigDecimal(approvedAmountVar);
        } catch (NumberFormatException ex) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.approved.amount", "Approved amount must be a valid amount eg: 99.99 ");
        }
        entity.setAmount(approvedAmount);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(AdvanceRequisitionStatus.Pending_Accounts_Payable_Dipatch);
            notifyAccountsPayableDept(entity);
        } else {
            entity.setStatus(AdvanceRequisitionStatus.Rejected);
        }
        AdvanceRequisitionDao.instance().save(entity);
        new GenericTaskCompleteNotification().notifyWithMoreRoles(task, OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
    }

    protected void accountsPayableTaskComplete(AdvanceRequisition entity, DelegateTask task) {
        String approvedAmountVar = (String) task.getExecution().getVariable("approvedAmount");
        BigDecimal approvedAmount;
        try {
            approvedAmount = new BigDecimal(approvedAmountVar);
        } catch (NumberFormatException ex) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.approved.amount", "Approved amount must be a valid amount eg: 99.99 ");
        }
        entity.setAmount(approvedAmount);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(AdvanceRequisitionStatus.Approved);
            notifyAccountsPayableDept(entity);
        } else {
            entity.setStatus(AdvanceRequisitionStatus.Rejected);
        }
        AdvanceRequisitionDao.instance().save(entity);
    }

    protected void saveAdvanceRequisition(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        AdvanceRequisitionDao dao = AdvanceRequisitionDao.instance();
        AdvanceRequisition entity = (AdvanceRequisition) task.getExecution().getVariable("entity");
        String repaymentCmt = "Repayment Months:" + entity.getRepaymentMonths() + "Repayment Notes:" + entity.getRepaymentNotes();
        entity.setBpmProcessId(task.getExecution().getProcessInstanceId());
        entity.setStatus(AdvanceRequisitionStatus.Pending_Initial_Approval);
        entity.setEmployee(emp);
        entity.setDateRequested(new Date());
        entity = dao.save(entity);
        CommentDao.instance().addComment(repaymentCmt, entity);
        task.getExecution().setVariable("entity", entity);
        task.getExecution().setVariable("entityId", entity.getId());
    }

    protected void assignAdvanceRequisitionTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (emp.getEmployeeType().getName().equals(EmployeeType.CORPORATE_EMPLOYEE) && reportsToEmp != null) {
            task.addCandidateUser(reportsToEmp.getEmployeeId());
        } else {
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
        }
    }

    public void notifyAccountsPayableDept(AdvanceRequisition entity) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name()));
        email.setSubject("Advance Requisition Approved For Employee" + entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
        String body = "<b>Advance Requisition Approved For Employee</b></br></br>" + "<b><i>Employee Name:</i></b>" + " " + entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName() + "</br></br>&nbsp;&nbsp;&nbsp;&nbsp;" + "<i> Please Print and Process it</i>";
        email.setBody(body);
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        messagingService.sendEmail(email);

    }

    protected AdvanceRequisition getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return AdvanceRequisitionDao.instance().findById(entityId);
        }
        return null;
    }
}
