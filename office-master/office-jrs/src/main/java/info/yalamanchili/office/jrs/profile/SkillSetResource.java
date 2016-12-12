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
import info.yalamanchili.office.dao.profile.SkillSetFileDao;
import info.yalamanchili.office.dto.profile.SkillSetSaveDto;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.profile.SkillSetFile;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.StringUtils;
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
        if (skillSetId == null) {
            SkillDao.instance().addSkill(null, name);
        } else {
            SkillDao.instance().addSkill(skillSetDao.findById(skillSetId), name);
        }

    }

    // to remove skills
    @PUT
    @Path("/skills/remove/{skill}")
    public void removeSkills(@QueryParam("skillSetId") Long skillSetId, @PathParam("skill") String name) {
        if (skillSetId == null) {
            SkillDao.instance().removeSkill(null, name);
        } else {
            SkillDao.instance().removeSkill(skillSetDao.findById(skillSetId), name);
        }
    }

    @GET
    @Path("/skills")
    @Transactional(readOnly = true)
    public String getSkills() {
        return StringUtils.join(SkillDao.instance().getSkills(), ",");
    }

    @GET
    @Path("/skills/{skillSetId}")
    @Transactional(readOnly = true)
    public String getSkills(@PathParam("skillSetId") Long skillSetId) {
        return StringUtils.join(SkillDao.instance().getSkills(skillSetId), ",");
    }

    //To add Certifications
    @PUT
    @Path("/certifications/add/{certification}")
    public void addCertifications(@QueryParam("skillSetId") Long skillSetId, @PathParam("certification") String name) {
        if (skillSetId == null) {
            SkillDao.instance().addCertification(null, name);
        } else {
            SkillDao.instance().addCertification(skillSetDao.findById(skillSetId), name);
        }
    }

    // to remove skills
    @PUT
    @Path("/certifications/remove/{certification}")
    public void removeCertifications(@QueryParam("skillSetId") Long skillSetId, @PathParam("certification") String name) {
        if (skillSetId == null) {
            SkillDao.instance().removeCertification(null, name);
        } else {
            SkillDao.instance().removeCertification(skillSetDao.findById(skillSetId), name);
        }
    }

    @GET
    @Path("/certifications")
    @Transactional(readOnly = true)
    public String getcertifications() {
        return StringUtils.join(SkillDao.instance().getCertifications(), ",");
    }

    @GET
    @Path("/certifications/{skillSetId}")
    @Transactional(readOnly = true)
    public String getcertifications(@PathParam("skillSetId") Long skillSetId) {
        return StringUtils.join(SkillDao.instance().getCertifications(skillSetId), ",");
    }

    @GET
    @Path("/search-resumes/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<SkillSetSaveDto> searchResumes(@QueryParam("searchText") String searchText, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        List<SkillSetSaveDto> res = new ArrayList<>();
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        for (SkillSet entity : skillSetDao.hibernateSearch(searchText, start, limit, "resumeContent")) {
            SkillSetSaveDto dto = mapper.map(entity, SkillSetSaveDto.class);
            dto.setEmployee(entity.getEmployee());
            res.add(dto);
        }
        return res;
    }

    @GET
    @Path("/resumes/{empId}")
    public SkillSetFile getSkillSetFile(@PathParam("empId") Long empId) {
        return SkillSetFileDao.instance().findById(empId);
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
