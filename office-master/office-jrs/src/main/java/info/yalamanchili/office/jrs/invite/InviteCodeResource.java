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
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dto.onboarding.InitiateOnBoardingDto;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.profile.invite.InviteCodeGeneratorService;
import info.yalamanchili.office.profile.invite.InviteCodeService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/invitecode")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class InviteCodeResource {

    @Autowired
    protected InviteCodeService inviteCodeService;
    @Autowired
    protected InviteCodeDao inviteCodeDao;

    @GET
    @Path("/{start}/{limit}")
    public InviteCodeService.InviteCodeTable Code(@PathParam("start") int start, @PathParam("limit") int limit) {
        return inviteCodeService.getInviteCodes(start, limit);
    }

    @GET
    @Path("/{caseId}/{start}/{limit}")
    public InviteCodeService.InviteCodeTable getCaseCodes(@PathParam("caseId") Long caseId, @PathParam("start") int start, @PathParam("limit") int limit) {
        return inviteCodeService.getCaseInviteCodes(caseId, start, limit);
    }

    @PUT
    @Path("/search")
    public List<InviteCodeService.InviteCodeDto> search(InviteCodeService.InviteCodeDto search) {
        return inviteCodeService.searchInviteCodes(search);
    }

    @PUT
    @Validate
    @Path("/invite")
    public void invite(InviteCode entity, @DefaultValue("true") @QueryParam("sendEmail") boolean sendEmail, @QueryParam("name") InitiateOnBoardingDto dto) {
        InviteCodeGeneratorService.instance().generate(entity, sendEmail, dto);
    }

    @PUT
    @Validate
    @Path("/update-expiration/{id}")
    public void updateExpirationDate(InviteCode entity) {
        InviteCode updateEntity = inviteCodeDao.find(entity.getInvitationCode());
        updateEntity.setExpiryDate(entity.getExpiryDate());
        inviteCodeDao.save(updateEntity);
    }
}