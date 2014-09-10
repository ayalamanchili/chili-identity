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
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.AdvanceRequisitionDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.AdvanceRequisitionStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class AdvanceRequestProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
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
        new GenericTaskCreateNotification().notify(task);
    }

    protected void advanceRequestTaskCompleted(DelegateTask task) {
        AdvanceRequisition entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.advancerequisition", "You cannot approve your advancerequisition task");
        }
        //Amount
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
            entity.setStatus(AdvanceRequisitionStatus.Approved);
        } else {
            entity.setStatus(AdvanceRequisitionStatus.Rejected);
        }
        if (task.getTaskDefinitionKey().equals("advanceRequisitionPaymentDispatchTask") && AdvanceRequisitionStatus.Approved.equals(entity.getStatus())) {
            entity.setStatus(AdvanceRequisitionStatus.Completed);
        }
        AdvanceRequisitionDao.instance().save(entity);
        if (task.getTaskDefinitionKey().equals("advanceRequisitionFinalApprovalTask") && AdvanceRequisitionStatus.Approved.equals(entity.getStatus())
                || task.getTaskDefinitionKey().equals("advanceRequisitionApprovalTask") && AdvanceRequisitionStatus.Approved.equals(entity.getStatus())) {
            return;
        }
        new GenericTaskCompleteNotification().notify(task);
    }

    protected void saveAdvanceRequisition(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        AdvanceRequisitionDao dao = AdvanceRequisitionDao.instance();
        AdvanceRequisition entity = (AdvanceRequisition) task.getExecution().getVariable("entity");
        String repaymentCmt = "Repayment Months:" + entity.getRepaymentMonths() + "Repayment Notes:" + entity.getRepaymentNotes();
        entity.setBpmProcessId(task.getExecution().getProcessInstanceId());
        entity.setStatus(AdvanceRequisitionStatus.Pending);
        entity.setEmployee(emp);
        entity.setDateRequested(new Date());
        entity = dao.save(entity);
        CommentDao.instance().addComment(repaymentCmt, entity);
        task.getExecution().setVariable("entity", entity);
        task.getExecution().setVariable("entityId", entity.getId());
    }

    protected void assignAdvanceRequisitionTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        if (emp.getEmployeeType().equals("Employee")) {
            task.addCandidateUser(CompanyContactDao.instance().getReportsToContactForEmployee(emp).getEmployeeId());
        } else {
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
        }
    }

    protected AdvanceRequisition getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return AdvanceRequisitionDao.instance().findById(entityId);
        }
        return null;
    }
}
