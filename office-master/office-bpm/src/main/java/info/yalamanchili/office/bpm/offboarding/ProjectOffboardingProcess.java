/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.offboarding;

import info.chili.email.Email;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author radhika.mukkala
 */
public class ProjectOffboardingProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            new GenericTaskCreateNotification().notify(task);
        }
        if ("complete".equals(task.getEventName())) {
            projectOffboardingTaskCompleted(task);
        }
    }

    private void projectOffboardingTaskCompleted(DelegateTask dt) {
        ProjectOffBoardingDto dto = (ProjectOffBoardingDto) dt.getExecution().getVariable("entity");
        if (dto == null) {
            return;
        }
        notifyEmployee(dto);
        new GenericTaskCompleteNotification().notify(dt);
    }

    public void notifyEmployee(ProjectOffBoardingDto dto) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        Employee associateEmployee = EmployeeDao.instance().findById(dto.getEmployeeId());
        email.addTo(associateEmployee.getPrimaryEmail().getEmail());
        email.setSubject("Project Offboarding Approved For Employee" + associateEmployee.getFirstName() + " " + associateEmployee.getLastName());
        String messageText = "Hi " + associateEmployee.getFirstName() + " " + associateEmployee.getLastName() + "/n" + "Your Project Offboarding task has been submitted by " + currentUser.getFirstName();
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }
}
