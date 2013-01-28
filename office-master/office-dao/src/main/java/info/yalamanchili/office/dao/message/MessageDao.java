/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.message;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
@Scope("prototype")
public class MessageDao extends CRUDDao<Message> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Message> query(int start, int limit) {
        Employee currentEmployee = SecurityService.instance().getCurrentUser();
        Query findAllQuery = getEntityManager().createQuery("select msg from " + entityCls.getCanonicalName() + " msg JOIN msg.tos emp where emp =:empParam", entityCls);
        findAllQuery.setParameter("empParam", currentEmployee);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Override
    public Long size() {
        Employee currentEmployee = SecurityService.instance().getCurrentUser();
        TypedQuery<Long> sizeQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where fromEmp=:currentEmp", Long.class);
        sizeQuery.setParameter("currentEmp", currentEmployee);
        return sizeQuery.getSingleResult();
    }

    public MessageDao() {
        super(Message.class);
    }

    public static MessageDao instance() {
        return SpringContext.getBean(MessageDao.class);
    }
}
