/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.recruiting;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
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
