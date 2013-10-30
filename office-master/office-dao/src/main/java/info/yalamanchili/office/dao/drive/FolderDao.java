/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.drive;

import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.drive.File;
import info.yalamanchili.office.entity.drive.Folder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yphanikumar
 */
@Repository
@Scope("prototype")
public class FolderDao extends CRUDDao<Folder> {

    @PersistenceContext
    protected EntityManager em;

    public FolderDao() {
        super(Folder.class);
    }

    public Folder getDriveFolder() {
        return QueryUtils.findEntity(em, Folder.class, "name", "DRIVE");
    }

    public List<File> getFilesInFolder(Long folderId, int start, int limit) {
        TypedQuery<File> query = em.createQuery("from " + File.class.getCanonicalName() + " where folder.id=:folderIdParam", File.class);
        query.setParameter("folderIdParam", folderId);
        query.setFirstResult(start);
        return query.getResultList();
    }

    public Long getFilesSizeInFolder(Long folderId) {
        TypedQuery<Long> query = em.createQuery("select count(*) from " + File.class.getCanonicalName() + " where folder.id=:folderIdParam", Long.class);
        query.setParameter("folderIdParam", folderId);
        return query.getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static FolderDao instance() {
        return SpringContext.getBean(FolderDao.class);
    }
}
