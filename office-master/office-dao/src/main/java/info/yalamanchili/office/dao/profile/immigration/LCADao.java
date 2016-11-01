/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.immigration;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.immigration.LCA;
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
public class LCADao extends CRUDDao<LCA> {

    @PersistenceContext
    protected EntityManager em;

    public LCADao() {
        super(LCA.class);
    }

    public static LCADao instance() {
        return SpringContext.getBean(LCADao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
