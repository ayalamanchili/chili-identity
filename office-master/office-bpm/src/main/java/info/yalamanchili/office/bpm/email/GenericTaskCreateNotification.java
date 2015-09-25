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
import info.chili.email.Email;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.HashSet;
import java.util.Set;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class GenericTaskCreateNotification implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        notify(delegateTask, false);
    }

    public void notifyWithMoreRoles(DelegateTask delegateTask, String... notifyRoles) {
        notify(delegateTask, Boolean.FALSE, notifyRoles);
    }

    public void notify(DelegateTask delegateTask, Boolean notifyEmployee, String... notifyRoles) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        if (delegateTask.getExecution().getVariable("currentEmployee") != null) {
            Employee currentEmployee = (Employee) delegateTask.getExecution().getVariable("currentEmployee");
            //TODO is this needed?
            delegateTask.setOwner(currentEmployee.getFirstName() + " " + currentEmployee.getLastName());
        }
        Email email = new Email();
        email.setTos(getEmails(delegateTask, notifyEmployee, notifyRoles));
        email.setSubject("Task Created:" + delegateTask.getName());
        String messageText = "Task is Created. Please complete.\n Details: \n Name: " + delegateTask.getName() + " \n Description:" + delegateTask.getDescription();
        email.setHtml(Boolean.TRUE);
        email.setBody(messageText);
        email.getHeaders().put("task-id", delegateTask.getId());
        messagingService.sendEmail(email);
    }

    public Set<String> getEmails(DelegateTask delegateTask, Boolean notifyEmployeeAlso, String... notifyRoles) {
        Set<String> emails = new HashSet();
        emails.addAll(BPMUtils.getCandidateEmails(delegateTask));
        if (notifyRoles.length > 0) {
            emails.addAll(MailUtils.instance().getEmailsAddressesForRoles(notifyRoles));
        }
        if (notifyEmployeeAlso) {
            Employee employee = (Employee) delegateTask.getExecution().getVariable("currentEmployee");
            if (employee != null) {
                emails.add(EmployeeDao.instance().getPrimaryEmail(employee.getId()));
            }
        }
        return emails;
    }
}
