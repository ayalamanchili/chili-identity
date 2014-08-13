/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jms;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.email.Email;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessagingService {

    @Autowired
    protected JmsTemplate offcieJmsTemplate;
    @Autowired
    protected Destination emailQueue;

    public void sendEmail(final Email email) {
        if (OfficeServiceConfiguration.instance().getIsSendMail()) {
            offcieJmsTemplate.send(emailQueue, new MessageCreator() {
                @Override
                public Message createMessage(Session arg0) throws JMSException {

                    ObjectMessage msg = arg0.createObjectMessage();
                    msg.setObject(email);
                    return msg;
                }
            });
        }
    }

    public void emailReport(String fileName, byte[] reportData, String... tos) {
        Email email = new Email();
        for (String to : tos) {
            email.addTo(to);
        }
        email.setSubject("Report:"+fileName);
        email.addAttachment(fileName);
        sendEmail(email);

    }

    public static MessagingService instance() {
        return SpringContext.getBean(MessagingService.class);
    }
}
