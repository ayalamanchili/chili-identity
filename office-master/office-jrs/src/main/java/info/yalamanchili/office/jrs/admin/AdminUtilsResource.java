/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.admin;

import info.yalamanchili.office.security.SecurityUtils;
import info.yalamanchili.office.toolbox.DataTools;
import info.yalamanchili.office.toolbox.ADPEmployeeDataTool;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/adminutils")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class AdminUtilsResource {

    @Autowired
    private DataTools dataTools;
    /*
     * hashes  all the emails in the databases
     */

    @Path("hash_emails")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void hashEmails() {
        dataTools.hashEmails();
    }

    /**
     *
     * @param str
     * @return
     */
    @Path("hash")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hash(@QueryParam("value") String value) {
        return dataTools.hash(value);
    }

    /**
     *
     * @param str
     * @return
     */
    @Path("encrypt")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String encrypt(@QueryParam("value") String value) {
        return SecurityUtils.encrypt(value);
    }

    @Path("decrypt")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String decrypt(@QueryParam("value") String value) {
        return SecurityUtils.decrypt(value);
    }
    /*
     * hashes  all the emails in the databases
     */

    @Path("sync_adp_emp_data")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void syncADPEmpployeeData() {
        ADPEmployeeDataTool.instance().syncADPEmpployeeData();
    }

    @Path("fixssn")
    @GET
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void fixssn(@PathParam("str") String str) {
        dataTools.fixSSN();
    }
}
