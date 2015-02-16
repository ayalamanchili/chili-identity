/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.employee;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.profile.Employee;
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

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Long size(Employee emp) {
        TypedQuery<Long> sizeQuery = em.createQuery("select count (*) from " + ProbationPeriodEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", Long.class);
        sizeQuery.setParameter("employeeParam", emp);
        return (Long) sizeQuery.getSingleResult();
    }

    public ProbationPeriodEvaluationDao() {
        super(ProbationPeriodEvaluation.class);
    }

    public static PerformanceEvaluationDao instance() {
        return SpringContext.getBean(ProbationPeriodEvaluation.class);
    }
}
