/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.drive;

import info.yalamanchili.office.dao.drive.FolderDao;
import info.yalamanchili.office.dto.drive.FileDto;
import info.yalamanchili.office.dto.drive.FolderDto;
import info.yalamanchili.office.entity.drive.File;
import info.yalamanchili.office.entity.drive.Folder;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yphanikumar
 */
@Component
public class DriveService {
    
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected FolderDao folderDao;
    
    public FolderDto getDriveFolderTree() {
        Folder driveFolder = folderDao.getDriveFolder();
        return FolderDto.map(mapper, driveFolder);
    }
    
    public void addFolder(Long parentFolderId, FolderDto folderDto) {
        Folder parentFolder = folderDao.findById(parentFolderId);
        Folder folder = mapper.map(folderDto, Folder.class);
        parentFolder.addChild(folder);
        folderDao.save(folder);
    }
    
    public void addFile(Long folderId, FileDto fileDto) {
        Folder folder = folderDao.findById(folderId);
        File file = mapper.map(fileDto, File.class);
        folder.addFile(file);
        folderDao.save(folder);
    }
}
