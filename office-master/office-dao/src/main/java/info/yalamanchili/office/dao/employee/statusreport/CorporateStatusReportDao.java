/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.employee.statusreport;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import info.yalamanchili.office.entity.employee.statusreport.CropStatusReportsStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benerji.v
 */
@Repository
@Scope("prototype")
public class CorporateStatusReportDao extends CRUDDao<CorporateStatusReport> {

    @Override
    public CorporateStatusReport save(CorporateStatusReport entity) {
        if (entity.getId() == null) {
            entity.setStatus(CropStatusReportsStatus.Saved);
            entity.setEmployee(OfficeSecurityService.instance().getCurrentUser());
        }
        return super.save(entity);
    }

    public List<CorporateStatusReport> getReports(Employee emp, int start, int limit) {
        TypedQuery<CorporateStatusReport> query = em.createQuery("from " + CorporateStatusReport.class.getCanonicalName() + " where employee=:empParam", CorporateStatusReport.class);
        query.setParameter("empParam", emp);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Long getReportsSize(Employee emp, int start, int limit) {
        TypedQuery<Long> query = em.createQuery("select count(*) from " + CorporateStatusReport.class.getCanonicalName() + " where employee=:empParam", Long.class);
        query.setParameter("empParam", emp);
        return query.getSingleResult();
    }

    public CorporateStatusReportDao() {
        super(CorporateStatusReport.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CorporateStatusReportDao instance() {
        return SpringContext.getBean(CorporateStatusReportDao.class);
    }
}
