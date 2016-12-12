/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.selfserv;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author ayalamanchili
 */
public class ServiceTaskCompleteListener extends GenericTaskCompleteNotification {

    @Override
    public void notify(DelegateTask delegateTask) {
        if (delegateTask.hasVariable("check-flag")) {
            super.notify(delegateTask);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.complete.service.ticket.task", "Please go to MyOffice-->Employee-->Selfservcie to resolve the Ticket");
        }
    }
}
