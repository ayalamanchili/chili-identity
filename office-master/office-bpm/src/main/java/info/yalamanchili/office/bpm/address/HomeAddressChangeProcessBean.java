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
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
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

    public void sendAddressChangeRequestSubmittedEmail(Address address) {
    }

    public void sendAddressChangeRequestCompletedEmail(Address address, Employee employee) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTo(EmployeeDao.instance().getPrimaryEmail(employee));
        email.setSubject("Address pdated Review");
        email.setBody("Your Address updated review as been completed");
        messagingService.sendEmail(email);

    }
}
