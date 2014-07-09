/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.Time.ConsultantTimeService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.dao.time.SearchConsultantTimeSheetDto;
import info.yalamanchili.office.dto.time.ConsultantTimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
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
 * @author ayalamanchili
 */
@Path("secured/consultant-timesheet")
@Component
@Transactional
@Scope("request")
public class ConsultantTimeSheetResource extends CRUDResource<ConsultantTimeSheet> {

    @GET
    @Path("/summary")
    public ConsultantTimeSummary getConsultantTimeSummary() {
        return ConsultantTimeService.instance().getYearlySummary(SecurityService.instance().getCurrentUser());
    }
    @GET
    @Path("/summary/{empId}")
    public ConsultantTimeSummary getConsultantTimeSummary(@PathParam("empId") Long empId) {
        Employee emp = EmployeeDao.instance().findById(empId);
        return ConsultantTimeService.instance().getYearlySummary(emp);
    }
    @PUT
    @Path("/submit-leave-request")
    public void submitLeaveRequest(ConsultantTimeSheet request) {
        ConsultantTimeService.instance().submitLeaveRequest(request);
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_RELATIONSHIP','ROLE_PAYROLL_AND_BENIFITS')")
    public ConsultantTimeSheet save(ConsultantTimeSheet entity) {
        if (entity.getId() == null) {
            Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
            entity.setEmployee(emp);
        }
        return super.save(entity);
    }

    @GET
    @Path("/current-leaves")
    public List<ConsultantTimeSheet> currentLeaves() {
        return consultantTimeSheetDao.getCurrentCompanyLeaves();
    }

    @PUT
    @Path("/update-leave-request")
    public void updateLeaveRequest(ConsultantTimeSheet entity) {
        ConsultantTimeService.instance().updateLeaveRequest(entity);
    }

    @GET
    @Path("/cancel-leave-request/{timesheetId}")
    public void cancelLeaveRequest(@PathParam("timesheetId") Long timesheetId, @QueryParam("cancelReason") String cancelReason) {
        ConsultantTimeService.instance().cancelLeaveRequest(timesheetId, cancelReason);
    }

    @Override
    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_RELATIONSHIP','ROLE_PAYROLL_AND_BENIFITS')")
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/employee/{empId}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_RELATIONSHIP','ROLE_PAYROLL_AND_BENIFITS','ROLE_CONSULTANT_TIME_REPORTS')")
    public ConsultantTimeSheetTable getConsultantTimeSheet(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("status") TimeSheetStatus status, @QueryParam("category") TimeSheetCategory category) {
        Employee emp = EmployeeDao.instance().findById(empId);
        return getConsultantTimeSheets(emp, status, category, start, limit);
    }

    @GET
    @Path("/currentuser/{start}/{limit}")
    public ConsultantTimeSheetTable getConsultantTimeSheet(@PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("status") TimeSheetStatus status, @QueryParam("category") TimeSheetCategory category) {
        Employee emp = SecurityService.instance().getCurrentUser();
        return getConsultantTimeSheets(emp, status, category, start, limit);
    }

    protected ConsultantTimeSheetTable getConsultantTimeSheets(Employee employee, TimeSheetStatus status, TimeSheetCategory category, int start, int limit) {
        ConsultantTimeSheetTable tableObj = new ConsultantTimeSheetTable();
        tableObj.setEntities(consultantTimeSheetDao.getTimeSheetsEmployee(employee, category, status, start, limit));
        tableObj.setSize(consultantTimeSheetDao.getTimeSheetsSizeForEmployee(employee, status, category));
        return tableObj;
    }

    @GET
    @Path("/all-cons-summary-report")
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION','ROLE_CONSULTANT_TIME_REPORTS')")
    public Response getAllEmployeesSummaryReport() {
        return ConsultantTimeService.instance().getAllConsultantEmployeesSummaryReport();
    }

    @PUT
    @Path("/report/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_RELATIONSHIP','ROLE_PAYROLL_AND_BENIFITS','ROLE_CONSULTANT_TIME_REPORTS')")
    public List<ConsultantTimeSheet> getReport(SearchConsultantTimeSheetDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return consultantTimeSheetDao.getReport(dto, start, limit);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return ConsultantTimeService.instance().getReport(id);
    }
    @Autowired
    public ConsultantTimeSheetDao consultantTimeSheetDao;

    @Override
    public CRUDDao getDao() {
        return consultantTimeSheetDao;
    }

    @XmlRootElement
    @XmlType
    public static class ConsultantTimeSheetTable implements java.io.Serializable {

        protected Long size;
        protected List<ConsultantTimeSheet> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ConsultantTimeSheet> getEntities() {
            return entities;
        }

        public void setEntities(List<ConsultantTimeSheet> entities) {
            this.entities = entities;
        }
    }
}
