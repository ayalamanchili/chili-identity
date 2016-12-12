/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.profile.PhoneDao;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.jrs.CRUDResource;

import java.util.List;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("secured/phone")
@Component
@Transactional
@Scope("request")
public class PhoneResource extends CRUDResource<Phone> {

    @Autowired
    public PhoneDao phoneDao;

    @Override
    public CRUDDao getDao() {
        return phoneDao;
    }
    
    @PUT
    @Path("/delete/{id}")
    @Override
    @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        getDao().delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class PhoneTable implements java.io.Serializable {

        protected Long size;
        protected List<Phone> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Phone> getEntities() {
            return entities;
        }

        public void setEntities(List<Phone> entities) {
            this.entities = entities;
        }

    }
}
