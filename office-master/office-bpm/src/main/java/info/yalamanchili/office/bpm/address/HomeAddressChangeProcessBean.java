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
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.selfserv.TicketComment;
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

    public void sendAddressChangeRequestSubmittedEmail(Address address, TicketComment comment) {


        Employee commentAuthor = OfficeSecurityService.instance().getCurrentUser();
        String[] roles = {OfficeRoles.OfficeRole.ROLE_RECRUITER.name()};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        StringBuilder subject = new StringBuilder();
        subject.append(commentAuthor.getFirstName()).append(" ").append(commentAuthor.getLastName()).append(" updated ticket:").append(comment.getTicket().getSubject());
        email.setSubject(subject.toString());
        Map<String, Object> emailCtx = new HashMap<String, Object>();
        emailCtx.put("currentComment", comment);
        emailCtx.put("ticket", comment.getTicket());
        emailCtx.put("ticketDepartment", OfficeRoles.rolesMessages.get(comment.getTicket().getDepartmentAssigned().getRolename()));

        email.setTemplateName("address_update_template.html");
        email.setContext(emailCtx);
        email.setHtml(Boolean.TRUE);
        MessagingService.instance().sendEmail(email);

    }

    public void sendAddressChangeRequestCompletedEmail(Address address, Employee employee) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTo(EmployeeDao.instance().getPrimaryEmail(employee));
        email.setSubject("Address Updated Review");
        email.setBody("Your Address updated review as been completed");
        messagingService.sendEmail(email);

    }
}
