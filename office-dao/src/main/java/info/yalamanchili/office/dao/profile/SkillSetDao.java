/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.SkillSet;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
public class SkillSetDao extends CRUDDao<SkillSet> {

    public SkillSetDao() {
        super(SkillSet.class);
    }
    @PersistenceContext
    protected EntityManager em;

    public SkillSet save(SkillSet entity) {
        entity.setLastUpdated(new Date());
        return super.save(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
