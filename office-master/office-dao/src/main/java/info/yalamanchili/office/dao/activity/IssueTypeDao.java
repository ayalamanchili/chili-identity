/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.activity;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.activity.IssueType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prashanthi
 */
public class IssueTypeDao extends CRUDDao<IssueType> {

    @PersistenceContext
    protected EntityManager em;

    public IssueTypeDao() {
        super(IssueType.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static IssueTypeDao instance() {
        return SpringContext.getBean(IssueTypeDao.class);

    }
}
