/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.ext;

import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.entity.ext.ExternalRef;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/external-ref")
@Component
@Transactional
@Scope("request")
//TODO create abstractREsource for ext
@Produces("application/json")
@Consumes("application/json")
public class ExternalRefResource {

    @Autowired
    public ExternalRefDao externalRefDao;

    @PUT
    @Path("{targetClassName}/{id}")
    public void save(@PathParam("targetClassName") String targetClassName, @PathParam("id") Long id, ExternalRef externalRef) {
        externalRefDao.save(externalRef, id, targetClassName);
    }
}
