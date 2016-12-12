/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.travelaurhorization;

import info.chili.commons.SearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.expense.travelauthorization.TravelAuthorizationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.expense.travelauthorization.TravelAuthorizationService;
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
 * @author prasanthi.p
 */
@Path("secured/travel-authorization")
@Component
@Transactional
@Scope("request")
public class TravelAuthorizationResource extends CRUDResource<TravelAuthorization> {

    @Autowired
    public TravelAuthorizationDao travelAuthorizationDao;

    @PUT
    @Validate
    @Override
    public TravelAuthorization save(TravelAuthorization entity) {
        return travelAuthorizationDao.save(entity);
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    @AccessCheck(companyContacts = {"Reports_To", "Perf_Eval_Manager"}, roles = {"ROLE_ADMIN", "ROLE_CEO","ROLE_TRAVEL_BOOKING_MANAGER"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public TravelAuthorization read(@PathParam("id") Long id) {
        return travelAuthorizationDao.findById(id);
    }

    @PUT
    @Validate
    @Path("/submit-travel-expense-request")
    @CacheEvict(value = OfficeCacheKeys.TRAVEL_AUTH, allEntries = true)
    public void submitTravelAuthorizationRequest(TravelAuthorization entity) {
        TravelAuthorizationService.instance().submitTravelAuthorization(entity);
    }

    @GET
    @Path("/{start}/{limit}")
    public TravelAuthorizationResource.TravelAurhorizationTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        TravelAuthorizationResource.TravelAurhorizationTable tableObj = new TravelAuthorizationResource.TravelAurhorizationTable();
        if ((OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_ADMIN.name()))
                || (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name()))
                || (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name()))
                || (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_CEO.name()))) {
            tableObj.setEntities(travelAuthorizationDao.queryAll(start, limit));
            tableObj.setSize(travelAuthorizationDao.size());
        } else {
            Employee currentEmp = OfficeSecurityService.instance().getCurrentUser();
            tableObj.setEntities(travelAuthorizationDao.queryForEmployee(currentEmp.getId(), start, limit));
            tableObj.setSize(travelAuthorizationDao.size(currentEmp.getId()));
        }
        return tableObj;
    }

    @GET
    @Path("/{employeeId}/{start}/{limit}")
    @AccessCheck(companyContacts = {"Perf_Eval_Manager", "Reports_To"}, roles = {"ROLE_ADMIN", "ROLE_CEO", "ROLE_TRAVEL_BOOKING_MANAGER"}, strictOrderCheck = false)
    public TravelAuthorizationResource.TravelAurhorizationTable getTravelAuthorizationsForEmployee(@PathParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        TravelAuthorizationResource.TravelAurhorizationTable tableObj = new TravelAuthorizationResource.TravelAurhorizationTable();
        tableObj.setEntities(travelAuthorizationDao.queryForEmployee(employeeId, start, limit));
        tableObj.setSize(travelAuthorizationDao.size(employeeId));
        return tableObj;
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.TRAVEL_AUTH, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        TravelAuthorizationService.instance().delete(id);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return TravelAuthorizationService.instance().getReport(travelAuthorizationDao.findById(id));
    }

    @Override
    public CRUDDao getDao() {
        return travelAuthorizationDao.instance();
    }

    @PUT
    @Path("/search-travelauth/{start}/{limit}")
    @Transactional(readOnly = true)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CEO','ROLE_PAYROLL_AND_BENIFITS','ROLE_ACCOUNTS_PAYABLE')")
    public List<TravelAuthorization> search(TravelAuthorization entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<TravelAuthorization> res = new ArrayList();
        Query searchQuery = SearchUtils.getSearchQuery(TravelAuthorizationDao.instance().getEntityManager(), entity, new SearchUtils.SearchCriteria());
        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(limit);
        for (Object p : searchQuery.getResultList()) {
            res.add((TravelAuthorization) p);
        }
        return res;
    }

    @XmlRootElement
    @XmlType
    public static class TravelAurhorizationTable implements java.io.Serializable {

        protected Long size;
        protected List<TravelAuthorization> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<TravelAuthorization> getEntities() {
            return entities;
        }

        public void setEntities(List<TravelAuthorization> entities) {
            this.entities = entities;
        }
    }
}
