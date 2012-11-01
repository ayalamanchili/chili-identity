/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.message;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.message.Message;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prashanthi
 */
public class MessageDao extends CRUDDao<Message> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public MessageDao() {
        super(Message.class);
    }
}
