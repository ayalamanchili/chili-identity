/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.EmergencyContactDao;
import info.yalamanchili.office.dto.profile.EmergencyContactDto;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.EmergencyContactService;

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

@Path("secured/emergencycontact")
@Component
@Transactional
@Scope("request")
public class EmergencyContactResource extends CRUDResource<EmergencyContactDto> {

    @Autowired
    public EmergencyContactDao emergencyContactDao;
    @Autowired
    public EmergencyContactService emergencyContactService;

    @Override
    public CRUDDao getDao() {
        return emergencyContactDao;
    }

    @PUT
    @Validate
    public EmergencyContactDto save(EmergencyContactDto entity) {
        return emergencyContactService.update(entity);
    }

    @GET
    @Override
    @Path("/{id}")
    public EmergencyContactDto read(@PathParam("id") Long id) {
        return emergencyContactService.read(id);
    }

    @XmlRootElement
    @XmlType
    public static class EmergencyContactTable implements java.io.Serializable{

        protected Long size;
        protected List<EmergencyContactDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<EmergencyContactDto> getEntities() {
            return entities;
        }

        public void setEntities(List<EmergencyContactDto> entities) {
            this.entities = entities;
        }
    }
}
