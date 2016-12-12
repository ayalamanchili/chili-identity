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
import info.yalamanchili.office.dao.profile.immigration.PetitionDao;
import info.yalamanchili.office.entity.immigration.Petition;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.PetitionService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/petition")
@Component
@Transactional
@Scope("request")
public class PetitionResource extends CRUDResource<Petition> {

    @Autowired
    protected PetitionDao petitionDao;
    @Autowired
    protected PetitionService petitionService;

    @PUT
    @Path("/save/{id}")
    @Validate
    public Petition save(@PathParam("id") Long empId, Petition dto) {
        return petitionService.savePetition(empId, dto);
    }
    
    @PUT
    @Path("/update/{id}")
    @Validate
    public Petition update(@PathParam("id") Long empId, Petition dto) {
        return petitionService.updatePetition(empId, dto);
    }

    @PUT
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        Petition petition = petitionDao.findById(id);
        if (petition.getId() != null) {
            petitionDao.delete(id);
        }
    }

    @GET
    @Path("/{start}/{limit}")
    public PetitionResource.PetitionTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        PetitionResource.PetitionTable tableObj = new PetitionResource.PetitionTable();
        tableObj.setEntities(petitionDao.query(start, limit));
        tableObj.setSize(petitionDao.size());
        return tableObj;
    }

    @Override
    public CRUDDao getDao() {
        return petitionDao;
    }

    @XmlRootElement
    @XmlType
    public static class PetitionTable implements java.io.Serializable {

        protected Long size;
        protected List<Petition> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Petition> getEntities() {
            return entities;
        }

        public void setEntities(List<Petition> entities) {
            this.entities = entities;
        }
    }

}
