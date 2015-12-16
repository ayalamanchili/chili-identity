/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.reports;

import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.reporting.EmailGroupsService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/email-groups")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
@Transactional
public class EmailGroupsResource {

    @Autowired
    protected EmailGroupsService emailGroupsService;

    @GET
    @Path("/type")
    public void basicEmployeeInfoReport(@QueryParam("employee-type") String employeeType) {
        emailGroupsService.getemailMenuReportsReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), employeeType);
    }

}
