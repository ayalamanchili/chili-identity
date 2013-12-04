/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.BillingRate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author prasanthi.p
 */
public class BillingRateDao extends CRUDDao<BillingRate> {

    @PersistenceContext
    protected EntityManager em;

    public BillingRateDao() {
        super(BillingRate.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static BillingRateDao instance() {
        return SpringContext.getBean(BillingRateDao.class);
    }
}
