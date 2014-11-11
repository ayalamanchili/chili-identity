/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.expensereport;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.ExpenseReportsDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.ExpenseReport;
import info.yalamanchili.office.entity.profile.Employee;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author prasanthi.p
 */
public class ExpenseReportRequestProcess implements TaskListener {

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
        if (dt.getTaskDefinitionKey().equals("expenseReportApprovalTask")) {
            saveExpenseReport(dt);
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
        new GenericTaskCompleteNotification().notify(dt);
    }

    private void saveExpenseReport(DelegateTask dt) {
        Employee emp = (Employee) dt.getExecution().getVariable("currentEmployee");
        ExpenseReportsDao dao = ExpenseReportsDao.instance();
        ExpenseReport entity = (ExpenseReport) dt.getExecution().getVariable("entity");
        String expenseReport = "Expense Report Department:" + entity.getDepartment() + "Report Description :" + entity.getDescription();
//        entity.setBpmProcessId(dt.getExecution().getProcessInstanceId());
//        entity.setStatus(AdvanceRequisitionStatus.Pending);
        entity.setEmployee(emp);
        entity = dao.save(entity);
        dt.getExecution().setVariable("entity", entity);
        dt.getExecution().setVariable("entityId", entity.getId());
    }

    private void assignExpenseReportTask(DelegateTask dt) {
        Employee emp = (Employee) dt.getExecution().getVariable("currentEmployee");
        Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (emp.getEmployeeType().getName().equals("Corporate Employee") && reportsToEmp != null) {
            dt.addCandidateUser(reportsToEmp.getEmployeeId());
        } else {
            dt.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name());
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
