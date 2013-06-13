/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.email;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
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
        email.addTo(account.getEmail());
        email.setSubject("Account Reset");
        mailUtils.getEmailsAddressesForRoles(OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR);
        StringBuilder message = new StringBuilder();
        //task statuss
        String status = (String) delegateTask.getExecution().getVariable("status");
        if (status != null) {
            message.append(" Status:").append(status.toUpperCase());
        }
        //username
        String username = (String) delegateTask.getExecution().getVariable("username");
        if (username != null) {
            message.append(" UserName:").append(username);
        }
        //password
        String password = (String) delegateTask.getExecution().getVariable("password");
        if (password != null) {
            message.append(" Password:").append(password);
        }
        //task notes
        String notes = (String) delegateTask.getExecution().getVariable("notes");
        if (notes != null) {
            message.append(" Notes:").append(notes);
        }
        email.setBody(message.toString());
        messagingService.sendEmail(email);
    }
}
