/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghu
 */
@Path("skillset")
@Component
@Transactional
@Produces("application/json")
@Consumes("application/json")
@Scope("request")
public class SkillSetResource extends CRUDResource<SkillSet> {

    @Autowired
    public SkillSetDao skillSetDao;
    @Autowired
    public EmployeeDao employeeDao;
    @Autowired
    protected SecurityService securityService;
    @Autowired
    protected ProfileNotificationService profileNotificationservice;
    @Override
    
    
    public CRUDDao getDao() {
        return skillSetDao;
    }
    
    @PUT
    public SkillSet save(SkillSet skillset) {
        Employee emp = securityService.getCurrentUser();
        if (skillset.getId() == null) {
            return save(skillset);
        } else {
            SkillSet savedSkillset = (SkillSet) getDao().save(skillset);
            profileNotificationservice.ResumeUpdatedNotification(emp);
            return savedSkillset;
        }
    }
}
