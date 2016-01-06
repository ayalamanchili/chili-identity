/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.client.ContractService;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dto.client.ContractSearchDto;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.context.annotation.Scope;
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
        ContractService.instance().generateSubCReport(dto);
    }
    
    @PUT
    @Path("/client-report")
    public void generateClientReport(ContractSearchDto dto) {
        ContractService.instance().generateClientReport(dto);
    }
    
    @PUT
    @Path("/vendor-report")
    public void generateVendorReport(ContractSearchDto dto) {
        ContractService.instance().generateVendorReport(dto);
    }
    
    @PUT
    @Path("/recruiter-report")
    public void generateRecruiterReport(ContractSearchDto dto) {
        ContractService.instance().generateRecruiterReport(dto);
    }
}
