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
import info.yalamanchili.office.entity.profile.ClientInfoHandleEntity;
import info.yalamanchili.office.entity.profile.ClientInformation;
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
public class ClientInfoHandleEntityDao extends AbstractHandleEntityDao<ClientInfoHandleEntity> {

    @PersistenceContext
    protected EntityManager em;

    public ClientInfoHandleEntityDao() {
        super(ClientInfoHandleEntityDao.class);
    }

    public static ClientInfoHandleEntityDao instance() {
        return SpringContext.getBean(ClientInfoHandleEntityDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional(readOnly = false)
    public List<ClientInformation> getAllCpds(Long sourceId) {
        TypedQuery<ClientInfoHandleEntity> getCPDQuery = getEntityManager().createQuery("from " + ClientInfoHandleEntity.class.getCanonicalName() + " WHERE sourceEntityId=:sourceIdParam", ClientInfoHandleEntity.class);
        getCPDQuery.setParameter("sourceIdParam", sourceId);
        List<ClientInformation> cpds = new ArrayList();
        List<ClientInfoHandleEntity> resultList = getCPDQuery.getResultList();
        if (resultList != null && resultList.size() > 0) {
            for (ClientInfoHandleEntity cpd : resultList) {
                cpds.add(ClientInformationDao.instance().findById(cpd.getTargetEntityId()));
            }
        }
        return cpds;
    }
}