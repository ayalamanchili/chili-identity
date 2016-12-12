/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.immigration.StayPeriodInfoDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.StayPeriodInfo;
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
@Scope("prototype")
public class StayPeriodInfoService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    public StayPeriodInfoDao stayPeriodDetailsDao;

    public void addStayPeriodInfoDetails(Long targetId, StayPeriodInfo periodInfoDetails) {
        StayPeriodInfo entity = null;
        entity = stayPeriodDetailsDao.save(periodInfoDetails);
        entity.setTargetEntityId(targetId);
        entity.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        em.merge(entity);
    }

    @Transactional
    public StayPeriodInfo saveStayPeriodInfoForCase(Long caseId, StayPeriodInfo stayPeriodInfo) {
        List<StayPeriodInfo> findAll = stayPeriodDetailsDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (findAll != null && findAll.size() > 0) {
            StayPeriodInfo info = findAll.get(0);
            info.setName(stayPeriodInfo.getName());
            info.setFromDate(stayPeriodInfo.getFromDate());
            info.setToDate(stayPeriodInfo.getToDate());
            info.setImmigrantStatus(stayPeriodInfo.getImmigrantStatus());
            info.setOtherCitizenship(stayPeriodInfo.getOtherCitizenship());
            info.setCountry(stayPeriodInfo.getCountry());
            info.setPurpose(stayPeriodInfo.getPurpose());
            info.setTargetEntityId(caseId);
            info.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            return stayPeriodDetailsDao.getEntityManager().merge(info);
        } else {
            StayPeriodInfo save = stayPeriodDetailsDao.save(stayPeriodInfo);
            return save;
        }
    }

    public static StayPeriodInfoService instance() {
        return SpringContext.getBean(StayPeriodInfoService.class);
    }

}
