/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import java.util.logging.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author yalamanchili
 */
@Component
public class EmailService {

    private static Logger logger = Logger.getLogger(EmailService.class.getName());
    protected JavaMailSender mailSender;

//    public void sendEmail(Email email) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email.getTos().toArray(new String[email.getTos().size()]));
//        if (email.getCcs() != null && email.getCcs().size() > 0) {
//            message.setCc(email.getCcs().toArray(new String[email.getCcs().size()]));
//        }
//        message.setSubject(email.getSubject());
//        message.setText(email.getBody());
//        OfficeServiceConfiguration officeserviceconfiguration = (OfficeServiceConfiguration) SpringContext.getBean("officeServiceConfiguration");
//        if (officeserviceconfiguration.getIsSendEmail() == true) {
//            logger.info("sending email:" + email);
//            mailSender.send(message);
//        }
//    }
    public void sendEmail(final Email email) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                Address[] tos = convertToEmailAddress(email.getTos());
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

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
