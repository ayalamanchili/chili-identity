/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.profile.RetirementPlanDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.RetirementPlan;
import info.yalamanchili.office.profile.RetirementPlanService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/retirement-plan")
@Component
@Transactional
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
public class RetirementPlanResource {

    @Autowired
    public RetirementPlanService retirementPlanService;

    @GET
    public RetirementPlan find() {
        return RetirementPlanDao.instance().find(null);
    }

    @PUT
    @Path("/opt-in")
    public void optIn(Comment comment) {
        retirementPlanService.optIn(comment);
    }

    @PUT
    @Path("/opt-out")
    public void optOut(Comment comment) {
        retirementPlanService.optOut(comment);
    }

    @GET
    @Path("/opt-in-report")
    public void optInReport() {
        retirementPlanService.getRetirementPlanOptInReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

}
