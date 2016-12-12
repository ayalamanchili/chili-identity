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
import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanthi
 */
@Repository
@Scope("prototype")
public class ClientDao extends CRUDDao<Client> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public ClientDao() {
        super(Client.class);
    }

    public static ClientDao instance() {
        return SpringContext.getBean(ClientDao.class);
    }

    @Transactional
    public void clientWithAddressReport() {
        List<ClientLocationDto> res = new ArrayList();
        for (Client c : query(0, 2000)) {
            ClientLocationDto dto = new ClientLocationDto();
            dto.setClientName(c.getName());
            for (Address a : c.getLocations()) {
                dto.setStreet1(a.getStreet1());
                dto.setCity(a.getCity());
                dto.setState(a.getState());
                break;
            }
            res.add(dto);
        }
        String[] columnOrder = new String[]{"clientName", "street1", "city", "state"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Client Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), OfficeServiceConfiguration.instance().getAdminEmail());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> query(int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + Client.class.getCanonicalName() + "  order by upper(name) ASC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();

    }
    
    public List<Client> getReport(Date startDate, Date endDate, int start, int limit) {
        String queryStr = getReportQueryString(startDate, endDate);
        TypedQuery<Client> query = getEntityManager().createQuery(queryStr, Client.class);
        query = (TypedQuery<Client>) getReportQueryWithParams(queryStr, query, startDate, endDate);
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
        reportQueryBuilder.append("from ").append(Client.class.getCanonicalName()).append(" where ");
        reportQueryBuilder.append("msaExpDate BETWEEN :startDateParam AND :endDateParam)");
        return reportQueryBuilder.toString();
    }
    
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Map<String, String> getEntityStringMapByParams(int start, int limit, String... params) {
        return QueryUtils.getEntityStringMapByParams(getEntityManager(), QueryUtils.getListBoxResultsQueryString(Client.class.getCanonicalName(), params) + " where clientStatus='ACTIVE' ", start, limit, params);
    }
}
