/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.email;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.task.IdentityLink;

/**
 *
 * @author ayalamanchili
 */
public class GenericTaskCreateNotification implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        MailUtils mailUtils = (MailUtils) SpringContext.getBean("mailUtils");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        //
        List<String> roles = new ArrayList<String>();
        Email email = new Email();
        for (IdentityLink identityLink : delegateTask.getCandidates()) {
            if (identityLink.getGroupId() != null && !identityLink.getGroupId().isEmpty()) {
                roles.add(identityLink.getGroupId());
            }
            if (identityLink.getUserId() != null && !identityLink.getUserId().isEmpty()) {
                email.addTo(identityLink.getUserId());
            }
        }
        if (roles.size() > 0) {
            email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        }
        if (delegateTask.getAssignee() != null && !delegateTask.getAssignee().isEmpty()) {
            email.addTo(delegateTask.getAssignee());
        }
        email.setSubject("Task Created:" + delegateTask.getName());
        String messageText = "Task is Created. Please complete.\n Details: \n Name: " + delegateTask.getName() + " \n Description:" + delegateTask.getDescription();
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }
}
