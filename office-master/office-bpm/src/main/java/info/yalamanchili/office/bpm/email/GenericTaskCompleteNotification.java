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
        email.setRichText(Boolean.TRUE);
        email.setTos(getEmails(delegateTask, notifyEmployee, notifyRoles));
        String subjectText = "Task Completed:" + delegateTask.getName();
        String messageText = "<b>Task Completed.  </b> <br/> <br/> <b> Name: </b>" + delegateTask.getName() + " <br/> <b> Description: </b>";
        String description = delegateTask.getDescription();
        String[] descA = description.split("\n");
        messageText = messageText.concat(descA[0] + "<br/> <br/> <b> <u> Details: </u> </b> <br/><html><body><table>");
        for (int i = 1; i < descA.length - 1; i++) {
            if (descA[i].contains(":")) {
                String descArrayLeft = descA[i].substring(0, descA[i].indexOf(":"));
                String descArrayRight = descA[i].substring(descA[i].indexOf(":") + 1, descA[i].length());
                messageText = messageText.concat("<tr> <td> <b>" + descArrayLeft.trim() + "</b> </td>");
                messageText = messageText.concat("<td> :" + descArrayRight + "</td> </tr>");
            } else {
                messageText = messageText.concat("<tr> <td colspan="+2+">" + descA[i] + "</td></tr>");
            }
        }
        if (descA[descA.length - 1].contains("instructions") || descA[descA.length - 1].contains("http")) {
            messageText = messageText.concat("</table></body></html> " + descA[descA.length - 1]);
        } else {
            if (descA[descA.length - 1].contains(":")) {
                String descArrayLeft = descA[descA.length - 1].substring(0, descA[descA.length - 1].indexOf(":"));
                String descArrayRight = descA[descA.length - 1].substring(descA[descA.length - 1].indexOf(":") + 1, descA[descA.length - 1].length());
                messageText = messageText.concat("<tr> <td> <b>" + descArrayLeft.trim() + "</b> </td>");
                messageText = messageText.concat("<td> :" + descArrayRight + "</td> </tr></table></body></html>");
            } else {
                messageText = messageText.concat("<tr> <td colspan="+2+">" + descA[descA.length - 1] + "</td></tr>");
            }
        }
        //task statuss
        String status = (String) delegateTask.getExecution().getVariable("status");
        if (status != null) {
            subjectText = subjectText.concat(" Status:" + status.toUpperCase());
            messageText = messageText.concat(" <br/> <b> Status :</b> &nbsp;" + status.toUpperCase());
        }
        //task notes
        String notes = (String) delegateTask.getExecution().getVariable("notes");
        if (notes != null) {
            messageText = messageText.concat(" <br/> <b>Notes :</b> &nbsp;" + notes);
        }
        Employee taskActionUser = (Employee) delegateTask.getExecution().getVariable("taskActionUser");
        if (taskActionUser != null) {
            messageText = messageText.concat(" <br/> <b> Task Updated By :</b> &nbsp;" + taskActionUser.getFirstName() + " " + taskActionUser.getLastName());
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
