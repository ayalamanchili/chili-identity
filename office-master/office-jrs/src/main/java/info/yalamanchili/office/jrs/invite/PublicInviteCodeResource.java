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
 * @author ayalamanchili
 */
@Path("public/invitecode")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class PublicInviteCodeResource {

    @PUT
    @Validate
    @Path("/validate")
    @Produces("application/text")
    public String validate(InviteCode entity) {
        return InviteCodeValidationService.instance().validate(entity.getInvitationCode());
    }
}
