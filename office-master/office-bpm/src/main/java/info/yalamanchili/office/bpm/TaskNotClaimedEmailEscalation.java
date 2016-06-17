/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import info.chili.email.Email;
import info.yalamanchili.office.jms.MessagingService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.task.TaskQuery;

/**
 *
 * @author anuyalamanchili
 */
public class TaskNotClaimedEmailEscalation implements JavaDelegate {

    /**
     * send task not Claimed escalation email to add parties involved with the
     * task.
     *
     * @param execution
     * @throws Exception
     */
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TaskService bpmTaskService = (TaskService) SpringContext.getBean("bpmTaskService");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        TaskQuery query = bpmTaskService.createTaskQuery().processInstanceId(execution.getProcessInstanceId());
        for (org.activiti.engine.task.Task task : query.list()) {
            if (task.getAssignee() == null) {
                Email email = new Email();
                email.setTos(BPMUtils.getCandidateEmails(task));
                email.setHtml(Boolean.TRUE);
                email.setRichText(Boolean.TRUE);
                email.setSubject("Task not claimed escalation email");
                String messageText = "<b>Task is not claimed. Please claim.</br></br><i> Task Details: </br></br> Name</i></b>: " + task.getName() + " </br><b><i> Description:</i></b>" + task.getDescription();
                email.setBody(messageText);
                messagingService.sendEmail(email);
            }
        }
    }
}
