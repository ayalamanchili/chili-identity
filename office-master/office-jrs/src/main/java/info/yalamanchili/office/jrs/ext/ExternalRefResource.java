/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.ext;

import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.entity.ext.ExternalRef;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    @Validate
    public void save(ExternalRef externalRef) {
        externalRefDao.save(externalRef);
    }

    @GET
    @Path("/clone/{id}")
    public ExternalRef clone(@PathParam("id") Long id) {
        return externalRefDao.clone(id);
    }

    @PUT
    @Path("/delete")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public void delete(ExternalRef externalRef) {
        externalRefDao.delete(externalRef);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public void delete(@PathParam("id") Long id) {
        externalRefDao.delete(id);
    }

    @GET
    @Path("{start}/{limit}")
    public ExternalRefTable getExternalReferences(@PathParam("start") int start, @PathParam("limit") int limit) {
        ExternalRefTable table = new ExternalRefTable();
        List<ExternalRef> extrefs = externalRefDao.query(start, limit);
        table.setEntities(extrefs);
        table.setSize(externalRefDao.size());
        return table;

    }
    
    
//    @GET
//    @Path("/dropdown/{start}/{limit}")
//    @Transactional(propagation = Propagation.NEVER)
//    @Cacheable(OfficeCacheKeys.SKILL)
//    @Override
//    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
//            @QueryParam("column") List<String> columns) {
//        return super.getDropDown(start, limit, columns);
//    }

    @XmlRootElement
    @XmlType
    public static class ExternalRefTable implements java.io.Serializable {

        protected Long size;
        protected List<ExternalRef> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ExternalRef> getEntities() {
            return entities;
        }

        public void setEntities(List<ExternalRef> entities) {
            this.entities = entities;
        }
    }
}
