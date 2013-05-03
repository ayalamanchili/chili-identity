/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.admin;

import info.yalamanchili.office.toolbox.DataTools;
import info.yalamanchili.office.toolbox.EmployeeDataLoad;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    /*
     * hashes  all the emails in the databases
     */
    @Path("hash_emails")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void hashEmails() {
        DataTools.instance().hashEmails();
    }

    /*
     * hashes  all the emails in the databases
     */
    @Path("sync_employee_addresses")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void syncEmployeeAddresses() {
        EmployeeDataLoad.instance().syncEmployeeAddresses();
    }
}
