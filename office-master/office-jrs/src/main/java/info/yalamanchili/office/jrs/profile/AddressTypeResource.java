/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.profile.AddressTypeDao;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import java.util.ArrayList;
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

@Path("secured/addresstype")
@Component
@Scope("request")
public class AddressTypeResource extends CRUDResource<AddressType> {

    @Autowired
    public AddressTypeDao addressTypeDao;

    @Override
    public CRUDDao getDao() {
        return addressTypeDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.ADDRESS_TYPES)
    public AddressTypeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        AddressTypeTable tableObj = new AddressTypeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.ADDRESS_TYPES, allEntries = true)
    @Override
    @Validate
    public AddressType save(AddressType entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.ADDRESS_TYPES, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.ADDRESS_TYPES)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        List<Entry> res= new ArrayList<>();
        for(Entry e:super.getDropDown(start, limit, columns)){
            if(!e.getValue().trim().equalsIgnoreCase("home")){
                res.add(e);
            }
        }
        return res;
    }

    @XmlRootElement
    @XmlType
    public static class AddressTypeTable implements java.io.Serializable {

        protected Long size;
        protected List<AddressType> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<AddressType> getEntities() {
            return entities;
        }

        public void setEntities(List<AddressType> entities) {
            this.entities = entities;
        }
    }
}
