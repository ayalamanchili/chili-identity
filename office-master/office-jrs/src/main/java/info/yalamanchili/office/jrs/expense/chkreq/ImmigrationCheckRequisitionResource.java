/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.chkreq;

import info.chili.commons.SearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.expense.chkreq.ImmigrationCheckRequisitionDao;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import info.yalamanchili.office.expense.chkreq.ImmigrationCheckRequisitionSaveDto;
import info.yalamanchili.office.expense.chkreq.ImmigrationCheckRequisitionService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/checkrequisition")
@Component
@Transactional
@Scope("request")
public class ImmigrationCheckRequisitionResource extends CRUDResource<ImmigrationCheckRequisition> {

    @Autowired
    public ImmigrationCheckRequisitionDao immigrationCheckRequisitionDao;

    @PUT
    @Validate
    @Path("/submit")
    @PreAuthorize("hasAnyRole('ROLE_GC_IMMIGRATION','ROLE_H1B_IMMIGRATION')")
    @CacheEvict(value = OfficeCacheKeys.IMMIGRATION_CHECK, allEntries = true)
    public void submitImmigrationCheckRequest(ImmigrationCheckRequisitionSaveDto dto) {
        ImmigrationCheckRequisitionService.instance().submitImmigrationCheckRequisition(dto);
    }

    @PUT
    @Validate
    @Path("/save")
    @PreAuthorize("hasAnyRole('ROLE_GC_IMMIGRATION','ROLE_H1B_IMMIGRATION')")
    @CacheEvict(value = OfficeCacheKeys.IMMIGRATION_CHECK, allEntries = true)
    public ImmigrationCheckRequisitionSaveDto save(ImmigrationCheckRequisitionSaveDto dto) {
        ImmigrationCheckRequisitionService.instance().saveImmigrationCheckRequisition(dto);
        return dto;
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_H1B_IMMIGRATION','ROLE_ACCOUNTS_PAYABLE','ROLE_CEO','ROLE_PAYROLL_AND_BENIFITS')")
    public ImmigrationCheckRequisitionSaveDto read(@PathParam("id") Long id) {
        return ImmigrationCheckRequisitionService.instance().read(id);
    }

    @Override
    public CRUDDao getDao() {
        return immigrationCheckRequisitionDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_H1B_IMMIGRATION','ROLE_ACCOUNTS_PAYABLE','ROLE_CEO','ROLE_PAYROLL_AND_BENIFITS')")
    public ImmigrationCheckRequisitionTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ImmigrationCheckRequisitionTable tableObj = new ImmigrationCheckRequisitionTable();
        tableObj.setEntities(immigrationCheckRequisitionDao.queryAll(start, limit));
        tableObj.setSize(immigrationCheckRequisitionDao.size());
        return tableObj;
    }

    @GET
    @Path("/{employeeId}/{start}/{limit}")
    @AccessCheck(companyContacts = {"Perf_Eval_Manager", "Reports_To"}, roles = {"ROLE_ADMIN", "ROLE_CEO", "ROLE_ACCOUNTS_PAYABLE", "ROLE_H1B_IMMIGRATION", "ROLE_PAYROLL_AND_BENIFITS"}, strictOrderCheck = false)
    public ImmigrationCheckRequisitionTable getExpenseReportForEmployee(@PathParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        ImmigrationCheckRequisitionTable tableObj = new ImmigrationCheckRequisitionTable();
        tableObj.setEntities(immigrationCheckRequisitionDao.queryForEmployee(employeeId, start, limit));
        tableObj.setSize(10l);
        return tableObj;
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.IMMIGRATION_CHECK, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        ImmigrationCheckRequisitionService.instance().delete(id);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return ImmigrationCheckRequisitionService.instance().getReport(immigrationCheckRequisitionDao.findById(id));
    }

    @GET
    @Transactional(readOnly = true)
    @Path("/clone/{id}")
    @Override
    public ImmigrationCheckRequisitionSaveDto clone(@PathParam("id") Long id) {
        return ImmigrationCheckRequisitionService.instance().clone(id);
    }

    @GET
    @Path("/check-request-void/{id}")
    public void checkRequisitionVoid(@PathParam("id") Long id) {
        ImmigrationCheckRequisitionService.instance().checkVoidRequest(id);
    }

    @PUT
    @Path("/search-checkreq/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<ImmigrationCheckRequisition> search(ImmigrationCheckRequisition entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<ImmigrationCheckRequisition> res = new ArrayList();
        Query searchQuery = SearchUtils.getSearchQuery(ImmigrationCheckRequisitionDao.instance().getEntityManager(), entity, new SearchUtils.SearchCriteria());
        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(limit);
        for (Object p : searchQuery.getResultList()) {
            res.add((ImmigrationCheckRequisition) p);
        }
        return res;
    }

    @XmlRootElement
    @XmlType
    public static class ImmigrationCheckRequisitionTable implements java.io.Serializable {

        protected Long size;
        protected List<ImmigrationCheckRequisition> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ImmigrationCheckRequisition> getEntities() {
            return entities;
        }

        public void setEntities(List<ImmigrationCheckRequisition> entities) {
            this.entities = entities;
        }
    }
}
