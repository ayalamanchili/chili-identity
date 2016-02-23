/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.SkillDao;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghu
 */
@Path("secured/skillset")
@Component
@Transactional
@Produces("application/json")
@Consumes("application/json")
@Scope("request")
public class SkillSetResource extends CRUDResource<SkillSet> {

    @Autowired
    public SkillSetDao skillSetDao;

    @GET
    @Path("/extract-resume/{skillSetId}")
    public void extractResumeFileContent(@PathParam("skillSetId") Long skillSetId) {
        skillSetDao.extractResumeContent(skillSetId);
    }

    //To add Skills
    @PUT
    @Path("/skills/add/{skill}")
    public void addSkills(@QueryParam("skillSetId") Long skillSetId, @PathParam("skill") String name) {
        SkillDao.instance().addSkill(skillSetDao.findById(skillSetId), name);
    }

    // to remove skills
    @PUT
    @Path("/skills/remove/{skill}")
    public void removeSkills(@PathParam("skill") String name) {
        SkillDao.instance().removeSkill(name);
    }

    @PUT
    @Path("/skills/remove/{skillSetId}/{skill}")
    public void removeSkills(@PathParam("skillSetId") Long skillSetId, @PathParam("skill") String name) {
        SkillDao.instance().removeSkill(skillSetId, name);
    }

    @GET
    @Path("/skills")
    @Transactional(readOnly = true)
    public String getSkills() {
        return mapSkills(SkillDao.instance().getSkills());
    }

    @GET
    @Path("/skills/{skillSetId}")
    @Transactional(readOnly = true)
    public String getSkills(@PathParam("skillSetId") Long skillSetId) {
        return mapSkills(SkillDao.instance().getSkillS(skillSetId));
    }

    protected String mapSkills(List<Skill> skills) {
        StringBuilder res = new StringBuilder();
        int counts = skills.size();
        for (Skill skill : skills) {
            res.append(skill.getName());
            if (counts > 1) {
                res.append(",  ");
                counts--;
            }

        }
        return res.toString();
    }

    //To add Certifications
    @PUT
    @Path("/certifications/add/{certification}")
    public void addCertifications(@PathParam("certification") String name) {
        SkillDao.instance().addCertification(name);
    }

    @PUT
    @Path("/certifications/add/{skillSetId}/{certification}")
    public void addCertifications(@PathParam("skillSetId") Long skillSetId, @PathParam("certification") String name) {
        SkillDao.instance().addCertification(skillSetId, name);
    }

    // to remove skills
    @PUT
    @Path("/certifications/remove/{certification}")
    public void removeCertifications(@PathParam("certification") String name) {
        SkillDao.instance().removeCertification(name);
    }

    @PUT
    @Path("/certifications/remove/{skillSetId}/{certification}")
    public void removeCertifications(@PathParam("skillSetId") Long skillSetId, @PathParam("certification") String name) {
        SkillDao.instance().removeCertification(skillSetId, name);
    }

    @GET
    @Path("/certifications")
    @Transactional(readOnly = true)
    public String getcertifications() {
        return mapCertfications(SkillDao.instance().getCertifications());
    }

    @GET
    @Path("/certifications/{skillSetId}")
    @Transactional(readOnly = true)
    public String getcertifications(@PathParam("skillSetId") Long skillSetId) {
        return mapCertfications(SkillDao.instance().getCertifications(skillSetId));
    }

    protected String mapCertfications(List<Certification> certs) {
        StringBuilder res = new StringBuilder();
        int countc = certs.size();
        for (Certification certfic : certs) {
            res.append(certfic.getName());
            if (countc > 1) {
                res.append(",  ");
                countc--;
            }

        }
        return res.toString();
    }

    @GET
    @Path("/search-resumes/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<SkillSetDto> searchResumes(@QueryParam("searchText") String searchText, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        List<SkillSetDto> res = new ArrayList<SkillSetDto>();
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        for (SkillSet entity : skillSetDao.hibernateSearch(searchText, start, limit, "resumeContent")) {
            SkillSetDto dto = mapper.map(entity, SkillSetDto.class);
            dto.setEmployeeName(entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
            res.add(dto);
        }
        return res;
    }

    @Override
    public CRUDDao getDao() {
        return skillSetDao;
    }

    @XmlRootElement
    @XmlType
    public static class SkillSetDto extends SkillSet {

        public SkillSetDto() {
        }

        protected String employeeName;

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

    }
}
