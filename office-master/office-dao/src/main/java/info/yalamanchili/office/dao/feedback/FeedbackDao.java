/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.feedback;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.Feedback.Feedback;
import java.sql.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    protected SecurityService securityService;

      public FeedbackDao() {
        super(Feedback.class);
    }
    
    @Override
    public Feedback save(Feedback entity)
    {
       entity.setSubmittedby(securityService.getCurrentUser().getEmployeeId());
       entity.setSubmitteddate(new java.util.Date());
       return super.save(entity);
    }
      
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
