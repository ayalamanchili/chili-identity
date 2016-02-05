/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.ext.DependentDao;
import info.yalamanchili.office.dto.profile.DependentDto;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.DependentService;
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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/dependent")
@Component
@Transactional
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
public class DependentResource extends CRUDResource<Dependent> {

    @Autowired
    public DependentDao dependentDao;

    @Autowired
    public DependentService dependentService;

    @PUT
    @Path("/update")
    @Validate
    public Dependent save(DependentDto entity) {
        return dependentService.update(entity);
    }

    @PUT
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        dependentDao.delete(id);
    }
    
    @GET
    @Override
    @Path("/{id}")
    public Dependent read(@PathParam("id") Long id) {
        return dependentService.read(id);
    }

    @Override
    public CRUDDao getDao() {
        return null;
    }
    
    @XmlRootElement
    @XmlType
    public static class DependentTable implements java.io.Serializable {

        protected Long size;
        protected List<DependentDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<DependentDto> getEntities() {
            return entities;
        }

        public void setEntities(List<DependentDto> entities) {
            this.entities = entities;
        }
    }
}
