/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import java.io.File;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/log")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Component
@Transactional
@Scope("request")
public class LogResource {

    private static final Log log = LogFactory.getLog(FileResource.class);

    @GET
    @Path("/server")
    public Response downloadFile() {
        Response.ResponseBuilder response = null;
        File file = null;
        try {
            String tomcatPath = System.getProperty("catalina.base");
            file = new File(tomcatPath + "/logs/office.log");
            log.info("downloading---------:" + file.getPath());
            if (file.exists()) {
                response = Response.ok((Object) file);
                response.header("Content-Disposition", "filename=" + file.getName());
                response.header("Content-Type", "application/text");
                return response.build();
            } else {
                response = Response.status(Response.Status.NOT_FOUND);
                return response.build();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error processing File download" + e);
        }

    }
}
