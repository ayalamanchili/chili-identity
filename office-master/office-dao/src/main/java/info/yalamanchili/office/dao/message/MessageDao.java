/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.message;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prashanthi
 */
@Repository
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
        Employee currentEmployee = OfficeSecurityService.instance().getCurrentUser();
        Query findAllQuery = getEntityManager().createQuery("select msg from " + entityCls.getCanonicalName() + " msg JOIN msg.tos emp where emp =:empParam order by msg.messageTs DESC", entityCls);
        findAllQuery.setParameter("empParam", currentEmployee);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Override
    public Long size() {
        Employee currentEmployee = OfficeSecurityService.instance().getCurrentUser();
        TypedQuery<Long> sizeQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " msg JOIN msg.tos emp where emp =:empParam", Long.class);
        sizeQuery.setParameter("empParam", currentEmployee);
        return sizeQuery.getSingleResult();
    }

    public MessageDao() {
        super(Message.class);
    }

    public static MessageDao instance() {
        return SpringContext.getBean(MessageDao.class);
    }
}
