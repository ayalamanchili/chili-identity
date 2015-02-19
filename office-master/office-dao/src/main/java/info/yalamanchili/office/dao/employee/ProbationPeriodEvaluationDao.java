/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.employee;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class ProbationPeriodEvaluationDao extends CRUDDao<ProbationPeriodEvaluation> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public List<ProbationPeriodEvaluation> getEvaluations(Employee emp) {
        TypedQuery<ProbationPeriodEvaluation> query = em.createQuery("from " + ProbationPeriodEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", ProbationPeriodEvaluation.class);
        query.setParameter("employeeParam", emp);
        return query.getResultList();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Long size(Employee emp) {
        TypedQuery<Long> sizeQuery = em.createQuery("select count (*) from " + ProbationPeriodEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", Long.class);
        sizeQuery.setParameter("employeeParam", emp);
        return (Long) sizeQuery.getSingleResult();
    }

    public void acceccCheck(Employee employee) {
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (employee.getId().equals(currentUser.getId())) {
            return;
        }
        boolean isCorporateEmployee = false;
        if (OfficeSecurityService.instance().getUserRoles(employee).contains(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            isCorporateEmployee = true;
        }
        //this is a corp emp review
        if (isCorporateEmployee) {
            if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name())) {
                return;
            }
            Employee perfEvalMgr = CompanyContactDao.instance().getCompanyContactForEmployee(employee, "Perf_Eval_Manager");
            if (perfEvalMgr != null && currentUser.getId().equals(perfEvalMgr.getId())) {
                return;
            }
            Employee reportsToMgr = CompanyContactDao.instance().getCompanyContactForEmployee(employee, "Reports_To");
            if (reportsToMgr != null && currentUser.getId().equals(reportsToMgr.getId())) {
                return;
            }
        } //Consultant employee review
        else {
            if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_RELATIONSHIP.name(), OfficeRoles.OfficeRole.ROLE_H1B_IMMIGRATION.name())) {
                return;
            }
        }
        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "permission.error", "you do not have permission to view this information");
    }

    public ProbationPeriodEvaluationDao() {
        super(ProbationPeriodEvaluation.class);
    }

    public static ProbationPeriodEvaluationDao instance() {
        return SpringContext.getBean(ProbationPeriodEvaluationDao.class);
    }
}
