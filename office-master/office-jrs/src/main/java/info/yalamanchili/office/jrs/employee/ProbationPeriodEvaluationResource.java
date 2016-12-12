/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.employee;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.employee.ProbationPeriodEvaluationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.employee.probeval.ProbationPeriodEvaluationDto;
import info.yalamanchili.office.employee.probeval.ProbationPeriodEvaluationInitiator;
import info.yalamanchili.office.employee.probeval.ProbationPeriodEvaluationService;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
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
@Path("secured/probation-period-evaluation")
@Component
@Transactional
@Scope("request")
public class ProbationPeriodEvaluationResource extends CRUDResource<ProbationPeriodEvaluation> {

    @Autowired
    protected ProbationPeriodEvaluationService probationPeriodEvaluationService;

    @GET
    @Path("/initiate-review/{employeeId}")
    public void initiateReview(@PathParam("employeeId") Long employeeId) {
        ProbationPeriodEvaluationInitiator.instance().initiateProbationPeriodEvaluationReview(employeeId);
    }

    @PUT
    @Path("/save")
    public void save(ProbationPeriodEvaluationDto dto) {
        probationPeriodEvaluationService.save(dto);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public void delete(@PathParam("id") Long id) {
        probationPeriodEvaluationService.delete(id);
    }

    @GET
    @Path("/{start}/{limit}")
    public ProbationPeriodEvaluationResource.ProbationPeriodEvaluationTable reportsForEmployee(@QueryParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = null;
        if (employeeId == null) {
            emp = OfficeSecurityService.instance().getCurrentUser();
        } else {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        getDao().acceccCheck(emp);
        ProbationPeriodEvaluationTable tableObj = new ProbationPeriodEvaluationTable();
        tableObj.setEntities(getDao().getEvaluations(emp));
        tableObj.setSize(new Long(getDao().getEvaluations(emp).size()));
        return tableObj;
    }

    @GET
    @Path("/comments/{id}")
    public List<QuestionComment> getQuestionComments(@PathParam("id") Long id, @QueryParam("category") QuestionCategory category, @QueryParam("context") QuestionContext context) {
        return probationPeriodEvaluationService.instance().getQuestionComments(id, category, context);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id, @QueryParam("type") String type) {
        return ProbationPeriodEvaluationService.instance().getReport(id, type);
    }

    @GET
    @Path("/probation-period-evaluation-report")
    public void employeeprobperformanceEvaluationReport(@QueryParam("year") String year) {
        probationPeriodEvaluationService.getgenerateEmployeProbationPeriodEvalInfoReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), year);

    }

    @XmlRootElement
    @XmlType
    public static class ProbationPeriodEvaluationTable implements java.io.Serializable {

        protected Long size;
        protected List<ProbationPeriodEvaluation> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ProbationPeriodEvaluation> getEntities() {
            return entities;
        }

        public void setEntities(List<ProbationPeriodEvaluation> entities) {
            this.entities = entities;
        }
    }

    @Override
    public ProbationPeriodEvaluationDao getDao() {
        return SpringContext.getBean(ProbationPeriodEvaluationDao.class);
    }
}
