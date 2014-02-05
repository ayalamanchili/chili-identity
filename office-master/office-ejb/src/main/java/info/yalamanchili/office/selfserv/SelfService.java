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
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import info.yalamanchili.office.entity.selfserv.TicketComment;
import info.yalamanchili.office.entity.selfserv.TicketStatus;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

    public String createServiceTicket(Long empId, ServiceTicket ticket) {
        ticket.setDepartmentAssigned(CRoleDao.instance().findRoleByName(getDepartmentToAssign(ticket).name()));
        ticket.setStatus(TicketStatus.Open);
        ticket.setEmployee(EmployeeDao.instance().findById(empId));
        ticket.setCreatedTimeStamp(new Date());
        ticket = em.merge(ticket);
        startServiceTicketTask(ticket);
        return em.merge(ticket).getId().toString();
    }

    public void resolveTicket(Long ticketId) {
        ServiceTicket ticket = serviceTicketDao.findById(ticketId);
        ticket.setStatus(TicketStatus.Resolved);
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        for (Task task : taskService.getTasksForProcessId(ticket.getBpmProcessId())) {
            taskService.completeTask(task.getId(), null);
        }
    }

    public void addTicketComment(Long ticketId, TicketComment comment) {
        Employee emp = SecurityService.instance().getCurrentUser();
        comment.setCreatedBy(emp.getFirstName() + " " + emp.getLastName());
        comment.setCreatedTimeStamp(new Date());
        comment.setTicket(ServiceTicketDao.instance().findById(ticketId));
        em.persist(comment);
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
