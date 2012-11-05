/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.drive;

import info.yalamanchili.office.drive.DriveService;
import info.yalamanchili.office.dto.drive.FileDto;
import info.yalamanchili.office.dto.drive.FolderDto;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @PUT
    @Path("/addfolder/{parentFolderId}")
    public void addFolder(@PathParam("parentFolderId") Long parentFolderId, FolderDto folder) {
        driveService.addFolder(parentFolderId, folder);
    }
    
    @PUT
    @Path("/addfile/{folderId}")
    @Produces("application/text")
    public String addFile(@PathParam("folderId") Long folderId, FileDto file) {
        return driveService.addFile(folderId, file);
    }
}
