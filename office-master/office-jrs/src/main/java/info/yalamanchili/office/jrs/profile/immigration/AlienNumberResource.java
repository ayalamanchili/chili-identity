/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.immigration.AlienNumberDao;
import info.yalamanchili.office.entity.immigration.AlienNumber;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.security.AccessCheck;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/alien-number")
@Component
@Transactional
@Scope("request")
public class AlienNumberResource extends CRUDResource<AlienNumber> {

    @Autowired
    protected AlienNumberDao alienNumberDao;

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @PUT
    @Path("/save/{caseId}")
    @Validate
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public AlienNumber save(@PathParam("caseId") Long caseId, AlienNumber alienNum) {
        AlienNumber num = new AlienNumber();
        num.setTargetEntityId(caseId);
        num.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        num.setAlienNumber(alienNum.getAlienNumber());
        return alienNumberDao.save(num);
    }

    @PUT
    @Path("/update")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Validate
    public AlienNumber update(AlienNumber alienNum) {
        AlienNumber num = alienNumberDao.findById(alienNum.getId());
        num.setAlienNumber(alienNum.getAlienNumber());
        return num;
    }

    @PUT
    @Path("/delete/{id}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Override
    public void delete(@PathParam("id") Long id) {
        AlienNumber alienNum = AlienNumberDao.instance().findById(id);
        if (alienNum.getId() != null) {
            AlienNumberDao.instance().delete(id);
        }
    }
}
