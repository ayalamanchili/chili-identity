/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.employee;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.employee.StatusReportDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.employee.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.employee.StatusReportService;
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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/statusreport")
@Component
@Transactional
@Scope("request")
public class StatusReportResource extends CRUDResource<StatusReport> {

    @Autowired
    public StatusReportDao employeeReportDao;

    @Override
    public CRUDDao getDao() {
        return employeeReportDao;
    }

    @PUT
    @Path("/save")
    public StatusReport saveReport(StatusReport entity, @QueryParam("submitForApproval") Boolean submitForApproval) {
        return StatusReportService.instance().save(entity, submitForApproval);
    }

    @GET
    @Path("/projects/dropdown/{id}/")
    @Transactional
    public List<Entry> getDropDown(@PathParam("id") Long statusReportId) {
        StatusReport report = employeeReportDao.findById(statusReportId);
        List<Entry> result = new ArrayList<Entry>();
        List<Project> results = report.getClientInformation().getClient().getProjects();
        for (Project project : results) {
            result.add(new Entry(project.getId().toString(), project.getName()));
        }
        return result;
    }

    @GET
    @Path("/{start}/{limit}")
    public EmployeeReportTable reportsForEmployee(@QueryParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = null;
        if (employeeId == null) {
            emp = OfficeSecurityService.instance().getCurrentUser();
        } else {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        EmployeeReportTable tableObj = new EmployeeReportTable();
        tableObj.setEntities(employeeReportDao.getReports(emp, start, limit));
        tableObj.setSize(employeeReportDao.getReportsSize(emp, start, limit));
        return tableObj;
    }

    //TODO move to abstract resource
    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return StatusReportService.instance().getReport(id);
    }

    @XmlRootElement
    @XmlType
    public static class EmployeeReportTable implements java.io.Serializable {

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
