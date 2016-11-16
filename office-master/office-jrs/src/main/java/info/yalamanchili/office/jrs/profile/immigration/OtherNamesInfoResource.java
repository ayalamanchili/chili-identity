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
import info.yalamanchili.office.dao.profile.immigration.OtherNamesInfoDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.OtherNamesInfo;
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
 * @author Rohith.Vallabhaneni
 */
@Path("secured/othernamesinfo")
@Component
@Transactional
@Scope("request")
public class OtherNamesInfoResource extends CRUDResource<OtherNamesInfo> {

    @Autowired
    protected OtherNamesInfoDao otherNamesInfoDao;

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @PUT
    @Path("/save/{caseId}")
    @Validate
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public OtherNamesInfo save(@PathParam("caseId") Long caseId, OtherNamesInfo otherInfo) {
        OtherNamesInfo nameInfo = new OtherNamesInfo();
        nameInfo.setTargetEntityId(caseId);
        nameInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        nameInfo.setFirstName(otherInfo.getFirstName());
        nameInfo.setLastName(otherInfo.getLastName());
        nameInfo.setMiddleName(otherInfo.getMiddleName());
        return otherNamesInfoDao.save(nameInfo);
    }

    @PUT
    @Path("/update")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Validate
    public OtherNamesInfo update(OtherNamesInfo otherInfo) {
        OtherNamesInfo info = otherNamesInfoDao.findById(otherInfo.getId());
        info.setFirstName(otherInfo.getFirstName());
        info.setLastName(otherInfo.getLastName());
        info.setMiddleName(otherInfo.getMiddleName());
        return info;
    }

    @PUT
    @Path("/delete/{id}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Override
    public void delete(@PathParam("id") Long id) {
        OtherNamesInfo info = otherNamesInfoDao.findById(id);
        if (info.getId() != null) {
            otherNamesInfoDao.delete(id);
        }
    }
}
