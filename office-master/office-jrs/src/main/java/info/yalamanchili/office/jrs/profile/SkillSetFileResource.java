/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.dao.profile.SkillSetFileDao;
import info.yalamanchili.office.entity.profile.SkillSetFile;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/resumeUrl")
@Component
@Transactional
@Scope("request")
public class SkillSetFileResource extends CRUDResource<SkillSetFile> {

    @Autowired
    public SkillSetFileDao skillSetResumeDao;

    @Override
    public CRUDDao getDao() {
        return skillSetResumeDao;
    }

    @GET
    @Path("/resume/{resumeId}")
    public Set<SkillSetFile> getDocuments(@PathParam("resumeId") Long resumeId) {
        return new HashSet(SkillSetDao.instance().findById(resumeId).getSkillSetFile());
    }
}
