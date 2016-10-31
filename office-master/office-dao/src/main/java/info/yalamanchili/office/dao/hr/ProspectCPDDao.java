/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.hr;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ProspectCPD;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class ProspectCPDDao extends AbstractHandleEntityDao<ProspectCPD> {

    @PersistenceContext
    protected EntityManager em;

    public ProspectCPDDao() {
        super(ProspectCPDDao.class);
    }

    public static ProspectCPDDao instance() {
        return SpringContext.getBean(ProspectCPDDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional(readOnly = false)
    public List<ClientInformation> getAllCpds(Long contactId) {
        TypedQuery<ProspectCPD> getCPDQuery = getEntityManager().createQuery("from " + ProspectCPD.class.getCanonicalName() + " WHERE contactId=:contactIdParam", ProspectCPD.class);
        getCPDQuery.setParameter("contactIdParam", contactId);
        List<ClientInformation> cpds = new ArrayList();
        List<ProspectCPD> resultList = getCPDQuery.getResultList();
        if (resultList != null && resultList.size() > 0) {
            for (ProspectCPD cpd : resultList) {
                cpds.add(ClientInformationDao.instance().findById(cpd.getClientInfoId()));
            }
        }
        return cpds;
    }
}