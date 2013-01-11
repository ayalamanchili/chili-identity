/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.Feedback;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.feedback.FeedbackDao;
import info.yalamanchili.office.entity.Feedback.Feedback;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import javax.ws.rs.PUT;
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
    
    @PUT
    public Feedback save(Feedback entity) {
       Feedback fb=  (Feedback) getDao().save(entity);
       ProfileNotificationService.instance().feedBackNotification(entity);
       return fb;
    }
    
}
