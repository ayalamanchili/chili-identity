/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.client.ContractReportService;
import info.yalamanchili.office.dao.profile.EmployeeDao.EmployeeTable;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dao.profile.EmployeeLocationDto;
import info.yalamanchili.office.dao.profile.EmployeeLocationReportDto;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/contract-report")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
@Transactional(readOnly = true)
public class ContractReportResource {

    @Autowired
    protected Mapper mapper;
    @PersistenceContext
    protected EntityManager em;

    @PUT
    @Path("/search-emp-between-days/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_FULL_VIEW')")
    public EmployeeTable employeeJoinedOrLeftSearch(@PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate, @QueryParam("value") String value) {
        return ContractReportService.instance().empJoinedLeftInAPeriod(start, limit, startDate, endDate, value);
    }

    @GET
    @Path("/search-emp-between-days-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_FULL_VIEW')")
    public void employeeJoinedOrLeftReport(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate, @QueryParam("value") String value) {
        String email = currentEmpEmail();
        ContractReportService.instance().empJoinedLeftInAPeriodReport(0, 10000, startDate, endDate, value, email);
    }

    @PUT
    @Path("/multiple-cpds")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_FULL_VIEW')")
    public ContractTable getMultipleCpds() {
        List<ContractDto> dtos = ContractReportService.instance().getMultipleCpds();
        ContractDto.ContractTable resultTable = new ContractDto.ContractTable();
        if (dtos != null && dtos.size() > 0) {
            resultTable.setEntities(dtos);
        }
        return resultTable;
    }

    @GET
    @Path("/multiple-cpds-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_FULL_VIEW')")
    public void multipleCPDsReport() {
        String email = currentEmpEmail();
        ContractReportService.instance().multipleCPDsReport(email);
    }

    @PUT
    @Path("/emp-location-search/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_FULL_VIEW')")
    public List<ContractDto> empLocationSearch(EmployeeLocationDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return ContractReportService.instance().getEmpsInLocation(dto, start, limit);
    }

    @PUT
    @Path("/emp-location-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_FULL_VIEW')")
    public void empLocationReport(EmployeeLocationDto dto) {
        String email = currentEmpEmail();
        ContractReportService.instance().getEmpsLocationReport(dto, email);
    }

    @PUT
    @Path("/emp-address")
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION')")
    public List<EmployeeLocationReportDto> searchEmpByAddress(EmployeeLocationDto dto) {
        return ContractReportService.instance().searchEmpsByAddress(dto);
    }

    @PUT
    @Path("/emp-address-report")
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION')")
    public void getEmpAddressReport(EmployeeLocationDto dto) {
        String email = currentEmpEmail();
        ContractReportService.instance().getEmpsByAddressReport(dto, email);
    }

    @PUT
    @Path("/search-projects-between-days/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_FULL_VIEW')")
    public ContractTable getCpdsBWDates(@PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate, @QueryParam("value") String value, @QueryParam("employeeType") String employeeType) {
        return ContractReportService.instance().searchProjsBWDates(start, limit, startDate, endDate, value, employeeType);
    }

    @GET
    @Path("/search-projects-between-days-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_FULL_VIEW')")
    public void getCpdsBWDatesReport(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate, @QueryParam("value") String value, @QueryParam("employeeType") String employeeType) {
        String email = currentEmpEmail();
        ContractReportService.instance().searchProjsBWDatesReport(startDate, endDate, value, employeeType, email);
    }

    @GET
    @Path("/subcontractors-summary-report")
    public void subContractorSummaryReport() {
        String email = currentEmpEmail();
        ContractReportService.instance().subContractorSummaryReport(email);
    }

    @GET
    @Path("/active-employees-projects-forecast-report")
    public void getActiveEmployeesProjectForecastReport() {
        String email = currentEmpEmail();
        ContractReportService.instance().activeEmployeesRevenueForcastReport(email);
    }

    @GET
    @Path("/all-employees-projects-forecast-report")
    public void getAllActiveProjectsReport() {
        String email = currentEmpEmail();
        ContractReportService.instance().allActiveProjectsRevenueForcastReport(email);
    }
    
    @GET
    @Path("/all-payrate-summary-report")
    public void getAllPayRateSummaryReport() {
        String email = currentEmpEmail();
        ContractReportService.instance().allPayRateSummaryReport(email);
    }

    private String currentEmpEmail() {
        return OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail();
    }
}
