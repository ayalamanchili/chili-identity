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
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.project.offboarding.ProjectEndDetailsDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.offboarding.ProjectEndDetails;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Date;
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
        ProjectEndDetails entity = getRequestFromTask(dt);;
        if (entity == null) {
            return;
        }
        String notes = (String) dt.getExecution().getVariable("notes");
        Date endDate = (Date) dt.getExecution().getVariable("endDate");
        CommentDao.instance().addComment(notes, entity);
        entity.setEndDate(endDate);
        notifyEmployee(entity);
        new GenericTaskCompleteNotification().notify(dt);
        ProjectEndDetailsDao.instance().save(entity);
    }

    public void notifyEmployee(ProjectEndDetails entity) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.valueOf(currentUser.toString()).name()));
        email.setSubject("Project Offboarding Approved For Employee" + currentUser.getFirstName() + " " + currentUser.getLastName());
        String messageText = "Hai "+ currentUser.getFirstName() + " " + currentUser.getLastName()+"/n"+ "Your Project Offboarding task has been completed by admin";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    protected ProjectEndDetails getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ProjectEndDetailsDao.instance().findById(entityId);
        }
        return null;
    }
}
