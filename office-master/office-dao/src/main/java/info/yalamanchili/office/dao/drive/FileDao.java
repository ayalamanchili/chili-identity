/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.drive;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.drive.File;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author yphanikumar
 */
@Component
@Scope("prototype")
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

    public static FileDao instance() {
        return SpringContext.getBean(FileDao.class);
    }
}
