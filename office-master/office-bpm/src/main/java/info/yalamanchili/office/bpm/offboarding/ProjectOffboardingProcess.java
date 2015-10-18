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
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.profile.EmployeeDao;
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
            if (task.getTaskDefinitionKey().equals("projectOffBoardingTask")) {
                notifyEmployeeAndTeams(task);
            } else {
                new GenericTaskCompleteNotification().notify(task);
            }

        }
    }

    public void notifyEmployeeAndTeams(DelegateTask dt) {
        ProjectOffBoardingDto dto = (ProjectOffBoardingDto) dt.getExecution().getVariable("entity");
        if (dto == null) {
            return;
        }
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Employee associateEmployee = EmployeeDao.instance().findById(dto.getEmployeeId());
        Email email1 = new Email();
        email1.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_HR.name(), OfficeRoles.OfficeRole.ROLE_GC_IMMIGRATION.name(), OfficeRoles.OfficeRole.ROLE_H1B_IMMIGRATION.name(), OfficeRoles.OfficeRole.ROLE_RECRUITER.name()));
        email1.setSubject("Project Offboarding Submitted for Employee" + associateEmployee.getFirstName() + " " + associateEmployee.getLastName());
        email1.setBody("Project Offboarding request has been submitted for Employee" + associateEmployee.getFirstName() + " " + associateEmployee.getLastName() + "\n Client : " + dto.getClientName() + "\n Vendor : " + dto.getVendorName() + "\n End Date of the project: " + dto.getEndDate() + "\n This employee project has been offboarded:" + associateEmployee.getFirstName() + " " + associateEmployee.getLastName() + " Please Proceed your actions!!!!!");
        messagingService.sendEmail(email1);
    }
}
