/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.probeval;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.reporting.ReportGenerator;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.chili.bpm.types.Task;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.employee.ProbationPeriodEvaluationDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.ext.QuestionService;
import info.yalamanchili.office.jms.MessagingService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("request")
public class ProbationPeriodEvaluationService {

    @Autowired
    protected ProbationPeriodEvaluationDao probationPeriodEvaluationDao;
    @Autowired
    protected Mapper mapper;

    public void save(ProbationPeriodEvaluationDto dto) {
        ProbationPeriodEvaluation entity = probationPeriodEvaluationDao.findById(dto.getEvaluation().getId());
        entity.setTrainingRequirments(dto.getEvaluation().getTrainingRequirments());
        entity.setAdditionalComments((dto.getEvaluation().getAdditionalComments()));
        entity.setHrNotes(dto.getEvaluation().getHrNotes());
        if (dto.getEvaluation().getActive() != null) {
            entity.setActive(dto.getEvaluation().getActive());
        }
        entity = probationPeriodEvaluationDao.save(entity);
        if (dto.getComments() != null) {
            createQuestionComments(entity, dto.getComments());
        }
    }

    public void delete(Long id) {
        ProbationPeriodEvaluation ticket = probationPeriodEvaluationDao.findById(id);
        Task task = getTaskForTicket(ticket);
        if (task != null) {
            OfficeBPMTaskService.instance().deleteTask(task.getId());
        }
        probationPeriodEvaluationDao.delete(id);
    }

    //TODO move to commons
    protected Task getTaskForTicket(ProbationPeriodEvaluation evaluation) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(evaluation.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
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
        return QuestionService.instance().getQuestionCommentsForProbationPeriodEvaluations(id, category, context);
    }

    public Response getReport(Long id, String type) {
        ProbationPeriodEvaluation evaluation = probationPeriodEvaluationDao.findById(id);
        Employee employee = evaluation.getEmployee();
        probationPeriodEvaluationDao.acceccCheck(employee);
        OfficeServiceConfiguration serviceConfig = OfficeServiceConfiguration.instance();
        OfficeSecurityConfiguration securityConfig = OfficeSecurityConfiguration.instance();
        PdfDocumentData data = new PdfDocumentData();
        data.setKeyStoreName(securityConfig.getKeyStoreName());
        data.setTemplateUrl("/templates/pdf/probation-period-evaluation-template.pdf");
        if (evaluation.getEvaluationDate() != null) {
            data.getData().put("evaluationDate", new SimpleDateFormat("MM-dd-yyyy").format(evaluation.getEvaluationDate()));
        }
        data.getData().put("employeeName", employee.getFirstName() + " " + employee.getLastName());
        data.getData().put("startDate", new SimpleDateFormat("MM-dd-yyyy").format(employee.getStartDate()));
        data.getData().put("jobTitle", employee.getJobTitle());
        Integer i = 1;
        for (QuestionComment qc : getQuestionComments(id, QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER, QuestionContext.PROBATION_PERIOD_EVALUATION)) {
            data.getData().put("probation.prd.eval.q" + i, qc.getQuestion());
            data.getData().put("probation.prd.eval.qc" + i, qc.getQuestionInfo());
            if (qc.getRating() != null) {
                data.getData().put("q" + i + ".rating", qc.getRating().toString());
            } else {
                data.getData().put("q" + i + ".rating", "n/a");
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
            if (manager != null) {
                Signature approvedBysignature = new Signature(manager.getEmployeeId(), manager.getEmployeeId(), securityConfig.getKeyStorePassword(), true, "managerSignature", DateUtils.dateToCalendar(evaluation.getApprovedDate()), employeeDao.getPrimaryEmail(manager), null);
                data.getSignatures().add(approvedBysignature);
                //TODO is this needed?
                data.getData().put("managerTitle", manager.getJobTitle());
                data.getData().put("manageName", manager.getFirstName() + " " + manager.getLastName());
            }
        }
        //HR 
        if (evaluation.getHrApprovalBy() != null) {
            Employee hr = employeeDao.findEmployeWithEmpId(evaluation.getHrApprovalBy());
            if (hr != null) {
                Signature hrSignature = new Signature(hr.getEmployeeId(), hr.getEmployeeId(), securityConfig.getKeyStorePassword(), true, "hrSignature", DateUtils.dateToCalendar(evaluation.getApprovedDate()), employeeDao.getPrimaryEmail(hr), null);
                data.getSignatures().add(hrSignature);
                //TODO is this needed?
                data.getData().put("hrTitle", hr.getJobTitle());
                data.getData().put("hrName", hr.getFirstName() + " " + hr.getLastName());
            }
        }
        //Employee
        if (evaluation.getAcceptDate() != null) {
            Signature employeeSignature = new Signature(employee.getEmployeeId(), employee.getEmployeeId(), securityConfig.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(evaluation.getEvaluationDate()), employeeDao.getPrimaryEmail(employee), null);
            data.getSignatures().add(employeeSignature);
        }
        String empCompanyLogo = "";
        if (employee.getCompany() != null) {
            empCompanyLogo = employee.getCompany().getLogoURL().replace("entityId", employee.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);

        return Response.ok(pdf)
                .header("content-disposition", "filename = probation-period-evaluation.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    @Async
    @Transactional
    public void getgenerateEmployeProbationPeriodEvalInfoReport(String email, String year) {
        List<ProbationPeriodEvaluationReportDto> res = new ArrayList<ProbationPeriodEvaluationReportDto>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE)) {
            ProbationPeriodEvaluationReportDto dto = mapper.map(emp, ProbationPeriodEvaluationReportDto.class);
            List<ProbationPeriodEvaluation> evaluation = probationPeriodEvaluationDao.getEvaluations(emp);
            if (evaluation.size() > 0) {
                for (ProbationPeriodEvaluation eval : evaluation) {
                    ProbationPeriodEvaluationReportDto dtos = new ProbationPeriodEvaluationReportDto();
                    setEmployee(emp, dtos);
                    dtos.setStage(eval.getStage().name());
                    if (eval.getActive()) {
                        dtos.setActive("Yes");
                    } else {
                        dtos.setActive("No");
                    }
                    res.add(dtos);
                }
            } else {
                setEmployee(emp, dto);
                dto.setStage("Probation is not initiated");
                dto.setActive("Probation is not initiated");
                res.add(dto);
            }
        }
        String[] columnOrder = new String[]{"employee", "startDate", "email", "stage", "active"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Probation-Period-Evaluation-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    protected void setEmployee(Employee emp, ProbationPeriodEvaluationReportDto dto) {
        dto.setEmployee(emp.getFirstName() + " " + emp.getLastName());
        dto.setEmail(EmployeeDao.instance().getPrimaryEmail(emp));
        dto.setStartDate(emp.getStartDate());
    }

    public static ProbationPeriodEvaluationService instance() {
        return SpringContext.getBean(ProbationPeriodEvaluationService.class);
    }

}
