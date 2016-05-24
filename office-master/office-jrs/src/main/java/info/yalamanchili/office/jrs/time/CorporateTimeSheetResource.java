/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.Time.CorporateTimeService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao.CorporateTimeSheetTable;
import info.yalamanchili.office.dao.time.SearchCorporateTimeSheetDto;
import info.yalamanchili.office.dto.time.CorporateTimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.security.AccessCheck;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    @AccessCheck(companyContacts = {"Reports_To", "Perf_Eval_Manager"}, roles = {"ROLE_ADMIN", "ROLE_CEO", "ROLE_CORPORATE_TIME__ADMIN", "ROLE_PAYROLL_AND_BENIFITS", "ROLE_CORPORATE_TIME_REPORTS"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public CorporateTimeSheet read(@PathParam("id") Long id) {
        return corporateTimeSheetDao.findById(id);
    }

    @GET
    @Path("/summary")
    public CorporateTimeSummary getCorporateTimeSummary() {
        return CorporateTimeService.instance().getYearlySummary(OfficeSecurityService.instance().getCurrentUser());
    }

    @GET
    @Path("/current-leaves")
    public List<CorporateTimeSheet> currentLeaves() {
        return corporateTimeSheetDao.getCurrentCompanyLeaves();
    }

    @GET
    @Path("/summary/{empId}")
    @AccessCheck(companyContacts = {"Reports_To"}, roles = {"ROLE_CORPORATE_TIME_ADMIN", "ROLE_CORPORATE_TIME_REPORTS"})
    public CorporateTimeSummary getCorporateTimeSummary(@PathParam("empId") Long empId) {
        Employee emp = EmployeeDao.instance().findById(empId);
        return CorporateTimeService.instance().getYearlySummary(emp);
    }

    @PUT
    @Validate
    @Path("/submit-leave-request")
    public void submitLeaveRequest(CorporateTimeSheet entity) {
        CorporateTimeService.instance().submitLeaveRequest(entity);
    }
    @PUT
    @Validate
    @Path("/category-leave-update-request")
    public void categoryLeaveRequest(CorporateTimeSheet entity) {
        CorporateTimeService.instance().categoryLeaveUpdateRequest(entity);
    }

    @PUT
    @Validate
    @Path("/update-leave-request")
    public void updateLeaveRequest(CorporateTimeSheet entity) {
        CorporateTimeService.instance().updateLeaveRequest(entity);
    }

    @GET
    @Path("/cancel-leave-request/{timesheetId}")
    public void cancelLeaveRequest(@PathParam("timesheetId") Long timesheetId, @QueryParam("cancelReason") String cancelReason) {
        CorporateTimeService.instance().cancelLeaveRequest(timesheetId, cancelReason);
    }

    @Override
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_CORPORATE_TIME_ADMIN')")
    public CorporateTimeSheet save(CorporateTimeSheet entity) {
        if (entity.getId() == null) {
            Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
            entity.setEmployee(emp);
        }
        return super.save(entity);
    }

    @Validate
    @Path("/adjust-hours")
    @PreAuthorize("hasAnyRole('ROLE_CORPORATE_TIME_ADMIN')")
    @PUT
    public void adjustPTOAccruedHours(CorporateTimeSheet entity, @QueryParam("adjustmentHours") BigDecimal adjustmentHours, @QueryParam("adjustmentReason") String adjustmentReason) {
        entity = corporateTimeSheetDao.findById(entity.getId());
        corporateTimeSheetDao.adjustPTODAccruedHours(entity, adjustmentHours, adjustmentReason);
    }

    @Override
    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_CORPORATE_TIME_ADMIN')")
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
    @AccessCheck(companyContacts = {"Reports_To"}, roles = {"ROLE_CORPORATE_TIME_ADMIN", "ROLE_CORPORATE_TIME_REPORTS"})
    public CorporateTimeSheetTable getCorporateTimeSheet(@PathParam("empId") Long empId, @QueryParam("status") TimeSheetStatus status, @QueryParam("category") TimeSheetCategory category, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = EmployeeDao.instance().findById(empId);
        if (category != null && TimeSheetCategory.Regular.equals(category)) {
            return getCorporateTimeSheets(emp, status, category, start, limit);
        } else {
            return getCorporateTimeSheets(emp, status, category, start, limit);
        }
    }

    @GET
    @Path("/currentuser/{start}/{limit}")
    public CorporateTimeSheetTable getCorporateTimeSheet(@QueryParam("status") TimeSheetStatus status, @QueryParam("category") TimeSheetCategory category, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        return getCorporateTimeSheets(emp, status, category, start, limit);
    }

    @PUT
    @Path("/report/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_CORPORATE_TIME_ADMIN','ROLE_CORPORATE_TIME_REPORTS')")
    @Validate
    public List<CorporateTimeSheet> getReport(SearchCorporateTimeSheetDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return corporateTimeSheetDao.getReport(dto, start, limit);
    }

    @POST
    @Path("/report")
    @Produces({"application/pdf"})
    @PreAuthorize("hasAnyRole('ROLE_RELATIONSHIP','ROLE_PAYROLL_AND_BENIFITS','ROLE_CORPORATE_TIME_REPORTS')")
    public Response getPDFReport(SearchCorporateTimeSheetDto dto) {
        return corporateTimeSheetDao.getPDFReport(dto);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return CorporateTimeService.instance().getReport(corporateTimeSheetDao.findById(id));
    }

    @GET
    @Path("/all-emp-summary-report")
    @PreAuthorize("hasAnyRole('ROLE_CORPORATE_TIME_ADMIN','ROLE_CORPORATE_TIME_REPORTS')")
    public void getAllEmployeesSummaryReport() {
        CorporateTimeService.instance().getAllEmployeesSummaryReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    protected CorporateTimeSheetTable getCorporateTimeSheets(Employee employee, TimeSheetStatus status, TimeSheetCategory category, int start, int limit) {
        CorporateTimeSheetTable tableObj = new CorporateTimeSheetTable();
        tableObj.setEntities(corporateTimeSheetDao.getTimeSheetsEmployee(employee, status, category, start, limit));
        tableObj.setSize(corporateTimeSheetDao.getTimeSheetsSizeForEmployee(employee, status, category));
        return tableObj;
    }
}
