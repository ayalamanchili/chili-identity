/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.perfeval;

import info.chili.commons.BeanMapper;
import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
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
import info.yalamanchili.office.entity.employee.PerformanceEvaluationStage;
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
import org.dozer.Mapper;
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

//Associate Performance Review
    public void saveAssociateReview(Employee employee, PerformanceEvaluationSaveDto dto, Boolean submitForApproval) {
        PerformanceEvaluation entity;
        if (dto.getPerformanceEvaluation().getId() != null) {
            entity = PerformanceEvaluationDao.instance().save(dto.getPerformanceEvaluation());
        } else {
            entity = getEvaluationForYear(dto.getPerformanceEvaluation().getEvaluationFYYearString(), employee, dto);
            entity.setStage(PerformanceEvaluationStage.Self_Review);
        }
        createQuestionComments(entity, dto.getComments());
        if (submitForApproval) {
            startAssociatePerformanceEvaluationProcess(entity, employee);
        }
    }

    protected void startAssociatePerformanceEvaluationProcess(PerformanceEvaluation entity, Employee emp) {
        OfficeBPMTaskService.instance().deleteTasksWithVariable("entityId", entity.getId(), "eemReviewTask", true);
        OfficeBPMTaskService.instance().deleteTasksWithVariable("entityId", entity.getId(), "hrFinalApprovalTask", true);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entityId", entity.getId());
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("assoc_emp_perf_eval_process", vars);
    }

//----------------------Corporate Employee Review----------------------------------
    public void saveCorporatePerformanceEvaluation(Employee employee, PerformanceEvaluationSaveDto dto, boolean startProcess) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        String year = dto.getYear();
        if (year == null) {
            year = dto.getPerformanceEvaluation().getEvaluationFYYear();
        }
        PerformanceEvaluation entity = getEvaluationForYear(year, employee, dto);
        if (dto.getPerformanceEvaluation() != null) {
            entity.setAreasNeedImprovement(dto.getPerformanceEvaluation().getAreasNeedImprovement());
            entity.setKeyAccomplishments(dto.getPerformanceEvaluation().getKeyAccomplishments());
            entity.setManagerComments(dto.getPerformanceEvaluation().getManagerComments());
            entity.setEmployeeComments(dto.getPerformanceEvaluation().getEmployeeComments());
            entity.setHrComments(dto.getPerformanceEvaluation().getHrComments());
        }
        createQuestionComments(entity, dto.getComments());
        if (startProcess) {
            startCorporatePerformanceEvaluationProcess(entity, employee);
        }
    }

    protected void startCorporatePerformanceEvaluationProcess(PerformanceEvaluation entity, Employee emp) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entityId", entity.getId());
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("corp_emp_perf_eval_process", vars);
    }

    public PerformanceEvaluation getEvaluationForYear(String year, Employee emp, PerformanceEvaluationSaveDto dto) {
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
        } else if (dto != null) {
            PerformanceEvaluation peval;
            if (dto.getPerformanceEvaluation() != null) {
                Mapper mapper = (Mapper) SpringContext.getBean("mapper");
                peval = mapper.map(dto.getPerformanceEvaluation(), PerformanceEvaluation.class);
            } else {
                peval = new PerformanceEvaluation();
            }
            peval.setEmployee(emp);
            peval.setEvaluationPeriodStartDate(startDate);
            peval.setEvaluationPeriodEndDate(endDate);
            peval.setEvaluationDate(new Date());
            peval.setType(EvaluationFrequencyType.Annual);
            return performanceEvaluationDao.getEntityManager().merge(peval);
        }
        return null;
    }

    public List<QuestionDto> getQuestions(QuestionCategory category) {
        return QuestionService.instance().getQuestions(category, QuestionContext.PERFORMANCE_EVALUATION_MANGER, 0, 100);
    }

    public void createQuestionComments(PerformanceEvaluation perfEval, List<QuestionComment> comments) {
        CommentDao commentDao = CommentDao.instance();
        for (QuestionComment comment : comments) {
            if (comment.getQuestionId() != null) {
                Question qes = QuestionDao.instance().findById(comment.getQuestionId());
                perfEval.addQuestion(qes);
                Comment cmt = commentDao.find(perfEval, qes);
                if (cmt == null) {
                    commentDao.addComment(comment.getComment(), comment.getRating(), perfEval, qes);
                } else {
                    cmt.setComment(comment.getComment());
                    cmt.setRating(comment.getRating());
                }
            }
        }
        calculatRating(perfEval);
    }

    protected void calculatRating(PerformanceEvaluation perfEval) {
        Double sum = 0.0;
        Double size = 0.0;
        for (Question qes : perfEval.getQuestions()) {
            Comment cmt = CommentDao.instance().find(qes);
            if (cmt != null && cmt.getRating() != null) {
                if (cmt.getRating() > 0) {
                    sum = sum + cmt.getRating();
                    size++;
                }
            }
        }
        Double avg = sum / size;
        if (avg > 0) {
            perfEval.setRating(new Double(Math.round(avg)));
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
            String branch = null;
            if (emp.getBranch() != null) {
                branch = emp.getBranch().name();
            }
            Signature signature = new Signature(emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, null, DateUtils.dateToCalendar(evaluation.getApprovedDate()), EmployeeDao.instance().getPrimaryEmail(emp), branch);
            pdf = PDFUtils.convertToSignedPDF(report, securityConfiguration.getKeyStoreName(), signature);
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
