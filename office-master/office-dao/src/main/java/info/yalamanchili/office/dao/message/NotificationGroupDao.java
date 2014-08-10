/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.message;

import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class NotificationGroupDao extends CRUDDao<NotificationGroup> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public void syncNotificationGroupsForRoles() {
        for (OfficeRole role : OfficeRoles.OfficeRole.values()) {
            String groupName = role.name().replace("ROLE_", "").trim();
            NotificationGroup group = findByName(groupName);
            if (group == null) {
                group = new NotificationGroup();
                group.setName(groupName);
                group = save(group);
            }
            //add missing emps
            for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 2000, role.name())) {
                boolean flag = false;
                for (Employee grpEmp : group.getEmployees()) {
                    if (grpEmp.getEmployeeId().equals(emp.getEmployeeId())) {
                        flag = true;
                    }
                }
                if (flag == false) {
                    group.getEmployees().add(emp);
                }
            }
            //remove emps
            for (Employee grpEmp : group.getEmployees()) {
                boolean flag = false;
                for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 2000, role.name())) {
                    if (grpEmp.getEmployeeId().equals(emp.getEmployeeId())) {
                        flag = true;
                    }
                }
                if (flag == false) {
                    group.getEmployees().remove(grpEmp);
                }
            }
            save(group);
        }
    }

    public NotificationGroup findByName(String name) {
        return QueryUtils.findEntity(getEntityManager(), NotificationGroup.class, "name", name);
    }

    public NotificationGroupDao() {
        super(NotificationGroup.class);
    }

    public static NotificationGroupDao instance() {
        return SpringContext.getBean(NotificationGroupDao.class);
    }
}
