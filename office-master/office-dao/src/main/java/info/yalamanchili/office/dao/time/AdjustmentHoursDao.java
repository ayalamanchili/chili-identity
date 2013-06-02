/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.time.AdjustmentHours;
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
public class AdjustmentHoursDao extends CRUDDao<AdjustmentHours> {

    @PersistenceContext
    protected EntityManager em;
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
       public AdjustmentHoursDao() {
        super(AdjustmentHours.class);
    }

}
