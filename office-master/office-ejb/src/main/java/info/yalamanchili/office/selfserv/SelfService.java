/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.selfserv;

import info.chili.audit.AuditChangeDto;
import info.chili.audit.AuditService;
import info.chili.commons.HtmlUtils;
import info.chili.security.dao.CRoleDao;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.chili.bpm.types.Task;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.selfserv.ServiceTicketDao;
import info.chili.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import info.yalamanchili.office.entity.selfserv.TicketComment;
import info.yalamanchili.office.entity.selfserv.TicketStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
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
        ticket.setDepartmentAssigned(CRoleDao.instance().findRoleByName("ROLE_SELFSERVICE_TRIAGE"));
        ticket.setStatus(TicketStatus.Open);
        ticket.setEmployee(emp);
        ticket.setCreatedTimeStamp(new Date());
        ticket.setDescription(HtmlUtils.cleanData(ticket.getDescription()));
        ticket = em.merge(ticket);
        startServiceTicketTask(ticket);
        return em.merge(ticket).getId().toString();
    }

    public void updateTicket(ServiceTicket servTicket) {
        ServiceTicket ticket = serviceTicketDao.findById(servTicket.getId());
        ticket.setType(servTicket.getType());
        //Status
        if (servTicket.getStatus() != null) {
            ticket.setStatus(servTicket.getStatus());
            switch (servTicket.getStatus()) {
                case Resolved:
                    resolveTicket(ticket);
                    break;
                case InProgress:
                    claimTicket(ticket);
                    break;
                case Rejected:
                    rejectTicket(ticket);
                    break;
                case ReOpened:
                    reopenTicket(ticket);
                    break;
            }
        }
        //Dept assigned to 
        if (servTicket.getDepartmentAssigned() != null && CRoleDao.instance().findById(servTicket.getDepartmentAssigned().getRoleId()) != null) {
            updateTaskAssignedToDepartment(ticket, ticket.getDepartmentAssigned().getRolename(), CRoleDao.instance().findById(servTicket.getDepartmentAssigned().getRoleId()).getRolename());
            ticket.setDepartmentAssigned(CRoleDao.instance().findById(servTicket.getDepartmentAssigned().getRoleId()));
        }
        //Assigned to
        if (servTicket.getAssignedTo() != null) {
            Employee assignedTo = EmployeeDao.instance().findById(servTicket.getAssignedTo().getId());
            Task task = getTaskForTicket(ticket);
            if (task != null) {
                OfficeBPMTaskService.instance().assignTask(task.getId(), assignedTo.getEmployeeId());
            }
            ticket.setAssignedTo(assignedTo);
        }
        addTicketComment(servTicket.getId(), servTicket.getComments().get(0));
        serviceTicketDao.save(ticket);
    }

    protected void reopenTicket(ServiceTicket ticket) {
        startServiceTicketTask(ticket);
    }

    protected void rejectTicket(ServiceTicket ticket) {
        completeTask(ticket);
    }

    protected void claimTicket(ServiceTicket ticket) {
        assignTask(ticket);
    }

    protected void resolveTicket(ServiceTicket ticket) {
        completeTask(ticket);
    }

    protected void assignTask(ServiceTicket ticket) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        ticket.setAssignedTo(emp);
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        Task task = getTaskForTicket(ticket);
        if (task != null) {
            taskService.assignTask(task.getId(), emp.getEmployeeId());
        }
    }

    protected void updateTaskAssignedToDepartment(ServiceTicket ticket, String oldDepartment, String newDepartment) {
        Task task = getTaskForTicket(ticket);
        if (task != null) {
            //TODO send seperate notification
            OfficeBPMTaskService.instance().setCandidateGroup(task.getId(), oldDepartment, newDepartment);
        }
    }

    protected void completeTask(ServiceTicket ticket) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        Task task = getTaskForTicket(ticket);
        if (task != null) {
            List<Entry> vars = new ArrayList<>();
            //Used to make sure that tasks is not complete from My Tasks
            Entry entry = new Entry("check-flag", "true");
            vars.add(entry);
            taskService.completeTask(task.getId(), vars);
        }
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
        sendTicketUpdatedNotification(comment);
        Task task = getTaskForTicket(comment.getTicket());
        if (task != null) {
            OfficeBPMTaskService.instance().addComment(task.getId(), comment.getComment());
        }
    }

    protected void sendTicketUpdatedNotification(TicketComment comment) {
        Employee commentAuthor = OfficeSecurityService.instance().getCurrentUser();
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setTos(getTicketNotificationGroup(comment));
        StringBuilder subject = new StringBuilder();
        subject.append(commentAuthor.getFirstName()).append(" ").append(commentAuthor.getLastName()).append(" updated ticket:").append(comment.getTicket().getSubject());
        email.setSubject(subject.toString());
        Map<String, Object> emailCtx = new HashMap<>();
        emailCtx.put("currentComment", comment);
        emailCtx.put("ticket", comment.getTicket());
        emailCtx.put("ticketDepartment", OfficeRoles.rolesMessages.get(comment.getTicket().getDepartmentAssigned().getRolename()));
        List<TicketComment> comments = new ArrayList<>();
        comments.addAll(comment.getTicket().getComments());
        emailCtx.put("comments", comments);
        try{
        emailCtx.put("changes", determineChanges(comment.getTicket()));
        }catch(Exception e){
            e.printStackTrace();
        }
        email.setTemplateName("service_ticket_template.html");
        email.setContext(emailCtx);
        email.setHtml(Boolean.TRUE);
        MessagingService.instance().sendEmail(email);
    }

    protected List<AuditChangeDto> determineChanges(ServiceTicket ticket) {
        List<AuditChangeDto> changes = new ArrayList<>();
        ServiceTicket previousVersion = (ServiceTicket) AuditService.instance().mostRecentVersion(ServiceTicket.class, ticket.getId());
        if (!previousVersion.getStatus().equals(ticket.getStatus())) {
            AuditChangeDto change = new AuditChangeDto();
            change.setPropertyName("Status");
            change.setNewValue(ticket.getStatus().name());
            change.setOldValue(previousVersion.getStatus().name());
            changes.add(change);
        }
        if (!previousVersion.getDepartmentAssigned().getRolename().equals(ticket.getDepartmentAssigned().getRolename())) {
            AuditChangeDto change = new AuditChangeDto();
            change.setPropertyName("Department");
            change.setNewValue(OfficeRoles.rolesMessages.get(ticket.getDepartmentAssigned().getRolename()));
            change.setOldValue(OfficeRoles.rolesMessages.get(previousVersion.getDepartmentAssigned().getRolename()));
            changes.add(change);
        }
        if (previousVersion.getAssignedTo() != null && !previousVersion.getAssignedTo().getEmployeeId().equals(ticket.getAssignedTo().getEmployeeId())) {
            AuditChangeDto change = new AuditChangeDto();
            change.setPropertyName("Assigned To");
            change.setNewValue(ticket.getAssignedTo().getFirstName());
            change.setOldValue(previousVersion.getAssignedTo().getFirstName());
            changes.add(change);
        }
        return changes;
    }

    protected Set<String> getTicketNotificationGroup(TicketComment comment) {
        Set<String> notificationGroup = new HashSet<>();
        //employee who created the ticket;
        Employee emp = comment.getTicket().getEmployee();
//        if (TicketStatus.Resolved.equals(comment.getTicket().getStatus()) || TicketStatus.Rejected.equals(comment.getTicket().getStatus())) {
        notificationGroup.add(EmployeeDao.instance().getPrimaryEmail(emp));
//        }
        // Role to which the ticket is assigned to 
        String role = comment.getTicket().getDepartmentAssigned().getRolename();
        notificationGroup.addAll(MailUtils.instance().getEmailsAddressesForRoles(role));
        //assigned to emp email
        if (comment.getTicket().getAssignedTo() != null) {
            notificationGroup.add(EmployeeDao.instance().getPrimaryEmail(comment.getTicket().getAssignedTo()));
        }
        //TODO get audited data emails also?
        return notificationGroup;
    }

    //TODO externalize
    protected OfficeRole getDepartmentToAssign(ServiceTicket ticket) {
        switch (ticket.getType()) {
            case Immigration:
                return OfficeRole.ROLE_HR;
            case HumanResource:
                return OfficeRole.ROLE_HR;
            case Invoicing:
                return OfficeRole.ROLE_BILLING_AND_INVOICING;
            case Recruiting:
                return OfficeRole.ROLE_RECRUITER;
            case Payroll:
                return OfficeRole.ROLE_PAYROLL_AND_BENIFITS;
            case HealthInsurance:
                return OfficeRole.ROLE_HR;
            case Network:
                return OfficeRole.ROLE_SYSTEM_AND_NETWORK_ADMIN;
            default:
                return OfficeRole.ROLE_RELATIONSHIP;
        }
    }

    protected void startServiceTicketTask(ServiceTicket ticket) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("ticket", ticket);
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        String processId = OfficeBPMService.instance().startProcess("service_ticket_process", vars);
        ticket.setBpmProcessId(processId);
    }

    public void delete(Long id) {
        ServiceTicket ticket = serviceTicketDao.findById(id);
        Task task = getTaskForTicket(ticket);
        if (task != null) {
            OfficeBPMTaskService.instance().deleteTask(task.getId());
        }
        serviceTicketDao.delete(id);

    }

    public static SelfService instance() {
        return SpringContext.getBean(SelfService.class);
    }
}
