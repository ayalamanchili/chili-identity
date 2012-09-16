/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.CertificationDao;
import info.yalamanchili.office.dao.profile.SkillDao;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.MuitiSelectObj;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    //TODO use jpa query to improve performance
    @GET
    @Path("/skills/{empId}/{start}/{limit}")
    public MuitiSelectObj getSkills(@PathParam("empId") Long empId, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        MuitiSelectObj obj = new MuitiSelectObj();
        SkillSet skillSet = (SkillSet) getDao().findById(empId);
        SkillDao skillDao = (SkillDao) SpringContext.getBean("skillDao");
        for (Skill skill : skillDao.query(start, limit)) {
            obj.addAvailable(skill.getId().toString(), skill.getName());
        }
        for (Skill skill : skillSet.getSkills()) {
            obj.addSelected(skill.getId().toString());
        }
        return obj;
    }

    @GET
    @Path("/certifications/{empId}/{start}/{limit}")
    public MuitiSelectObj getCertifications(@PathParam("empId") Long empId, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        MuitiSelectObj obj = new MuitiSelectObj();
        SkillSet skillSet = (SkillSet) getDao().findById(empId);
        CertificationDao certificationDao = (CertificationDao) SpringContext.getBean("certificationDao");
        for (Certification certification : certificationDao.query(start, limit)) {
            obj.addAvailable(certification.getId().toString(), certification.getName());
        }
        for (Certification certification : skillSet.getCertifications()) {
            obj.addSelected(certification.getId().toString());
        }
        return obj;
    }

    public CRUDDao getDao() {
        return skillSetDao;
    }
}
