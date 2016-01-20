/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.hr;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.hr.Resume;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class ResumeDao extends CRUDDao<Resume> {

    public ResumeDao() {
        super(Resume.class);
    }
    
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void delete(Long id) {
        delete(findById(id));
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ResumeDao instance() {
        return SpringContext.getBean(ResumeDao.class);
    }

}
