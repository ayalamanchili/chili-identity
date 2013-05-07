/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.admin;

import info.yalamanchili.office.toolbox.DataTools;
import info.yalamanchili.office.toolbox.ADPEmployeeDataTool;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Path("hash/{str}")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getHash(@PathParam("str") String str) {
        return dataTools.getHash(str);
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
