/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.feedback;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.Feedback.Feedback;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
@Scope("request")
public class FeedbackDao extends CRUDDao<Feedback> {

     @PersistenceContext
    protected EntityManager em;

      public FeedbackDao() {
        super(Feedback.class);
    }
      
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
