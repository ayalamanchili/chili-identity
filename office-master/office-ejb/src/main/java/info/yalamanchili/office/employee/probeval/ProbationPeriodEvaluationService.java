/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.probeval;

import com.google.common.base.Strings;
import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.employee.ProbationPeriodEvaluationDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.ext.QuestionService;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<QuestionComment> getQuestionComments(Long id, QuestionCategory category, QuestionContext context) {
        return QuestionService.instance().getQuestionComments(id, category, context);
    }

    public Response getReport(Long id, String type) {
        if ("probation-period".equals(type)) {
            return generateProbationPeriodManagerReviewReport(id);
        }
        return null;
    }

    protected Response generateProbationPeriodManagerReviewReport(Long id) {
        ProbationPeriodEvaluation evaluation = probationPeriodEvaluationDao.findById(id);
        Employee employee = evaluation.getEmployee();
        probationPeriodEvaluationDao.acceccCheck(employee);
        OfficeServiceConfiguration serviceConfig = OfficeServiceConfiguration.instance();
        OfficeSecurityConfiguration securityConfig = OfficeSecurityConfiguration.instance();
        PdfDocumentData data = new PdfDocumentData();
        data.setKeyStoreName(securityConfig.getKeyStoreName());
        data.setTemplateUrl("/templates/pdf/probation-period-evaluation-template.pdf");
        data.getData().put("evaluationDate", new SimpleDateFormat("MM-dd-yyyy").format(evaluation.getEvaluationDate()));
        data.getData().put("employeeName", employee.getFirstName() + " " + employee.getLastName());
        data.getData().put("startDate", new SimpleDateFormat("MM-dd-yyyy").format(employee.getStartDate()));
        data.getData().put("managerName", employee.getFirstName() + " " + employee.getLastName());
        data.getData().put("jobTitle", employee.getJobTitle());
        Integer i = 1;
        for (QuestionComment qc : getQuestionComments(id, QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER, QuestionContext.PROBATION_PERIOD_EVALUATION)) {
            data.getData().put("probation.prd.eval.q" + i + "-question", qc.getQuestion());
            data.getData().put("probation.prd.eval.qc" + i + "-questionInfo", qc.getQuestionInfo());
            if (qc.getRating() != null) {
                data.getData().put("q.rating" + i + "q.rating", qc.getRating().toString());
            }

            i++;
        }

        data.getData().put("trainingRequirments", evaluation.getTrainingRequirments());
        data.getData().put("additionalComments", evaluation.getAdditionalComments());
        data.getData().put("hrNotes", evaluation.getHrNotes());


        EmployeeDao employeeDao = EmployeeDao.instance();
        //Manager 
        if (evaluation.getApprovedBy() != null) {
            Employee manager = employeeDao.findEmployeWithEmpId(evaluation.getApprovedBy());
            Signature approvedBysignature = new Signature(manager.getEmployeeId(), manager.getEmployeeId(), securityConfig.getKeyStorePassword(), true, "managerSignature", DateUtils.dateToCalendar(evaluation.getApprovedDate()), employeeDao.getPrimaryEmail(manager), null);
            data.getSignatures().add(approvedBysignature);
            data.getData().put("managerTitle", manager.getJobTitle());
            data.getData().put("managerName", manager.getFirstName() + " " + manager.getLastName());
        }
        //HR 
        if (evaluation.getHrApprovalBy() != null) {
            Employee hr = employeeDao.findEmployeWithEmpId(evaluation.getHrApprovalBy());
            Signature hrSignature = new Signature(hr.getEmployeeId(), hr.getEmployeeId(), securityConfig.getKeyStorePassword(), true, "hrSignature", DateUtils.dateToCalendar(evaluation.getApprovedDate()), employeeDao.getPrimaryEmail(hr), null);
            data.getSignatures().add(hrSignature);
            data.getData().put("hrTitle", hr.getJobTitle());
            data.getData().put("hrName", hr.getFirstName() + " " + hr.getLastName());
        }
        //Employee
        Signature employeeSignature = new Signature(employee.getEmployeeId(), employee.getEmployeeId(), securityConfig.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(evaluation.getEvaluationDate()), employeeDao.getPrimaryEmail(employee), null);
        data.getSignatures().add(employeeSignature);
        data.getData().put("employeeTitle", employee.getJobTitle());
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = manager-review.pdf")
                .header("Content-Length", pdf)
                .build();
    }
}
