/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.immigration;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.immigration.MiscellaneousInfo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ramana.Lukalapu
 */
@Repository
@Scope("prototype")
public class MiscellaneousInfoDao extends AbstractHandleEntityDao<MiscellaneousInfo> {
    
    @PersistenceContext
    protected EntityManager em;

    public MiscellaneousInfoDao() {
        super(MiscellaneousInfo.class);
    }

    public static MiscellaneousInfoDao instance() {
        return SpringContext.getBean(MiscellaneousInfoDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
