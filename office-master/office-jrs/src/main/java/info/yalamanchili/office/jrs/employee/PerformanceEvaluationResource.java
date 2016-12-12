/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.employee;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.employee.PerformanceEvaluationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.employee.PerformanceEvaluationSaveDto;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.employee.perfeval.PerformanceEvaluationReportDto;
import info.yalamanchili.office.employee.perfeval.PerformanceEvaluationService;
import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/performance-evaluation")
@Component
@Transactional
@Scope("request")
public class PerformanceEvaluationResource extends CRUDResource<PerformanceEvaluation> {

    @Autowired
    public PerformanceEvaluationDao performanceEvaluationDao;
    @Autowired
    protected PerformanceEvaluationService performanceEvaluationService;

    @Override
    public CRUDDao getDao() {
        return performanceEvaluationDao;
    }

    @GET
    @Path("read/{employeeId}/{year}")
    public PerformanceEvaluation getPerformanceEvaluation(@PathParam("employeeId") Long employeeId, @PathParam("year") String year) {
        return PerformanceEvaluationService.instance().getEvaluationForYear(year, EmployeeDao.instance().findById(employeeId), null);
    }

    @PUT
    @Validate
    @Path("/save")
    public void createCorporateReview(@QueryParam("employeeId") Long employeeId, PerformanceEvaluationSaveDto dto, @QueryParam("submitForApproval") boolean submitForApproval) {
        Employee emp = null;
        if (employeeId != null) {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        if (emp == null) {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        if (OfficeSecurityService.instance().getUserRoles(emp).contains(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            PerformanceEvaluationService.instance().saveCorporatePerformanceEvaluation(emp, dto, submitForApproval);
        } else {
            PerformanceEvaluationService.instance().saveAssociateReview(emp, dto, submitForApproval);
        }

    }

    @GET
    @Path("/years")
    public List<Entry> getFYYears(@QueryParam("employeeId") Long employeeId) {
        Employee emp = null;
        if (employeeId != null) {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        if (emp == null) {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        return PerformanceEvaluationService.instance().getFYYears(emp);
    }

    @GET
    @Path("/comments/{id}")
    public List<QuestionComment> getQuestionComments(@PathParam("id") Long id, @QueryParam("category") QuestionCategory category, @QueryParam("context") QuestionContext context) {
        return PerformanceEvaluationService.instance().getQuestionComments(id, category, context);
    }

    @GET
    @Path("/{start}/{limit}")
    public PerformanceEvaluationTable table(@QueryParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = null;
        if (employeeId != null) {
            emp = EmployeeDao.instance().findById(employeeId);

        } else {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        PerformanceEvaluationDao.instance().acceccCheck(emp);
        PerformanceEvaluationTable tableObj = new PerformanceEvaluationTable();
        tableObj.setEntities(performanceEvaluationDao.getPerformanceEvaluationsForEmp(emp));
        tableObj.setSize(performanceEvaluationDao.size(emp));
        return tableObj;
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public void delete(@PathParam("id") Long id) {
        PerformanceEvaluationService.instance().delete(id);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id, @QueryParam("type") String type) {
        return PerformanceEvaluationService.instance().getReport(id, type);
    }

    @GET
    @Path("/performance-evaluation-report")
    public void employeeperformanceEvaluationReport(@QueryParam("year") String year) {
        List<PerformanceEvaluationReportDto> report = new ArrayList<>();
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        report = performanceEvaluationService.getPerformanceEvaluationReport(year);
        String[] columnOrder = new String[]{"employee", "evaluationFYYear", "startDate", "manager", "managerReviewStarted", "rating", "stage"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(report, " Performance-Evaluation-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), emp.getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/performance-evaluation-reportView")
    public List<PerformanceEvaluationReportDto> employeeperformanceEvaluationReportView(@QueryParam("year") String year) {
        return performanceEvaluationService.getPerformanceEvaluationReport(year);
    }

    @XmlRootElement
    @XmlType
    public static class PerformanceEvaluationTable implements java.io.Serializable {

        protected Long size;
        protected List<PerformanceEvaluation> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<PerformanceEvaluation> getEntities() {
            return entities;
        }

        public void setEntities(List<PerformanceEvaluation> entities) {
            this.entities = entities;
        }
    }
}
