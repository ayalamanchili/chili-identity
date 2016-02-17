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
        email.addTo(emp.getPrimaryEmail().getEmail());
        email.setSubject("Welcome to System Soft Portal");
        String messageTextforuser = "Hai " + emp.getFirstName() + " " + emp.getLastName() + " \n";
        messageTextforuser = messageTextforuser.concat("Thank you For Completing the onboarding form. \n Our Onboarding Manager Will get in touch with you once the process complete");
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
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(empOnBoarding.getBpmProcessId(), true);
        OfficeBPMIdentityService.instance().deleteUser(emp.getUser().getUsername());
    }
}
