/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.entity.immigration.LCA;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.LCAService;
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/lca")
@Component
@Transactional
@Scope("request")
public class LCAResource extends CRUDResource<LCA> {

    @Autowired
    protected LCADao lcaDao;
    @Autowired
    protected LCAService lcaService;

    @PUT
    @Override
    @Validate
    public LCA save(LCA lca) {
        return lcaService.saveLCA(lca);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        LCA lca = lcaDao.findById(id);
        if (lca.getId() != null) {
            lcaDao.delete(id);
        }
    }

    @GET
    @Path("{start}/{limit}")
    public LCAResource.LCATable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        LCAResource.LCATable tableObj = new LCAResource.LCATable();
        tableObj.setEntities(lcaDao.query(start, limit));
        tableObj.setSize(lcaDao.size());
        return tableObj;
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    public List<Entry> getLCADropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @Override
    public CRUDDao getDao() {
        return lcaDao;
    }

    @XmlRootElement
    @XmlType
    public static class LCATable implements java.io.Serializable {

        protected Long size;
        protected List<LCA> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<LCA> getEntities() {
            return entities;
        }

        public void setEntities(List<LCA> entities) {
            this.entities = entities;
        }
    }

}
