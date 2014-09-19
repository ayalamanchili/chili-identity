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
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    @Override
    public PerformanceEvaluation save(PerformanceEvaluation entity) {
        return em.merge(entity);
    }

    public List<PerformanceEvaluation> getPerformanceEvaluationsForEmp(Employee emp) {
        TypedQuery<PerformanceEvaluation> query = em.createQuery("from " + PerformanceEvaluation.class.getCanonicalName() + "  where employee=:employeeParam", PerformanceEvaluation.class);
        query.setParameter("employeeParam", emp);
        return query.getResultList();
    }

    public Set<Question> getQuestions(Long id, QuestionCategory category, QuestionContext context) {
        TypedQuery<Question> query = getEntityManager().createQuery("select question from " + PerformanceEvaluation.class.getCanonicalName() + " pe inner join pe.questions question where pe.id=:idPraam and question.category =:categoryParam and question.context =:contextParam order by question.sortOrder ASC", Question.class);
        query.setParameter("idPraam", id);
        query.setParameter("categoryParam", category);
        query.setParameter("contextParam", context);
        return new HashSet<Question>(query.getResultList());
    }

    public PerformanceEvaluationDao() {
        super(PerformanceEvaluation.class);
    }

    public static PerformanceEvaluationDao instance() {
        return SpringContext.getBean(PerformanceEvaluationDao.class);
    }
}
