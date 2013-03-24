/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
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

    public void syncUserAndRoles(String userId) {
        if (findUser(userId) == null) {
            User user = bpmIdentityService.newUser(userId);
            bpmIdentityService.saveUser(user);
            //groups
            CUser cuser = SecurityService.instance().findEmployee(userId).getUser();
            for (CRole role : cuser.getRoles()) {
                createGroup(role.getRolename());
                addUserToGroup(cuser.getUsername(), role.getRolename());
            }
        }
    }

    public void createGroup(String groupId) {
        if (findGroup(groupId) == null) {
            Group group = bpmIdentityService.newGroup(groupId);
            bpmIdentityService.saveGroup(group);
        }
    }

    public void addUserToGroup(String userId, String groupId) {
        UserQuery userQuery = bpmIdentityService.createUserQuery().userId(userId).memberOfGroup(groupId);
        if (userQuery.count() < 1) {
            bpmIdentityService.createMembership(userId, groupId);
        }
    }

    public void removeUserFromGroup(String userId, String groupId) {
        UserQuery userQuery = bpmIdentityService.createUserQuery().userId(userId).memberOfGroup(groupId);
        if (userQuery.count() > 0) {
            bpmIdentityService.deleteMembership(userId, groupId);
        }
    }

    /**
     * sync Portal internal users with Activiti BPM users
     */
    @Async
    public void syncUsersAndRoles() {
        TypedQuery<Employee> empQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where employeeType.name=:empTypeParam", Employee.class);
        empQuery.setParameter("empTypeParam", "INTERNAL");
        for (Employee emp : empQuery.getResultList()) {
            syncUserAndRoles(emp.getUser().getUsername());
        }
    }

    public void syncRoles() {
        TypedQuery<CRole> rolesQuery = em.createQuery("from " + CRole.class.getCanonicalName(), CRole.class);
        for (CRole crole : rolesQuery.getResultList()) {
            createGroup(crole.getRolename());
        }
    }

    public User findUser(String userId) {
        UserQuery userQuery = bpmIdentityService.createUserQuery().userId(userId);
        if (userQuery.count() == 1) {
            try {
                return userQuery.singleResult();
            } catch (ActivitiException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public Group findGroup(String groupId) {
        GroupQuery grpQuery = bpmIdentityService.createGroupQuery().groupId(groupId);
        if (grpQuery.count() == 1) {
            try {
                return grpQuery.singleResult();
            } catch (ActivitiException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public static OfficeBPMIdentityService instance() {
        return SpringContext.getBean(OfficeBPMIdentityService.class);
    }
}
