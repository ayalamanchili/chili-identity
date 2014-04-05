/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.recruiting;

import info.chili.commons.EntityQueryUtils;
import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class SkillSetTagDao extends CRUDDao<SkillSetTag> {

    public void addTag(Long skillSetId, String name) {
        SkillSetTag tag = EntityQueryUtils.findEntity(getEntityManager(), SkillSetTag.class, "name", name.trim());
        if (tag != null) {
            SkillSetDao.instance().findById(skillSetId).addTag(tag);
        }
    }

    public void addTag(String name) {
        SkillSetTag tag = EntityQueryUtils.findEntity(getEntityManager(), SkillSetTag.class, "name", name.trim());
        if (tag != null) {
            SkillSetDao.instance().getCurrentUserSkillSet().addTag(tag);
        }
    }

    public void removeTag(String name) {
        SkillSetTag tag = EntityQueryUtils.findEntity(getEntityManager(), SkillSetTag.class, "name", name.trim());
        if (tag != null) {
            SkillSetDao.instance().getCurrentUserSkillSet().removeTag(tag);
        }
    }

    public void removeTag(Long skillSetId, String name) {
        SkillSetTag tag = EntityQueryUtils.findEntity(getEntityManager(), SkillSetTag.class, "name", name.trim());
        if (tag != null) {
            SkillSetDao.instance().findById(skillSetId).removeTag(tag);
        }
    }

    public Set<SkillSetTag> getSkillSetTags() {
        return SkillSetDao.instance().getCurrentUserSkillSet().getTags();
    }

    public Set<SkillSetTag> getSkillSetTags(Long skillSetId) {
        return SkillSetDao.instance().findById(skillSetId).getTags();
    }

    @PersistenceContext
    protected EntityManager em;

    public SkillSetTagDao() {
        super(SkillSetTag.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static SkillSetTagDao instance() {
        return SpringContext.getBean(SkillSetTagDao.class);
    }
}
