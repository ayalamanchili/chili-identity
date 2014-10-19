/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.employee.statusreport;

import com.google.common.base.Strings;
import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.statusreport.StatusReport;
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
        if (!Strings.isNullOrEmpty(entity.getApprovedBy()) && EmployeeDao.instance().findEmployeWithEmpId(entity.getApprovedBy()) == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.approvedById", "Approved By must be a employee Id");
        }
        if (entity.getEmployee() == null) {
            entity.setEmployee(OfficeSecurityService.instance().getCurrentUser());
        }
        return em.merge(entity);
    }

    public List<StatusReport> getReports(Employee emp, int start, int limit) {
        TypedQuery<StatusReport> query = em.createQuery("from " + StatusReport.class.getCanonicalName() + " where employee=:empParam", StatusReport.class);
        query.setParameter("empParam", emp);
        //TODO filter report attribute
        return query.getResultList();
    }

    public Long getReportsSize(Employee emp, int start, int limit) {
        TypedQuery<Long> query = em.createQuery("select count(*) from " + StatusReport.class.getCanonicalName() + " where employee=:empParam", Long.class);
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
