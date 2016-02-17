/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.commons.CollectionsUtils;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.dao.profile.immigration.LCALinkDao;
import info.yalamanchili.office.entity.immigration.LCA;
import info.yalamanchili.office.entity.immigration.LCADto;
import info.yalamanchili.office.entity.immigration.LCALink;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.MultiSelectObj;
import info.yalamanchili.office.profile.immigration.LCAService;
import java.util.ArrayList;
import java.util.Date;
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
    protected LCALinkDao lcaLinkDao;
    @Autowired
    protected EmployeeDao employeeDao;
    @Autowired
    protected LCAService lcaService;

    @PUT
    @Path("/save")
    @Validate
    public LCA save(LCADto lca) {
        return lcaService.saveLCA(lca);
    }

    @PUT
    @Path("/update")
    @Validate
    public LCA update(LCADto lca) {
        return lcaService.updateLCA(lca);
    }

    @GET
    @Path("/group/employees/{groupId}/{start}/{limit}")
    // Todo tune the query
    public MultiSelectObj getGroupEmployees(@PathParam("groupId") Long groupId, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        MultiSelectObj obj = new MultiSelectObj();
        EmployeeDao empDao = (EmployeeDao) SpringContext.getBean(EmployeeDao.class);
        for (Employee emp : empDao.query(start, limit)) {
            obj.addAvailable(emp.getId().toString(), emp.getFirstName() + " " + emp.getLastName());
        }
        if (groupId != 0) {
            LCA lca = lcaDao.findById(groupId);
            for (LCALink link : lcaLinkDao.findLCA(groupId, lca.getClass().getCanonicalName())) {
                if (link.getId() != null) {
                    Employee employee = employeeDao.findById(link.getTargetEntityId());
                    obj.addSelected(employee.getId().toString());
                }
            }
        }
        obj.setAvailable(CollectionsUtils.sortByComparator(obj.getAvailable()));
        return obj;
    }

    @PUT
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        LCA lca = lcaDao.findById(id);
        if (lca.getId() != null) {
            lcaDao.delete(id);
        }
    }

    @GET
    @Path("/{start}/{limit}")
    public LCAResource.LCATable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        LCAResource.LCATable tableObj = new LCAResource.LCATable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @GET
    @Path("/dropdown/{id}/{start}/{limit}")
    public List<Entry> getLCADropDown(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }
    
    @GET
    @Path("/dropdown/{id}")
    public List<Entry> getLCAEmployeeDown(@PathParam("id") long id) {
        Employee emp = EmployeeDao.instance().findById(id);    
        Date todayDate = new Date();
        List<Entry> result = new ArrayList<>();
        for (LCALink lcaLink : lcaLinkDao.findAll(emp)) {
            LCA lca = lcaDao.findById(lcaLink.getSourceEntityId());
            if (todayDate.compareTo(lca.getLcaValidToDate()) <= 0) {
            Entry entry = new Entry();
            entry.setId(lca.getId().toString());
            entry.setValue(lca.getLcaNumber());
            result.add(entry);
            }           
        }
        return result;
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
