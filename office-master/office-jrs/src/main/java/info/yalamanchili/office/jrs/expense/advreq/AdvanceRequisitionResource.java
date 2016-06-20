/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.advreq;

import info.chili.commons.SearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.security.domain.CRole;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.expense.advreq.AdvanceRequisitionDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.Transaction;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.expense.advreq.AdvanceRequisitionService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.expense.advreq.TransactionResource.TransactionTable;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
@Path("secured/advancerequisition")
@Component
@Transactional
@Scope("request")
public class AdvanceRequisitionResource extends CRUDResource<AdvanceRequisition> {

    @Autowired
    public AdvanceRequisitionDao advanceRequisitionDao;

    @PUT
    @Validate
    @Path("/submit-advance-requisition-request")
    @CacheEvict(value = OfficeCacheKeys.ADVANCE_REQUSITON, allEntries = true)
    public void submitAdvanceRequisitionRequest(AdvanceRequisition entity) {
        AdvanceRequisitionService.instance().submitAdvanceRequisition(entity);
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    @AccessCheck(companyContacts = {"Perf_Eval_Manager", "Reports_To"}, roles = {"ROLE_ADMIN", "ROLE_CEO", "ROLE_PAYROLL_AND_BENIFITS", "ROLE_ACCOUNTS_PAYABLE", "ROLE_GENERAL_EXPENSE_MANAGER"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public AdvanceRequisition read(@PathParam("id") Long id) {
        return advanceRequisitionDao.findById(id);
    }

    @PUT
    @Validate
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.ADVANCE_REQUSITON, allEntries = true)
    public AdvanceRequisition save(AdvanceRequisition entity) {
        return super.save(entity);
    }

    @PUT
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PAYROLL_AND_BENIFITS','ROLE_ACCOUNTS_PAYABLE','ROLE_GENERAL_EXPENSE_MANAGER')")
    @Path("/transaction/{id}")
    public void addTransaction(@PathParam("id") Long id, Transaction transaction) {
        advanceRequisitionDao.addTransaction(id, transaction);
    }

    @GET
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PAYROLL_AND_BENIFITS','ROLE_ACCOUNTS_PAYABLE','ROLE_GENERAL_EXPENSE_MANAGER')")
    @Path("/transactions/{id}/{start}/{limit}")
    public TransactionTable getTransactions(@PathParam("id") Long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        TransactionTable table = new TransactionTable();
        table.setEntities(advanceRequisitionDao.getTransactions(id, start, limit));
        table.setSize(advanceRequisitionDao.getTransactionsSize(id, start, limit));
        return table;
    }

    @GET
    @Path("/{start}/{limit}")
    public AdvanceRequisitionTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        AdvanceRequisitionTable tableObj = new AdvanceRequisitionTable();
        if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name(), OfficeRoles.OfficeRole.ROLE_ADMIN.name())) {
            tableObj.setEntities(advanceRequisitionDao.queryAll(start, limit));
            tableObj.setSize(advanceRequisitionDao.size());
        } else {
            Employee currentEmp = OfficeSecurityService.instance().getCurrentUser();
            tableObj.setEntities(advanceRequisitionDao.queryForEmployee(currentEmp.getId(), start, limit));
            tableObj.setSize(advanceRequisitionDao.size(currentEmp.getId()));
        }
        return tableObj;
    }

    @PUT
    @Path("/search-advancerequisition/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CEO','ROLE_PAYROLL_AND_BENIFITS','ROLE_ACCOUNTS_PAYABLE','ROLE_GENERAL_EXPENSE_MANAGER')")
    @Transactional(readOnly = true)
    @Override
    public List<AdvanceRequisition> search(AdvanceRequisition entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<AdvanceRequisition> res = new ArrayList();
        Query searchQuery = SearchUtils.getSearchQuery(AdvanceRequisitionDao.instance().getEntityManager(), entity, new SearchUtils.SearchCriteria());
        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(limit);
        for (Object p : searchQuery.getResultList()) {
            res.add((AdvanceRequisition) p);
        }
        return res;
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.ADVANCE_REQUSITON, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        AdvanceRequisitionService.instance().delete(id);
    }

    @GET
    @Path("/{employeeId}/{start}/{limit}")
    @AccessCheck(companyContacts = {"Perf_Eval_Manager", "Reports_To"}, roles = {"ROLE_ADMIN", "ROLE_CEO", "ROLE_PAYROLL_AND_BENIFITS", "ROLE_ACCOUNTS_PAYABLE", "ROLE_GENERAL_EXPENSE_MANAGER"}, strictOrderCheck = false)
    public AdvanceRequisitionTable getAdvanceRequisitionsForEmployee(@PathParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        AdvanceRequisitionTable tableObj = new AdvanceRequisitionTable();
        tableObj.setEntities(advanceRequisitionDao.queryForEmployee(employeeId, start, limit));
        tableObj.setSize(advanceRequisitionDao.size(employeeId));
        return tableObj;
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return AdvanceRequisitionService.instance().getReport(advanceRequisitionDao.findById(id));
    }

    @Override
    public CRUDDao getDao() {
        return advanceRequisitionDao;
    }

    @XmlRootElement
    @XmlType
    public static class AdvanceRequisitionTable implements java.io.Serializable {

        protected Long size;
        protected List<AdvanceRequisition> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<AdvanceRequisition> getEntities() {
            return entities;
        }

        public void setEntities(List<AdvanceRequisition> entities) {
            this.entities = entities;
        }
    }
}
