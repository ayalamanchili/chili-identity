/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import info.chili.spring.SpringContext;
import java.util.logging.Logger;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.stereotype.Component;
import info.yalamanchili.office.config.OfficeServiceConfiguration;

/**
 *
 * @author yalamanchili
 */
@Component
public class EmailService {

    private static Logger logger = Logger.getLogger(EmailService.class.getName());
    protected MailSender mailSender;

    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTos().toArray(new String[email.getTos().size()]));
        if (email.getCcs() != null && email.getCcs().size() > 0) {
            message.setCc(email.getCcs().toArray(new String[email.getCcs().size()]));
        }
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        OfficeServiceConfiguration officeserviceconfiguration = (OfficeServiceConfiguration) SpringContext.getBean("officeServiceConfiguration");
        if (officeserviceconfiguration.getIsSendEmail() == true) {
            logger.info("sending email:" + email);
            mailSender.send(message);
        }
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}
