/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.yalamanchili.office.security.OfficeAclService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("acl")
@Component
@Transactional
@Scope("request")
public class AclResource {

    @Autowired
    protected OfficeAclService officeAclService;

    @GET
    @Path("/permission/add/{className}/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addPermissions(@PathParam("className") String className, @PathParam("id") Long id, @QueryParam("permission") List<String> permissions) {
        officeAclService.addBasicPermissions(className, id, permissions);
    }
}
