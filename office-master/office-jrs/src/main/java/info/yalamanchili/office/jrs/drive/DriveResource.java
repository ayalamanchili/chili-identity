/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.drive;

import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
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
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
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
    @Cacheable(OfficeCacheKeys.DRIVE)
    public FolderDto getDriveFolder() {
        return driveService.getDriveFolderTree();
    }

    @PUT
    @Validate
    @Path("/addfolder/{parentFolderId}")
    @CacheEvict(value = OfficeCacheKeys.DRIVE, allEntries = true)
    public void addFolder(@PathParam("parentFolderId") Long parentFolderId, FolderDto folder) {
        driveService.addFolder(parentFolderId, folder);
    }

    @PUT
    @Validate
    @Path("/addfile/{folderId}")
    @Produces("application/text")
    @CacheEvict(value = OfficeCacheKeys.DRIVE, allEntries = true)
    public String addFile(@PathParam("folderId") Long folderId, FileDto file) {
        return driveService.addFile(folderId, file);
    }

    @PUT
    @Validate
    @Path("/update-file")
    @Produces("application/text")
    @PreAuthorize("hasAnyRole('ROLE_DRIVE')")
    @CacheEvict(value = OfficeCacheKeys.DRIVE, allEntries = true)
    public String updateFile(FileDto file) {
        return driveService.updateFile(file);
    }

    @GET
    @Path("/rename-folder/{folderId}/{folderName}")
    @CacheEvict(value = OfficeCacheKeys.DRIVE, allEntries = true)
    public void renameFolder(@PathParam("folderId") Long folderId, @PathParam("folderName") String folderName) {
        //TODO driveservice
        driveService.renameFolder(folderId, folderName);
    }

    @PUT
    @Path("/files/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_DRIVE')")
    @CacheEvict(value = OfficeCacheKeys.DRIVE, allEntries = true)
    public void deletefile(@PathParam("id") Long id) {
        File file = FileDao.instance().findById(id);
        FileDao.instance().delete(id);
        FileResource.instance().deleteFile(file.getFileUrl(), file.getId().toString());
    }

    @PUT
    @Path("/folder/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_DRIVE')")
    @CacheEvict(value = OfficeCacheKeys.DRIVE, allEntries = true)
    public void deletefolder(@PathParam("id") Long id) {
        FolderDao.instance().delete(id);
    }

    @GET
    @Path("/files/{folderId}/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.DRIVE)
    public FileTable getFiles(@PathParam("folderId") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        return driveService.getFiles(id, start, limit);
    }

    @GET
    @Path("/searchdrive/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.DRIVE)
    public List<info.yalamanchili.office.dto.drive.FileDto> searchFile(@PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("text") String text) {
        List<info.yalamanchili.office.dto.drive.FileDto> files = new ArrayList<>();
        //TODO pass only necessary search columns as needed
        for (Object fileObj : FileDao.instance().search(text, start, limit, null, true, false)) {
            files.add(info.yalamanchili.office.dto.drive.FileDto.map(mapper, (File) fileObj));
        }
        return files;
    }

    @PUT
    @Path("/searchdrive/{start}/{limit}")
    public List<info.yalamanchili.office.dto.drive.FileDto> searchFile(File entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<info.yalamanchili.office.dto.drive.FileDto> files = new ArrayList<info.yalamanchili.office.dto.drive.FileDto>();
        for (Object fileObj : FileDao.instance().search(entity, start, limit)) {
            files.add(info.yalamanchili.office.dto.drive.FileDto.map(mapper, (File) fileObj));
        }
        return files;
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.DRIVE)
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        List<Entry> result = new ArrayList<Entry>();
        Map<String, String> values = FileDao.instance().getEntityStringMapByParams(start, limit, columns.toArray(new String[columns.size()]));
        for (String key : values.keySet()) {
            result.add(new Entry(key, values.get(key)));
        }
        return result;
    }
}
