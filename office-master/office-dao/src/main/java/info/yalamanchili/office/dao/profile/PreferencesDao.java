/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Preferences;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yphanikumar
 */
@Repository
@Scope("prototype")
public class PreferencesDao extends CRUDDao<Preferences> {

    @PersistenceContext
    protected EntityManager em;

    public PreferencesDao() {
        super(Preferences.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
