/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.probeval;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.employee.ProbationPeriodEvaluationDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.ext.Question;
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
public class ProbationPeriodEvaluationService {

    @Autowired
    protected ProbationPeriodEvaluationDao probationPeriodEvaluationDao;

    public void initiateProbationPeriodEvaluationReview(Long employeeId) {
        if (probationPeriodEvaluationDao.query(0, 10).size() > 0) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "probation.evaluation.already.exists", "Probation Period Evaluation already Exists");
        } else {
            ProbationPeriodEvaluation evaluation = new ProbationPeriodEvaluation();
            evaluation.setEmployee(EmployeeDao.instance().findById(employeeId));
            evaluation = probationPeriodEvaluationDao.save(evaluation);
            probationPeriodEvaluationDao.getEntityManager().flush();
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("entityId", evaluation.getId());
            obj.put("entity", evaluation);
            OfficeBPMService.instance().startProcess("probation_period_evaluation_process", obj);
        }
    }

    public void save(ProbationPeriodEvaluationDto dto) {
        ProbationPeriodEvaluation entity = probationPeriodEvaluationDao.findById(dto.getEvaluation().getId());
        entity.setTrainingRequirments(dto.getEvaluation().getTrainingRequirments());
        entity.setAdditionalComments((dto.getEvaluation().getAdditionalComments()));
        entity = probationPeriodEvaluationDao.save(entity);
        createQuestionComments(entity, dto.getComments());
    }

    public void createQuestionComments(ProbationPeriodEvaluation evaluation, List<QuestionComment> comments) {
        CommentDao commentDao = CommentDao.instance();
        for (QuestionComment comment : comments) {
            if (comment.getQuestionId() != null) {
                Question qes = QuestionDao.instance().findById(comment.getQuestionId());
                evaluation.addQuestion(qes);
                Comment cmt = commentDao.find(evaluation, qes);
                if (cmt == null) {
                    commentDao.addComment(comment.getComment(), comment.getRating(), evaluation, qes);
                } else {
                    cmt.setComment(comment.getComment());
                    cmt.setRating(comment.getRating());
                }
            }
        }
    }

}
