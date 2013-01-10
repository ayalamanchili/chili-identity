/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.Feedback;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.feedback.FeedbackDao;
import info.yalamanchili.office.entity.Feedback.Feedback;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Path("secured/feedback")
@Component
@Scope("request")
public class FeedbackResource extends CRUDResource<Feedback> {

    @Autowired
    public FeedbackDao feedbackDao;
    
    @Override
    public CRUDDao getDao() {
        return feedbackDao;
    }
    
}
