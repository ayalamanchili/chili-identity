/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.drive;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.FolderDao;
import info.yalamanchili.office.dto.drive.FolderDto;
import info.yalamanchili.office.entity.drive.Folder;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author yphanikumar
 */
@Component
public class DriveService {

    public FolderDto getDriveFolderTree() {
        Folder driveFolder = FolderDao.instance().getDriveFolder();
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        return FolderDto.map(mapper, driveFolder);
    }
  
}
