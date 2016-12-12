/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.travelauthorization;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.expense.travelauthorization.TravelAuthorizationDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorizationStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author prasanthi.p
 */
public class TravelAuthorizationProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
        if ("complete".equals(task.getEventName())) {
            travelAuthorizationTaskCompleted(task);
        }
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
            case "travelAuthorizationManagerApprovalTask":
                managerApprovalTaskComplete(entity, task);
                break;
            case "travelAuthorizationBookingTask":
                travelBookingManagerApprovalTaskComplete(entity, task);
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
            entity.setStatus(TravelAuthorizationStatus.PENDING_TRAVEL_BOOKING);
            entity.setManagerApprovalBy(OfficeSecurityService.instance().getCurrentUser().getEmployeeId());
            entity.setManaerApprovalDate(new Date());
        } else {
            entity.setStatus(TravelAuthorizationStatus.REJECTED);
        }
        TravelAuthorizationDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
    }


    protected void travelBookingManagerApprovalTaskComplete(TravelAuthorization entity, DelegateTask task) {
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        entity.setStatus(TravelAuthorizationStatus.APPROVED);
        TravelAuthorizationDao.instance().save(entity);
    }

    protected TravelAuthorization getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return TravelAuthorizationDao.instance().findById(entityId);
        }
        return null;
    }
}
