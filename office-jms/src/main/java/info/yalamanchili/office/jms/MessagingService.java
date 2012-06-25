package info.yalamanchili.office.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
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

	public void sendJMSMessage(final String to, final String message) {
		System.out.println("-----------sending email message---------------");
		offcieJmsTemplate.send(emailQueue, new MessageCreator() {

			@Override
			public Message createMessage(Session arg0) throws JMSException {

				TextMessage msg = arg0.createTextMessage();
				msg.setText(message);
				return msg;
			}
		});
	}
}
