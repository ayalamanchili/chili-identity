/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.ext;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.ext.Dependent;
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
public class DependentDao extends AbstractHandleEntityDao<Dependent> {

    @PersistenceContext
    protected EntityManager em;

    public DependentDao() {
        super(Dependent.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static DependentDao instance() {
        return SpringContext.getBean(DependentDao.class);
    }

}
