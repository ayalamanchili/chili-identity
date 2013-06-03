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
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.task.IdentityLink;

/**
 * Use this for notifying the current for approval of any submitted requests.
 *
 * @author ayalamanchili
 */
public class GenericTaskCompleteNotification implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        MailUtils mailUtils = (MailUtils) SpringContext.getBean("mailUtils");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        //
        List<String> roles = new ArrayList<String>();
        Employee employee = (Employee) delegateTask.getExecution().getVariable("currentEmployee");
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
        if (employee != null) {
            email.addTo(employee.getPrimaryEmail().getEmail());
        }
        if (delegateTask.getAssignee() != null && !delegateTask.getAssignee().isEmpty()) {
            email.addTo(delegateTask.getAssignee());
        }

        String subjectText = "Task Complete:" + delegateTask.getName();
        String messageText = "Task Complete.  Details: \n Name: " + delegateTask.getName() + " \n Description:" + delegateTask.getDescription();
        //task statuss
        String status = (String) delegateTask.getExecution().getVariable("status");
        if (status != null) {
            subjectText = subjectText.concat(" Status:" + status.toUpperCase());
            messageText = messageText.concat(" \n Status:" + status.toUpperCase());
        }
        //task notes
        String notes = (String) delegateTask.getExecution().getVariable("notes");
        if (notes != null) {
            subjectText = subjectText.concat(" Notes:" + notes);
            messageText = messageText.concat(" \n Notes:" + notes);
        }
        email.setSubject(subjectText);
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }
}
