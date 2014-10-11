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
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.dto.ext.QuestionDto;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.messages.MessagesUtils;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    protected MessagesUtils messagesUtils;
    @Autowired
    protected QuestionDao questionDao;

    public List<QuestionDto> getQuestions(QuestionCategory category, QuestionContext context, int start, int limit) {
        List<QuestionDto> questions = new ArrayList<QuestionDto>();
        for (Question q : questionDao.getQuestions(category, context, start, limit)) {
            QuestionDto dto = new QuestionDto();
            dto.setId(q.getId());
            dto.setSortOrder(q.getSortOrder());
            dto.setQuestion(messagesUtils.get(q.getQuestionKey()));
            dto.setQuestionInfo(messagesUtils.get(q.getQuestionKey() + "_info"));
            dto.setQuestionCommentRequired(q.getQuestionCommentRequired());
            dto.setQuestionRatingRequired(q.getQuestionRatingRequired());
            questions.add(dto);
        }
        return questions;
    }

    public List<QuestionComment> getQuestionComments(Long perfEvalId, QuestionCategory category, QuestionContext context) {
        List<QuestionComment> res = new ArrayList<QuestionComment>();
        PerformanceEvaluation perfEval = PerformanceEvaluationDao.instance().findById(perfEvalId);
        CommentDao commentDao = CommentDao.instance();
        for (Question q : PerformanceEvaluationDao.instance().getQuestions(perfEvalId, category, context)) {
            Comment cmmt = commentDao.find(perfEval, q);
            QuestionComment qc = new QuestionComment();
            qc.setQuestion(messagesUtils.get(q.getQuestionKey()));
            qc.setQuestionInfo(messagesUtils.get(q.getQuestionKey() + "_info"));
            qc.setSortOrder(q.getSortOrder());
            if (cmmt != null) {
                qc.setId(cmmt.getId());
                qc.setComment(cmmt.getComment());
                qc.setRating(cmmt.getRating());
            }
            res.add(qc);
        }
        return res;
    }

    public static QuestionService instance() {
        return SpringContext.getBean(QuestionService.class);
    }

}
