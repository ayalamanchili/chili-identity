/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.profile.PhoneTypeDao;

import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Path("secured/phonetype")
@Component
@Scope("request")
public class PhoneTypeResource extends CRUDResource<PhoneType> {

    @Autowired
    public PhoneTypeDao phoneTypeDao;

    @Override
    public CRUDDao getDao() {
        return phoneTypeDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.PHONE_TYPE)
    public PhoneTypeResource.PhoneTypeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        PhoneTypeResource.PhoneTypeTable tableObj = new PhoneTypeResource.PhoneTypeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    @CacheEvict(value = OfficeCacheKeys.PHONE_TYPE, allEntries = true)
    @Validate
    public PhoneType save(PhoneType entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    @CacheEvict(value = OfficeCacheKeys.PHONE_TYPE, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.PHONE_TYPE)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @XmlRootElement
    @XmlType
    public static class PhoneTypeTable implements java.io.Serializable {

        protected Long size;
        protected List<PhoneType> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<PhoneType> getEntities() {
            return entities;
        }

        public void setEntities(List<PhoneType> entities) {
            this.entities = entities;
        }
    }
}
