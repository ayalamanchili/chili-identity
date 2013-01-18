/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.profile.TodoDao;
import info.yalamanchili.office.entity.profile.Todo;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class TODOService {

    private final static Logger logger = Logger.getLogger(TODOService.class.getName());
    @Autowired
    protected TodoDao todoDao;

    public Todo save(Todo entity) {
        OfficeBPMService.instance().deployProcess("info/yalamanchili/office/hello-world.bpmn20.xml");
        OfficeBPMService.instance().startProcess("helloWorld");
        return (Todo) todoDao.save(entity);
    }
}
