/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.security.domain.CRole;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Employee;
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
        if (findUser(userId) == null) {
            User user = bpmIdentityService.newUser(userId);
            bpmIdentityService.saveUser(user);
        }
    }

    public void createGroup(String groupId) {
        if (findGroup(groupId) == null) {
            Group group = bpmIdentityService.newGroup(groupId);
            bpmIdentityService.saveGroup(group);
        }
    }

    public void removeUserFromGroup(String userId, String groupId) {
        UserQuery userQuery = bpmIdentityService.createUserQuery().userId(userId).memberOfGroup(groupId);
        if (userQuery.count() > 0) {
            bpmIdentityService.deleteMembership(userId, groupId);
        }
    }

    public void addUserToGroup(String userId, String groupId) {
        createUser(userId);
        UserQuery userQuery = bpmIdentityService.createUserQuery().userId(userId).memberOfGroup(groupId);
        if (userQuery.count() < 1) {
            bpmIdentityService.createMembership(userId, groupId);
        }
    }

    /**
     * sync Portal internal users with Activiti BPM users
     */
//    @Async
//    TODO this should be async
    public void syncUsersAndRoles() {
        syncRoles();
        TypedQuery<Employee> empQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where employeeType.name=:empTypeParam and user.enabled=true", Employee.class);
        empQuery.setParameter("empTypeParam", "Employee");
        for (Employee emp : empQuery.getResultList()) {
            logger.log(Level.INFO, "creating activiti user:{0}", emp.getEmployeeId());
            createUser(emp.getEmployeeId());
            for (CRole role : emp.getUser().getRoles()) {
                createGroup(role.getRolename());
                addUserToGroup(emp.getEmployeeId(), role.getRolename());
            }
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
    
    public void deleteUser(String userId){
        bpmIdentityService.deleteUser(userId);
    }

    public static OfficeBPMIdentityService instance() {
        return SpringContext.getBean(OfficeBPMIdentityService.class);
    }
}
