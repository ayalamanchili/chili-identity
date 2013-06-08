/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.audit;

import info.yalamanchili.office.audit.AuditService;
import info.yalamanchili.office.dto.audit.LoginActivityDto.LoginActivityTable;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/audit")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class AuditResource {

    @GET
    @Path("/resent_loginactivity/{start}/{limit}")
    public LoginActivityTable getRecentLoginActivity(@PathParam("start") int start, @PathParam("limit") int limit) {
        return AuditService.instance().getLoginActivity(start, limit);
    }
}
