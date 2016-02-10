/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.reports;

import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.employee.statusreport.CorporateStatusReportDao;
import info.yalamanchili.office.dao.employee.statusreport.CorporateStatusReportDao.CorporateStatusReportSearchDto;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.TimePeriodDao;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.employee.statusreport.CorporateStatusReportService;
import info.yalamanchili.office.model.time.TimePeriod;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author benerji.v
 */
@Path("secured/corporate-statusreport")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
@Transactional
public class CorporateStatusReportResource {

    @Autowired
    protected CorporateStatusReportService corporateStatusReportService;
    @Autowired
    protected CorporateStatusReportDao corporateStatusReportDao;

    @GET
    @Path("/{id}")
    public CorporateStatusReport get(@PathParam("id") Long id) {
        return corporateStatusReportDao.findById(id);
    }

    @GET
    @Path("/clone/{id}")
    public CorporateStatusReport clone(@PathParam("id") Long id) {
        CorporateStatusReport entity = corporateStatusReportDao.clone(id);
        entity.setApprovedBy(null);
        entity.setApprovedDate(null);
        entity.setBpmProcessId(null);
        entity.setSubmittedDate(null);
        entity.setReportStartDate(null);
        entity.setReportEndDate(null);
        entity.setStatus(null);
        return entity;
    }

    @Path("/diff/{reportId}")
    @Produces(MediaType.TEXT_HTML)
    @GET
    public String diff(@PathParam("reportId") Long reportId) {
        return corporateStatusReportService.diff(reportId);
    }

    @PUT
    @Validate
    public void save(CorporateStatusReport entity, @QueryParam("submitForApproval") Boolean submitForApproval) {
        TimePeriod statusReportPeriod = TimePeriodDao.instance().fineOne(entity.getStatusReportPeriod().getId());
        entity.setReportStartDate(statusReportPeriod.getStartDate());
        entity.setReportEndDate(statusReportPeriod.getEndDate());
        corporateStatusReportService.save(entity, submitForApproval);
    }

    @PUT
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        corporateStatusReportService.delete(id);
    }

    @GET
    @Path("/{start}/{limit}")
    public CorpoateStatusReportTable reportsForEmployee(@QueryParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = null;
        if (employeeId != null) {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        if (emp == null) {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        CorpoateStatusReportTable tableObj = new CorpoateStatusReportTable();
        tableObj.setEntities(corporateStatusReportDao.getReports(emp, start, limit));
        tableObj.setSize(corporateStatusReportDao.getReportsSize(emp, start, limit));
        return tableObj;
    }

    @PUT
    @Path("/search")
    public List<CorporateStatusReport> search(CorporateStatusReportSearchDto dto) {
        return corporateStatusReportDao.search(dto);
    }

    @PUT
    @Path("/not-submitted-reminder")
    public void notSubmittedRemainder(CorporateStatusReportSearchDto dto) {
        corporateStatusReportDao.notSubmittedEmailNotification(dto);
    }

    @XmlRootElement
    @XmlType
    public static class CorpoateStatusReportTable implements java.io.Serializable {

        protected Long size;
        protected List<CorporateStatusReport> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<CorporateStatusReport> getEntities() {
            return entities;
        }

        public void setEntities(List<CorporateStatusReport> entities) {
            this.entities = entities;
        }
    }
}
