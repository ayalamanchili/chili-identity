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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Use this for notifying the current for approval of any submitted requests.
 *
 * @author ayalamanchili
 */
public class GenericTaskApprovalEmail implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Employee emp = (Employee) execution.getVariable("currentEmployee");
        Email email = new Email();
        email.addTo(emp.getPrimaryEmail().getEmail());
        Set<String> tos = new HashSet<String>();
        tos.add(emp.getPrimaryEmail().getEmail());
        email.setTos(tos);
        //TODO add details
        email.setSubject("Request Approved ");
        email.setBody("Request Approved");
        messagingService.sendEmail(email);
    }
}
