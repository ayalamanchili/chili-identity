/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.practice;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.practice.Practice;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prashanthi
 */
@Repository
@Scope("prototype")
public class PracticeDao extends CRUDDao<Practice> {

    @PersistenceContext
    protected EntityManager em;

    public PracticeDao() {
        super(Practice.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static PracticeDao instance() {
        return SpringContext.getBean(PracticeDao.class);
    }
}
