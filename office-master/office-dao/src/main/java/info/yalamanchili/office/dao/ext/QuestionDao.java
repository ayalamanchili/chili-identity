/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.ext;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class QuestionDao extends CRUDDao<Question> {

    @PersistenceContext
    protected EntityManager em;

    public QuestionDao() {
        super(Question.class);
    }

    public List<Question> getQuestions(QuestionType type, int start, int limit) {
        TypedQuery<Question> questionsQ = em.createQuery("from " + Question.class.getCanonicalName() + " where type=:typeParam", Question.class);
        //TODO use sort order
        questionsQ.setParameter("typeParam", type);
        questionsQ.setFirstResult(start);
        questionsQ.setMaxResults(limit);
        return questionsQ.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static QuestionDao instance() {
        return SpringContext.getBean(QuestionDao.class);
    }

}
