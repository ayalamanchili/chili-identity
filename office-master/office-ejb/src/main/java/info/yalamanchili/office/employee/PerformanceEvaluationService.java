/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee;

import info.chili.commons.DateUtils;
import info.chili.commons.PDFUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.employee.PerformanceEvaluationDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.employee.PerformanceEvaluationSaveDto;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.dto.ext.QuestionDto;
import info.yalamanchili.office.entity.employee.EvaluationFrequencyType;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.ext.QuestionService;
import info.yalamanchili.office.template.TemplateService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;
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

    /**
     * Create Manager Evaluation
     *
     * @param dto
     */
    public void createPerformanceEvaluation(PerformanceEvaluationSaveDto dto) {
        PerformanceEvaluation entity = getEvaluationForYear(dto.getPerformanceEvaluation().getEvaluationFYYear(), EmployeeDao.instance().findById(dto.getEmployeeId()));
        createQuestionComments(entity, dto.getComments());
    }

    public void updatePerformanceEvaluation(PerformanceEvaluationSaveDto dto) {
        performanceEvaluationDao.save(dto.getPerformanceEvaluation());
        for (QuestionComment qc : dto.getComments()) {
            if (qc.getId() != null) {
                Comment cmt = CommentDao.instance().find(qc.getId());
                cmt.setComment(qc.getComment());
                cmt.setRating(qc.getRating());
                CommentDao.instance().save(cmt);
            }
        }
    }

    /**
     * Create Self Evaluation
     *
     * @param dto
     */
    public void createPerformanceSelfEvaluation(PerformanceEvaluationSaveDto dto) {
        PerformanceEvaluation entity = getEvaluationForYear(dto.getYear(), OfficeSecurityService.instance().getCurrentUser());
        createQuestionComments(entity, dto.getComments());
    }

    public PerformanceEvaluation getEvaluationForYear(String year, Employee emp) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy", Locale.ENGLISH).parse(year);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        Date startDate = DateUtils.getFirstDayOfYear(date);
        Date endDate = DateUtils.getLastDayOfYear(date);
        TypedQuery<PerformanceEvaluation> query = performanceEvaluationDao.getEntityManager().createQuery("from " + PerformanceEvaluation.class.getCanonicalName() + " where evaluationPeriodStartDate=:startDateParam and evaluationPeriodEndDate=:endDateParam and employee=:employeeParam", PerformanceEvaluation.class);
        query.setParameter("startDateParam", startDate);
        query.setParameter("endDateParam", endDate);
        query.setParameter("employeeParam", emp);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            PerformanceEvaluation peval = new PerformanceEvaluation();
            peval.setEmployee(emp);
            peval.setEvaluationPeriodStartDate(startDate);
            peval.setEvaluationPeriodEndDate(endDate);
            peval.setEvaluationDate(new Date());
            peval.setType(EvaluationFrequencyType.Annual);
            return performanceEvaluationDao.getEntityManager().merge(peval);
        }
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

    public Response getReport(Long id) {
        PerformanceEvaluation evaluation = performanceEvaluationDao.findById(id);
        Employee emp = null;
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", evaluation);
        vars.put("attitudeComments", getQuestionComments(id, QuestionCategory.ATTITUDE, QuestionContext.PERFORMANCE_EVALUATION_MANGER));
        vars.put("managementComments", getQuestionComments(id, QuestionCategory.MANAGEMENT, QuestionContext.PERFORMANCE_EVALUATION_MANGER));
        vars.put("skillComments", getQuestionComments(id, QuestionCategory.SKILL_AND_APTITUDE, QuestionContext.PERFORMANCE_EVALUATION_MANGER));
        String report = TemplateService.instance().process("performance-evaluation.xhtml", vars);
        byte[] pdf = null;
        if (emp == null) {
            pdf = PDFUtils.convertToPDF(report);
        } else {
            OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
            pdf = PDFUtils.convertToSignedPDF(report, (emp.getBranch() != null) ? emp.getBranch().name() : null, DateUtils.dateToCalendar(evaluation.getEvaluationDate()), securityConfiguration.getKeyStoreName(), emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword());
        }
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = performance-evaluation.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static PerformanceEvaluationService instance() {
        return SpringContext.getBean(PerformanceEvaluationService.class);
    }
}
