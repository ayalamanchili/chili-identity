/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.selfserv;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import info.yalamanchili.office.entity.selfserv.TicketComment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class ServiceTicketDao extends CRUDDao<ServiceTicket> {

    public List<ServiceTicket> getTickets(Employee emp, int start, int limit) {
        //TODO order by created date
        Query query = getEntityManager().createQuery("from " + ServiceTicket.class.getCanonicalName() + " st where st.employee=:employeeParam order by st.createdTimeStamp DESC", ServiceTicket.class);
        query.setParameter("employeeParam", emp);
        return query.getResultList();
    }

    public Long getTicketsSize(Employee emp, int start, int limit) {
        Query query = getEntityManager().createQuery("select count (*) from " + ServiceTicket.class.getCanonicalName() + " st where st.employee=:employeeParam", Long.class);
        query.setParameter("employeeParam", emp);
        return (Long) query.getSingleResult();

    }

    public List<TicketComment> getCommentsForTicket(Long ticketId) {
        Query query = getEntityManager().createQuery(" from " + TicketComment.class.getCanonicalName() + " tc where tc.ticketId.id=:ticketIdParam", TicketComment.class);
        query.setParameter("ticketIdParam", ticketId);
        return query.getResultList();
    }

    public ServiceTicketDao() {
        super(ServiceTicket.class);
    }
    
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ServiceTicketDao instance() {
        return SpringContext.getBean(ServiceTicketDao.class);
    }
}
