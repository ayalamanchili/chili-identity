/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import com.google.common.base.Strings;
import info.chili.commons.FileSearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.security.SecurityUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.profile.SkillSet;
import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
            if (skillSet.getResumeUrl() != null && !skillSet.getResumeUrl().equalsIgnoreCase("ResumeUrl")) {
                extractResumeContent(skillSet.getId());
            }
        }
    }

    @Async
    @Transactional
    public void extractResumeContent(Long skillSetId) {
        SkillSet entity = findById(skillSetId);
        if (!Strings.isNullOrEmpty(entity.getResumeUrl())) {
            String resumeUrl = OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + entity.getResumeUrl();
            resumeUrl = resumeUrl.replace("entityId", entity.getId().toString());
            File file = new File(resumeUrl);
            String resumeContent = FileSearchUtils.extractFileContents(file);
            entity.setResumeContent(resumeContent);
            getEntityManager().merge(entity);
        }
    }

    public SkillSetDao() {
        super(SkillSet.class);
    }

    public SkillSet getCurrentUserSkillSet() {
        TypedQuery<SkillSet> query = em.createQuery("from " + SkillSet.class.getCanonicalName() + " where employee.employeeId=:empIdParam", SkillSet.class);
        query.setParameter("empIdParam", SecurityUtils.getCurrentUser());
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
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
