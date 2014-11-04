/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.employee;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
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

//    @Override
//    public PerformanceEvaluation save(PerformanceEvaluation entity) {
//        return em.merge(entity);
//    }
    public List<PerformanceEvaluation> getPerformanceEvaluationsForEmp(Employee emp) {
        List<PerformanceEvaluation> performanceEvaluations = new ArrayList<PerformanceEvaluation>();
        TypedQuery<PerformanceEvaluation> query = em.createQuery("from " + PerformanceEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", PerformanceEvaluation.class);
        query.setParameter("employeeParam", emp);
        boolean isCorporateEmployee = false;
        if (OfficeSecurityService.instance().getUserRoles(emp).contains(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            isCorporateEmployee = true;
        }
        for (PerformanceEvaluation perfEval : query.getResultList()) {
            if (PerformanceEvaluationStage.Manager_Review.equals(perfEval.getStage()) && isCorporateEmployee && checkPermission(emp)) {
                perfEval.setEnableManagerReview(true);
            } else {
                perfEval.setEnableManagerReview(false);
            }
            performanceEvaluations.add(perfEval);
        }
        return performanceEvaluations;
    }

    protected boolean checkPermission(Employee emp) {
        
        if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name())) {
            return true;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        Employee perfEvalMgr = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Perf_Eval_Manager");
        if (perfEvalMgr != null && perfEvalMgr.getId().equals(currentUser.getId())) {
            return true;
        }
        Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (reportsToEmp != null && reportsToEmp.getId().equals(currentUser.getId())) {
            return true;
        }
        return false;
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
