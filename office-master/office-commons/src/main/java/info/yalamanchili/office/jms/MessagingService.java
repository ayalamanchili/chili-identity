/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jms;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.chili.email.Email;
import info.yalamanchili.office.email.EmailService;
import org.springframework.stereotype.Component;

@Component
public class MessagingService {

    public void sendEmail(final Email email) {
        if (OfficeServiceConfiguration.instance().getIsSendMail()) {
            EmailService.instance().sendEmail(email);
        }
    }

    public void emailReport(String fileName, String... tos) {
        Email email = new Email();
        for (String to : tos) {
            email.addTo(to);
        }
        email.setSubject("Report:" + fileName);
        email.addAttachment(fileName);
        sendEmail(email);

    }

    public static MessagingService instance() {
        return SpringContext.getBean(MessagingService.class);
    }
}
