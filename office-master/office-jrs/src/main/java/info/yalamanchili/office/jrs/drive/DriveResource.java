/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.drive;

import info.yalamanchili.office.drive.DriveService;
import info.yalamanchili.office.dto.drive.FileDto;
import info.yalamanchili.office.dto.drive.FileDto.FileTable;
import info.yalamanchili.office.dto.drive.FolderDto;
import info.yalamanchili.office.dao.drive.FileDao;
import info.yalamanchili.office.dao.drive.FolderDao;
import info.yalamanchili.office.entity.drive.File;
import info.yalamanchili.office.jrs.FileResource;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yphanikumar
 */
@Path("secured/drive")
@Component
@Transactional
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
public class DriveResource {

    @Autowired
    protected DriveService driveService;
    @Autowired
    private Mapper mapper;

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

    @PUT
    @Path("/files/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public void deletefile(@PathParam("id") Long id) {
        File file = FileDao.instance().findById(id);
        FileDao.instance().delete(id);
        FileResource.instance().deleteFile(file.getFileUrl(), file.getId().toString());
    }

    @PUT
    @Path("/folder/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public void deletefolder(@PathParam("id") Long id) {
        FolderDao.instance().delete(id);
    }

    @GET
    @Path("/files/{folderId}/{start}/{limit}")
    public FileTable getFiles(@PathParam("folderId") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        return driveService.getFiles(id, start, limit);
    }
    
//    @GET
//    @Path("/searchdrive/{start}/{limit}")
//    public List<info.yalamanchili.office.dto.drive.FileDto> searchFile(@PathParam("start") int start,
//            @PathParam("limit") int limit, @QueryParam("text") String text) {
//        List<info.yalamanchili.office.dto.drive.FileDto> files = new ArrayList<info.yalamanchili.office.dto.drive.FileDto>();
//        for (Object fileObj : FileDao.instance().search(text, start, limit, true)) {
//            files.add(info.yalamanchili.office.dto.drive.FileDto.map(mapper, (File) fileObj));
//        }
//        return files;
//    }

//    @PUT
//    @Path("/searchdrive/{start}/{limit}")
//    public List<info.yalamanchili.office.dto.drive.FileDto> searchFile(File entity, @PathParam("start") int start, @PathParam("limit") int limit) {
//        List<info.yalamanchili.office.dto.drive.FileDto> files = new ArrayList<info.yalamanchili.office.dto.drive.FileDto>();
//        for (Object fileObj :FileDao.instance().search(entity, start, limit)) {
//            files.add(info.yalamanchili.office.dto.drive.FileDto.map(mapper, (File) fileObj));
//        }
//        return files;
//    }
}
