/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.security.SecurityUtils;
import java.io.File;
import java.util.logging.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring3.SpringTemplateEngine;

/**
 *
 * @author yalamanchili
 */
@Component
public class EmailService {

    private static Logger logger = Logger.getLogger(EmailService.class.getName());
    protected JavaMailSender mailSender;
    @Autowired
    protected OfficeServiceConfiguration officeServiceConfiguration;

    @Async
    public void sendEmail(final Email email) {
        final Address[] tos = convertToEmailAddress(filterEmails(email.getTos()));
        if (tos.length < 1) {
            return;
        }
        final SpringTemplateEngine templateEngine = (SpringTemplateEngine) SpringContext.getBean("templateEngine");
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessage.setRecipients(Message.RecipientType.BCC, tos);
                mimeMessage.setSubject(email.getSubject());
                final Context ctx = new Context();
                ctx.setVariable("email", email);
                String htmlContent = templateEngine.process(email.getTemplateName(), ctx);
                message.setText(htmlContent, true);
                processAttchments(message, email);
            }
        };
        try {
            logger.info("sending email:" + email);
            mailSender.send(preparator);
        } catch (MailException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    protected void processAttchments(MimeMessageHelper message, Email email) throws MessagingException {
        for (String attachmentPath : email.getAttachments()) {
            File attachment = new File(officeServiceConfiguration.getContentManagementLocationRoot() + attachmentPath);
            if (attachment.exists()) {
                message.addAttachment(attachment.getName(), attachment);
            }
        }
    }

    private Address[] convertToEmailAddress(Set<String> emails) {
        List<Address> addresses = new ArrayList<Address>();
        for (String emailAddress : emails) {
            Address address = null;
            try {
                address = new InternetAddress(emailAddress);
            } catch (AddressException ex) {
                // simply log it and go on...
                System.err.println(ex.getMessage());
            }
            addresses.add(address);
        }
        return addresses.toArray(new Address[addresses.size()]);
    }

    protected Set<String> filterEmails(Set<String> emails) {
        Set<String> result = new HashSet<String>();
        for (String email : emails) {
            if (notificationsEnabled(email)) {
                result.add(email);
            }
        }
        return result;
    }

    protected boolean notificationsEnabled(String emailAddress) {
        info.yalamanchili.office.entity.profile.Email email = findEmail(emailAddress);
        if (email != null && email.getContact() instanceof Employee) {
            Employee emp = (Employee) findEmail(emailAddress).getContact();
            em.refresh(emp.getPreferences());
            if (!emp.getPreferences().getEnableEmailNotifications()) {
                return false;
            }
        }
        return true;
    }
    
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

//TODO update to return just emp preferecnes
    public info.yalamanchili.office.entity.profile.Email findEmail(String emailAddress) {
        Query getEmailQ = em.createQuery("from " + info.yalamanchili.office.entity.profile.Email.class.getCanonicalName() + " where emailHash=:emailAddressParam");
        getEmailQ.setParameter("emailAddressParam", SecurityUtils.hash(emailAddress));
        if (getEmailQ.getResultList().size() > 0) {
            info.yalamanchili.office.entity.profile.Email email = (info.yalamanchili.office.entity.profile.Email) getEmailQ.getResultList().get(0);
            return email;
        } else {
            return null;
        }
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
