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
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.entity.profile.ClientInformation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.TreeSet;

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

    TreeSet<Date> dates = new TreeSet();

    public InvoiceDao() {
        super(Invoice.class);
    }

    public static InvoiceDao instance() {
        return SpringContext.getBean(InvoiceDao.class);
    }

    protected String getSearchQuery(String empFirstName, String empLastName) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT inv from ").append(Invoice.class.getCanonicalName());
        queryStr.append(" inv where ");
        queryStr.append("inv.clientInformation.employee.firstName LIKE '%").append(empFirstName.trim()).append("%' AND ");
        queryStr.append("inv.clientInformation.employee.lastName LIKE '%").append(empLastName.trim()).append("%'");
        return queryStr.toString();
    }

    public List<Invoice> search(String empFirstName, String empLastName, int start, int limit) {
        String searchQuery = getSearchQuery(empFirstName, empLastName);
        TypedQuery<Invoice> query = em.createQuery(searchQuery, Invoice.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public List<Invoice> getInvoices(Long clientInfoId, int start, int limit) {
        TypedQuery<Invoice> query = getEntityManager().createQuery("from " + Invoice.class.getCanonicalName() + " where clientInformation.id=:clientInfoIdParam order by invoiceDate DESC", Invoice.class);
        query.setParameter("clientInfoIdParam", clientInfoId);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public List<Invoice> getInvoicesForDates(Date startDate, Date endDate) {
        Query findAllQuery = getEntityManager().createQuery("from " + Invoice.class.getCanonicalName() + " inv where inv.invoiceDate>=:startDateParam AND inv.invoiceDate<=:endDateParam ", entityCls);
        findAllQuery.setParameter("startDateParam", startDate);
        findAllQuery.setParameter("endDateParam", endDate);
        return findAllQuery.getResultList();
    }

    public List<Invoice> getInvoicesForDates(ClientInformation ci, Date startDate, Date endDate) {
        Query findAllQuery = getEntityManager().createQuery("from " + Invoice.class.getCanonicalName() + " inv where inv.startDate>=:startDateParam AND inv.endDate<=:endDateParam AND inv.clientInformation=:ciParam", entityCls);
        findAllQuery.setParameter("startDateParam", startDate);
        findAllQuery.setParameter("endDateParam", endDate);
        findAllQuery.setParameter("ciParam", ci);
        return findAllQuery.getResultList();
    }

    @Override
    public void delete(Invoice entity) {
        try {
            getEntityManager().remove(entity);
        } catch (javax.persistence.PersistenceException e) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "SQLError", e.getMessage());
        }
    }

    public List<Invoice> search(String empFirstName, String empLastName) {
        String searchQuery = getSearchQuery(empFirstName, empLastName);
        TypedQuery<Invoice> query = em.createQuery(searchQuery, Invoice.class);
        return query.getResultList();
    }
}
