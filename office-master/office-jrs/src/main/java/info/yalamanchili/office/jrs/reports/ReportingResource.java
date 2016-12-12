/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.reports;

import info.yalamanchili.office.reporting.AdhocReportingService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/reporting")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
public class ReportingResource {

    @GET
    @Path("/incomplete_profiles")
    @Produces({"application/pdf"})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String generateIncompleteProfileReport() {
        return AdhocReportingService.instance().generateIncompleteProfileReport();
    }
}
