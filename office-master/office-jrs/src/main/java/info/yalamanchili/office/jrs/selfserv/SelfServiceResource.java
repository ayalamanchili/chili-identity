/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.selfserv;

import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.selfserv.ServiceTicketDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import info.yalamanchili.office.entity.selfserv.TicketComment;
import info.yalamanchili.office.security.AccessCheck;
import info.yalamanchili.office.selfserv.SelfService;
import info.yalamanchili.office.selfserv.ServiceTicketUpdateDto;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/selfservice")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class SelfServiceResource {

    @PUT
    @Validate
    @Path("/create-ticket/{empid}")
    public String createServiceTicket(@PathParam("empid") long empid, ServiceTicket ticket) {
        return SelfService.instance().createServiceTicket(EmployeeDao.instance().findById(empid), ticket);
    }

    @PUT
    @Validate
    @Path("/create-ticket/currentuser")
    public String createServiceTicket(ServiceTicket ticket) {
        return SelfService.instance().createServiceTicket(OfficeSecurityService.instance().getCurrentUser(), ticket);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathParam("id") Long id) {
        SelfService.instance().delete(id);
    }

    @Autowired
    protected Mapper mapper;

    @PUT
    @Path("/update-ticket")
    public void updateTicket(ServiceTicketUpdateDto servTicket) {
        SelfService.instance().updateTicket(mapper.map(servTicket, ServiceTicket.class));
    }

    @GET
    @Path("/{ticketId}")
//    @AccessCheck(roles = {"ROLE_SELFSERVICE_TRIAGE" }, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public ServiceTicket viewServiceTicket(@PathParam("ticketId") long ticketId) {
        return ServiceTicketDao.instance().findById(ticketId);
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
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        ServiceTicketDao dao = ServiceTicketDao.instance();
        ServiceTicketTable table = new ServiceTicketTable();
        table.getEntities().addAll(dao.getCandidateTickets(currentUser, start, limit));
        table.setSize(dao.getCandidateTicketsSize(currentUser, start, limit));
        return table;
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
    public static class ServiceTicketTable implements java.io.Serializable{

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
            if (this.entities == null) {
                this.entities = new ArrayList<ServiceTicket>();
            }
            return entities;
        }

        public void setEntities(List<ServiceTicket> entities) {
            this.entities = entities;
        }
    }
}
