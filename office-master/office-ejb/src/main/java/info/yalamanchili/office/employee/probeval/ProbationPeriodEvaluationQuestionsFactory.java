/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.probeval;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Component
@Transactional
public class ProbationPeriodEvaluationQuestionsFactory {

    /**
     * sync all performance evaluation questions
     */
    @CacheEvict(value = OfficeCacheKeys.QUESTIONS, allEntries = true)
    public void syncProbationQuestions() {
        QuestionDao questionDao = QuestionDao.instance();

        //PROBATION_PERIOD_EVALUATION_MANAGER;
        Question q26 = new Question();
        q26.setQuestionKey("probation.review.attitude.question1");
        q26.setCategory(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER);
        q26.setContext(QuestionContext.PROBATION_PERIOD_EVALUATION);
        q26.setSortOrder(1);
        q26.setQuestionCommentRequired(true);
        questionDao.create(q26);
        Question q27 = new Question();
        q27.setQuestionKey("probation.review.attitude.question2");
        q27.setCategory(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER);
        q27.setContext(QuestionContext.PROBATION_PERIOD_EVALUATION);
        q27.setSortOrder(2);
        q27.setQuestionCommentRequired(true);
        questionDao.create(q27);
        Question q28 = new Question();
        q28.setQuestionKey("probation.review.attitude.question3");
        q28.setCategory(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER);
        q28.setContext(QuestionContext.PROBATION_PERIOD_EVALUATION);
        q28.setSortOrder(3);
        q28.setQuestionCommentRequired(true);
        questionDao.create(q28);
        Question q29 = new Question();
        q29.setQuestionKey("probation.review.attitude.question4");
        q29.setCategory(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER);
        q29.setContext(QuestionContext.PROBATION_PERIOD_EVALUATION);
        q29.setSortOrder(4);
        q29.setQuestionCommentRequired(true);
        questionDao.create(q29);
        Question q30 = new Question();
        q30.setQuestionKey("probation.review.attitude.question5");
        q30.setCategory(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER);
        q30.setContext(QuestionContext.PROBATION_PERIOD_EVALUATION);
        q30.setSortOrder(5);
        q30.setQuestionCommentRequired(true);
        questionDao.create(q30);
        Question q31 = new Question();
        q31.setQuestionKey("probation.review.attitude.question6");
        q31.setCategory(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER);
        q31.setContext(QuestionContext.PROBATION_PERIOD_EVALUATION);
        q31.setSortOrder(6);
        q31.setQuestionCommentRequired(true);
        questionDao.create(q31);
        Question q32 = new Question();
        q32.setQuestionKey("probation.review.attitude.question7");
        q32.setCategory(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER);
        q32.setContext(QuestionContext.PROBATION_PERIOD_EVALUATION);
        q32.setSortOrder(7);
        q32.setQuestionCommentRequired(true);
        questionDao.create(q32);
        Question q33 = new Question();
        q33.setQuestionKey("probation.review.attitude.question8");
        q33.setCategory(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER);
        q33.setContext(QuestionContext.PROBATION_PERIOD_EVALUATION);
        q33.setSortOrder(8);
        q33.setQuestionCommentRequired(true);
        questionDao.create(q33);
    }

    public static ProbationPeriodEvaluationQuestionsFactory instance() {
        return SpringContext.getBean(ProbationPeriodEvaluationQuestionsFactory.class);
    }
}
