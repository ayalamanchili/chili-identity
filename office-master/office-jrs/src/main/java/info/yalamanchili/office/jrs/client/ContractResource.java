/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import com.google.common.base.Strings;
import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.client.ContractService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dto.client.ContractSearchDto;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.profile.EmployeeLocationDto;
import info.yalamanchili.office.jrs.profile.EmployeeLocationReportDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/contract")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
@Transactional(readOnly = true)
public class ContractResource {
    
    @Autowired
    protected Mapper mapper;
    @PersistenceContext
    protected EntityManager em;

    @GET
    @Path("/read/{id}")
    @Transactional(readOnly = true)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_ADMIN', 'ROLE_BILLING_ADMIN', 'ROLE_BILLING_AND_INVOICING')")
    public ContractDto readCIDto(@PathParam("id") Long id) {
        return ContractService.instance().read(id);
    }

    @GET
    @Path("/search/{start}/{limit}")
    public ContractTable searchContracts(@QueryParam("empId") Long empId, @QueryParam("itemNum") String itemNum, @PathParam("start") int start, @PathParam("limit") int limit) {
        if (empId != null) {
            return ContractService.instance().search(empId, start, limit);
        } else {
            return ContractService.instance().search(itemNum, start, limit);
        }
    }

    @PUT
    @Path("/search/{start}/{limit}")
    public ContractTable searchContracts(ContractSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return ContractService.instance().search(dto, start, limit);
    }

    @GET
    @Path("/{start}/{limit}")
    public ContractTable getContracts(@PathParam("start") int start, @PathParam("limit") int limit) {
        return ContractService.instance().getContractorPlacementInfo(start, limit);
    }

    @GET
    @Path("/report")
    public Response generateContractsReport(@QueryParam("format") String format) {
        return ContractService.instance().generateContractorPlacementInfoReport(format);
    }

    @PUT
    @Path("/sub-contractor-report")
    public void generateSubContractorReport(ContractSearchDto dto) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        ContractService.instance().generateSubCReport(dto, emp.getPrimaryEmail().getEmail());
    }

    @PUT
    @Path("/client-report")
    public void generateClientReport(ContractSearchDto dto) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        ContractService.instance().generateClientReport(dto, emp.getPrimaryEmail().getEmail());
    }

    @PUT
    @Path("/vendor-report")
    public void generateVendorReport(ContractSearchDto dto) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        ContractService.instance().generateVendorReport(dto, emp.getPrimaryEmail().getEmail());
    }

    @PUT
    @Path("/recruiter-report")
    public void generateRecruiterReport(ContractSearchDto dto) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        ContractService.instance().generateRecruiterReport(dto, emp.getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/reports")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return ContractService.instance().getContractReport(id);
    }

    @PUT
    @Path("/recruiterSearch")
    public ContractTable searchContractsForRecruiter(ContractSearchDto dto) {
        return ContractService.instance().searchContractsForRecruiter(dto);
    }

    @GET
    @Path("/subcontractors-report")
    public void subcontractorsReport() {
        ContractDto.ContractTable table = new ContractDto.ContractTable();
        ContractSearchDto searchDto = new ContractSearchDto();
        searchDto.setEmployeeType(EmployeeType.SUBCONTRACTOR);
        table = ContractService.instance().getResultForReport(searchDto);
        String[] columnOrder = new String[]{"employee", "employeeType", "vendor", "vendorLocation", "vendorAPContact", "vendorRecruiter", "subContractorName", "subcontractorAddress", "subContractorContactName", "startDate", "endDate", "subcontractorPayRate"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(table.getEntities(), "SubContractors Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }
    
    @PUT
    @Path("/emp-location-search/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<ClientInformation> empLocationSearch(EmployeeLocationDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        TypedQuery<Employee> q = em.createQuery(getSearchQuery(dto), Employee.class);
        List<ClientInformation> dtos = new ArrayList();
        q.getResultList().stream().forEach((Employee emp) -> {
            emp.getClientInformations().stream().forEach((ClientInformation ci) -> {
                if (ci.getEndDate() != null) {
                    if ((ci.getEndDate().after(new Date())) || (ci.getEndDate().equals(new Date()))) {
                        dtos.add(ci);
                    }
                } else {
                    dtos.add(ci);
                }
            });
        });
        return dtos;
    }
    
    @PUT
    @Path("/location-report")
    @Transactional(readOnly = true)
    public void empLocationReport(EmployeeLocationDto dto) {
        ContractDto.ContractTable table = new ContractDto.ContractTable();
        List<ClientInformation> dtos = empLocationSearch(dto, 0, 1000);
        List<ContractDto> contractdtos = new ArrayList();
        dtos.stream().forEach((ci) -> {
            contractdtos.add(ContractService.instance().mapClientInformation(ci));
        });
        table.setEntities(contractdtos);
        String[] columnOrder = new String[]{"employee", "client", "clientLocation", "vendor", "startDate", "endDate"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        if (dto.getCity() != null) {
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Emp Working In City " + dto.getCity(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        } else if (dto.getState() != null) {
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Emp Working In State " + dto.getState(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
        }
    }

    protected String getSearchQuery(EmployeeLocationDto dto) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT emp from ").append(Employee.class.getCanonicalName()).append(" as emp");
        if (!Strings.isNullOrEmpty(dto.getCity()) || !Strings.isNullOrEmpty(dto.getState()) || !Strings.isNullOrEmpty(dto.getCountry())) {
            queryStr.append(" join emp.addresss as address");
        }
        queryStr.append("  where ");
        if (!Strings.isNullOrEmpty(dto.getCity())) {
            queryStr.append("lower(address.city) = '").append(dto.getCity().toLowerCase().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append("address.state = '").append(dto.getState().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getCountry())) {
            queryStr.append("address.country = '").append(dto.getCountry().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getBranch())) {
            queryStr.append("emp.branch = '").append(dto.getBranch().trim()).append("' ").append(" and ");
        }

        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    @PUT
    @Path("/emp-address")
    public List<EmployeeLocationReportDto> searchEmployeeAddress(EmployeeLocationDto dto) {
        TypedQuery<Employee> q = em.createQuery(getSearchQuery(dto), Employee.class);
        List<EmployeeLocationReportDto> dtos = new ArrayList();
        q.getResultList().stream().forEach((emp) -> {
            dtos.add(EmployeeLocationReportDto.map(mapper, emp, dto));
        });
        return dtos;
    }

    @PUT
    @Path("/emp-address-report")
    public void getEmpAddressReport(EmployeeLocationDto dto) {
        Employee employee = OfficeSecurityService.instance().getCurrentUser();
        List<EmployeeLocationReportDto> dtos = searchEmployeeAddress(dto);
        if (dtos.size() > 0) {
            String[] columnOrder = new String[]{"employee", "branch", "street1", "street2", "city", "state", "country"};
            String fileName = ReportGenerator.generateExcelOrderedReport(dtos, "Employee In A Location report ", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, employee.getPrimaryEmail().getEmail());
        }
    }

    @GET
    @Path("/sub-contractor-monthly-compliance")
    public ContractTable subCMonthlyCompliance(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
        ContractTable table = new ContractTable();
        List<ContractDto> dtos = new ArrayList();
        List<Employee> emps = EmployeeDao.instance().getAllEmployeesByType(EmployeeType.SUBCONTRACTOR);
        emps.stream().map((emp) -> emp.getClientInformations()).filter((cis) -> (cis.size() > 0)).forEach((cis) -> {
            cis.stream().forEach((ci) -> {
                if (ci.getEndDate() != null) {
                    if (ci.getEndDate().after(startDate) && ci.getEndDate().before(endDate)) {
                        dtos.add(ContractService.instance().mapClientInformation(ci));
                    }
                } else {
                    dtos.add(ContractService.instance().mapClientInformation(ci));
                }
            });
        });
        table.setEntities(dtos);
        table.setSize(Long.valueOf(dtos.size()));
        return table;
    }

    @GET
    @Path("/sub-contractor-monthly-compliance-report")
    public void subCMonthlyComplianceReport(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
        ContractTable table = subCMonthlyCompliance(startDate, endDate);
        if (table.getSize() > 0) {
            String[] columnOrder = new String[]{"employee", "client", "vendor", "startDate", "endDate", "billingRate", "subcontractorPayRate", "subContractorName", "recruiter"};
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "SubContractor Monthly Compliance Projects Report ", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
        }
    }
}
