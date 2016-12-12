/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.expense.Check;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class CheckDao extends AbstractHandleEntityDao<Check> {

    @PersistenceContext
    protected EntityManager em;

    public CheckDao() {
        super(Check.class);
    }

    public static CheckDao instance() {
        return SpringContext.getBean(CheckDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
