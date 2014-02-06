/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.selfserv;

import info.chili.security.dao.CRoleDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dao.selfserv.ServiceTicketDao;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import info.yalamanchili.office.entity.selfserv.TicketComment;
import info.yalamanchili.office.entity.selfserv.TicketStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class SelfService {

    @Autowired
    protected ServiceTicketDao serviceTicketDao;

    @PersistenceContext
    protected EntityManager em;

    public String createServiceTicket(Employee emp, ServiceTicket ticket) {
        ticket.setDepartmentAssigned(CRoleDao.instance().findRoleByName(getDepartmentToAssign(ticket).name()));
        ticket.setStatus(TicketStatus.Open);
        ticket.setEmployee(emp);
        ticket.setCreatedTimeStamp(new Date());
        ticket = em.merge(ticket);
        startServiceTicketTask(ticket);
        return em.merge(ticket).getId().toString();
    }

    public void updateTicket(Long ticketId, TicketStatus status, TicketComment comment) {
        ServiceTicket ticket = serviceTicketDao.findById(ticketId);
        ticket.setStatus(status);
        addTicketComment(ticketId, comment);
        switch (status) {
            case Resolved:
                resolveTicket(ticket);
            case InProgres:
                claimTicket(ticket);
            case Rejected:
                claimTicket(ticket);
            case ReOpened:
                reopenTicket(ticket);
        }

    }

    protected void reopenTicket(ServiceTicket ticket) {
        //TODO
    }

    protected void rejectTicket(ServiceTicket ticket) {
        //TODO
    }

    protected void claimTicket(ServiceTicket ticket) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.claimTask(getTaskForTicket(ticket).getId(), SecurityService.instance().getCurrentUserId());
    }

    protected void resolveTicket(ServiceTicket ticket) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.completeTask(getTaskForTicket(ticket).getId(), null);
    }

    protected Task getTaskForTicket(ServiceTicket ticket) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(ticket.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }

    public void addTicketComment(Long ticketId, TicketComment comment) {
        comment = serviceTicketDao.addTicketComment(ticketId, comment);
        sendTicketCommentNotification(comment);
        OfficeBPMTaskService.instance().addComment(getTaskForTicket(comment.getTicket()).getId(), comment.getComment());
    }

    protected void sendTicketCommentNotification(TicketComment comment) {
        Email email = new Email();
        email.setTos(getTicketNotificationGroup(comment));
        email.setSubject("Comment Added for Ticket: " + comment.getTicket().getSubject());
        email.setBody(comment.getComment());
        MessagingService.instance().sendEmail(email);
    }

    protected Set<String> getTicketNotificationGroup(TicketComment comment) {
        Set<String> notificationGroup = new HashSet<String>();
        //employee who created the ticket;
        Employee emp = comment.getTicket().getEmployee();
        notificationGroup.add(emp.getPrimaryEmail().getEmail());
        // Role to which the ticket is assigned to 
        String role = comment.getTicket().getDepartmentAssigned().getRolename();
        notificationGroup.addAll(MailUtils.instance().getEmailsAddressesForRoles(role));
        //assigned to emp email
        if (comment.getTicket().getAssignedTo() != null) {
            notificationGroup.add(comment.getTicket().getAssignedTo().getPrimaryEmail().getEmail());
        }
        //TODO get audited data emails also?
        return notificationGroup;
    }

    protected OfficeRole getDepartmentToAssign(ServiceTicket ticket) {
        switch (ticket.getType()) {
            case Immigration:
                return OfficeRole.ROLE_HR;
            case Billing:
                return OfficeRole.ROLE_TIME;
            default:
                return OfficeRole.ROLE_RELATIONSHIP;
        }
    }

    protected void startServiceTicketTask(ServiceTicket ticket) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("ticket", ticket);
        String processId = OfficeBPMService.instance().startProcess("service_ticket_process", vars);
        ticket.setBpmProcessId(processId);
    }

    public static SelfService instance() {
        return SpringContext.getBean(SelfService.class);
    }
}
