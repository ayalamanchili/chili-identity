/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.recruiting;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.types.Entry;
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

    @PUT
    @Path("/add-tag/{tag}")
    public void addTag(@PathParam("tag") String name) {
        skillSetTagDao.addTag(name);
    }

    @PUT
    @Path("/add-tag/{skillSetId}/{tag}")
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER')")
    public void addTag(@PathParam("skillSetId") Long skillSetId, @PathParam("tag") String name) {
        skillSetTagDao.addTag(skillSetId, name);
    }

    @PUT
    @Path("/remove-tag/{tag}")
    public void removeTag(@PathParam("tag") String name) {
        skillSetTagDao.removeTag(name);
    }

    @PUT
    @Path("/remove-tag/{skillSetId}/{tag}")
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER')")
    public void removeTag(@PathParam("skillSetId") Long skillSetId, @PathParam("tag") String name) {
        skillSetTagDao.removeTag(skillSetId, name);
    }

    @PUT
    @Override
    public SkillSetTag save(SkillSetTag entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER')")
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
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @GET
    @Path("/{start}/{limit}")
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
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER')")
    @Transactional(readOnly = true)
    public String getSkillSetTags(@PathParam("skillSetId") Long skillSetId) {
        return mapTags(skillSetTagDao.getSkillSetTags(skillSetId));
    }

    protected String mapTags(Set<SkillSetTag> tags) {
        StringBuilder res = new StringBuilder();
        for (SkillSetTag tag : tags) {
            res.append(tag.getName());
            res.append(" ");
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
    public static class SkillSetTagTable {

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
