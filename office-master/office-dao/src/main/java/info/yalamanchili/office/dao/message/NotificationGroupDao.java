/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.message;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.message.NotificationGroup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anuyalamanchili
 */
public class NotificationGroupDao extends CRUDDao<NotificationGroup> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public NotificationGroupDao() {
        super(NotificationGroup.class);
    }

    public static NotificationGroupDao instance() {
        return SpringContext.getBean(NotificationGroupDao.class);
    }
}
