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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public PerformanceEvaluationDao() {
        super(PerformanceEvaluation.class);
    }

    public static PerformanceEvaluationDao instance() {
        return SpringContext.getBean(PerformanceEvaluationDao.class);
    }
}
