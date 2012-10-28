/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.client.Client;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
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
