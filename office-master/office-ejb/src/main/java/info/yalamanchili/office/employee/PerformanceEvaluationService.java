/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.employee.PerformanceEvaluationDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.dto.ext.QuestionDto;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.ext.QuestionService;
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
public class PerformanceEvaluationService {

    @Autowired
    protected PerformanceEvaluationDao performanceEvaluationDao;

    public String startPerformanceEvaluation(Employee emp, PerformanceEvaluation entity) {
        entity.setEmployee(emp);
        return performanceEvaluationDao.save(entity).getId().toString();
    }

    public List<QuestionDto> getQuestions(QuestionCategory category) {
        return QuestionService.instance().getQuestions(category, QuestionContext.PERFORMANCE_EVALUATION_MANGER, 0, 100);
    }

    public void saveQuestionComments(Long perfEvalId, List<QuestionComment> comments) {
        PerformanceEvaluation perfEval = PerformanceEvaluationDao.instance().findById(perfEvalId);
        for (QuestionComment comment : comments) {
            Question qes = QuestionDao.instance().findById(comment.getQuestionId());
            perfEval.addQuestion(qes);
            CommentDao.instance().addComment(comment.getComment(), comment.getRating(),qes);
        }
    }

    public static PerformanceEvaluationService instance() {
        return SpringContext.getBean(PerformanceEvaluationService.class);
    }
}
