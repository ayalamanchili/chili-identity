/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.client.ContractService;
import info.yalamanchili.office.dto.client.ContractDto;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
@Transactional
public class ContractResource {
    
    @GET
    public List<ContractDto> getContracts(){
        return ContractService.instance().getContractorPlacementInfo();
    }
}
