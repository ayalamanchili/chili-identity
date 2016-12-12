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
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.HashSet;
import java.util.List;
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
        email.setRichText(Boolean.TRUE);
        email.setTos(getEmails(delegateTask, notifyEmployee, notifyRoles));
        email.setSubject("Task Created:" + delegateTask.getName());
        String messageText = "<b>Task Created:</b> Please complete.<br/> <br/> <b> Name        : </b>" + delegateTask.getName() + " <br/> <br/> <b> Description : </b>";
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
        messageText = messageText.concat("<br/> <br/> &nbsp; <b>Please click on the below link to complete the task: </b> <br/> &nbsp; " + getTaskLink(delegateTask));
        email.setHtml(Boolean.TRUE);
        email.setBody(messageText);
        email.getHeaders().put("task-id", delegateTask.getId());
        messagingService.sendEmail(email);
    }

    protected String getTaskLink(DelegateTask delegateTask) {
        StringBuilder sb = new StringBuilder();
        sb.append(OfficeServiceConfiguration.instance().getPortalWebUrl()).append("#?entity=info.chili.bpm.types.Task&id=").append(delegateTask.getId());
        return sb.toString();
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

    private int alignSpacesUsingLargestStr(List<String> leftStr) {
        int largestStr = leftStr.size();
        for (int i = 0; i < leftStr.size(); i++) {
            if (leftStr.get(i).trim().length() > largestStr) {
                largestStr = leftStr.get(i).trim().length();
            }
        }
        return largestStr;
    }
}
