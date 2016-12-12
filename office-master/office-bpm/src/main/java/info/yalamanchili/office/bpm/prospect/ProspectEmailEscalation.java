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
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.BPMUtils;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.task.TaskQuery;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ProspectEmailEscalation implements JavaDelegate {

    public static final String PROSPECT_ESCALATION_NOTIFICATION_GROUP = "Prospect_Escalation_Notification_Group";

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TaskService bpmTaskService = (TaskService) SpringContext.getBean("bpmTaskService");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        TaskQuery query = bpmTaskService.createTaskQuery().processInstanceId(execution.getProcessInstanceId());
        for (org.activiti.engine.task.Task task : query.list()) {
            Email email = new Email();
            email.setTos(BPMUtils.getCandidateEmails(task));
            NotificationGroup ng = NotificationGroupDao.instance().findByName(PROSPECT_ESCALATION_NOTIFICATION_GROUP);
            if (ng != null) {
                for (Employee emp : ng.getEmployees()) {
                    email.addTo(emp.getPrimaryEmail().getEmail());
                }
            }
            email.setHtml(Boolean.TRUE);
            email.setSubject("Task Escalation Email");
            String messageText = "Task is Escalated. Please complete.\n Details: \n Name" + task.getName() + " \n Description:" + task.getDescription();
            email.setBody(messageText);
            messagingService.sendEmail(email);
        }
    }

}
