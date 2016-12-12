/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.SkillSetFile;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class SkillSetFileDao extends CRUDDao<SkillSetFile> {

    public SkillSetFileDao() {
        super(SkillSetFile.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void delete(Long id) {
        delete(findById(id));
    }
       
    public List<SkillSetFile> findSkillSetFileById(Long id) {
        Query query = em.createQuery("from SkillSetFile where id =:empId");
        query.setParameter("empId", id);
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static SkillSetFileDao instance() {
        return SpringContext.getBean(SkillSetFileDao.class);
    }
}
