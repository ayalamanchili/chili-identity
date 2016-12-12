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
import info.yalamanchili.office.reports.profile.ProfileReportsService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/profile-reports")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
@Transactional
public class ProfileReportsResource {

    @Autowired
    protected ProfileReportsService profileReportsService;

    @GET
    @Path("/employee-basic-info-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR_ADMINSTRATION')")
    public void basicEmployeeInfoReport() {
        profileReportsService.generateEmployeBasicInfoReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/employee-advance-info-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR_ADMINSTRATION')")
    public void generateProfileInformationReport() {
        profileReportsService.generateProfileReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }
    
    @GET
    @Path("/employee-company-contacts-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR_ADMINSTRATION')")
    public void generateCompanyContactsReport() {
        profileReportsService.generateEmployeCompanyContactsReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/employee-client-info-report")
    public void employeeclientInfoReport() {
        profileReportsService.generateEmployeClientInfoReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }
}
