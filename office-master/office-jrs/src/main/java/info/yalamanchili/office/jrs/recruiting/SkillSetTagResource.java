/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.recruiting;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.dao.recruiting.SkillSetTagDao;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import java.util.Set;
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
 * @author prasanthi.p
 */
@Path("secured/skillsettag")
@Component
@Scope("request")
public class SkillSetTagResource extends CRUDResource<SkillSetTag> {

    @Autowired
    public SkillSetDao skillSetDao;

    @PUT
    @Path("/create-add-tag/{skillSetId}/{tag}")
    @CacheEvict(value = OfficeCacheKeys.SKILL_SET_TAG, allEntries = true)
    public void createAndAddTag(@PathParam("skillSetId") Long skillSetId, @PathParam("tag") String name) {
        skillSetTagDao.createAndAddTag(skillSetId, name);
    }

    @PUT
    @Path("/add-tag/{tag}")
    public void addTag(@QueryParam("skillSetId") Long skillSetId, @PathParam("tag") String name) {
        if (skillSetId == null) {
            skillSetTagDao.addTag(null, name);
        } else {
            skillSetTagDao.addTag(skillSetDao.findById(skillSetId), name);
        }

    }

    @PUT
    @Path("/remove-tag/{tag}")
    public void removeTag(@QueryParam("skillSetId") Long skillSetId, @PathParam("tag") String name) {
        if (skillSetId == null) {
            skillSetTagDao.removeTag(null, name);
        } else {
            skillSetTagDao.removeTag(skillSetDao.findById(skillSetId), name);
        }
    }

    @PUT
    @Validate
    @Override
    @CacheEvict(value = OfficeCacheKeys.SKILL_SET_TAG, allEntries = true)
    public SkillSetTag save(SkillSetTag entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER')")
    @CacheEvict(value = OfficeCacheKeys.SKILL_SET_TAG, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/{id}")
    @Override
    public SkillSetTag read(@PathParam("id") Long id) {
        return super.read(id);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Cacheable(OfficeCacheKeys.SKILL_SET_TAG)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @GET
    @Path("/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.SKILL_SET_TAG)
    public SkillSetTagTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        SkillSetTagTable tableObj = new SkillSetTagTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @GET
    @Path("/tags")
    @Transactional(readOnly = true)
    public String getSkillSetTags() {
        return mapTags(skillSetTagDao.getSkillSetTags());
    }

    @GET
    @Path("/tags/{skillSetId}")
    @Transactional(readOnly = true)
    public String getSkillSetTags(@PathParam("skillSetId") Long skillSetId) {
        return mapTags(skillSetTagDao.getSkillSetTags(skillSetId));
    }

    protected String mapTags(Set<SkillSetTag> tags) {
        StringBuilder res = new StringBuilder();
        int countT = tags.size();
        for (SkillSetTag tag : tags) {
            res.append(tag.getName());
            if (countT > 1) {
                res.append(",  ");
                countT--;
            }

        }
        return res.toString();
    }

    @Autowired
    public SkillSetTagDao skillSetTagDao;

    @Override
    public CRUDDao getDao() {
        return skillSetTagDao;
    }

    @XmlRootElement
    @XmlType
    public static class SkillSetTagTable implements java.io.Serializable {

        protected Long size;
        protected List<SkillSetTag> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<SkillSetTag> getEntities() {
            return entities;
        }

        public void setEntities(List<SkillSetTag> entities) {
            this.entities = entities;
        }
    }
}
