/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.immigration.DeportationInfoDao;
import info.yalamanchili.office.entity.immigration.DeportationInfo;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.security.AccessCheck;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ramana.Lukalapu
 */
public class DeportationInfoResource extends CRUDResource<DeportationInfo> {

    @Autowired
    protected DeportationInfoDao deportationInfoDao;

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @PUT
    @Path("/save/{caseId}")
    @Validate
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public DeportationInfo save(@PathParam("caseId") Long caseId, DeportationInfo info) {
        DeportationInfo depInfo = new DeportationInfo();
        depInfo.setTargetEntityId(caseId);
        depInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        depInfo.setIsBenfRemProceed(info.getIsBenfRemProceed());
        return deportationInfoDao.save(depInfo);
    }

    @PUT
    @Path("/update")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Validate
    public DeportationInfo update(DeportationInfo info) {
        DeportationInfo depInfo = deportationInfoDao.findById(info.getId());
        depInfo.setIsBenfRemProceed(info.getIsBenfRemProceed());
        return depInfo;
    }

    @PUT
    @Path("/delete/{id}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Override
    public void delete(@PathParam("id") Long id) {
        DeportationInfo info = deportationInfoDao.findById(id);
        if (info.getId() != null) {
            deportationInfoDao.delete(id);
        }
    }
}
