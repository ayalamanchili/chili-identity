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
import info.yalamanchili.office.jrs.MultiSelectObj;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Path("/skills/{skillSetId}/{start}/{limit}")
    public MultiSelectObj getSkills(@PathParam("skillSetId") Long skillSetId, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        //TODO move logic to DAO
        MultiSelectObj obj = new MultiSelectObj();
        SkillSet skillSet = (SkillSet) getDao().findById(skillSetId);
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
    @Path("/skills/add/{skillSetId}/")
    public void addSkills(@PathParam("skillSetId") Long skillSetId, @QueryParam("id") List<Long> ids) {
        SkillSet skillSet = (SkillSet) getDao().findById(skillSetId);
        SkillDao skillDao = (SkillDao) SpringContext.getBean("skillDao");
        for (Long skillId : ids) {
            Skill skill = skillDao.findById(skillId);
            skillSet.getSkills().add(skill);
        }
    }

    @GET
    @Path("/skills/remove/{skillSetId}/")
    public void removeSkills(@PathParam("skillSetId") Long skillSetId, @QueryParam("id") List<Long> ids) {
        //TODO move some logic to jpa
        SkillSet skillSet = (SkillSet) getDao().findById(skillSetId);
        SkillDao skillDao = (SkillDao) SpringContext.getBean("skillDao");
        for (Long skillId : ids) {
            Skill skill = skillDao.findById(skillId);
            if (ids.contains(skillId)) {
                skillSet.getSkills().remove(skill);
            }
        }
    }

    @GET
    @Path("/certifications/{empId}/{start}/{limit}")
    public MultiSelectObj getCertifications(@PathParam("empId") Long empId, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        MultiSelectObj obj = new MultiSelectObj();
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

    @GET
    @Path("/certifications/add/{skillSetId}/")
    public void addCertifications(@PathParam("skillSetId") Long skillSetId, @QueryParam("id") List<Long> ids) {
        SkillSet skillSet = (SkillSet) getDao().findById(skillSetId);
        CertificationDao certificationDao = (CertificationDao) SpringContext.getBean("certificationDao");
        for (Long certificationId : ids) {
            Certification certification = certificationDao.findById(certificationId);
            skillSet.getCertifications().add(certification);
        }
    }

    @GET
    @Path("/certifications/remove/{skillSetId}/")
    public void removeCertifications(@PathParam("skillSetId") Long skillSetId, @QueryParam("id") List<Long> ids) {
        //TODO move some logic to jpa
        SkillSet skillSet = (SkillSet) getDao().findById(skillSetId);
        CertificationDao certificationDao = SpringContext.getBean(CertificationDao.class);
        for (Long certificationId : ids) {
            Certification certification = certificationDao.findById(certificationId);
            if (ids.contains(certificationId)) {
                skillSet.getCertifications().remove(certification);
            }
        }
    }

    public CRUDDao getDao() {
        return skillSetDao;
    }
}
