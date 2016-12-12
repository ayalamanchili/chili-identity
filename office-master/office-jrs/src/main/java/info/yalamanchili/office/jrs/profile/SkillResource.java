/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.profile.SkillDao;
import info.yalamanchili.office.entity.profile.Skill;
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
 * @author prani
 */
@Path("secured/skill")
@Component
@Transactional
@Scope("request")
public class SkillResource extends CRUDResource<Skill> {

    @Autowired
    public SkillDao skillDao;

    @PUT
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RECRUITER','ROLE_RELATIONSHIP')")
    @Override
    public Skill save(Skill entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RECRUITER','ROLE_RELATIONSHIP')")
    @CacheEvict(value = OfficeCacheKeys.SKILL, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/{id}")
    @Override
    public Skill read(@PathParam("id") Long id) {
        return super.read(id);
    }

    @GET
    @Path("/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.SKILL)
    public SkillTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        SkillTable tableObj = new SkillTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @GET
    @Path("/search/{searchText}/{start}/{limit}")
    @Transactional(readOnly = true)
    @Override
    public List<Skill> search(@PathParam("searchText") String searchText, @PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("column") List<String> columns) {
        return getDao().search(searchText, start, limit, columns, true, true);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.SKILL)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @Override
    public CRUDDao getDao() {
        return skillDao;
    }//

    @XmlRootElement
    @XmlType
    public static class SkillTable implements java.io.Serializable {

        protected Long size;
        protected List<Skill> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Skill> getEntities() {
            return entities;
        }

        public void setEntities(List<Skill> entities) {
            this.entities = entities;
        }
    }
}
