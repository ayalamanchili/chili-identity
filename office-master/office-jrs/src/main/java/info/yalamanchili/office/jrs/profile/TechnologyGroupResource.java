/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.TechnologyGroupDao;
import info.yalamanchili.office.entity.profile.TechnologyGroup;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Path("secured/technologyGroup")
@Component
@Scope("request")
public class TechnologyGroupResource extends CRUDResource<TechnologyGroup> {

    @Autowired
    public TechnologyGroupDao technologyGroupDao;

    @Override
    public CRUDDao getDao() {
        return technologyGroupDao;
    }
}
