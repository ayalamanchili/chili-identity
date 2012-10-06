/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import info.yalamanchili.office.entity.profile.Employee;
import java.util.logging.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;

/**
 *
 * @author yalamanchili
 */
@Component
public class EmailService {

    private static Logger logger = Logger.getLogger(EmailService.class.getName());
    protected JavaMailSender mailSender;

    @Async
    public void sendEmail(final Email email) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                Address[] tos = convertToEmailAddress(filterEmails(email.getTos()));
                mimeMessage.setRecipients(Message.RecipientType.TO, tos);
                mimeMessage.setSubject(email.getSubject());
                if (email.isHtml) {
                    message.setText(email.getBody(), true);
                } else {
                    message.setText(email.getBody());
                }
            }
        };
        try {
            logger.info("sending email:" + email);
            mailSender.send(preparator);
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }

    private Address[] convertToEmailAddress(Set<String> emails) {
        emails = filterEmails(emails);
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
        if (findEmail(emailAddress).getContact() instanceof Employee) {
            Employee emp = (Employee) findEmail(emailAddress).getContact();
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
        Query getEmailQ = em.createQuery("from " + info.yalamanchili.office.entity.profile.Email.class.getCanonicalName() + " where email=:emailAddressParam");
        getEmailQ.setParameter("emailAddressParam", emailAddress);
        if (getEmailQ.getResultList().size() > 0) {
            System.out.println("dddddd");
            return (info.yalamanchili.office.entity.profile.Email) getEmailQ.getResultList().get(0);
        } else {
            return null;
        }
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
