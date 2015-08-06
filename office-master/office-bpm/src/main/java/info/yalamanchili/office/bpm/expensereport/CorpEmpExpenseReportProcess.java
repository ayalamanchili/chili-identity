/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.expensereport;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReportsDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReportStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class CorpEmpExpenseReportProcess implements TaskListener {

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
        if (dt.getTaskDefinitionKey().equals("expenseReportMgrApprovalTask")) {
            assignExpenseReportTask(dt);
        }
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
        if (dt.getTaskDefinitionKey().equals("expenseReportMgrApprovalTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ExpenseReportStatus.PENDING_CEO_APPROVAL);
                entity.setApprovedByManager(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
                entity.setApprovedByManagerDate(new Date());
            } else {
                entity.setStatus(ExpenseReportStatus.REJECTED);
            }
        }
        if (dt.getTaskDefinitionKey().equals("expenseReportFinalApprovalTask") && ExpenseReportStatus.PENDING_CEO_APPROVAL.equals(entity.getStatus())) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ExpenseReportStatus.PENDING_PAYROLL_APPROVAL);
                entity.setApprovedByCEO(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
                entity.setApprovedByCEODate(new Date());
            } else {
                entity.setStatus(ExpenseReportStatus.REJECTED);
            }
        }

        if (dt.getTaskDefinitionKey().equals("expenseReportPayrollApprovalTask") && ExpenseReportStatus.PENDING_PAYROLL_APPROVAL.equals(entity.getStatus())) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ExpenseReportStatus.APPROVED);
                entity.setApprovedByAccountsDept(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
                entity.setApprovedByAccountsDeptDate(new Date());
            } else {
                entity.setStatus(ExpenseReportStatus.REJECTED);
            }
        }
        ExpenseReportsDao.instance().save(entity);
        new GenericTaskCompleteNotification().notify(dt);
    }

    private void assignExpenseReportTask(DelegateTask dt) {
        Employee emp = (Employee) dt.getExecution().getVariable("currentEmployee");
        Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (reportsToEmp != null) {
            dt.addCandidateUser(reportsToEmp.getEmployeeId());
        } else {
            dt.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name());
        }
    }

    protected ExpenseReport getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ExpenseReportsDao.instance().findById(entityId);
        }
        return null;
    }
}
