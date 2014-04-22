/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.TaskQuery;

/**
 *
 * @author ayalamanchili
 */
public class EmailEscalation implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TaskService bpmTaskService = (TaskService) SpringContext.getBean("bpmTaskService");
        MailUtils mailUtils = (MailUtils) SpringContext.getBean("mailUtils");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        //
        TaskQuery query = bpmTaskService.createTaskQuery().processInstanceId(execution.getProcessInstanceId());
        for (org.activiti.engine.task.Task task : query.list()) {
            List<String> roles = new ArrayList<String>();
            Set<String> emails = new HashSet<String>();
            List<IdentityLink> identityLinks = bpmTaskService.getIdentityLinksForTask(task.getId());
            Email email = new Email();
            for (IdentityLink identityLink : identityLinks) {
                if (identityLink.getGroupId() != null && !identityLink.getGroupId().isEmpty()) {
                    roles.add(identityLink.getGroupId());
                }
                if (identityLink.getUserId() != null && !identityLink.getUserId().isEmpty()) {
                    Employee emp = MailUtils.instance().findEmployee(identityLink.getUserId());
                    if (emp != null && emp.getPrimaryEmail() != null) {
                        emails.add(emp.getPrimaryEmail().getEmail());
                    }
                }
            }
            if (roles.size() > 0) {
                emails.addAll(mailUtils.getEmailsAddressesForRoles(roles.toArray(new String[roles.size()])));
            }
            email.setTos(emails);
            email.setHtml(Boolean.TRUE);
            email.setSubject("Task Escalation Email");
            String messageText = "Task is Escalated. Please complete.\n Details: \n Name" + task.getName() + " \n Description:" + task.getDescription();
            email.setBody(messageText);
            messagingService.sendEmail(email);
        }
    }
}
