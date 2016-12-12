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
import info.yalamanchili.office.entity.immigration.ConsulateInfo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class ConsulateInfoDao extends AbstractHandleEntityDao<ConsulateInfo> {
    
    @PersistenceContext
    protected EntityManager em;

    public ConsulateInfoDao() {
        super(ConsulateInfo.class);
    }

    public static ConsulateInfoDao instance() {
        return SpringContext.getBean(ConsulateInfoDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}