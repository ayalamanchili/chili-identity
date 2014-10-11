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
import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
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

    public Question create(Question entity) {
        if (QueryUtils.findEntity(em, Question.class, "questionKey", entity.getQuestionKey()) == null) {
            return super.save(entity);
        } else {
            return entity;
        }
    }

    public List<Question> getQuestions(QuestionCategory category, QuestionContext context, int start, int limit) {
        TypedQuery<Question> questionsQ = em.createQuery("from " + Question.class.getCanonicalName() + " where category=:categoryParam and context=:contextParam order by sortOrder ASC", Question.class);
        questionsQ.setParameter("categoryParam", category);
        questionsQ.setParameter("contextParam", context);
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
