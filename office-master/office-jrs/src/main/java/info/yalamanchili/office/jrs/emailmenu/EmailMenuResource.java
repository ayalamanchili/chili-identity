/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.emailmenu;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.emailmenu.EmailMenuReportsService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.reports.profile.ProfileReportsService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
 * @author prasanthi.p
 */
@Path("secured/email-menu")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
@Transactional
public class EmailMenuResource {

    @Autowired
    protected EmailMenuReportsService emailMenuReportsService;

    @GET
    @Path("/email-menu-report")
    public void basicEmployeeInfoReport(@QueryParam("employee") String employee) {
        emailMenuReportsService.getemailMenuReportsReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), employee);
    }

}
