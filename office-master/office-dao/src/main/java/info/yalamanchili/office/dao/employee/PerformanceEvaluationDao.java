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
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.employee.PerformanceEvaluationStage;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
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
public class PerformanceEvaluationDao extends CRUDDao<PerformanceEvaluation> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public List<PerformanceEvaluation> getPerformanceEvaluationsForEmp(Employee emp) {
        List<PerformanceEvaluation> performanceEvaluations = new ArrayList<>();
        TypedQuery<PerformanceEvaluation> query = em.createQuery("from " + PerformanceEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", PerformanceEvaluation.class);
        query.setParameter("employeeParam", emp);
        boolean isCorporateEmployee = false;
        if (OfficeSecurityService.instance().getUserRoles(emp).contains(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            isCorporateEmployee = true;
        }
        for (PerformanceEvaluation perfEval : query.getResultList()) {
            if (enableUpdate(perfEval, emp) && isCorporateEmployee && perfEval.getQuestions().size() <= 4) {
                perfEval.setEnableManagerReview(true);
            } else {
                perfEval.setEnableManagerReview(false);
            }
            if (isCorporateEmployee) {
                perfEval.setEnableUpdate(enableUpdate(perfEval, emp));
            } else {
                perfEval.setEnableUpdate(true);
            }
            performanceEvaluations.add(perfEval);
        }
        return performanceEvaluations;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Long size(Employee emp) {
        TypedQuery<Long> sizeQuery = em.createQuery("select count (*) from " + PerformanceEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", Long.class);
        sizeQuery.setParameter("employeeParam", emp);
        return (Long) sizeQuery.getSingleResult();
    }

    public boolean enableUpdate(PerformanceEvaluation peval, Employee employee) {
        boolean flag = false;
        if (OfficeSecurityService.instance().hasAnyRole(OfficeRole.ROLE_HR_ADMINSTRATION.name())) {
            flag = true;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        Employee perfEvalMgr = CompanyContactDao.instance().getCompanyContactForEmployee(employee, "Perf_Eval_Manager");
        if (perfEvalMgr != null && currentUser.getId().equals(perfEvalMgr.getId())) {
            flag = true;
        }
        Employee reportsToMgr = CompanyContactDao.instance().getCompanyContactForEmployee(employee, "Reports_To");
        if (reportsToMgr != null && currentUser.getId().equals(reportsToMgr.getId())) {
            flag = true;
        }
        return flag && PerformanceEvaluationStage.Manager_Review.equals(peval.getStage());
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
            if (OfficeSecurityService.instance().hasAnyRole(OfficeRole.ROLE_HR_ADMINSTRATION.name())) {
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
            if (OfficeSecurityService.instance().hasAnyRole(OfficeRole.ROLE_RELATIONSHIP.name(), OfficeRole.ROLE_H1B_IMMIGRATION.name(), OfficeRole.ROLE_IT_DEVELOPER.name())) {
                return;
            }
        }
        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "permission.error", "you do not have permission to view this information");
    }

    public List<Question> getQuestions(Long id, QuestionCategory category, QuestionContext context) {
        TypedQuery<Question> query = getEntityManager().createQuery("select question from " + PerformanceEvaluation.class.getCanonicalName() + " pe inner join pe.questions question where pe.id=:idPraam and question.category =:categoryParam and question.context =:contextParam order by question.sortOrder ASC", Question.class);
        query.setParameter("idPraam", id);
        query.setParameter("categoryParam", category);
        query.setParameter("contextParam", context);
        return query.getResultList();
    }

    public PerformanceEvaluationDao() {
        super(PerformanceEvaluation.class);
    }

    public static PerformanceEvaluationDao instance() {
        return SpringContext.getBean(PerformanceEvaluationDao.class);
    }
}
