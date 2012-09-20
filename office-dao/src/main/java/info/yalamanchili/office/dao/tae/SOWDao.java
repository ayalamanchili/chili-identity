/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.tae;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.time.TimeSheet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
/**
 *
 * @author bala
 */
@Component
public class SOWDao extends CRUDDao<TimeSheet> {

    public SOWDao() {
        super(TimeSheet.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}