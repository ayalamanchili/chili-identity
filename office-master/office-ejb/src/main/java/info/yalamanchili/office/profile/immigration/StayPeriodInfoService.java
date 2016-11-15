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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

    public static StayPeriodInfoService instance() {
        return SpringContext.getBean(StayPeriodInfoService.class);
    }

}
