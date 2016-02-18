/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.yalamanchili.office.profile.invite.InviteCodeValidationService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("public/file")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Component
@Transactional
@Scope("request")
public class PublicFileResource {
    
    @Autowired
    protected FileResource fileResource;
    
    @POST
    @Path("/upload")
    public Response uploadFile(@Context HttpServletRequest request, @QueryParam("token") String token) {
        InviteCodeValidationService.instance().exists(token);
        return fileResource.processFileUpload(request);
    }
}
