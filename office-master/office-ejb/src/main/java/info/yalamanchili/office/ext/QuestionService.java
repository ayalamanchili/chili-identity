/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.ext;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.employee.PerformanceEvaluationDao;
import info.yalamanchili.office.dao.employee.ProbationPeriodEvaluationDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.dto.ext.QuestionDto;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.messages.MessagesUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("request")
public class QuestionService {

    protected MessagesUtils messagesUtils;

    @Autowired
    protected QuestionDao questionDao;

    public List<QuestionDto> getQuestions(QuestionCategory category, QuestionContext context, int start, int limit, Map<String, String> swaps) {
        List<QuestionDto> questions = new ArrayList<>();
        questionDao.getQuestions(category, context, start, limit).stream().map((q) -> {
            QuestionDto dto = new QuestionDto();
            dto.setId(q.getId());
            dto.setSortOrder(q.getSortOrder());
            dto.setQuestion(getMessageUtils().get(q.getQuestionKey(), swaps));
            dto.setQuestionInfo(getMessageUtils().get(q.getQuestionKey() + "_info", swaps));
            dto.setQuestionCommentRequired(q.getQuestionCommentRequired());
            dto.setQuestionRatingRequired(q.getQuestionRatingRequired());
            return dto;
        }).forEach((dto) -> {
            questions.add(dto);
        });
        return questions;
    }

    public List<QuestionDto> getQuestions(QuestionCategory category, QuestionContext context, int start, int limit) {
        return getQuestions(category, context, start, limit, Collections.emptyMap());
    }

    public List<QuestionComment> getQuestionComments(Long perfEvalId, QuestionCategory category, QuestionContext context, Map<String, String> swaps) {
        List<QuestionComment> res = new ArrayList<>();
        PerformanceEvaluation perfEval = PerformanceEvaluationDao.instance().findById(perfEvalId);
        CommentDao commentDao = CommentDao.instance();
        PerformanceEvaluationDao.instance().getQuestions(perfEvalId, category, context).stream().map((q) -> {
            Comment cmmt = commentDao.find(perfEval, q);
            QuestionComment qc = new QuestionComment();
            qc.setQuestion(getMessageUtils().get(q.getQuestionKey(), swaps));
            qc.setQuestionInfo(getMessageUtils().get(q.getQuestionKey() + "_info", swaps));
            qc.setSortOrder(q.getSortOrder());
            qc.setQuestionRatingRequired(q.getQuestionRatingRequired());
            qc.setQuestionCommentRequired(q.getQuestionCommentRequired());
            if (cmmt != null) {
                qc.setCommentId(cmmt.getId());
                qc.setQuestionId(q.getId());
                qc.setComment(cmmt.getComment());
                qc.setRating(cmmt.getRating());
            }
            return qc;
        }).forEach((qc) -> {
            res.add(qc);
        });
        return res;
    }

    public List<QuestionComment> getQuestionComments(Long perfEvalId, QuestionCategory category, QuestionContext context) {
        PerformanceEvaluation perfEval = PerformanceEvaluationDao.instance().findById(perfEvalId);
        Map<String, String> swaps = new HashMap();
        Integer fyYear = Integer.valueOf(perfEval.getEvaluationFYYear());
        swaps.put("fyYear", fyYear.toString());
        fyYear++;
        swaps.put("nextFyYear", fyYear.toString());
        return getQuestionComments(perfEvalId, category, context, swaps);
    }

    public List<QuestionComment> getQuestionCommentsForProbationPeriodEvaluations(Long provationPrdEvaluation, QuestionCategory category, QuestionContext context) {
        List<QuestionComment> res = new ArrayList<>();
        ProbationPeriodEvaluation perfEval = ProbationPeriodEvaluationDao.instance().findById(provationPrdEvaluation);
        CommentDao commentDao = CommentDao.instance();
        for (Question q : ProbationPeriodEvaluationDao.instance().getQuestions(provationPrdEvaluation, category, context)) {
            Comment cmmt = commentDao.find(perfEval, q);
            QuestionComment qc = new QuestionComment();
            qc.setQuestion(getMessageUtils().get(q.getQuestionKey()));
            qc.setQuestionInfo(getMessageUtils().get(q.getQuestionKey() + "_info"));
            qc.setSortOrder(q.getSortOrder());
            qc.setQuestionRatingRequired(q.getQuestionRatingRequired());
            qc.setQuestionCommentRequired(q.getQuestionCommentRequired());
            if (cmmt != null) {
                qc.setCommentId(cmmt.getId());
                qc.setQuestionId(q.getId());
                qc.setComment(cmmt.getComment());
                qc.setRating(cmmt.getRating());
            }
            res.add(qc);
        }
        return res;
    }

    public MessagesUtils getMessageUtils() {
        if (messagesUtils == null) {
            messagesUtils = SpringContext.getBean(MessagesUtils.class);
            messagesUtils.setBundleName("officeMessages");
        }
        return messagesUtils;
    }

    public static QuestionService instance() {
        return SpringContext.getBean(QuestionService.class);
    }

}
