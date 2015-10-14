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
import info.chili.security.domain.CRole;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.email.MailUtils;
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
       /* MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        Employee associateEmployee = EmployeeDao.instance().findById(dto.getEmployeeId());
        email.addTo(associateEmployee.getPrimaryEmail().getEmail());
        email.setSubject("Project Offboarding Approved For Employee" + associateEmployee.getFirstName() + " " + associateEmployee.getLastName());
        String messageText = "Hi " + associateEmployee.getFirstName() + " " + associateEmployee.getLastName() + "/n" + "Your Project Offboarding task has been submitted by " + currentUser.getFirstName();
        email.setBody(messageText);
        messagingService.sendEmail(email);*/
        
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Employee associateEmployee = EmployeeDao.instance().findById(dto.getEmployeeId());
        Email email1 = new Email();
        email1.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_HR.name(), OfficeRoles.OfficeRole.ROLE_GC_IMMIGRATION.name(), OfficeRoles.OfficeRole.ROLE_H1B_IMMIGRATION.name(), OfficeRoles.OfficeRole.ROLE_RECRUITER.name() ));
        email1.setSubject("Project Offboarding details for Employee" + associateEmployee.getFirstName() + " " + associateEmployee.getLastName());
        email1.setBody("Project Offboarding details has been updated for Employee" + associateEmployee.getFirstName() + " " + associateEmployee.getLastName()+"\n Client : "+dto.getClientName()+"\n Vendor : "+dto.getVendorName()+"\n End Date of the project: "+dto.getEndDate()+"\n This employee project has been offboarded:" + associateEmployee.getFirstName() + " " + associateEmployee.getLastName()+ " Please Proceed your actions!!!!!");
        messagingService.sendEmail(email1);
    }
}
