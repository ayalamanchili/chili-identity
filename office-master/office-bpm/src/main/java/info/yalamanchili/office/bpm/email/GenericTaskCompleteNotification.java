/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.email;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.BPMUtils;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.chili.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.HashSet;
import java.util.Set;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * Use this for notifying the current for approval of any submitted requests.
 *
 * @author ayalamanchili
 */
public class GenericTaskCompleteNotification implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        notifyWithMoreRoles(delegateTask);
    }

    public void notify(DelegateTask delegateTask, Boolean notifyEmployee, String... notifyRoles) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.setTos(getEmails(delegateTask, notifyEmployee, notifyRoles));
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
        Employee taskActionUser = (Employee) delegateTask.getExecution().getVariable("taskActionUser");
        if (taskActionUser != null) {
            messageText = messageText.concat(" \n Task Updated By:" + taskActionUser.getFirstName() + " " + taskActionUser.getLastName());
        }
        email.setHtml(Boolean.TRUE);
        email.setSubject(subjectText);
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    public void notifyWithMoreRoles(DelegateTask delegateTask, String... notifyRoles) {
        notify(delegateTask, Boolean.FALSE, notifyRoles);
    }

    public Set<String> getEmails(DelegateTask delegateTask, Boolean notifyEmployeeOnly, String... notifyRoles) {
        Set<String> emails = new HashSet();
        if (!notifyEmployeeOnly) {
            emails.addAll(BPMUtils.getCandidateEmails(delegateTask));
        }
        if (notifyRoles.length > 0) {
            emails.addAll(MailUtils.instance().getEmailsAddressesForRoles(notifyRoles));
        }
        Employee employee = (Employee) delegateTask.getExecution().getVariable("currentEmployee");
        if (employee != null) {
            emails.add(EmployeeDao.instance().getPrimaryEmail(employee.getId()));
        }
        return emails;
    }
}
