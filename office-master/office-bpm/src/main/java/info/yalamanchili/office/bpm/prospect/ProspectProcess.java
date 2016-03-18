/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.prospect;

import info.chili.email.Email;
import info.chili.service.jrs.exception.ServiceException;
import static info.yalamanchili.office.bpm.prospect.ProspectEmailEscalation.PROSPECT_ESCALATION_NOTIFICATION_GROUP;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Transactional
public class ProspectProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
        if ("complete".equals(task.getEventName())) {
            prospectTaskCompleted(task);
        }
    }

    protected void prospectTaskCompleted(DelegateTask task) {
        Prospect entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }

        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);

        //Status
        String status = (String) task.getExecution().getVariable("prospectStatus");
        if (task.getTaskDefinitionKey().equals("newProspectImmigrationTask")) {
            if (status.equalsIgnoreCase("recruiting")) {
                entity.setStatus(ProspectStatus.RECRUITING);
                if (entity.getAssigned() == null) {
                    throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.assignedto", "Please fill AssignedTo field in Prospect panel before completing this task.");
                }
            } else if (status.equalsIgnoreCase("hold")) {
                entity.setStatus(ProspectStatus.ONHOLD);
            }

        }
        if (task.getTaskDefinitionKey().equals("newProspectRecruitmentTask")) {
            if (status.equalsIgnoreCase("bench")) {
                entity.setStatus(ProspectStatus.BENCH);
            } else if (status.equalsIgnoreCase("hold")) {
                entity.setStatus(ProspectStatus.ONHOLD);
            } else if (status.equalsIgnoreCase("closedlost")) {
                entity.setStatus(ProspectStatus.CLOSED_LOST);
            } else if (status.equalsIgnoreCase("closedwon")) {
                entity.setStatus(ProspectStatus.CLOSED_WON);
            }
        }
        
        if (task.getTaskDefinitionKey().equals("newProspectBenchTask")) {
            if (status.equalsIgnoreCase("closedwon")) {
                entity.setStatus(ProspectStatus.CLOSED_WON);
            } else if (status.equalsIgnoreCase("closedlost")) {
                entity.setStatus(ProspectStatus.CLOSED_LOST);
            } else if (status.equalsIgnoreCase("hold")) {
                entity.setStatus(ProspectStatus.ONHOLD);
            }
        }
        // Send notification for Prospect Status Change
        sendProspectStatusUpdateNotification(entity);

        task.getExecution().setVariable("prospect", entity);
        if (entity.getAssigned() != null) {
            task.getExecution().setVariable("approvalManager", EmployeeDao.instance().findById(entity.getAssigned()).getEmployeeId());
        }
        ProspectDao.instance().save(entity);
    }

    protected Prospect getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ProspectDao.instance().findById(entityId);
        }
        return null;
    }

    @Async
    @Transactional
    public void sendProspectStatusUpdateNotification(Prospect prospect) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        Email email = new Email();
        email.addTo(EmployeeDao.instance().findById(prospect.getManager()).getPrimaryEmail().getEmail());
        email.addTo(EmployeeDao.instance().findById(prospect.getAssigned()).getPrimaryEmail().getEmail());
        NotificationGroup ng = NotificationGroupDao.instance().findByName(PROSPECT_ESCALATION_NOTIFICATION_GROUP);
        if (ng != null) {
            for (Employee employee : ng.getEmployees()) {
                email.addTo(employee.getPrimaryEmail().getEmail());
            }
        }
        email.setHtml(Boolean.TRUE);
        email.setSubject("Prospect Status change for : " + prospect.getContact().getFirstName() + " " + prospect.getContact().getLastName() + "; " + "Status: " + prospect.getStatus());
        String messageText = " Prospect Information :: ";
        messageText = messageText.concat("\n Prospect     : " + prospect.getContact().getFirstName() + " " + prospect.getContact().getLastName());
        messageText = messageText.concat("\n Status       : " + prospect.getStatus());
        messageText = messageText.concat("\n Case Manager : " + EmployeeDao.instance().findById(prospect.getManager()).getFirstName());
        messageText = messageText.concat("\n Assigned To  : " + EmployeeDao.instance().findById(prospect.getAssigned()).getFirstName());
        messageText = messageText.concat("\n Updated_By   : " + emp.getFirstName() + " " + emp.getLastName());
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

}
