/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.company;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.company.CompanyContactTypeDao;
import info.yalamanchili.office.entity.company.CompanyContactType;
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

/**
 *
 * @author ayalamanchili
 */
@Path("secured/companycontacttype")
@Component
@Scope("request")
public class CompanyContactTypeResource extends CRUDResource<CompanyContactType> {

    @Autowired
    public CompanyContactTypeDao companyContactTypeDao;

    @Override
    public CRUDDao getDao() {
        return companyContactTypeDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.CONTACT_TYPE)
    public CompanyContactTypeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        CompanyContactTypeTable tableObj = new CompanyContactTypeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Validate
    @Override
    @CacheEvict(value = OfficeCacheKeys.CONTACT_TYPE, allEntries = true)
    public CompanyContactType save(CompanyContactType entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.CONTACT_TYPE, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.CONTACT_TYPE)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @XmlRootElement
    @XmlType
    public static class CompanyContactTypeTable implements java.io.Serializable {

        protected Long size;
        protected List<CompanyContactType> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<CompanyContactType> getEntities() {
            return entities;
        }

        public void setEntities(List<CompanyContactType> entities) {
            this.entities = entities;
        }
    }
}
