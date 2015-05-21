/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.chili.i18n.CDatabaseMessages;
import info.chili.i18n.dao.Ci18nDao;
import info.chili.i18n.domain.Ci18nResource;
import info.chili.i18n.domain.Ci18nResource.Ci18nResourceTable;
import info.chili.i18n.domain.Ci18nResourceBundle;
import info.chili.jpa.validation.Validate;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/i18n")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class CI18nResource {

    @Autowired
    protected Ci18nDao ci18nDao;

    @PUT
    @Path("/bundle")
    @Validate
    @CacheEvict(value = CDatabaseMessages.CMESSAGES_CACHE_REGION, allEntries = true)
    public void saveBundle(Ci18nResourceBundle bundle) {
        ci18nDao.saveBundle(bundle);
    }

    @PUT
    @Path("/bundle/delete/{id}")
    @Validate
    @CacheEvict(value = CDatabaseMessages.CMESSAGES_CACHE_REGION, allEntries = true)
    public void deleteBundle(@PathParam("id") Integer id) {
        ci18nDao.deleteBundle(id);
    }

    @Path("/bundle/{start}/{limit}")
    @GET
    public Ci18nResourceBundle.CResourceBundleTable getBundles(@PathParam("start") int start, @PathParam("limit") int limit) {
        return ci18nDao.getBundles(start, limit);
    }

    @PUT
    @Path("/bundle/resource/{bundleId}")
    @Validate
    @CacheEvict(value = CDatabaseMessages.CMESSAGES_CACHE_REGION, allEntries = true)
    public void addResource(@PathParam("bundleId") Integer bundleId, Ci18nResource resource) {
        ci18nDao.addResource(bundleId, resource);
    }

    @PUT
    @Path("/bundle/resource")
    @Validate
    @CacheEvict(value = CDatabaseMessages.CMESSAGES_CACHE_REGION, allEntries = true)
    public void updateResource(Ci18nResource resource) {
        ci18nDao.updateResource(resource);
    }

    @PUT
    @Path("/bundle/resource/delete/{id}")
    @Validate
    @CacheEvict(value = CDatabaseMessages.CMESSAGES_CACHE_REGION, allEntries = true)
    public void deleteResource(@PathParam("id") Integer id) {
        ci18nDao.deleteResource(id);
    }

    @Path("/bundle/resources/{bundleId}/{start}/{limit}")
    @GET
    public Ci18nResourceTable getResources(@PathParam("bundleId") Integer bundleId, @PathParam("start") int start, @PathParam("limit") int limit) {
        return ci18nDao.getResources(bundleId, start, limit);
    }
}
