/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Preferences;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author yphanikumar
 */
@Component
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
