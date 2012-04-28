package info.yalamanchili.office.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("---------- in on message-----------");
		try {
			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage) message;
				String msg = tm.getText();
			}
		} catch (JMSException e) {
			System.out.println("eerror	");
		}
	}
}
