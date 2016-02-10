/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.immigration.LCA;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.profile.immigration.LCAService;
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
public class LCAResource {

    @Autowired
    protected LCADao lcaDao;
    @Autowired
    protected LCAService lcaService;

    @PUT
    @Path("/save/{empId}")
    @Validate
    public LCA save(@PathParam("empId") Long empId, LCA lca) {
        return lcaService.saveLCA(empId, lca);
    }

    @PUT
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        LCA lca = lcaDao.find(id);
        if (lca.getId() != null) {
            lcaDao.delete(id);
        }
    }

    @GET
    @Path("/{id}/{start}/{limit}")
    public LCAResource.LCATable table(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        LCAResource.LCATable tableObj = new LCAResource.LCATable();
        Employee emp = EmployeeDao.instance().findById(id);
        tableObj.setEntities(lcaDao.findAll(emp));
        tableObj.setSize(lcaDao.size());
        return tableObj;
    }

    @GET
    @Path("/dropdown/{id}/{start}/{limit}")
    public List<Entry> getLCADropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        Employee emp = EmployeeDao.instance().findById(id);
        return getLCAColumnDropDown(lcaDao.findAll(emp));
    }

    protected List<Entry> getLCAColumnDropDown(List<LCA> lcas) {
        List<Entry> result = new ArrayList<>();
        for (LCA lca : lcas) {
            Entry entry = new Entry();
            entry.setId(lca.getId().toString());
            entry.setValue(lca.getLcaNumber());
            result.add(entry);
        }
        return result;
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
