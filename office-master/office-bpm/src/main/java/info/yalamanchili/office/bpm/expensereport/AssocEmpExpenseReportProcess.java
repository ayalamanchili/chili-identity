/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.expensereport;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReportsDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReportStatus;
import info.yalamanchili.office.entity.profile.Employee;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author prasanthi.p
 */
public class AssocEmpExpenseReportProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        if ("create".equals(dt.getEventName())) {
            expenseReportTaskCreated(dt);
        }
        if ("complete".equals(dt.getEventName())) {
            expenseReportTaskCompleted(dt);
        }
    }

    private void expenseReportTaskCreated(DelegateTask dt) {
        new GenericTaskCreateNotification().notify(dt);
    }

    private void expenseReportTaskCompleted(DelegateTask dt) {
        ExpenseReport entity = getRequestFromTask(dt);
        if (entity == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.expenseReport", "You cannot approve your expenseReport task");
        }
        //Status
        String status = (String) dt.getExecution().getVariable("status");
        if (dt.getTaskDefinitionKey().equals("expenseReportPayrollApprovalTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ExpenseReportStatus.PENDING_CEO_APPROVAL);
            } else {
                entity.setStatus(ExpenseReportStatus.REJECTED);
            }
        }

        if (dt.getTaskDefinitionKey().equals("expenseReportFinalApprovalTask") && ExpenseReportStatus.PENDING_CEO_APPROVAL.equals(entity.getStatus())) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ExpenseReportStatus.APPROVED);
            } else {
                entity.setStatus(ExpenseReportStatus.REJECTED);
            }
        }
        ExpenseReportsDao.instance().save(entity);
        new GenericTaskCompleteNotification().notify(dt);
    }

    protected ExpenseReport getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ExpenseReportsDao.instance().findById(entityId);
        }
        return null;
    }
}
