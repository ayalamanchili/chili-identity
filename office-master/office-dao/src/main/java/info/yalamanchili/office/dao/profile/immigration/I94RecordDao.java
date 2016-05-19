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
import info.yalamanchili.office.entity.immigration.i94Record;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class I94RecordDao  extends AbstractHandleEntityDao<i94Record> {
    
    @PersistenceContext
    protected EntityManager em;

    public I94RecordDao() {
        super(i94Record.class);
    }

    public static I94RecordDao instance() {
        return SpringContext.getBean(I94RecordDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}