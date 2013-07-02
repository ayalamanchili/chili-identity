/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.activity;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.activity.CommunicationActivity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
public class CommunicationActivityDao extends CRUDDao<CommunicationActivity> {

    @PersistenceContext
    protected EntityManager em;

    public CommunicationActivityDao() {
        super(CommunicationActivity.class);
    }

    public List<CommunicationActivity> getCommunicationActivity(Long empId, int start, int limit) {
        Query query = getEntityManager().createQuery("from " + CommunicationActivity.class.getCanonicalName() + " ca where ca.employee.id=:employeeIdParam", CommunicationActivity.class);
        query.setParameter("employeeIdParam", empId);
        return query.getResultList();
    }

    public Long getCommunicationActivitySize(Long empId, int start, int limit) {
        Query query = getEntityManager().createQuery("select count (*) from " + CommunicationActivity.class.getCanonicalName() + " ca where ca.employee.id=:employeeIdParam", Long.class);
        query.setParameter("employeeIdParam", empId);
        return (Long) query.getSingleResult();
    }

    @Override
    public CommunicationActivity save(CommunicationActivity entity) {
        entity.setIssueType(IssueTypeDao.instance().findById(entity.getIssueType().getId()));
        return super.save(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static IssueTypeDao instance() {
        return SpringContext.getBean(CommunicationActivityDao.class);

    }
}
