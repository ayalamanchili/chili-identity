/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.immigration;

/**
 *
 * @author Madhu.Badiginchala
 */
import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.immigration.Passport;
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
public class PassportDao extends AbstractHandleEntityDao<Passport> {
    
    @PersistenceContext
    protected EntityManager em;

    public PassportDao() {
        super(Passport.class);
    }

    public static PassportDao instance() {
        return SpringContext.getBean(PassportDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
