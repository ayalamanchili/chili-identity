/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.perfeval;

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
 * @author ayalamanchili
 */
@Component
@Transactional
public class PerformanceEvaluationQuestionsFactory {

    /**
     * sync all performance evaluation questions
     */
    @CacheEvict(value = OfficeCacheKeys.QUESTIONS, allEntries = true)
    public void syncQuestions() {
        QuestionDao questionDao = QuestionDao.instance();
        /*
         SKILL_AND_APTITUDE
         */
        Question q1 = new Question();
        q1.setQuestionKey("performance.review.skill.aptitude.question1");
        q1.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q1.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q1.setSortOrder(1);
        q1.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q1);

        Question q2 = new Question();
        q2.setQuestionKey("performance.review.skill.aptitude.question2");
        q2.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q2.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q2.setSortOrder(2);
        q2.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q2);

        Question q3 = new Question();
        q3.setQuestionKey("performance.review.skill.aptitude.question3");
        q3.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q3.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q3.setSortOrder(3);
        q3.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q3);

        Question q4 = new Question();
        q4.setQuestionKey("performance.review.skill.aptitude.question4");
        q4.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q4.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q4.setQuestionRatingRequired(Boolean.TRUE);
        q4.setSortOrder(4);
        questionDao.create(q4);

        Question q5 = new Question();
        q5.setQuestionKey("performance.review.skill.aptitude.question5");
        q5.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q5.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q5.setSortOrder(5);
        q5.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q5);

        Question q6 = new Question();
        q6.setQuestionKey("performance.review.skill.aptitude.question6");
        q6.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q6.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q6.setSortOrder(6);
        q6.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q6);

        Question q7 = new Question();
        q7.setQuestionKey("performance.review.skill.aptitude.question7");
        q7.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q7.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q7.setSortOrder(7);
        q7.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q7);

        Question q8 = new Question();
        q8.setQuestionKey("performance.review.skill.aptitude.question8");
        q8.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q8.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q8.setSortOrder(8);
        q8.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q8);

        Question q9 = new Question();
        q9.setQuestionKey("performance.review.skill.aptitude.question9");
        q9.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q9.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q9.setSortOrder(9);
        q9.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q9);

        Question q10 = new Question();
        q10.setQuestionKey("performance.review.skill.aptitude.question10");
        q10.setCategory(QuestionCategory.SKILL_AND_APTITUDE);
        q10.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q10.setSortOrder(10);
        q10.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q10);
        /*
         ATTITUDE
         */
        Question q11 = new Question();
        q11.setQuestionKey("performance.review.attitude.question11");
        q11.setCategory(QuestionCategory.ATTITUDE);
        q11.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q11.setSortOrder(11);
        q11.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q11);

        Question q12 = new Question();
        q12.setQuestionKey("performance.review.attitude.question12");
        q12.setCategory(QuestionCategory.ATTITUDE);
        q12.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q12.setSortOrder(12);
        q12.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q12);

        Question q13 = new Question();
        q13.setQuestionKey("performance.review.attitude.question13");
        q13.setCategory(QuestionCategory.ATTITUDE);
        q13.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q13.setSortOrder(13);
        q13.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q13);

        Question q14 = new Question();
        q14.setQuestionKey("performance.review.attitude.question14");
        q14.setCategory(QuestionCategory.ATTITUDE);
        q14.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q14.setSortOrder(14);
        q14.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q14);

        Question q15 = new Question();
        q15.setQuestionKey("performance.review.attitude.question15");
        q15.setCategory(QuestionCategory.ATTITUDE);
        q15.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q15.setSortOrder(15);
        q15.setQuestionRatingRequired(Boolean.TRUE);
        questionDao.create(q15);

        /*
         Management (Applicable to Managers w/Direct Reports only):
         */
        Question q16 = new Question();
        q16.setQuestionKey("performance.review.managenet.question16");
        q16.setCategory(QuestionCategory.MANAGEMENT);
        q16.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q16.setSortOrder(16);
        q16.setQuestionRatingRequired(Boolean.FALSE);
        questionDao.create(q16);
        Question q17 = new Question();
        q17.setQuestionKey("performance.review.managenet.question17");
        q17.setCategory(QuestionCategory.MANAGEMENT);
        q17.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q17.setSortOrder(17);
        q17.setQuestionRatingRequired(Boolean.FALSE);
        questionDao.create(q17);
        Question q18 = new Question();
        q18.setQuestionKey("performance.review.managenet.question18");
        q18.setCategory(QuestionCategory.MANAGEMENT);
        q18.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q18.setSortOrder(18);
        q18.setQuestionRatingRequired(Boolean.FALSE);
        questionDao.create(q18);
        Question q19 = new Question();
        q19.setQuestionKey("performance.review.managenet.question19");
        q19.setCategory(QuestionCategory.MANAGEMENT);
        q19.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q19.setSortOrder(19);
        q19.setQuestionRatingRequired(Boolean.FALSE);
        questionDao.create(q19);
        Question q20 = new Question();
        q20.setQuestionKey("performance.review.managenet.question20");
        q20.setCategory(QuestionCategory.MANAGEMENT);
        q20.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q20.setSortOrder(20);
        q20.setQuestionRatingRequired(Boolean.FALSE);
        questionDao.create(q20);
        Question q21 = new Question();
        q21.setQuestionKey("performance.review.managenet.question21");
        q21.setCategory(QuestionCategory.MANAGEMENT);
        q21.setContext(QuestionContext.PERFORMANCE_EVALUATION_MANGER);
        q21.setSortOrder(21);
        q21.setQuestionRatingRequired(Boolean.FALSE);
        questionDao.create(q21);
        /*
         Self Review Questions
         */
        Question q22 = new Question();
        q22.setQuestionKey("performance.review.self.question1");
        q22.setCategory(QuestionCategory.SELF_EVALUATION);
        q22.setContext(QuestionContext.PERFORMANCE_EVALUATION_SELF);
        q22.setSortOrder(41);
        q22.setQuestionCommentRequired(true);
        questionDao.create(q22);
        Question q23 = new Question();
        q23.setQuestionKey("performance.review.self.question2");
        q23.setCategory(QuestionCategory.SELF_EVALUATION);
        q23.setContext(QuestionContext.PERFORMANCE_EVALUATION_SELF);
        q23.setSortOrder(42);
        q23.setQuestionCommentRequired(true);
        questionDao.create(q23);
        Question q24 = new Question();
        q24.setQuestionKey("performance.review.self.question3");
        q24.setCategory(QuestionCategory.SELF_EVALUATION);
        q24.setContext(QuestionContext.PERFORMANCE_EVALUATION_SELF);
        q24.setSortOrder(43);
        q24.setQuestionCommentRequired(true);
        questionDao.create(q24);
        Question q25 = new Question();
        q25.setQuestionKey("performance.review.self.question4");
        q25.setCategory(QuestionCategory.SELF_EVALUATION);
        q25.setContext(QuestionContext.PERFORMANCE_EVALUATION_SELF);
        q25.setSortOrder(44);
        q25.setQuestionCommentRequired(true);
        questionDao.create(q25);

    }

    public static PerformanceEvaluationQuestionsFactory instance() {
        return SpringContext.getBean(PerformanceEvaluationQuestionsFactory.class);
    }
}
