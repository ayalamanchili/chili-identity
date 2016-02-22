/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.commons.EntityQueryUtils;
import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Skill;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

/**
 *
 * @author raghu
 */
@Repository
@Scope("prototype")
public class SkillDao extends CRUDDao<Skill> {

    public SkillDao() {
        super(Skill.class);
    }

    @PersistenceContext
    protected EntityManager em;

    public void addSkill(String name) {
        Skill skill = EntityQueryUtils.findEntity(getEntityManager(), Skill.class, "name", name.trim());
        if (skill != null) {
            SkillSetDao.instance().getCurrentUserSkillSet().addSkill(skill);
        }
    }

    public void addSkill(Long skillSetId, String name) {
        Skill skill = EntityQueryUtils.findEntity(getEntityManager(), Skill.class, "name", name.trim());
        if (skill != null) {
            SkillSetDao.instance().findById(skillSetId).addSkill(skill);
        }
    }

    public void removeSkill(String name) {
        Skill skill = EntityQueryUtils.findEntity(getEntityManager(), Skill.class, "name", name.trim());
        if (skill != null) {
            SkillSetDao.instance().getCurrentUserSkillSet().removeSkill(skill);
        }
    }

    public void removeSkill(Long skillSetId, String name) {
        Skill skill = EntityQueryUtils.findEntity(getEntityManager(), Skill.class, "name", name.trim());
        if (skill != null) {
            SkillSetDao.instance().findById(skillSetId).removeSkill(skill);
        }
    }

    public Set<Skill> getSkills() {
        return SkillSetDao.instance().getCurrentUserSkillSet().getSkills();
    }

    public Set<Skill> getSkillS(Long skillSetId) {
        return SkillSetDao.instance().findById(skillSetId).getSkills();
    }

    public void addCertification(String name) {
        Certification cert = EntityQueryUtils.findEntity(getEntityManager(), Certification.class, "name", name.trim());
        if (cert != null) {
            SkillSetDao.instance().getCurrentUserSkillSet().addCertification(cert);
        }
    }

    public void addCertification(Long skillSetId, String name) {
        Certification cert = EntityQueryUtils.findEntity(getEntityManager(), Certification.class, "name", name.trim());
        if (cert != null) {
            SkillSetDao.instance().findById(skillSetId).addCertification(cert);
        }
    }

    public void removeCertification(String name) {
        Certification cert = EntityQueryUtils.findEntity(getEntityManager(), Certification.class, "name", name.trim());
        if (cert != null) {
            SkillSetDao.instance().getCurrentUserSkillSet().removeCertification(cert);
        }
    }

    public void removeCertification(Long skillSetId, String name) {
        Certification cert = EntityQueryUtils.findEntity(getEntityManager(), Certification.class, "name", name.trim());
        if (cert != null) {
            SkillSetDao.instance().findById(skillSetId).removeCertification(cert);
        }
    }

    public Set<Certification> getCertifications() {
        return SkillSetDao.instance().getCurrentUserSkillSet().getCertifications();
    }

    public Set<Certification> getCertifications(Long skillSetId) {
        return SkillSetDao.instance().findById(skillSetId).getCertifications();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static SkillDao instance() {
        return SpringContext.getBean(SkillDao.class);
    }

}
