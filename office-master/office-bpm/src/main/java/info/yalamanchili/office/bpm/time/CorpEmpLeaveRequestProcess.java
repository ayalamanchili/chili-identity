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
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.BPMUtils;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
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

    public boolean validateLeaveRequest(Employee employee, String category, String hours) {
        BigDecimal leaveHours = BigDecimal.valueOf(Long.valueOf(hours));
        TimeSheetCategory tsCategory = TimeSheetCategory.valueOf(category);
        if (TimeSheetCategory.Unpaid.equals(tsCategory)) {
            return true;
        }
        BigDecimal earned = CorporateTimeSheetDao.instance().getHoursInCurrentYear(employee, TimeSheetCategory.valueOf(category.replace("Spent", "Earned")));
        BigDecimal spent = CorporateTimeSheetDao.instance().getHoursInCurrentYear(employee, tsCategory);
        if (spent.add(leaveHours).subtract(earned).compareTo(BigDecimal.ZERO) < 0) {
            return true;
        } else {
            //TODO send email 
            return false;
        }
    }

    /**
     * Leave Request Created
     *
     * @param task
     */
    protected void leaveRequestTaskCreated(DelegateTask task) {
        assignTask(task);
        sendLeaveRequestCreatedNotification(task);
    }

    protected void sendLeaveRequestCreatedNotification(DelegateTask task) {
        sendLeaveRequestStatusNotification("Submitted", task);
    }

    protected void assignTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        List<CompanyContact> cnts = CompanyContactDao.instance().getCompanyContact(emp, "Reports_To");
        if (cnts.size() > 0) {
            task.setAssignee(cnts.get(0).getEmployee().getEmployeeId());
        } else {
            task.addCandidateGroup(OfficeRoles.ROLE_HR);
        }
    }

    /**
     * Leave Request Completed
     *
     * @param task
     */
    protected void leaveRequestTaskCompleted(DelegateTask task) {
        String status = (String) task.getExecution().getVariable("status");
        String category = (String) task.getExecution().getVariable("category");
        if ("approved".equals(status) && !TimeSheetCategory.Unpaid.name().equals(category)) {
            leaveRequestApproved(task);
        }
        if ("approved".equals(status) && "Unpaid Leave Final Approval Task".equals(task.getName())) {
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
        sendLeaveRequestStatusNotification("Rejected", task);
    }

    protected void sendLeaveRequestStatusNotification(String status, DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.setTos(BPMUtils.getCandidateEmails(task));
        email.setSubject("Leave Request " + status + " For: " + emp.getFirstName() + " " + emp.getLastName());
        String messageText = "Name: " + task.getName() + " \n Description: " + task.getDescription() + " \n Task Notes: " + task.getVariable("taskNotes");
        email.setBody(messageText);
        email.setIsHtml(Boolean.TRUE);
        //TODO add reamining leaves for employee details
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
