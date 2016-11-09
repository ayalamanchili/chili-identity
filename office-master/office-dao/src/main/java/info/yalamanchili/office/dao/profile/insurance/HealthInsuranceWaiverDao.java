/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.insurance;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class HealthInsuranceWaiverDao extends CRUDDao<HealthInsuranceWaiver> {

    @PersistenceContext
    protected EntityManager em;

    public HealthInsuranceWaiverDao() {
        super(HealthInsuranceWaiver.class);
    }

    public static HealthInsuranceWaiverDao instance() {
        return SpringContext.getBean(HealthInsuranceWaiverDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
