/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.practice;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.practice.PracticeDao;
import info.yalamanchili.office.entity.practice.Practice;
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
 * @author Prashanthi
 */
@Path("secured/practice")
@Component
@Scope("request")
public class PracticeResource extends CRUDResource<Practice> {

    @Autowired
    public PracticeDao pracitceDao;

    @Override
    public CRUDDao getDao() {
        return pracitceDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.PRACTICE)
    public PracticeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        PracticeTable tableObj = new PracticeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RECRUITER')")
    @CacheEvict(value = OfficeCacheKeys.PRACTICE, allEntries = true)
    @Override
    public Practice save(Practice entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RECRUITER')")
    @CacheEvict(value = OfficeCacheKeys.PRACTICE, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.PRACTICE)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @XmlRootElement
    @XmlType
    public static class PracticeTable implements java.io.Serializable{

        protected Long size;
        protected List<Practice> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Practice> getEntities() {
            return entities;
        }

        public void setEntities(List<Practice> entities) {
            this.entities = entities;
        }
    }
}
