/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.employee;

import com.google.gson.Gson;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.employee.statusreport.StatusReportDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.statusreport.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.employee.statusreport.StatusReportService;
import info.yalamanchili.office.entity.employee.statusreport.ReportDocument;
import info.yalamanchili.office.security.AccessCheck;
import java.util.List;
import javax.ws.rs.Consumes;
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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/statusreport")
@Component
@Produces("application/json")
@Consumes("application/json")
@Transactional
@Scope("request")
public class StatusReportResource extends CRUDResource<StatusReport> {

    @Autowired
    public StatusReportDao statusReportDao;

    @Override
    public CRUDDao getDao() {
        return statusReportDao;
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    @AccessCheck(roles = {"ROLE_H1B_IMMIGRATION", "ROLE_IT_DEVELOPER", "ROLE_RELATIONSHIP"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public StatusReport read(@PathParam("id") Long id) {
        return StatusReportService.instance().read(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        StatusReportService.instance().delete(id);
    }

    @PUT
    @Validate
    @Path("/save")
    @Produces("application/text")
    public String saveReport(StatusReport entity, @QueryParam("submitForApproval") Boolean submitForApproval) {
        return StatusReportService.instance().save(entity, submitForApproval);
    }

    @GET
    @Path("/clone/{id}")
    @Override
    public StatusReport clone(@PathParam("id") Long id) {
        StatusReport entity = statusReportDao.clone(id);
        entity.setReportDocument(new Gson().fromJson(entity.getReport(), ReportDocument.class));
        entity.setApprovedBy(null);
        entity.setApprovedDate(null);
        entity.setBpmProcessId(null);
        entity.setSubmittedDate(null);
        entity.setStage(null);
        return entity;
    }

    @GET
    @Path("/{start}/{limit}")
    public StatusReportTable reportsForEmployee(@QueryParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = null;
        if (employeeId == null) {
            emp = OfficeSecurityService.instance().getCurrentUser();
        } else {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        StatusReportTable tableObj = new StatusReportTable();
        tableObj.setEntities(statusReportDao.getReports(emp, start, limit));
        tableObj.setSize(statusReportDao.getReportsSize(emp, start, limit));
        return tableObj;
    }

    //TODO move to abstract resource
    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return StatusReportService.instance().getReport(statusReportDao.findById(id));
    }

    @XmlRootElement
    @XmlType
    public static class StatusReportTable implements java.io.Serializable {

        protected Long size;
        protected List<StatusReport> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<StatusReport> getEntities() {
            return entities;
        }

        public void setEntities(List<StatusReport> entities) {
            this.entities = entities;
        }
    }
}
