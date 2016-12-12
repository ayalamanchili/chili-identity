/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.chili.security.acl.ChiliAclService;
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
@Path("secured/acl")
@Component
@Transactional
@Scope("request")
public class AclResource {

    @Autowired
    protected ChiliAclService officeAclService;
//TODO change to put

//    @GET
//    @Path("/permission/add/{className}/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public void addPermissions(@PathParam("className") String className, @PathParam("id") Long id, @QueryParam("permission") List<String> permissions) {
//        officeAclService.addBasicPermissions(className, id, permissions);
//    }
//
//    @GET
//    @Path("/permission/remove/{className}/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public void removePermissions(@PathParam("className") String className, @PathParam("id") Long id, @QueryParam("permission") List<String> permissions) {
//        officeAclService.removePermissions(className, id, permissions);
//    }
}
