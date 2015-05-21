/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.reports;

import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.reports.profile.CorporateStatusReportService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author benerji.v
 */
@Path("secured/corporate_status")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
@Transactional
public class CorporateStatusReportResource {
  @Autowired
    protected CorporateStatusReportService profileReportsService;

    @GET
    @Path("/corporate_status-report")
    public void basicEmployeeInfoReport() {
        profileReportsService.getCorporateStatusReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }
}
