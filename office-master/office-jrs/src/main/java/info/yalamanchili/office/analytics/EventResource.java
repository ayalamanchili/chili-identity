/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.analytics;

import info.chili.analytics.model.Event;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.Path;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/analytics")
@Component
@Transactional
@Scope("request")
public class EventResource extends CRUDResource<Event> {

    @Override
    public CRUDDao getDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
