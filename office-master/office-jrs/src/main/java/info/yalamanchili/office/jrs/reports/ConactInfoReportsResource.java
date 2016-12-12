/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.reports;

import info.yalamanchili.office.contact.ContactInfoReportingService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.context.annotation.Scope;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/contact-info-reports")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
@Transactional
public class ConactInfoReportsResource {

    @GET
    @Path("/corp-emp-contact-info")
    @Produces({"application/pdf"})
    public Response getCorporateContactInfo() {
        return ContactInfoReportingService.instance().getCorporateContactInfo();
    }
}
