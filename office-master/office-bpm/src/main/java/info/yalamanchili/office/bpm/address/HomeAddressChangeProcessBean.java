/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.address;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
@Transactional
public class HomeAddressChangeProcessBean {
    
    @Autowired
    protected MailUtils mailUtils;

//TODO send email to employee with default set of instructions
    public void sendAddressChangeRequestSubmittedEmail(Address address) {
        Email email = new Email();
        email.addTo(EmployeeDao.instance().getPrimaryEmail(EmployeeDao.instance().findById(address.getContact().getId())));
        StringBuilder subject = new StringBuilder();
        subject.append("Address update request received");
        email.setSubject(subject.toString());
        Map<String, Object> emailCtx = new HashMap<String, Object>();
        email.setTemplateName("home_address_update_template.html");
        email.setContext(emailCtx);
        email.setHtml(Boolean.TRUE);
        MessagingService.instance().sendEmail(email);
    }
//TODO send email to employee

    public void sendAddressChangeRequestCompletedEmail(Address address) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTo(EmployeeDao.instance().getPrimaryEmail(((Employee) address.getContact())));
        email.setSubject("Address update request complete");
        email.setBody("Your Address request has been completed");
        messagingService.sendEmail(email);
    }
}
