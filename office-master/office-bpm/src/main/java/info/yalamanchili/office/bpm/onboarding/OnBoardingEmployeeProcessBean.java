/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.onboarding;

import info.chili.email.Email;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.drive.FileDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("prototype")
@Transactional
public class OnBoardingEmployeeProcessBean {

    @Autowired
    protected MailUtils mailUtils;
    @Autowired
    FileDao fileDao;
    protected final String[] ON_BOARDING_FORMS_LIST = {"W2_On_Boarding", "I9_On_Boarding"};
    //
    public void sendEmployeeOnBoardingEmail(Employee emp) {
        Email email = new Email();
        email.addTo(emp.getPrimaryEmail().getEmail());
        StringBuilder subject = new StringBuilder();
        subject.append("System Soft employee on boarding email");
        email.setSubject(subject.toString());
        Map<String, Object> emailCtx = new HashMap<>();
        emailCtx.put("employeeName", "asdf");
        email.setTemplateName("on_board_employee_template.html");
        email.setContext(emailCtx);
        email.setHtml(Boolean.TRUE);
        for (String fileName : ON_BOARDING_FORMS_LIST) {
            if (fileDao.getFilePath(fileName) != null) {
                email.getAttachments().add(fileDao.getFilePath(fileName));
            }
        }
        MessagingService.instance().sendEmail(email);
    }

    public void sendEmployeeOnBoardingCompletedEmail(Employee emp) {
        Email email = new Email();
        email.addTo(emp.getPrimaryEmail().getEmail());
        StringBuilder subject = new StringBuilder();
        subject.append("System Soft employee on boarding completed!");
        email.setSubject(subject.toString());
        Map<String, Object> emailCtx = new HashMap<>();
        emailCtx.put("employeeName", "asdf");
        // TODO new template for completed email
        email.setTemplateName("on_board_employee_template.html");
        email.setContext(emailCtx);
        email.setHtml(Boolean.TRUE);
        MessagingService.instance().sendEmail(email);
    }

    public void sendInformationToOtherSystemsTask(Employee emp) {
        System.out.println("sendInformationToOtherSystemsTask");
    }
    
    public void createServiceTicketforNetworkDept(Employee emp) {
        System.out.println("createServiceTicketforNetworkDept");
    }
    

}
