/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import info.chili.email.dao.TaskEmailDao;
import info.chili.email.domain.TaskEmail;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FlagTerm;
import javax.mail.search.MessageIDTerm;
import javax.mail.search.SearchTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Transactional
public class ReceiveEmailsService {
    
    protected Store store;
    
    @Autowired
    protected MongoTemplate mongoTemplate;
    
    public void processNewMessages() {
        try {
            Folder inbox = getStore().getFolder("inbox");
            inbox.open(Folder.READ_WRITE);
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            
            Message[] messages = reverseMessageOrder(inbox.search(unseenFlagTerm));
            for (int i = 0; i <= 10; i++) {
                Message msg = messages[i];
                String inReplyToMessageId = getMessageHeader(msg, IN_REPLY_TO_HEADER);
                if (inReplyToMessageId != null) {
                    TaskEmail taskEmail = TaskEmailDao.instance().find(inReplyToMessageId);
                    if (taskEmail != null) {
                        String taskId = taskEmail.getTaskId();
                        List<Entry> attrs = new ArrayList();
                        Entry attr = new Entry("status", "approved");
                        attrs.add(attr);
                        String email = msg.getFrom() == null ? null : ((InternetAddress) msg.getFrom()[0]).getAddress();
                        try {
                            OfficeBPMTaskService.instance().completeTaskOnBehalf(taskId, attrs, email);
                            msg.setFlag(Flag.SEEN, true);
                            taskEmail.setProcessed(true);
                            taskEmail.setProcessedByEmail(email);
                            taskEmail.setProcessedTimeStamp(new Date());
                            taskEmail.setResponseContent(msg.getContent().toString());
                            mongoTemplate.save(taskEmail);
                        } catch (ServiceException e) {
                            //TODO send email about issue in completing the task via email
                        }
                    }
                }

//                }
            }
            inbox.close(true);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected Message getOriginalMessage(Folder inbox, String messageId) throws MessagingException {
        SearchTerm searchTerm = new MessageIDTerm(messageId);
        Message[] messages = inbox.search(searchTerm);
        if (messages.length > 0) {
            return messages[0];
        } else {
            return null;
        }
    }
    
    protected static final String IN_REPLY_TO_HEADER = "In-Reply-To";
    protected static final String TASK_ID_HEADER = "task-id";
    
    protected String getMessageHeader(Message msg, String headerName) throws MessagingException {
        if (msg.getHeader(headerName) != null && msg.getHeader(headerName).length > 0) {
            return msg.getHeader(headerName)[0];
        }
        return null;
    }
    
    private static Message[] reverseMessageOrder(Message[] messages) {
        Message revMessages[] = new Message[messages.length];
        int i = messages.length - 1;
        for (int j = 0; j < messages.length; j++, i--) {
            revMessages[j] = messages[i];
            
        }
        
        return revMessages;
    }
    
    protected Store getStore() {
        if (store == null || !store.isConnected()) {
            try {
                Properties props = new Properties();
                props.load(new FileInputStream(new File("/home/ayalamanchili/smtp.properties")));
                Session session = Session.getDefaultInstance(props, null);
                this.store = session.getStore("imaps");
                store.connect("smtp.gmail.com", "ayalamanchili@sstech.mobi", "zuzubi1833");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return store;
    }
    
    public static ReceiveEmailsService instance() {
        return SpringContext.getBean(ReceiveEmailsService.class);
    }
}
