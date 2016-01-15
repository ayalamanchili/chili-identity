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
import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
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
}
