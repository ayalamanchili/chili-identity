/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.onboarding;

import info.chili.email.Email;
import info.chili.security.domain.CUser;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Date;
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

    public void sendEmployeeOnBoardingProcessStartEmail(Employee emp) {
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.addTo(emp.getPrimaryEmail().getEmail());
        email.setSubject("Welcome to System Soft Portal");
        String messageTextforuser = "Hai " + "<b>" + emp.getFirstName() + "</b>" + " " + "<b>" + emp.getLastName() + "</b>" + " \n";
        messageTextforuser = messageTextforuser.concat(" <br> Thank you for completing the onboarding form. </br> \n <br> Our <b> Onboarding Manager </b> will get in touch with you once the process is completed or for any additional information. </br> \n <br> Please login to portal and update it in profile tab</br> \n <br> Instruction: https://apps.sstech.us/site/office/profile/profile.html </br>");
        email.setBody(messageTextforuser);
        MessagingService.instance().sendEmail(email);
    }

    public void deleteEmployee(Employee emp) {
        emp.setEndDate(new Date());
        emp = EmployeeDao.instance().getEntityManager().merge(emp);
        EmployeeOnBoarding empOnBoarding = EmployeeOnBoardingDao.instance().findByEmployeeId(emp.getId());
        empOnBoarding.setStatus(OnBoardingStatus.Rejected);
        CUser user1 = emp.getUser();
        user1.setEnabled(false);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(empOnBoarding.getBpmProcessId(), false);
        //TODO this should be only done in case of a corporate employee since for others bpm user is not created.
        OfficeBPMIdentityService.instance().deleteUser(emp.getUser().getUsername());
    }
}
