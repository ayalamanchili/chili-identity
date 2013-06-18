/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.TechnologyGroup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prashanthi
 */
public class TechnologyGroupDao extends CRUDDao<TechnologyGroup> {

    @PersistenceContext
    protected EntityManager em;

    public TechnologyGroupDao() {
        super(TechnologyGroup.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static TechnologyGroupDao instance() {
        return SpringContext.getBean(TechnologyGroupDao.class);
    }
}
