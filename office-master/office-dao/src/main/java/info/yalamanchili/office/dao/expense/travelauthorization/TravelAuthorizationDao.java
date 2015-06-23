/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.travelauthorization;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelExpenseRequisition;
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
public class TravelAuthorizationDao extends CRUDDao<TravelExpenseRequisition> {

    public TravelAuthorizationDao() {
        super(TravelExpenseRequisition.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static TravelAuthorizationDao instance() {
        return SpringContext.getBean(TravelAuthorizationDao.class);
    }
}
