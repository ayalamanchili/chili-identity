/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.dao.profile.immigration.ConsulateInfoDao;
import info.yalamanchili.office.entity.immigration.ConsulateInfo;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("request")
public class ConsulateInfoService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected ConsulateInfoDao consulateDao;

    @Transactional
    public ConsulateInfo saveConsulateInfoForCase(Long caseId, ConsulateInfo consulateInfo) {
        List<ConsulateInfo> findAll = consulateDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (findAll != null && findAll.size() > 0) {
            ConsulateInfo info = findAll.get(0);
            info.setCity(consulateInfo.getCity());
            info.setCountry(consulateInfo.getCountry());
            info.setTargetEntityId(caseId);
            info.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            return consulateDao.getEntityManager().merge(info);
        } else {
            ConsulateInfo save = consulateDao.save(consulateInfo);
            return save;
        }
    }

}
