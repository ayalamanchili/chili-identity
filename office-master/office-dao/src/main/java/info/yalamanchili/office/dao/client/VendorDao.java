/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.client.Vendor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prashanthi
 */
public class VendorDao extends CRUDDao<Vendor> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public VendorDao() {
        super(Vendor.class);
    }
}
