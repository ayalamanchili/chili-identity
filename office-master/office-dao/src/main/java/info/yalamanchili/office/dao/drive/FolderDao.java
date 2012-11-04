/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.drive;

import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.drive.Folder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author yphanikumar
 */
@Component
public class FolderDao extends CRUDDao<Folder> {

    @PersistenceContext
    protected EntityManager em;

    public FolderDao() {
        super(Folder.class);
    }

    public Folder getDriveFolder() {
        return QueryUtils.findEntity(em, Folder.class, "name", "DRIVE");
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static FolderDao instance() {
        return SpringContext.getBean(FolderDao.class);
    }
}
