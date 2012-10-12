/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.beans.BeanMapper;
import info.chili.jpa.AbstractEntity;
import info.chili.service.jrs.exception.ServiceException;
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

    
    
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    public SkillSetDao() {
        super(SkillSet.class);
    }
    
    @Override
    public SkillSet save(SkillSet entity) {
        
        if(entity.getResumeUrl()== null){
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "ResumeUrl", "ResumeUrl", "Resume URL can not be null");
        }
        if (entity instanceof AbstractEntity) {
            if (((AbstractEntity) entity).getId() != null) {
                entity = (SkillSet) BeanMapper.merge(entity, findById(((AbstractEntity) entity).getId()));
            }
        }
        return getEntityManager().merge(entity);
    }
}
