/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.client.Invoice;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class InvoiceDao extends CRUDDao<Invoice> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public InvoiceDao() {
        super(Invoice.class);
    }

    public static InvoiceDao instance() {
        return SpringContext.getBean(InvoiceDao.class);
    }

    protected String getSearchQuery(String empFirstName, String empLastName) {
        // write sql query to search the employee in invocie table through clieinfo 
        return null;
    }

    public List<Invoice> search(String empFirstName, String empLastName, int start, int limit) {
        String searchQuery = getSearchQuery(empFirstName, empLastName);
        TypedQuery<Invoice> query = em.createQuery(searchQuery, Invoice.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }
}
