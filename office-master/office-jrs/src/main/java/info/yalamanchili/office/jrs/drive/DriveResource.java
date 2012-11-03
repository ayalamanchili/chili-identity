/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.drive;

import info.yalamanchili.office.drive.DriveService;
import info.yalamanchili.office.dto.drive.FolderDto;
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
 * @author yphanikumar
 */
@Path("drive")
@Component
@Transactional
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
public class DriveResource {

    @Autowired
    protected DriveService driveService;

    @Path("/tree")
    @GET
    public FolderDto getDriveFolder() {
        return driveService.getDriveFolderTree();
    }
}
