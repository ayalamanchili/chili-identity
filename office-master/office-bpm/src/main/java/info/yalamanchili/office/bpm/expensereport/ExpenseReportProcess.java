/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.expensereport;

import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReportsDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReportStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author ayalamanchili
 */
public class ExpenseReportProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
        if ("complete".equals(task.getEventName())) {
            expenseReportTaskCompleted(task);
        }
    }

    @Override
    protected void processTaskDelegation(DelegateTask task) {
        if (task.getTaskDefinitionKey().equals("expenseReportMgrApprovalTask")) {
            ExpenseReport entity = getRequestFromTask(task);
            if (entity.getEmployee().getEmployeeType().getName().equals("Employee")) {
                task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
            } else {
                super.processTaskDelegation(task);
            }
        } else {
            super.processTaskDelegation(task);
        }
    }

    private void expenseReportTaskCompleted(DelegateTask dt) {
        ExpenseReport entity = getRequestFromTask(dt);
        if (entity == null) {
            return;
        }
        //Notes
        String notes = (String) dt.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
//            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.expenseReport", "You cannot approve your expenseReport task");
        }
        //Status
        String status = (String) dt.getExecution().getVariable("status");
        BigDecimal totExpenses = entity.getTotalExpenses();
        BigDecimal checkedExpenses = new BigDecimal("1000.00");
        if (dt.getTaskDefinitionKey().equals("expenseReportMgrApprovalTask")) {
            if (status.equalsIgnoreCase("approved")) {
                if (totExpenses.compareTo(checkedExpenses) == 1) {
                    entity.setStatus(ExpenseReportStatus.PENDING_CEO_APPROVAL);
                } else {
                    entity.setStatus(ExpenseReportStatus.PENDING_ACCOUNTS_PAYABLE_DISPATCH);
                }
                entity.setApprovedByManager(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
                entity.setApprovedByManagerDate(new Date());
            } else {
                entity.setStatus(ExpenseReportStatus.REJECTED);
            }
        }
        if (dt.getTaskDefinitionKey().equals("expenseReportFinalApprovalTask") && ExpenseReportStatus.PENDING_CEO_APPROVAL.equals(entity.getStatus())) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ExpenseReportStatus.PENDING_ACCOUNTS_PAYABLE_DISPATCH);
                entity.setApprovedByCEO(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
                entity.setApprovedByCEODate(new Date());
            } else {
                entity.setStatus(ExpenseReportStatus.REJECTED);
            }
        }
        if (dt.getTaskDefinitionKey().equals("expenseReportAccountsPayableTask") && ExpenseReportStatus.PENDING_ACCOUNTS_PAYABLE_DISPATCH.equals(entity.getStatus())) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ExpenseReportStatus.APPROVED);
                entity.setApprovedByAccountsDept(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
                entity.setApprovedByAccountsDeptDate(new Date());
            } else {
                entity.setStatus(ExpenseReportStatus.REJECTED);
            }
        }
        dt.getExecution().setVariable("entity", entity);
        ExpenseReportsDao.instance().save(entity);
    }

    protected ExpenseReport getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ExpenseReportsDao.instance().findById(entityId);
        }
        return null;
    }
}
