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
//        TaskService bpmTaskService = (TaskService) SpringContext.getBean("bpmTaskService");
//        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
//        TaskQuery query = bpmTaskService.createTaskQuery().processInstanceId(execution.getProcessInstanceId());
//        for (org.activiti.engine.task.Task task : query.list()) {
//            Email email = new Email();
//            email.setTos(BPMUtils.getCandidateEmails(task));
//            email.setHtml(Boolean.TRUE);
//            email.setRichText(Boolean.TRUE);
//            email.setSubject("Task Escalation Email");
//            String messageText = "<b> Task is Escalated. Please complete.</b> <br/> <b> Name </b>" + task.getName() + "<br/> <b> Description </b>:";
//            String description = task.getDescription();
//            String[] descA = description.split("\n");
//            messageText = messageText.concat(descA[0] + "<br/> <br/> <b> <u> Details: </u> </b> <br/><html><body><table>");
//            for (int i = 1; i < descA.length - 1; i++) {
//                if (descA[i].contains(":")) {
//                    String descArrayLeft = descA[i].substring(0, descA[i].indexOf(":"));
//                    String descArrayRight = descA[i].substring(descA[i].indexOf(":") + 1, descA[i].length());
//                    messageText = messageText.concat("<tr> <td> <b>" + descArrayLeft.trim() + "</b> </td>");
//                    messageText = messageText.concat("<td> :" + descArrayRight + "</td> </tr>");
//                } else {
//                    messageText = messageText.concat("<tr> <td colspan=" + 2 + ">" + descA[i] + "</td></tr>");
//                }
//            }
//            if (descA[descA.length - 1].contains("instructions") || descA[descA.length - 1].contains("http")) {
//                messageText = messageText.concat("</table></body></html> " + descA[descA.length - 1]);
//            } else {
//                if (descA[descA.length - 1].contains(":")) {
//                    String descArrayLeft = descA[descA.length - 1].substring(0, descA[descA.length - 1].indexOf(":"));
//                    String descArrayRight = descA[descA.length - 1].substring(descA[descA.length - 1].indexOf(":") + 1, descA[descA.length - 1].length());
//                    messageText = messageText.concat("<tr> <td> <b>" + descArrayLeft.trim() + "</b> </td>");
//                    messageText = messageText.concat("<td> :" + descArrayRight + "</td> </tr></table></body></html>");
//                } else {
//                    messageText = messageText.concat("<tr> <td colspan=" + 2 + ">" + descA[descA.length - 1] + "</td></tr>");
//                }
//            }
//            email.setBody(messageText);
//            messagingService.sendEmail(email);
        }
    }

