/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.reporting;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.reporting.AdminReportingService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/reporting")
@Component
@Scope("request")
public class ReportingResource {

    @GET
    @Path("/pdf")
    @Produces({"application/pdf"})
    public Response doPdfReport() {
        AdminReportingService adminReportingService = SpringContext.getBean(AdminReportingService.class);
        return Response.
                ok(adminReportingService.doPdfReport()).
                header("Content-Disposition", "inline; filename=spring3-rest-jasper-report.pdf").
                build();
    }
}
