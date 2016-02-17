/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.immigration;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.immigration.Petition;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class PetitionDao extends CRUDDao<Petition> {

    @PersistenceContext
    protected EntityManager em;

    public PetitionDao() {
        super(Petition.class);
    }

    public static PetitionDao instance() {
        return SpringContext.getBean(PetitionDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
