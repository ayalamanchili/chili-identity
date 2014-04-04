/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.recruiting;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.recruiting.SkillSetTagDao;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.Path;
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
public class SkillSetTagResource extends CRUDResource<SkillSetTagResource> {

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
        protected List<SkillSetTagResource> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<SkillSetTagResource> getEntities() {
            return entities;
        }

        public void setEntities(List<SkillSetTagResource> entities) {
            this.entities = entities;
        }
    }
}
