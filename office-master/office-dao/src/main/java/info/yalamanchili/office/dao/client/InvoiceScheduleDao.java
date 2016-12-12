/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.client.InvoiceSchedule;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ramana.Lukalapu
 */
@Repository
@Scope("prototype")
public class InvoiceScheduleDao extends AbstractHandleEntityDao<InvoiceSchedule> {

    @PersistenceContext
    protected EntityManager em;

    public InvoiceScheduleDao() {
        super(InvoiceSchedule.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public List<InvoiceSchedule> query() {
        TypedQuery<InvoiceSchedule> findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName(), entityCls);
        return findAllQuery.getResultList();
    }

    public static InvoiceScheduleDao instance() {
        return SpringContext.getBean(InvoiceScheduleDao.class);
    }
}
