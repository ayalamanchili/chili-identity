/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.selfserv;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.selfserv.ServiceTicketDao;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import info.yalamanchili.office.entity.selfserv.TicketStatus;
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

    public void createServiceTicket(ServiceTicket ticket) {
        //TODO start process to create user task
        //TODO set dept 
        //TODO set task id
        ticket.setStatus(TicketStatus.Open);
        em.persist(ticket);
    }

    public static SelfService instance() {
        return SpringContext.getBean(SelfService.class);
    }
}
