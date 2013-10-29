/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.PreferencesDao;
import info.yalamanchili.office.entity.profile.Preferences;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author yphanikumar
 */
@Path("secured/preferences")
@Component
@Scope("request")
public class PreferencesResource extends CRUDResource<Preferences> {

    @Autowired
    public PreferencesDao preferencesDao;

    @Override
    public CRUDDao getDao() {
        return preferencesDao;
    }
}
