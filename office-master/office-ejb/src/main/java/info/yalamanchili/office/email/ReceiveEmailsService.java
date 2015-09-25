/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.mail.search.MessageIDTerm;
import javax.mail.search.SearchTerm;
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
    
    public void processNewMessages() {
        try {
            Folder inbox = getStore().getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            
            Message[] messages = reverseMessageOrder(inbox.search(unseenFlagTerm));
            for (int i = 0; i <= 10; i++) {
                Message msg = messages[i];
                System.out.println("ddddddd" + msg.getSubject());
                if (msg.getSubject().contains("Task Created:")) {
                    //get in reply to messge id
                    String inReplyToMessageId = getMessageHeader(msg, IN_REPLY_TO_HEADER);
                    if (inReplyToMessageId != null) {
                        //get orginal message.
                        Message originalMsg = getOriginalMessage(inbox, inReplyToMessageId);
                        if (originalMsg != null) {
                            //get task-id
                            String taskId = getMessageHeader(msg, TASK_ID_HEADER);
                            if (taskId != null) {
                                OfficeBPMTaskService.instance().completeTaskOnBehalf(taskId, Collections.EMPTY_LIST, msg.getFrom()[0].toString());
                            }
                        }
                    }
                    
                }
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
