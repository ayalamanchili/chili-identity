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
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bhavana.Atluri
 */
@Path("secured/immigrationcase")
@Component
@Transactional
@Scope("request")
public class ImmigrationCaseResource extends CRUDResource<ImmigrationCase> {

    @Autowired
    protected ImmigrationCaseDao immigrationCaseDao;

    @Override
    public CRUDDao getDao() {
        return immigrationCaseDao;
    }

    @PUT
    @Path("/{employeeId}")
    @Validate
    public ImmigrationCase save(@PathParam("employeeId") Long employeeId, ImmigrationCase entity) {
        entity.setEmployee(EmployeeDao.instance().findById(employeeId));
        entity.setCreatedBy(OfficeSecurityService.instance().getCurrentUserName());
        return immigrationCaseDao.save(entity);
    }

}
