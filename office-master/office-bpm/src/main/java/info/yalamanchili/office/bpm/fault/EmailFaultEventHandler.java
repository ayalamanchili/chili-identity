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
import info.chili.email.Email;
import info.yalamanchili.office.jms.MessagingService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component("info.chili.email.Email.FaultEventHandler")
@Transactional
public class EmailFaultEventHandler implements FaultEventHandler {

    @Override
    //TODO async ?
    //TODO handle exception?
    public void handleFaultEvent(FaultEventPayload faultEventPayload) {
        MessagingService.instance().sendEmail((Email) faultEventPayload.getPayload());
    }

}
