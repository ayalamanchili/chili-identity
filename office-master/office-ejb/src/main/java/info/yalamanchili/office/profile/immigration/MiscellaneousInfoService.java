/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.dao.profile.immigration.MiscellaneousInfoDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.MiscellaneousInfo;
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
public class MiscellaneousInfoService {
    
    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected MiscellaneousInfoDao miscellaneousDao;

    @Transactional
    public MiscellaneousInfo saveMisceInfoForCase(Long caseId, MiscellaneousInfo misceInfo) {
        List<MiscellaneousInfo> findAll = miscellaneousDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (findAll != null && findAll.size() > 0) {
            MiscellaneousInfo info = findAll.get(0);
            info.setSevisNumber(misceInfo.getEadNumber());
            info.setSevisNumber(misceInfo.getSevisNumber());
            info.setTargetEntityId(caseId);
            info.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            return miscellaneousDao.getEntityManager().merge(info);
        } else {
            MiscellaneousInfo save = miscellaneousDao.save(misceInfo);
            return save;
        }
    }
}
