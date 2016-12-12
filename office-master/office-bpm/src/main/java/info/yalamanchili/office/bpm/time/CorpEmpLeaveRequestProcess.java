/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.BPMUtils;
import info.yalamanchili.office.bpm.EmailEscalation;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.chili.email.Email;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
@Transactional
public class CorpEmpLeaveRequestProcess extends RuleBasedTaskDelegateListner implements TaskListener, JavaDelegate {

    @Override
    public void processTask(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            leaveRequestTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            leaveRequestTaskCompleted(task);
        }
    }

    /**
     * Leave Request Created
     *
     * @param task
     */
    public static final String TAMPA_LEAVE_NOTIFICATION_GROUP = "Tampa_Leava_Notification_Group";
    public static final String ATLANTA_LEAVE_NOTIFICATION_GROUP = "Atlanta_Leava_Notification_Group";
    public static final String HERNDON_LEAVE_NOTIFICATION_GROUP = "Herndon_Leava_Notification_Group";
    public static final String DALLAS_LEAVE_NOTIFICATION_GROUP = "Dallas_Leava_Notification_Group";
    public static final String HYDERABAD_LEAVE_NOTIFICATION_GROUP = "Hyderabad_Leava_Notification_Group";
    public static final String FLORIDA_LEAVE_NOTIFICATION_GROUP = "Florida_Leava_Notification_Group";

    protected void leaveRequestTaskCreated(DelegateTask task) {
        saveLeaveRequest(task);
        if (task.getTaskDefinitionKey().equals("leaveRequestApprovalTask")) {
            assignLeaveRequestTask(task);
        }
        sendLeaveRequestCreatedNotification(task);
    }

    protected void saveLeaveRequest(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        CorporateTimeSheet ts = (CorporateTimeSheet) task.getExecution().getVariable("entity");
        ts.setBpmProcessId(task.getExecution().getProcessInstanceId());
        ts.setStatus(TimeSheetStatus.Pending);
        ts.setEmployee(emp);
        ts.setCreatedTimeStamp(new Date());
        ts = CorporateTimeSheetDao.instance().save(ts);
        task.getExecution().setVariable("entity", ts);
        task.getExecution().setVariable("entityId", ts.getId());
    }

    protected final String SUBMITTED_STATUS = "Submitted";
    protected final String UPDATED_STATUS = "Updated";
    protected final String APPROVED_STATUS = "Approved";
    protected final String REJECTED_STATUS = "Rejected";

    protected void sendLeaveRequestCreatedNotification(DelegateTask task) {
        String status = (String) task.getExecution().getVariable("status");
        if (status != null && !task.getTaskDefinitionKey().equals("unpaidLeaveFinalApprovalTask")) {
            sendLeaveRequestStatusNotification(UPDATED_STATUS, task);
        } else {
            sendLeaveRequestStatusNotification(SUBMITTED_STATUS, task);
        }
    }

    protected void assignLeaveRequestTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        Employee manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (manager != null) {
            task.addCandidateUser(manager.getEmployeeId());
            task.setOwner(manager.getEmployeeId());
        }
        task.addCandidateGroup(OfficeRole.ROLE_HR_ADMINSTRATION.name());
    }

    /**
     * Leave Request Completed
     *
     * @param task
     */
    protected void leaveRequestTaskCompleted(DelegateTask task) {
        CorporateTimeSheet request = getTimeSheetFromTask(task);
        if (request == null) {
            return;
        }
        String status = (String) task.getExecution().getVariable("status");
        if ("approved".equals(status) && !TimeSheetCategory.Unpaid.equals(request.getCategory())) {
            leaveRequestApproved(task);
        }
        if ("approved".equals(status) && "unpaidLeaveFinalApprovalTask".equals(task.getTaskDefinitionKey())) {
            leaveRequestApproved(task);
        }
        if ("rejected".equals(status)) {
            leaveRequestRejected(task);
        }
    }

    protected CorporateTimeSheet getTimeSheetFromTask(DelegateTask task) {
        Long tsId = (Long) task.getExecution().getVariable("entityId");
        if (tsId != null) {
            return CorporateTimeSheetDao.instance().findById(tsId);
        }
        return null;
    }

    /**
     * Leave request Approved
     *
     * @param task
     */
    protected void leaveRequestApproved(DelegateTask task) {
        CorporateTimeSheet ts = getTimeSheetFromTask(task);
        if (ts == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(ts.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.timesheet", "You cannot approve your timesheet");
        }
        if (CorpEmpLeaveRequestProcessBean.instance().validateLeaveRequest(ts.getEmployee(), ts)) {
            ts.setApprovedBy(currentUser.getEmployeeId());
            sendLeaveRequestStatusNotification(APPROVED_STATUS, task);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "no.enough.leaves", "No Enough leaves for employee. Please verify time summary and reject the task");
        }
    }

    /**
     * Leave request rejected
     *
     * @param task
     */
    protected void leaveRequestRejected(DelegateTask task) {
        CorporateTimeSheet ts = getTimeSheetFromTask(task);
        ts.setStatus(TimeSheetStatus.Rejected);
        CorporateTimeSheetDao.instance().save(ts);
        sendLeaveRequestStatusNotification(REJECTED_STATUS, task);
    }

    protected void sendLeaveRequestStatusNotification(String status, DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        sendNotifyEmplyeeNotification(status, task);
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        if (status.equals(SUBMITTED_STATUS) || status.equals(UPDATED_STATUS)) {
            email.setTos(BPMUtils.getCandidateEmails(task));
        }
        email.addTo(EmployeeDao.instance().getPrimaryEmail(emp));
        String summary = "Leave Request " + status + " For: " + emp.getFirstName() + " " + emp.getLastName();
        email.setSubject(summary);
        String messageBuilder = "<b>Summary: </b>".concat(summary).concat("<br/>");
        String taskNotes = (String) task.getVariable("leaveRequestApprovalTaskNotes");
        if (taskNotes != null && !taskNotes.isEmpty()) {
            messageBuilder = messageBuilder.concat("<b>Notes: </b>").concat(taskNotes).concat("<br/>");
        }
        Employee taskActionUser = (Employee) task.getExecution().getVariable("taskActionUser");
        if (taskActionUser != null) {
            messageBuilder = messageBuilder.concat("<b>Task Updated By :</b> ").concat(taskActionUser.getFirstName()).concat(" ").concat(taskActionUser.getLastName()).concat("<br/>");
        }
        messageBuilder = messageBuilder.concat("<b>Name:</b> ").concat(task.getName()).concat("<br/>");

        String description = task.getDescription();
        String[] descA = description.split("\n");
        messageBuilder = messageBuilder.concat(descA[0] + "<br/> <br/> <b> <u> Details: </u> </b> <br/><html><body><table>");
        for (int i = 1; i < descA.length - 1; i++) {
            if (descA[i].contains(":")) {
                String descArrayLeft = descA[i].substring(0, descA[i].indexOf(":"));
                String descArrayRight = descA[i].substring(descA[i].indexOf(":") + 1, descA[i].length());
                messageBuilder = messageBuilder.concat("<tr> <td> <b>" + descArrayLeft.trim() + "</b> </td>");
                messageBuilder = messageBuilder.concat("<td> :" + descArrayRight + "</td> </tr>");
            } else {
                messageBuilder = messageBuilder.concat("<tr> <td> </td> <td> " + descA[i] + "</td></tr>");
            }
        }
        if (descA[descA.length - 1].contains("instructions") || descA[descA.length - 1].contains("http")) {
            messageBuilder = messageBuilder.concat("</table></body></html> " + descA[descA.length - 1]);
        } else {
            if (descA[descA.length - 1].contains(":")) {
                String descArrayLeft = descA[descA.length - 1].substring(0, descA[descA.length - 1].indexOf(":"));
                String descArrayRight = descA[descA.length - 1].substring(descA[descA.length - 1].indexOf(":") + 1, descA[descA.length - 1].length());
                messageBuilder = messageBuilder.concat("<tr> <td> <b>" + descArrayLeft.trim() + "</b> </td>");
                messageBuilder = messageBuilder.concat("<td> :" + descArrayRight + "</td> </tr></table></body></html>");
            } else {
                messageBuilder = messageBuilder.concat("<tr> <td> </td> <td> " + descA[descA.length - 1] + "</td></tr>");
            }
        }

        if (!email.getTos().equals(emp)) {
            messageBuilder = messageBuilder.concat("<br/><br/><b>Please click on the below link to complete the task </b> : <br/> " + getTaskLink(task));
            email.getHeaders().put("task-id", task.getId());
        }
        email.setBody(messageBuilder);
        messagingService.sendEmail(email);
    }

    protected String getTaskLink(DelegateTask delegateTask) {
        StringBuilder sb = new StringBuilder();
        sb.append(OfficeServiceConfiguration.instance().getPortalWebUrl()).append("#?entity=info.chili.bpm.types.Task&id=").append(delegateTask.getId());
        return sb.toString();
    }

    protected void sendNotifyEmplyeeNotification(String status, DelegateTask task) {
        List<Entry> notifyEmployees = (List<Entry>) task.getExecution().getVariable("notifyEmployees");
        Email email = new Email();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (notifyEmployees != null) {
            for (Entry e : notifyEmployees) {
                email.addTo(EmployeeDao.instance().getPrimaryEmail(e.getId()));
            }
        }
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        if (emp.getBranch() != null) {
            if (Branch.Tampa.name().equals(emp.getBranch().name().trim())) {
                NotificationGroup group = NotificationGroupDao.instance().findByName(TAMPA_LEAVE_NOTIFICATION_GROUP);
                Set<String> emailto1 = new HashSet<String>();
                if (group != null) {
                    for (Employee empname : group.getEmployees()) {
                        if (empname.isActive() == true) {
                            emailto1.add(empname.getPrimaryEmail().getEmail());
                        }
                        email.setTos(emailto1);
                    }
                }
            } else if (Branch.Atlanta.name().equals(emp.getBranch().name().trim())) {
                NotificationGroup group = NotificationGroupDao.instance().findByName(ATLANTA_LEAVE_NOTIFICATION_GROUP);
                Set<String> emailto1 = new HashSet<String>();
                if (group != null) {
                    for (Employee empname : group.getEmployees()) {
                        if (empname.isActive() == true) {
                            emailto1.add(empname.getPrimaryEmail().getEmail());
                        }
                        email.setTos(emailto1);
                    }
                }
            } else if (Branch.Florida.name().equals(emp.getBranch().name().trim())) {
                NotificationGroup group = NotificationGroupDao.instance().findByName(FLORIDA_LEAVE_NOTIFICATION_GROUP);
                Set<String> emailto1 = new HashSet<String>();
                if (group != null) {
                    for (Employee empname : group.getEmployees()) {
                        if (empname.isActive() == true) {
                            emailto1.add(empname.getPrimaryEmail().getEmail());
                        }
                        email.setTos(emailto1);
                    }
                }
            } else if (Branch.Herndon.name().equals(emp.getBranch().name().trim())) {
                NotificationGroup group = NotificationGroupDao.instance().findByName(HERNDON_LEAVE_NOTIFICATION_GROUP);
                Set<String> emailto1 = new HashSet<String>();
                if (group != null) {
                    for (Employee empname : group.getEmployees()) {
                        if (empname.isActive() == true) {
                            emailto1.add(empname.getPrimaryEmail().getEmail());
                        }
                        email.setTos(emailto1);
                    }
                }
            } else if (Branch.Dallas.name().equals(emp.getBranch().name().trim())) {
                NotificationGroup group = NotificationGroupDao.instance().findByName(DALLAS_LEAVE_NOTIFICATION_GROUP);
                Set<String> emailto1 = new HashSet<String>();
                if (group != null) {
                    for (Employee empname : group.getEmployees()) {
                        if (empname.isActive() == true) {
                            emailto1.add(empname.getPrimaryEmail().getEmail());
                        }
                        email.setTos(emailto1);
                    }
                }
            } else if (Branch.Hyderabad.name().equals(emp.getBranch().name().trim())) {
                NotificationGroup group = NotificationGroupDao.instance().findByName(HYDERABAD_LEAVE_NOTIFICATION_GROUP);
                Set<String> emailto1 = new HashSet<String>();
                if (group != null) {
                    for (Employee empname : group.getEmployees()) {
                        if (empname.isActive() == true) {
                            emailto1.add(empname.getPrimaryEmail().getEmail());
                        }
                        email.setTos(emailto1);
                    }
                }
            }
        }
        CorporateTimeSheet ts = getTimeSheetFromTask(task);
        email.setSubject("Leave Request " + status + " For: " + emp.getFirstName() + " " + emp.getLastName());
        String summary = "<b>Leave Request " + status + " For Employee</b></br></br>" + "&nbsp;&nbsp;<b><i>Employee Name</i></b>&nbsp;:&nbsp;" + emp.getFirstName() + " " + emp.getLastName() + "</br>" + "&nbsp;&nbsp;<b><i>Start Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i></b>:&nbsp;" + sdf.format(ts.getStartDate()) + "</br>" + "&nbsp;&nbsp;<b><i>End Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i></b>:&nbsp;" + sdf.format(ts.getEndDate());
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        email.setBody(summary);
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        messagingService.sendEmail(email);
    }

    /**
     * Leave Request Escalation Task
     *
     * @param execution
     * @throws java.lang.Exception
     */
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        leaveRequestEscationTask(execution);
    }

    protected void leaveRequestEscationTask(DelegateExecution execution) throws Exception {
        new EmailEscalation().execute(execution);
    }
}
