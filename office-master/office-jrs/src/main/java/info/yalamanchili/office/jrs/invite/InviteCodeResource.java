/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.invite;

import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.profile.invite.InviteCodeGeneratorService;
import info.yalamanchili.office.profile.invite.InviteCodeValidationService;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/invite")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class InviteCodeResource {


    @PUT
    @Validate
    @Path("/invite")
    public void submitInviteRequest(InviteCode entity) {
        InviteCodeGeneratorService.instance().inviteCodeGeneration(entity);
    }
    
    @PUT
    @Validate
    @Path("/validate")
    public void inviteCodeValidation(String inviteCode) {
        InviteCodeValidationService.instance().inviteCodeValidator(inviteCode);
    }
    
    
}
