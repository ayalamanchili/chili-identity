/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.email;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.types.AccountReset;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.chili.email.Email;
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
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        AccountReset account = (AccountReset) delegateTask.getExecution().getVariable("account");
        Email email = new Email();
        email.addTo(account.getEmail());
        String status = (String) delegateTask.getExecution().getVariable("status");
        email.setSubject("Account Reset Task Completed: Status:" + status);
        StringBuilder message = new StringBuilder();
        //username
        String username = (String) delegateTask.getExecution().getVariable("username");
        if (EmployeeDao.instance().findEmployeWithEmpId(username) == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.employeeid", "employee id does not exist. Please enter correct employeeId for the user to complete.");
        }
        if (username != null) {
            message.append("&nbsp;<b><i>Username / EmployeeId&nbsp;</i></b>:&nbsp;").append(username).append("</br>");
        }
        message.append("<b><i>&nbsp;&nbsp;Status&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i></b>:&nbsp;").append(status.toUpperCase()).append("</br>");
        //task notes
        String notes = (String) delegateTask.getExecution().getVariable("notes");
        if (notes != null) {
            message.append("&nbsp;<b><i>Notes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i></b>:&nbsp;").append(notes).append("</br>");
        }
        message.append("&nbsp;Account was reset. Please submit forgot password request with the Username / EmployeeId above to get a temporary password </br>");
        message.append("&nbsp;https://apps.sstech.us/site/office/forgot-password.html");
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setBody(message.toString());
        messagingService.sendEmail(email);
    }
}
