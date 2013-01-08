/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.Feedback;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.feedback.FeedbackDao;
import info.yalamanchili.office.entity.Feedback.Feedback;
import info.yalamanchili.office.jrs.CRUDResource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author raghu
 */
public class FeedbackResource extends CRUDResource<Feedback> {

    @Autowired
    public FeedbackDao feedbackDao;
    
    @Override
    public CRUDDao getDao() {
        return feedbackDao;
    }
    
}
