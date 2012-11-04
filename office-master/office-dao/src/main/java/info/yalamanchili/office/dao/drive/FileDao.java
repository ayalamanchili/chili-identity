/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.drive;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.drive.File;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author yphanikumar
 */
@Component
public class FileDao extends CRUDDao<File> {

    @PersistenceContext
    protected EntityManager em;

    public FileDao() {
        super(File.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static FolderDao instance() {
        return SpringContext.getBean(FileDao.class);
    }
}
