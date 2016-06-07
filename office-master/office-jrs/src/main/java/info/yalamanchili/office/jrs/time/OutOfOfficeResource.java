/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.commons.SearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.Time.OutOfOfficeService;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.OutOfOfficeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Path("secured/out-of-office")
@Component
@Transactional
@Scope("request")
public class OutOfOfficeResource extends CRUDResource<OutOfOfficeRequest> {

    @Autowired
    protected Mapper mapper;

    @Autowired
    public OutOfOfficeDao outOfOfficeDao;

    @Override
    public CRUDDao getDao() {
        return outOfOfficeDao;
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public OutOfOfficeRequest read(@PathParam("id") Long id) {
        return outOfOfficeDao.findById(id);
    }

    @PUT
    @Path("/submit-request/")
    @CacheEvict(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, allEntries = true)
    public void submitRequest(OutOfOfficeRequest outOfOfficeRequest) {
        OutOfOfficeService.instance().submitRequest(outOfOfficeRequest);
    }

    @PUT
    @Validate
    @Path("/update-request")
    @CacheEvict(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, allEntries = true)
    public void updateRequest(OutOfOfficeRequest entity) {
        OutOfOfficeService.instance().updateRequest(entity);
    }

    @GET
    @Path("/{start}/{limit}")
    @CacheEvict(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, allEntries = true)
    public OutOfOfficeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        OutOfOfficeTable tableObj = new OutOfOfficeTable();
        if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name())) {
            tableObj.setEntities(outOfOfficeDao.query(start, limit));
            tableObj.setSize(outOfOfficeDao.size());
        } else {
            Employee currentEmp = OfficeSecurityService.instance().getCurrentUser();
            tableObj.setEntities(outOfOfficeDao.queryForEmployee(currentEmp.getId(), start, limit));
            tableObj.setSize(outOfOfficeDao.size(currentEmp.getId()));
        }
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @GET
    @Path("/{employeeId}/{start}/{limit}")
    @CacheEvict(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, allEntries = true)
    @AccessCheck(companyContacts = {"Reports_To"}, roles = {"ROLE_HR_ADMINSTRATION"}, strictOrderCheck = false)
    public OutOfOfficeResource.OutOfOfficeTable getOutOfOfficeRequestForEmployee(@PathParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        OutOfOfficeResource.OutOfOfficeTable tableObj = new OutOfOfficeResource.OutOfOfficeTable();
        tableObj.setEntities(outOfOfficeDao.queryForEmployee(employeeId, start, limit));
        tableObj.setSize(outOfOfficeDao.size(employeeId));
        return tableObj;
    }

    @GET
    @Path("/current-week/{start}/{limit}")
    @CacheEvict(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, allEntries = true)
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION')")
    public OutOfOfficeResource.OutOfOfficeTable getCurrentWeekRequests(@PathParam("start") int start, @PathParam("limit") int limit) {
        OutOfOfficeResource.OutOfOfficeTable tableObj = new OutOfOfficeResource.OutOfOfficeTable();
        tableObj.setEntities(outOfOfficeDao.queryForCurrentWeekRequests(start, limit));
        tableObj.setSize(outOfOfficeDao.size());
        return tableObj;
    }

    @PUT
    @Path("/search-request/{start}/{limit}")
    @Transactional(readOnly = true)
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION')")
    public List<OutOfOfficeRequest> search(OutOfOfficeRequest entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<OutOfOfficeRequest> res = new ArrayList();
        Query searchQuery = SearchUtils.getSearchQuery(OutOfOfficeDao.instance().getEntityManager(), entity, new SearchUtils.SearchCriteria());
        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(limit);
        for (Object p : searchQuery.getResultList()) {
            res.add((OutOfOfficeRequest) p);
        }
        return res;
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION')")
    @CacheEvict(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        OutOfOfficeService.instance().delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class OutOfOfficeTable implements java.io.Serializable {

        protected Long size;
        protected List<OutOfOfficeRequest> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<OutOfOfficeRequest> getEntities() {
            return entities;
        }

        public void setEntities(List<OutOfOfficeRequest> entities) {
            this.entities = entities;
        }
    }
}
