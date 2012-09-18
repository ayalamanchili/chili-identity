/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.Client;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.client.Client;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prashanthi
 */
public class ClientDao extends CRUDDao<Client> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public ClientDao() {
        super(Client.class);
    }
}
