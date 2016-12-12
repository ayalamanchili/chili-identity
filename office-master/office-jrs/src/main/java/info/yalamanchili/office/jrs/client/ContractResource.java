/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.client.ContractService;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dto.client.ContractSearchDto;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CONTRACTS_ADMIN', 'ROLE_BILLING_ADMIN', 'ROLE_BILLING_AND_INVOICING', 'ROLE_CONTRACTS_FULL_VIEW','ROLE_INVOICE_MANAGER')")
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
    
    @PUT
    @Path("/serviceType-report")
    public void generateServiceTypeReport(ContractSearchDto dto) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        ContractService.instance().generateServiceTypeReport(dto, emp.getPrimaryEmail().getEmail());
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
    @Path("/load-invoice-billingRate/{cpdId}")
    public String getEffectiveBillingRateForInvoice(@PathParam("cpdId") Long cpdId, @QueryParam("startDate") Date startDate) {
        return String.valueOf(ContractService.instance().getEffectiveBillingRateForInvoice(cpdId, startDate));
    }
}
