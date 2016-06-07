/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.email.Email;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.OutOfOfficeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.entity.time.OutOfOfficeRequestStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.util.List;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author Ramana.Lukalapu
 */
public class OutOfOfficeRequestProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
        sendNotifyEmplyeeNotification(task);
        if ("complete".equals(task.getEventName())) {
            outOfOfficeTaskCompleted(task);
        }
    }

    protected void outOfOfficeTaskCompleted(DelegateTask task) {
        OutOfOfficeRequest entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.outofoffice", "You cannot approve your outof office task");
        }
        if (task.getTaskDefinitionKey().equals("outOfOfficeMgrApprovalTask")) {
            managerApprovalTaskComplete(entity, task);
        }
    }

    protected void managerApprovalTaskComplete(OutOfOfficeRequest entity, DelegateTask task) {
        String status = (String) task.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(OutOfOfficeRequestStatus.APPROVED);
        } else {
            entity.setStatus(OutOfOfficeRequestStatus.REJECTED);
        }
        OutOfOfficeDao.instance().save(entity);
        task.getExecution().setVariable("entity", entity);
    }

    protected void sendNotifyEmplyeeNotification(DelegateTask task) {
        List<Entry> notifyEmployees = (List<Entry>) task.getExecution().getVariable("notifyEmployees");
        Email email = new Email();

        if (notifyEmployees != null) {
            for (Entry e : notifyEmployees) {
                email.addTo(EmployeeDao.instance().getPrimaryEmail(e.getId()));
            }
        }
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        OutOfOfficeRequest ts = getRequestFromTask(task);
        email.setSubject("OutOfOffice Request " + ts.getStatus().name() + " For: " + emp.getFirstName() + " " + emp.getLastName());
        String summary = "OutOfOffice Request " + ts.getStatus().name() + " For: " + emp.getFirstName() + " " + emp.getLastName() + " : Start Date " + ts.getStartDate() + " End Date " + ts.getEndDate();
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        email.setBody(summary);
        email.setHtml(Boolean.TRUE);
        messagingService.sendEmail(email);
    }

    protected OutOfOfficeRequest getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return OutOfOfficeDao.instance().findById(entityId);
        }
        return null;
    }
}
