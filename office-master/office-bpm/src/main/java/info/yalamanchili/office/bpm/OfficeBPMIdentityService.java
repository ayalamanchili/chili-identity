/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeBPMIdentityService {

    @Autowired
    protected IdentityService bpmIdentityService;

    public void createUser(String userId) {
        User user = bpmIdentityService.newUser(userId);
        bpmIdentityService.saveUser(user);
    }

    public static OfficeBPMIdentityService instance() {
        return SpringContext.getBean(OfficeBPMIdentityService.class);
    }
}
