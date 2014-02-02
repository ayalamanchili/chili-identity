/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.selfserv;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return null;
    }

    public Long getTicketsSize(Employee emp, int start, int limit) {
        return null;
    }

    public ServiceTicketDao() {
        super(EmployeeDocument.class);
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
