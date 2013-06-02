/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Skill;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;
/**
 *
 * @author raghu
 */
@Component
@Scope("prototype")
public class SkillDao extends CRUDDao<Skill> {
    
    public SkillDao()
    {
      super(Skill.class);
    }
    
   @PersistenceContext
	protected EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
    
}
