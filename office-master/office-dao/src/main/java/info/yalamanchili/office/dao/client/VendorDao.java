/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.chili.jpa.QueryUtils;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanthi
 */
@Repository
@Scope("prototype")
public class VendorDao extends CRUDDao<Vendor> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public VendorDao() {
        super(Vendor.class);
    }

    @Async
    @Transactional
    public void updateExistingClientInformations(Vendor vendor, Boolean submitForUpdateF, Boolean submitForUpdateP, Boolean submitForUpdateD, String updatedBy) {
        TypedQuery<ClientInformation> q = em.createQuery("from " + ClientInformation.class.getCanonicalName() + " WHERE vendor_id=:vendorIdParam)", ClientInformation.class);
        q.setParameter("vendorIdParam", vendor.getId());
        for (ClientInformation ci : q.getResultList()) {
            if (submitForUpdateP) {
                ci.setVendorPaymentTerms(vendor.getPaymentTerms());
            }
            if (submitForUpdateF) {
                if (vendor.getVendorinvFrequency() != null) {
                    if (!ci.getInvoiceFrequency().equals(vendor.getVendorinvFrequency())) {
                        if (ci.getBillingRates().isEmpty()) {
                            Employee emp = ci.getEmployee();
                            BillingRate firstBillingRate = new BillingRate();
                            firstBillingRate.setBillingRate(ci.getBillingRate());
                            firstBillingRate.setOverTimeBillingRate(ci.getOverTimeBillingRate());
                            firstBillingRate.setBillingInvoiceFrequency(ci.getInvoiceFrequency());
                            if (emp.getEmployeeType().getName().equals(EmployeeType.SUBCONTRACTOR)) {
                                firstBillingRate.setSubContractorPayRate(ci.getSubcontractorPayRate());
                                firstBillingRate.setSubContractorOverTimePayRate(ci.getSubcontractorOvertimePayRate());
                                firstBillingRate.setSubContractorInvoiceFrequency(ci.getSubcontractorinvoiceFrequency());
                            }
                            if (emp.getEmployeeType().getName().equals(EmployeeType._1099_CONTRACTOR)) {
                                firstBillingRate.setSubContractorPayRate(ci.getPayRate1099());
                                firstBillingRate.setSubContractorOverTimePayRate(ci.getOverTimePayrate1099());
                                firstBillingRate.setSubContractorInvoiceFrequency(ci.getInvoiceFrequency1099());
                            }
                            firstBillingRate.setEffectiveDate(ci.getStartDate());
                            firstBillingRate.setClientInformation(ci);
                            em.merge(firstBillingRate);
                        }
                        ci.setInvoiceFrequency(vendor.getVendorinvFrequency());
                        BillingRate br = new BillingRate();
                        br.setClientInformation(ci);
                        br.setBillingInvoiceFrequency(vendor.getVendorinvFrequency());
                        br.setUpdatedBy(updatedBy);
                        br.setUpdatedTs(Calendar.getInstance().getTime());
                        br.setEffectiveDate(new Date());
                        em.merge(br);
                    }
                }
            }
            if (submitForUpdateD) {
                ci.setInvoiceDeliveryMethod(vendor.getVendorinvDeliveryMethod());
            }
            em.merge(ci);
        }
    }

    public static VendorDao instance() {
        return SpringContext.getBean(VendorDao.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Vendor> query(int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + Vendor.class.getCanonicalName() + "  order by upper(name) ASC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    public List<Vendor> getReport(Date startDate, Date endDate, int start, int limit) {
        String queryStr = getReportQueryString(startDate, endDate);
        TypedQuery<Vendor> query = getEntityManager().createQuery(queryStr, Vendor.class);
        query = (TypedQuery<Vendor>) getReportQueryWithParams(queryStr, query, startDate, endDate);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    protected Query getReportQueryWithParams(String qryStr, Query query, Date startDate, Date endDate) {
        if (qryStr.contains("startDateParam")) {
            query.setParameter("startDateParam", startDate, TemporalType.DATE);
        }
        if (qryStr.contains("endDateParam")) {
            query.setParameter("endDateParam", endDate, TemporalType.DATE);
        }
        return query;
    }

    protected String getReportQueryString(Date startDate, Date endDate) {
        StringBuilder reportQueryBuilder = new StringBuilder();
        reportQueryBuilder.append("from ").append(Vendor.class.getCanonicalName()).append(" where ");
        reportQueryBuilder.append("msaExpDate BETWEEN :startDateParam AND :endDateParam");
        return reportQueryBuilder.toString();
    }
    
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Map<String, String> getEntityStringMapByParams(int start, int limit, String... params) {
        return QueryUtils.getEntityStringMapByParams(getEntityManager(), QueryUtils.getListBoxResultsQueryString(Vendor.class.getCanonicalName(), params) + " where vendorStatus='ACTIVE' ", start, limit, params);
    }
}
