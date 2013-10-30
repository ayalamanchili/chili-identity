/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.drive;

import info.yalamanchili.office.dao.drive.FileDao;
import info.yalamanchili.office.dao.drive.FolderDao;
import info.yalamanchili.office.dto.drive.FileDto;
import info.yalamanchili.office.dto.drive.FileDto.FileTable;
import info.yalamanchili.office.dto.drive.FolderDto;
import info.yalamanchili.office.entity.drive.File;
import info.yalamanchili.office.entity.drive.Folder;
import java.util.ArrayList;
import org.dozer.Mapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author yphanikumar
 */
@Component
@Scope("request")
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
        folder.setParent(parentFolder);
        folderDao.save(folder);
    }

    public String addFile(Long folderId, FileDto fileDto) {
        Folder folder = folderDao.findById(folderId);
        File file = mapper.map(fileDto, File.class);
        file.setFolder(folder);
        return FileDao.instance().save(file).getId().toString();
    }

    public String updateFile(FileDto fileDto) {
        File file = mapper.map(fileDto, File.class);
        return FileDao.instance().save(file).getId().toString();
    }

    public void renameFolder(Long folderId, String folderName) {
        Folder folder = folderDao.findById(folderId);
        folder.setName(folderName);
        folderDao.save(folder);
    }

    public FileTable getFiles(Long folderId, Integer start, Integer limit) {
        FileTable fileTable = new FileTable();
        List<FileDto> files = new ArrayList<FileDto>();
        for (File file : folderDao.getFilesInFolder(folderId, start, limit)) {
            files.add(FileDto.map(mapper, file));
        }
        fileTable.setEntities(files);
        fileTable.setSize(folderDao.getFilesSizeInFolder(folderId));
        return fileTable;
    }
}
