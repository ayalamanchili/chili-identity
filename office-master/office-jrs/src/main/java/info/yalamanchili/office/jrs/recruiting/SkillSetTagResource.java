/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.recruiting;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.recruiting.SkillSetTagDao;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/skillsettag")
@Component
@Scope("request")
public class SkillSetTagResource extends CRUDResource<SkillSetTag> {

    @GET
    @Path("/{start}/{limit}")
    public SkillSetTagTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        SkillSetTagTable tableObj = new SkillSetTagTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
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
