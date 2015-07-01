/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.travelauthorization;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.travelauthorization.TravelAuthorizationDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorizationStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author prasanthi.p
 */
public class TravelAuthorizationProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            travelAuthorizationRequestTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            travelAuthorizationTaskCompleted(task);
        }
    }

    protected void travelAuthorizationRequestTaskCreated(DelegateTask task) {
        if (task.getTaskDefinitionKey().equals("travelAuthorizationApprovalTask")) {
            saveTravelAuthorization(task);
            assignTravelAuthorizationTask(task);
        }
        new GenericTaskCreateNotification().notify(task);
    }

    protected void travelAuthorizationTaskCompleted(DelegateTask task) {
        TravelAuthorization entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.travelauthorization", "You cannot approve your travel authorization task");
        }
        switch (task.getTaskDefinitionKey()) {
            case "travelAuthorizationApprovalTask":
                managerApprovalTaskComplete(entity, task);
                break;
            case "travelAuthorizationFinalApprovalTask":
                adminApprovalTaskComplete(entity, task);
                break;
        }
    }

    protected void managerApprovalTaskComplete(TravelAuthorization entity, DelegateTask task) {
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setTravelExpenseRequisitionStatus(TravelAuthorizationStatus.PENDING_CEO_APPROVAL);
            entity.setCeoApprovalBy(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
            entity.setCeoApprovalDate(new Date());
        } else {
            entity.setTravelExpenseRequisitionStatus(TravelAuthorizationStatus.REJECTED);
            new GenericTaskCompleteNotification().notify(task);
        }
        TravelAuthorizationDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
    }

    protected void adminApprovalTaskComplete(TravelAuthorization entity, DelegateTask task) {
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setTravelExpenseRequisitionStatus(TravelAuthorizationStatus.APPROVED);
        } else {
            entity.setTravelExpenseRequisitionStatus(TravelAuthorizationStatus.REJECTED);
        }
        TravelAuthorizationDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
        new GenericTaskCompleteNotification().notifyWithMoreRoles(task, OfficeRoles.OfficeRole.ROLE_ADMIN.name());
    }

    protected void saveTravelAuthorization(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        TravelAuthorizationDao dao = TravelAuthorizationDao.instance();
        TravelAuthorization entity = (TravelAuthorization) task.getExecution().getVariable("entity");
        entity.setBpmProcessId(task.getExecution().getProcessInstanceId());
        entity.setTravelExpenseRequisitionStatus(TravelAuthorizationStatus.PENDING_MANAGER_APPROVAL);
        entity.setEmployee(emp);
        entity = dao.save(entity);
        CommentDao.instance().addComment("Save Travel Authorizaton Expense", entity);
        task.getExecution().setVariable("entity", entity);
        task.getExecution().setVariable("entityId", entity.getId());
    }

    protected void assignTravelAuthorizationTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (emp.getEmployeeType().getName().equals("Corporate Employee") && reportsToEmp != null) {
            task.addCandidateUser(reportsToEmp.getEmployeeId());
        } else {
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_ADMIN.name());
        }
    }

    protected TravelAuthorization getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return TravelAuthorizationDao.instance().findById(entityId);
        }
        return null;
    }
}
