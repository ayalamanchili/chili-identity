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
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseAdditionalDetailsDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCaseAdditionalDetails;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.ImmigrationCaseAdditionalDetailsService;
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
 * @author Ramana.Lukalapu
 */
@Path("secured/case-details")
@Component
@Transactional
@Scope("prototype")
public class ImmigrationCaseAdditionalDetailsResource extends CRUDResource<ImmigrationCaseAdditionalDetails> {

    @Autowired
    public ImmigrationCaseAdditionalDetailsDao caseDetailsDao;

    @Autowired
    public ImmigrationCaseAdditionalDetailsService caseDetailsService;

    @PUT
    @Path("/add/{targetId}")
    @Validate
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public void addCaseDetails(@PathParam("targetId") Long targetId, ImmigrationCaseAdditionalDetails caseDetails) {
        caseDetailsService.addCaseDetails(targetId, caseDetails);
    }

    @PUT
    @Path("/update")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Validate
    public ImmigrationCaseAdditionalDetails update(ImmigrationCaseAdditionalDetails caseDetails) {
        ImmigrationCaseAdditionalDetails caseAdditionalDetails = caseDetailsDao.findById(caseDetails.getId());
        caseAdditionalDetails.setCurrentOccupation(caseDetails.getCurrentOccupation());
        caseAdditionalDetails.setNoOfDependents(caseDetails.getNoOfDependents());
        return caseAdditionalDetails;
    }

    @PUT
    @Path("/delete/{id}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Override
    public void delete(@PathParam("id") Long id) {
        ImmigrationCaseAdditionalDetails details = caseDetailsDao.findById(id);
        if (details.getId() != null) {
            caseDetailsDao.delete(id);
        }
    }

    @Override
    public CRUDDao getDao() {
        return null;
    }

}
