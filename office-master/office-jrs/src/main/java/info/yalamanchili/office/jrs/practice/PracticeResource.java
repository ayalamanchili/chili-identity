/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.practice;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.practice.PracticeDao;
import info.yalamanchili.office.entity.practice.Practice;
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
    public PracticeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        PracticeTable tableObj = new PracticeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class PracticeTable {

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
