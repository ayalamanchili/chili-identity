/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.selfserv;

import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dao.selfserv.ServiceTicketDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import info.yalamanchili.office.entity.selfserv.TicketComment;
import info.yalamanchili.office.selfserv.SelfService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/selfservice")
@Component
@Transactional
@Scope("request")
public class SelfServiceResource {
    
    @PUT
    @Path("/create-ticket/{empid}")
    public String createServiceTicket(@PathParam("empid") long empid, ServiceTicket ticket) {
       return  SelfService.instance().createServiceTicket(empid, ticket);
    }
    
    @PUT
    @Path("/resolve-ticket/{ticketId}")
    public void resolveTicket(@PathParam("ticketId") long ticketId) {
        SelfService.instance().resolveTicket(ticketId);
    }
    
    @GET
    @Path("/tickets/{empid}/{start}/{limit}")
    //TODO add roles check
    public ServiceTicketTable getTickets(@PathParam("empid") long empid, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        Employee emp = EmployeeDao.instance().findById(empid);
        return getTicketsTable(emp, start, limit);
    }
    
    @GET
    @Path("/tickets/currentuser/{start}/{limit}")
    public ServiceTicketTable getTickets(@PathParam("start") int start,
            @PathParam("limit") int limit) {
        return getTicketsTable(SecurityService.instance().getCurrentUser(), start, limit);
    }
    
    protected ServiceTicketTable getTicketsTable(Employee emp, int start, int limit) {
        ServiceTicketTable tableObj = new ServiceTicketTable();
        tableObj.setEntities(ServiceTicketDao.instance().getTickets(emp, start, limit));
        tableObj.setSize(ServiceTicketDao.instance().getTicketsSize(emp, start, limit));
        return tableObj;
    }

    //------Service Ticket--------
    @PUT
    @Path("/add-comment/{ticketId}")
    public void addTicketComment(@PathParam("ticketId") long ticketId, TicketComment comment) {
        SelfService.instance().addTicketComment(ticketId, comment);
    }
    
    @GET
    @Path("/ticket/comments/{ticketId}/{start}/{limit}")
    public List<TicketComment> getCommentsForTicket(@PathParam("ticketId") long ticketId, @PathParam("start") int start, @PathParam("limit") int limit) {
        return ServiceTicketDao.instance().getCommentsForTicket(ticketId);
    }
    
    @XmlRootElement
    @XmlType
    public static class ServiceTicketTable {
        
        protected Long size;
        protected List<ServiceTicket> entities;
        
        public Long getSize() {
            return size;
        }
        
        public void setSize(Long size) {
            this.size = size;
        }
        
        @XmlElement
        public List<ServiceTicket> getEntities() {
            return entities;
        }
        
        public void setEntities(List<ServiceTicket> entities) {
            this.entities = entities;
        }
    }
}
