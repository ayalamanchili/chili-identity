/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.clientinformation;

import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Employee;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author prasanthi.p
 */
public class NewClientInformationProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
        if ("complete".equals(task.getEventName())) {
            clientInforamtionTaskCompleted(task);
        }
    }

    protected void clientInforamtionTaskCompleted(DelegateTask task) {
        ClientInformation entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);
        //
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
//            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.expenseReport", "You cannot approve your expenseReport task");
        }
        //Status
        String status = (String) task.getExecution().getVariable("status");
        if (task.getTaskDefinitionKey().equals("newClientInfoAccountTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.PENDING_ACCOUNTS_VERIFICATION);
            } else {
                entity.setStatus(ClientInformationStatus.COMPLETED);
            }
        }
        if (task.getTaskDefinitionKey().equals("newClientInfoHRTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.PENDING_HR_VERIFICATION);;
            } else {
                entity.setStatus(ClientInformationStatus.COMPLETED);
            }
        }
        ClientInformationDao.instance().save(entity);
    }

    protected ClientInformation getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ClientInformationDao.instance().findById(entityId);
        }
        return null;
    }
}
