package info.yalamanchili.office.jms;

import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.EmailService;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class EmailQueueMessageListener implements MessageListener {

    @Autowired
    protected EmailService emailService;

    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
                Email email = (Email) msg.getObject();
                emailService.sendEmail(email);
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
