/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.fault;

import info.chili.exception.FaultEventPayload;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class FaultEventProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        Boolean enableEmailNotification = (Boolean) task.getVariable("enableEmailNotification");
        if ("create".equals(task.getEventName())) {
            if (enableEmailNotification) {
                new GenericTaskCreateNotification().notify(task);
            }
        }
        if ("complete".equals(task.getEventName())) {
            handleFaultEventRetry(task);
            if (enableEmailNotification) {
                new GenericTaskCompleteNotification().notify(task);
            }
        }
    }

    protected void handleFaultEventRetry(DelegateTask task) {
        FaultEventPayload payload = (FaultEventPayload) task.getVariable("entity");
        FaultEventHandler handler = (FaultEventHandler) SpringContext.getBean(payload.getPayloadType() + ".FaultEventHandler");
        handler.handleFaultEvent(payload);
    }

}
