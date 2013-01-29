/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.time.BonusPayment;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
@Scope("prototype")
public class BonusPaymentDao extends CRUDDao<BonusPayment> {

    @PersistenceContext
    protected EntityManager em;
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
       public BonusPaymentDao() {
        super(BonusPayment.class);
    }

}
