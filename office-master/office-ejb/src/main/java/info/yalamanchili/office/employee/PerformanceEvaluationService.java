/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.employee.PerformanceEvaluationSaveDto;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.dto.ext.QuestionDto;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
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
    
    public void updatePerformanceEvaluation(PerformanceEvaluationSaveDto dto) {
        performanceEvaluationDao.save(dto.getPerformanceEvaluation());
        for (QuestionComment qc : dto.getComments()) {
            Comment cmt = new Comment();
            cmt.setId(qc.getId());
            cmt.setComment(qc.getComment());
            cmt.setRating(qc.getRating());
            CommentDao.instance().save(cmt);
        }
    }
    
    public void createPerformanceEvaluation(PerformanceEvaluationSaveDto dto) {
        PerformanceEvaluation entity = dto.getPerformanceEvaluation();
        entity.setEmployee(EmployeeDao.instance().findById(dto.getEmployeeId()));
        entity = performanceEvaluationDao.getEntityManager().merge(entity);
        createQuestionComments(entity, dto.getComments());
    }
    
    public List<QuestionDto> getQuestions(QuestionCategory category) {
        return QuestionService.instance().getQuestions(category, QuestionContext.PERFORMANCE_EVALUATION_MANGER, 0, 100);
    }
    
    public void createQuestionComments(PerformanceEvaluation perfEval, List<QuestionComment> comments) {
        for (QuestionComment comment : comments) {
            Question qes = QuestionDao.instance().findById(comment.getId());
            perfEval.addQuestion(qes);
            CommentDao.instance().addComment(comment.getComment(), comment.getRating(), perfEval, qes);
        }
    }
    
    public List<QuestionComment> getQuestionComments(Long id, QuestionCategory category, QuestionContext context) {
        return QuestionService.instance().getQuestionComments(id, category, context);
    }
    //TODO move to commons

//    public Response getReport(Long id) {
//        PerformanceEvaluation evaluation = performanceEvaluationDao.findById(id);
//        Employee emp = null;
//        if (evaluation.getApprovedBy() != null) {
//            emp = EmployeeDao.instance().findEmployeWithEmpId(evaluation.getApprovedBy());
//        }
//        String report = TemplateService.instance().process("performance-evaluation.xhtml", evaluation);
//        byte[] pdf = null;
//        if (emp == null) {
//            pdf = PDFUtils.convertToPDF(report);
//        } else {
//            OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
//            pdf = PDFUtils.convertToSignedPDF(report, (emp.getBranch() != null) ? emp.getBranch().name() : null, DateUtils.dateToCalendar(evaluation.getApprovedDate()), securityConfiguration.getKeyStoreName(), emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword());
//        }
//        return Response
//                .ok(pdf)
//                .header("content-disposition", "filename = performance-evaluation.pdf")
//                .header("Content-Length", pdf.length)
//                .build();
//    }
    public static PerformanceEvaluationService instance() {
        return SpringContext.getBean(PerformanceEvaluationService.class);
    }
}
