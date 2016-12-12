/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.audit;

import info.chili.audit.AuditService;
import info.chili.service.jrs.types.EntityAuditDataTbl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/audit")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class AuditResource {


    @GET
    @Path("/changes/{entityClass}/{id}")
    public EntityAuditDataTbl getChangesForEntity(@PathParam("entityClass") String entityClass, @PathParam("id") Long id, @QueryParam("ingoreField") List<String> ingoreFields) {
        return AuditService.instance().getRecentChanges(entityClass, id, ingoreFields);
    }
}
