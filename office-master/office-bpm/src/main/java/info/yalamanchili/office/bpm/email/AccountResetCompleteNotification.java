/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.email;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.types.AccountReset;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.jms.MessagingService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class AccountResetCompleteNotification implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        MailUtils mailUtils = (MailUtils) SpringContext.getBean("mailUtils");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        AccountReset account = (AccountReset) delegateTask.getExecution().getVariable("account");
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(OfficeRole.ROLE_ADMIN.name(), OfficeRole.ROLE_HR.name(), OfficeRole.ROLE_RELATIONSHIP.name()));
        email.addTo(account.getEmail());
        String status = (String) delegateTask.getExecution().getVariable("status");
        email.setSubject("Account Reset Task Completed: Status:" + status);
        StringBuilder message = new StringBuilder();
        message.append(" Status:").append(status.toUpperCase()).append("\n");;
        //username
        String username = (String) delegateTask.getExecution().getVariable("username");
        if (username != null) {
            message.append(" Username:").append(username).append("\n");;
        }
        //password
        String password = (String) delegateTask.getExecution().getVariable("password");
        if (password != null) {
            message.append(" Password:").append(password).append("\n");;
        }
        //task notes
        String notes = (String) delegateTask.getExecution().getVariable("notes");
        if (notes != null) {
            message.append(" Notes:").append(notes).append("\n");
        }
        email.setHtml(Boolean.TRUE);
        email.setBody(message.toString());
        messagingService.sendEmail(email);
    }
}
