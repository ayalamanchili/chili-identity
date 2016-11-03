/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.commons.SearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.immigration.LCA;
import info.yalamanchili.office.entity.immigration.LCADto;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.LCAService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
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
import org.springframework.transaction.annotation.Propagation;
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
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @Override
    public CRUDDao getDao() {
        return lcaDao;
    }

    @PUT
    @Path("/lca-status-search")
    @Transactional(readOnly = true)
    public List<LCA> prospectStatusSearch(LCA entity) {
        List<LCA> res = new ArrayList();
        Query searchQuery = SearchUtils.getSearchQuery(lcaDao.getEntityManager(), entity, new SearchUtils.SearchCriteria());
        for (Object p : searchQuery.getResultList()) {
            res.add((LCA) p);
        }
        return res;
    }

    @PUT
    @Path("/search-lca/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<LCA> search(LCA entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<LCA> res = new ArrayList();
        Query searchQuery = SearchUtils.getSearchQuery(lcaDao.getEntityManager(), entity, new SearchUtils.SearchCriteria());
        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(limit);
        for (Object p : searchQuery.getResultList()) {
            res.add((LCA) p);
        }
        return res;
    }

    @GET
    @Path("/lca-report")
    public void lcaReport() {
        lcaService.generateLcaReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public LCA read(@PathParam("id") Long id) {
        return lcaDao.findById(id);
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
