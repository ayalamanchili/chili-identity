/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.client.Vendor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
@Scope("prototype")
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

    public static VendorDao instance() {
        return SpringContext.getBean(VendorDao.class);
    }
}
