/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Repository
@Scope("prototype")
public class OutOfOfficeDao extends CRUDDao<OutOfOfficeRequest> {

    @PersistenceContext
    protected EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<OutOfOfficeRequest> query(int start, int limit) {
        TypedQuery<OutOfOfficeRequest> findAllQuery = getEntityManager().createQuery("from " + OutOfOfficeRequest.class.getCanonicalName(), OutOfOfficeRequest.class);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    public OutOfOfficeDao() {
        super(OutOfOfficeRequest.class);
    }

    public static OutOfOfficeDao instance() {
        return SpringContext.getBean(OutOfOfficeDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
