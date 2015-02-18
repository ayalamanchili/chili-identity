/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.employee;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.employee.ProbationPeriodEvaluationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.employee.probeval.ProbationPeriodEvaluationDto;
import info.yalamanchili.office.employee.probeval.ProbationPeriodEvaluationService;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
        probationPeriodEvaluationService.initiateProbationPeriodEvaluationReview(employeeId);
    }
    
    @PUT
    @Path("/save")
    public void initiateReview(ProbationPeriodEvaluationDto dto) {
        probationPeriodEvaluationService.save(dto);
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
        ProbationPeriodEvaluationTable tableObj = new ProbationPeriodEvaluationTable();
        tableObj.setEntities(ProbationPeriodEvaluationDao.instance().getEvaluations(emp));
        tableObj.setSize(1l);
        return tableObj;
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
    public CRUDDao getDao() {
        return null;
    }
}
