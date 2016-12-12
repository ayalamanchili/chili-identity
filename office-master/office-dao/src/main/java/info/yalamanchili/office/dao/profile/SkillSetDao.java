/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.commons.FileSearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.profile.SkillSetFile;
import info.yalamanchili.office.entity.profile.SkillSetFileType;
import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghu
 */
@Repository
@Scope("prototype")
public class SkillSetDao extends CRUDDao<SkillSet> {

    @Async
    @Transactional
    public void indexAllResumes() {
        for (SkillSet skillSet : query(0, 2000)) {
            if (skillSet.getSkillSetFile().size() > 0) {
                extractResumeContent(skillSet.getId());
            }
        }
    }

    @Async
    @Transactional
    public void extractResumeContent(Long skillSetId) {
        SkillSet entity = findById(skillSetId);
        if (entity.getSkillSetFile().size() > 0) {
            for (SkillSetFile sfile : entity.getSkillSetFile()) {
                if ((SkillSetFileType.Resume.name().equals(sfile.getName()) || ((sfile.getName() == null)))) {
                    String resumeUrl = OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + sfile.getFileURL();
                    resumeUrl = resumeUrl.replace("entityId", sfile.getId().toString());
                    File file = new File(resumeUrl);
                    String resumeContent = FileSearchUtils.extractFileContents(file);
                    entity.setResumeContent(entity.getResumeContent() + resumeContent);
                    getEntityManager().merge(entity);
                }
            }
        }
    }

    public SkillSetDao() {
        super(SkillSet.class);
    }

    public SkillSet getCurrentUserSkillSet() {
        return OfficeSecurityService.instance().getCurrentUser().getSkillSet();
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static SkillSetDao instance() {
        return SpringContext.getBean(SkillSetDao.class);
    }
}
