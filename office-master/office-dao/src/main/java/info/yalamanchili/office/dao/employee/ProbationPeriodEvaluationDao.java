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
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluationStage;
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
public class ProbationPeriodEvaluationDao extends CRUDDao<ProbationPeriodEvaluation> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public List<ProbationPeriodEvaluation> getEvaluations(Employee emp) {
        List<ProbationPeriodEvaluation> evals = new ArrayList<>();
        TypedQuery<ProbationPeriodEvaluation> query = em.createQuery("from " + ProbationPeriodEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", ProbationPeriodEvaluation.class);
        query.setParameter("employeeParam", emp);
        for (ProbationPeriodEvaluation eval : query.getResultList()) {
            if (enableUpdate(eval, emp) && eval.getQuestions().isEmpty()) {
                eval.setEnableManagerReview(true);
            } else {
                eval.setEnableManagerReview(false);
            }
            evals.add(eval);
        }
        return evals;
    }

    public List<ProbationPeriodEvaluation> getActiveEvaluations(Employee emp) {
        TypedQuery<ProbationPeriodEvaluation> query = em.createQuery("from " + ProbationPeriodEvaluation.class.getCanonicalName() + "  where employee=:employeeParam and active=:activeParam", ProbationPeriodEvaluation.class);
        query.setParameter("employeeParam", emp);
        query.setParameter("activeParam", true);
        return query.getResultList();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Long size(Employee emp) {
        TypedQuery<Long> sizeQuery = em.createQuery("select count (*) from " + ProbationPeriodEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", Long.class);
        sizeQuery.setParameter("employeeParam", emp);
        return sizeQuery.getSingleResult();
    }

    public List<Question> getQuestions(Long id, QuestionCategory category, QuestionContext context) {
        TypedQuery<Question> query = getEntityManager().createQuery("select question from " + ProbationPeriodEvaluation.class.getCanonicalName() + " pe inner join pe.questions question where pe.id=:idPraam and question.category =:categoryParam and question.context =:contextParam order by question.sortOrder ASC", Question.class);
        query.setParameter("idPraam", id);
        query.setParameter("categoryParam", category);
        query.setParameter("contextParam", context);
        return query.getResultList();
    }

    public boolean enableUpdate(ProbationPeriodEvaluation eval, Employee employee) {
        boolean flag = false;
        if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name(), OfficeRoles.OfficeRole.ROLE_PRB_EVALUATIONS_MANAGER.name())) {
            flag = true;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser == null) {
            return false;
        }
        Employee perfEvalMgr = CompanyContactDao.instance().getCompanyContactForEmployee(employee, "Perf_Eval_Manager");
        if (perfEvalMgr != null && currentUser.getId().equals(perfEvalMgr.getId())) {
            flag = true;
        }
        Employee reportsToMgr = CompanyContactDao.instance().getCompanyContactForEmployee(employee, "Reports_To");
        if (reportsToMgr != null && currentUser.getId().equals(reportsToMgr.getId())) {
            flag = true;
        }
        return flag && ProbationPeriodEvaluationStage.Manager_Review.equals(eval.getStage());
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
            if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name(), OfficeRoles.OfficeRole.ROLE_PRB_EVALUATIONS_MANAGER.name())) {
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
