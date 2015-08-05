/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
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
 * @author ayalamanchili
 */
public class EmailEscalation implements JavaDelegate {

    /**
     * send task not complete email to add parties involved with the task.
     *
     * @param execution
     * @throws Exception
     */
    @Override
    //TODO rename to TaskNotCompleteEmailEscalation need ot rename all bpm process files
    public void execute(DelegateExecution execution) throws Exception {
        TaskService bpmTaskService = (TaskService) SpringContext.getBean("bpmTaskService");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        TaskQuery query = bpmTaskService.createTaskQuery().processInstanceId(execution.getProcessInstanceId());
        for (org.activiti.engine.task.Task task : query.list()) {
            Email email = new Email();
            email.setTos(BPMUtils.getCandidateEmails(task));
            email.setHtml(Boolean.TRUE);
            email.setSubject("Task Escalation Email");
            String messageText = "Task is Escalated. Please complete.\n Details: \n Name" + task.getName() + " \n Description:" + task.getDescription();
            email.setBody(messageText);
            messagingService.sendEmail(email);
        }
    }
}
