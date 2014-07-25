/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.client.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class StatusReportDao extends CRUDDao<StatusReport> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public StatusReport save(StatusReport entity) {
        entity.setProject(ProjectDao.instance().findById(entity.getProject().getId()));
        entity.setClientInformation(ClientInformationDao.instance().findById(entity.getClientInformation().getId()));
        return em.merge(entity);
    }

    public List<StatusReport> getReports(Employee emp, int start, int limit) {
        TypedQuery<StatusReport> query = em.createQuery("from " + StatusReport.class.getCanonicalName() + " where clientInformation.employee=:empParam", StatusReport.class);
        query.setParameter("empParam", emp);
        return query.getResultList();
    }

    public Long getReportsSize(Employee emp, int start, int limit) {
        TypedQuery<Long> query = em.createQuery("select count(*) from " + StatusReport.class.getCanonicalName() + " where clientInformation.employee=:empParam", Long.class);
        query.setParameter("empParam", emp);
        return query.getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public StatusReportDao() {
        super(StatusReport.class);
    }

    public static StatusReportDao instance() {
        return SpringContext.getBean(StatusReportDao.class);
    }
}
