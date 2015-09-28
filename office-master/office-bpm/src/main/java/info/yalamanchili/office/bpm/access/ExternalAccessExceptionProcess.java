/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.access;

import info.chili.security.dao.CIPAddressDao;
import info.chili.security.dto.RemoteAccessRequestDto;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class ExternalAccessExceptionProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        if (null != dt.getEventName()) switch (dt.getEventName()) {
            case "create":
                new GenericTaskCreateNotification().notify(dt);
                break;
            case "complete":
                String status = (String) dt.getExecution().getVariable("status");
                RemoteAccessRequestDto dto = (RemoteAccessRequestDto) dt.getExecution().getVariable("entity");
                if (status.equalsIgnoreCase("approved")) {
                    CIPAddressDao.instance().addUserIPAddress(dto.getUserId(), dto.getRemoteIp());
                }   new GenericTaskCompleteNotification().notify(dt);
                break;
        }
    }
}
