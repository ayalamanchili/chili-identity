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
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.SkillSet;
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

    public void createAndAddTag(Long skillSetId, String name) {
        SkillSetTag tag = EntityQueryUtils.findEntity(getEntityManager(), SkillSetTag.class, "name", name.trim());
        if (tag == null) {
            tag = new SkillSetTag();
        }
        tag.setName(name);
        tag = save(tag);
        SkillSetDao.instance().findById(skillSetId).addTag(tag);
    }

    public void addTag(SkillSet skillSet, String name) {
        if (skillSet == null) {
            skillSet = OfficeSecurityService.instance().getCurrentUser().getSkillSet();
        }
        SkillSetTag tag = EntityQueryUtils.findEntity(getEntityManager(), SkillSetTag.class, "name", name.trim());
        if (tag != null && !skillSet.getTags().contains(tag)) {
            skillSet.addTag(tag);
        } else if (skillSet.getTags().contains(tag)) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "tag.already.added", "Tag already added");
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "tag.not.present", "Tag does not exist. Please click Create New Tag");
        }
    }

    public void removeTag(SkillSet skillSet, String name) {
        if (skillSet == null) {
            skillSet = OfficeSecurityService.instance().getCurrentUser().getSkillSet();
        }
        SkillSetTag tag = EntityQueryUtils.findEntity(getEntityManager(), SkillSetTag.class, "name", name.trim());
        if (tag != null) {
            skillSet.removeTag(tag);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "tag.not.present", "Tag does not exist. Please select valid Tag");
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
