/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.immigration;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.immigration.DeportationInfo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ramana.Lukalapu
 */
public class DeportationInfoDao extends AbstractHandleEntityDao<DeportationInfo> {

    @PersistenceContext
    protected EntityManager em;

    public DeportationInfoDao() {
        super(DeportationInfo.class);
    }

    public static DeportationInfoDao instance() {
        return SpringContext.getBean(DeportationInfoDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
