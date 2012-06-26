package info.yalamanchili.office.jms;

import info.yalamanchili.office.email.Email;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

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
