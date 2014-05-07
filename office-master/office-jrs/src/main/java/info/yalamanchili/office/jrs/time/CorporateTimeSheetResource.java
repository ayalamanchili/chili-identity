/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.Time.CorporateTimeService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao.CorporateTimeSheetTable;
import info.yalamanchili.office.dao.time.SearchCorporateTimeSheetDto;
import info.yalamanchili.office.dto.time.CorporateTimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/corporate-timesheet")
@Component
@Transactional
@Scope("request")
public class CorporateTimeSheetResource extends CRUDResource<CorporateTimeSheet> {

    @GET
    @Path("/summary")
    public CorporateTimeSummary getCorporateTimeSummary() {
        return CorporateTimeService.instance().getYearlySummary(SecurityService.instance().getCurrentUser());
    }

    @GET
    @Path("/current-leaves")
    public List<CorporateTimeSheet> currentLeaves() {
        return corporateTimeSheetDao.getCurrentCompanyLeaves();
    }

    @GET
    @Path("/summary/{empId}")
    public CorporateTimeSummary getCorporateTimeSummary(@PathParam("empId") Long empId) {
        Employee emp = EmployeeDao.instance().findById(empId);
        CorporateTimeService.instance().checkAccessToEmployeeTime(emp);
        return CorporateTimeService.instance().getYearlySummary(emp);
    }

    @PUT
    @Path("/submit-leave-request")
    public void submitLeaveRequest(CorporateTimeSheet entity) {
        CorporateTimeService.instance().submitLeaveRequest(entity);
    }

    @PUT
    @Path("/update-leave-request")
    public void updateLeaveRequest(CorporateTimeSheet entity) {
        CorporateTimeService.instance().updateLeaveRequest(entity);
    }

    @GET
    @Path("/cancel-leave-request/{timesheetId}")
    public void cancelLeaveRequest(@PathParam("timesheetId") Long timesheetId) {
        CorporateTimeService.instance().cancelLeaveRequest(timesheetId);
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION')")
    public CorporateTimeSheet save(CorporateTimeSheet entity) {
        if (entity.getId() == null) {
            Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
            entity.setEmployee(emp);
        }
        return super.save(entity);
    }

    @Override
    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION')")
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @Autowired
    public CorporateTimeSheetDao corporateTimeSheetDao;

    @Override
    public CRUDDao getDao() {
        return corporateTimeSheetDao;
    }

    @GET
    @Path("/employee/{empId}/{start}/{limit}")
    public CorporateTimeSheetTable getCorporateTimeSheet(@PathParam("empId") Long empId, @QueryParam("status") TimeSheetStatus status, @QueryParam("category") TimeSheetCategory category, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = EmployeeDao.instance().findById(empId);
        CorporateTimeService.instance().checkAccessToEmployeeTime(emp);
        return getCorporateTimeSheets(emp, status, category, start, limit);
    }

    @GET
    @Path("/currentuser/{start}/{limit}")
    public CorporateTimeSheetTable getCorporateTimeSheet(@QueryParam("status") TimeSheetStatus status, @QueryParam("category") TimeSheetCategory category, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = SecurityService.instance().getCurrentUser();
        return getCorporateTimeSheets(emp, status, category, start, limit);
    }

    @PUT
    @Path("/report/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION','ROLE_CORPORATE_TIME_REPORTS')")
    public List<CorporateTimeSheet> getReport(SearchCorporateTimeSheetDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return corporateTimeSheetDao.getReport(dto, start, limit);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return CorporateTimeService.instance().getReport(id);
    }

    @GET
    @Path("/all-emp-summary-report")
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION','ROLE_CORPORATE_TIME_REPORTS')")
    public Response getAllEmployeesSummaryReport() {
        return CorporateTimeService.instance().getAllEmployeesSummaryReport();
    }

    protected CorporateTimeSheetTable getCorporateTimeSheets(Employee employee, TimeSheetStatus status, TimeSheetCategory category, int start, int limit) {
        CorporateTimeSheetTable tableObj = new CorporateTimeSheetTable();
        tableObj.setEntities(corporateTimeSheetDao.getTimeSheetsEmployee(employee, status, category, start, limit));
        tableObj.setSize(corporateTimeSheetDao.getTimeSheetsSizeForEmployee(employee, status, category));
        return tableObj;
    }

}
