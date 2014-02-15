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
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import info.yalamanchili.office.entity.selfserv.TicketStatus;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author ayalamanchili
 */
public class ServiceTaskCompleteListener extends GenericTaskCompleteNotification {

    @Override
    public void notify(DelegateTask delegateTask) {
        ServiceTicket ticket = (ServiceTicket) delegateTask.getVariable("ticket");
//        if (TicketStatus.Open.equals(ticket.getStatus()) || TicketStatus.InProgress.equals(ticket.getStatus())) {
//            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "Complete", "Task incomplete", "Task cannot be completed util resolved with comments under employee.");
//        }
        super.notify(delegateTask);
    }
}
