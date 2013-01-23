/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeBPMIdentityService {

    private final static Logger logger = Logger.getLogger(OfficeBPMIdentityService.class.getName());
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected IdentityService bpmIdentityService;

    public void createUser(String userId) {
        if (findUser(userId) != null) {
            User user = bpmIdentityService.newUser(userId);
            bpmIdentityService.saveUser(user);
        }
    }

    /**
     * sync Portal internal users with Activiti BPM users
     */
    @Async
    public void syncUsers() {
        TypedQuery<Employee> empQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where employeeType.name=:empTypeParam", Employee.class);
        empQuery.setParameter("empTypeParam", "INTERNAL");
        for (Employee emp : empQuery.getResultList()) {
            logger.log(Level.INFO, "creating activiti user:{0}", emp.getEmployeeId());
            createUser(emp.getEmployeeId());
        }
    }

    public User findUser(String userId) {
        UserQuery userQuery = bpmIdentityService.createUserQuery().userId(userId);
        try {
            return userQuery.singleResult();
        } catch (ActivitiException e) {
            logger.log(Level.SEVERE, e.getLocalizedMessage());
            return null;
        }
    }

    public static OfficeBPMIdentityService instance() {
        return SpringContext.getBean(OfficeBPMIdentityService.class);
    }
}
