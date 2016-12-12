/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.feedback;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.Feedback.Feedback;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raghu
 */
@Repository
@Scope("prototype")
public class FeedbackDao extends CRUDDao<Feedback> {

    @PersistenceContext
    protected EntityManager em;

    public FeedbackDao() {
        super(Feedback.class);
    }

//    @Override
//    public Feedback save(Feedback entity)
//    {
////       entity.setSubmittedby(securityService.getCurrentUser().getEmployeeId());
////       entity.setSubmitteddate(new java.util.Date());
//       return super.save(entity);
//    }
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
