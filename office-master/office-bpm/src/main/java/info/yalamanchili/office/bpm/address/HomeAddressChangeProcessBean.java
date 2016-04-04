/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.address;

import info.chili.jms.adapter.CMessage;
import info.chili.jms.adapter.CMessagingService;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.chili.email.Email;
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

    public void sendAddressChangeRequestSubmittedEmail(Address address) {
        Email email = new Email();
        email.addTo(EmployeeDao.instance().getPrimaryEmail(EmployeeDao.instance().findById(address.getContact().getId())));
        StringBuilder subject = new StringBuilder();
        subject.append("Address update request received");
        email.setSubject(subject.toString());
        Map<String, Object> emailCtx = new HashMap<>();
        emailCtx.put("employeeName", address.getContact().getFirstName() + " " + address.getContact().getLastName());
        email.setTemplateName("home_address_update_template.html");
        email.setContext(emailCtx);
        email.setHtml(Boolean.TRUE);
        MessagingService.instance().sendEmail(email);
    }

    public void sendAddressChangeRequestEEMNotificationEmail(Address address) {
        //TODO send only for associate employee
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_RELATIONSHIP.name()));
        email.setSubject("Employee " + address.getContact().getFirstName() + " " + address.getContact().getLastName() + " Home Address has been updated");
        email.setBody("<b>Employee   : </b>" + address.getContact().getFirstName() + " " + address.getContact().getLastName() + "<br/> <br/> <b>Description : </b> Home / Primary Address has been updated");
        //TODO add address information in the email body
        messagingService.sendEmail(email);
    }

    public void sendAddressChangeRequestCompletedEmail(Address address) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTo(EmployeeDao.instance().getPrimaryEmail(((Employee) address.getContact())));
        email.setSubject("Address update request complete");
        email.setBody("Your Address request has been completed");
        messagingService.sendEmail(email);
    }

    public void publishToExternalSystems(Address address) {
        CMessagingService.instance().send(new CMessage("info.yalamanchili.office.integration.address.AddressPublishService", address));
    }
}
