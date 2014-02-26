/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.BPMUtils;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.util.List;
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
public class CorpEmpLeaveRequestProcess implements TaskListener, JavaDelegate {

    @Override
    public void notify(DelegateTask task) {
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
        task.getExecution().setVariable("entity", CorporateTimeSheetDao.instance().save(ts));
    }

    protected void sendLeaveRequestCreatedNotification(DelegateTask task) {
        sendLeaveRequestStatusNotification("Submitted", task);
    }

    protected void assignLeaveRequestTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        List<CompanyContact> cnts = CompanyContactDao.instance().getCompanyContact(emp, "Reports_To");
        if (cnts.size() > 0) {
            task.setAssignee(cnts.get(0).getContact().getEmployeeId());
        }
        task.addCandidateGroup(OfficeRole.ROLE_HR_ADMINSTRATION.name());
    }

    /**
     * Leave Request Completed
     *
     * @param task
     */
    protected void leaveRequestTaskCompleted(DelegateTask task) {
        CorporateTimeSheet request = (CorporateTimeSheet) task.getExecution().getVariable("entity");
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

    /**
     * Leave request Approved
     *
     * @param task
     */
    protected void leaveRequestApproved(DelegateTask task) {
        sendLeaveRequestStatusNotification("Approved", task);
    }

    /**
     * Leave request rejected
     *
     * @param task
     */
    protected void leaveRequestRejected(DelegateTask task) {
        CorporateTimeSheet ts = (CorporateTimeSheet) task.getExecution().getVariable("entity");
        ts.setStatus(TimeSheetStatus.Rejected);
        CorporateTimeSheetDao.instance().save(ts);
        sendLeaveRequestStatusNotification("Rejected", task);
    }

    protected void sendLeaveRequestStatusNotification(String status, DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.setTos(BPMUtils.getCandidateEmails(task));
        email.addTo(emp.getPrimaryEmail().getEmail());
        String summary = "Leave Request " + status + " For: " + emp.getFirstName() + " " + emp.getLastName();
        email.setSubject(summary);
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Summary: ").append(summary).append("\n");
        messageBuilder.append("Task  Details: \n Name: ").append(task.getName()).append("\n");
        messageBuilder.append("Description: ").append(task.getDescription()).append("\n");
        messageBuilder.append("Employee Available Sick Hours     : ").append(CorporateTimeSheetDao.instance().getHoursInCurrentYear(emp, TimeSheetCategory.Sick_Earned, TimeSheetStatus.Approved)).append("\n");
        messageBuilder.append("Employee Available Personal Hours : ").append(CorporateTimeSheetDao.instance().getHoursInCurrentYear(emp, TimeSheetCategory.Personal_Earned, TimeSheetStatus.Approved)).append("\n");

        Employee taskActionUser = (Employee) task.getExecution().getVariable("taskActionUser");
        if (taskActionUser != null) {
            messageBuilder.append("Task Updated By : ").append(taskActionUser.getFirstName()).append(" ").append(taskActionUser.getLastName()).append("\n");
        }
        email.setBody(messageBuilder.toString());
        email.setHtml(Boolean.TRUE);
        messagingService.sendEmail(email);
    }

    /**
     * Leave Request Escalation Task
     *
     * @param execution
     */
    @Override
    public void execute(DelegateExecution execution) {
        leaveRequestEscationTask(execution);
    }

    protected void leaveRequestEscationTask(DelegateExecution execution) {
    }
}
