package info.yalamanchili.office.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class EmailQueueMessageListener implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("---------- in email queue  message-----------");
		try {
			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage) message;
				String msg = tm.getText();
			}
		} catch (JMSException e) {
			System.out
					.println("-----------------error-----------------------	");
			throw new RuntimeException(e);

		}
	}
}
