/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.expenserpt;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReportsDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.expense.expenserpt.ExpenseReportSaveDto;
import info.yalamanchili.office.expense.expenserpt.ExpenseReportService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.security.AccessCheck;
import java.util.List;
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
 * @author Prasanthi.p
 */
@Path("secured/expensereport")
@Component
@Transactional
@Scope("request")
public class ExpenseReportResource extends CRUDResource<ExpenseReport> {

    @Autowired
    public ExpenseReportsDao expenseReportsDao;

    @PUT
    @Validate
    @Path("/submit")
    @CacheEvict(value = OfficeCacheKeys.EXPENSE, allEntries = true)
    public ExpenseReportSaveDto submit(ExpenseReportSaveDto dto) {
        return ExpenseReportService.instance().submit(dto);
    }

    @PUT
    @Validate
    @Path("/save")
    public ExpenseReportSaveDto save(ExpenseReportSaveDto dto) {
        return ExpenseReportService.instance().save(dto);
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public ExpenseReportSaveDto read(@PathParam("id") Long id) {
        return ExpenseReportService.instance().read(id);
    }

    @GET
    @Path("/{start}/{limit}")
    public ExpenseReportResource.ExpenseReportsTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ExpenseReportResource.ExpenseReportsTable tableObj = new ExpenseReportResource.ExpenseReportsTable();
        if ((OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_ADMIN.name()))
                || (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name()))
                || (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_CEO.name()))) {
            tableObj.setEntities(expenseReportsDao.queryAll(start, limit));
            tableObj.setSize(expenseReportsDao.size());
        } else {
            Employee currentEmp = OfficeSecurityService.instance().getCurrentUser();
            tableObj.setEntities(expenseReportsDao.queryForEmployee(currentEmp.getId(), start, limit));
            tableObj.setSize(expenseReportsDao.size(currentEmp.getId()));
        }
        return tableObj;
    }

    @GET
    @Path("/{employeeId}/{start}/{limit}")
    @AccessCheck(companyContacts = {"Perf_Eval_Manager", "Reports_To"}, roles = {"ROLE_ADMIN"})
    public ExpenseReportResource.ExpenseReportsTable getExpenseReportForEmployee(@PathParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        ExpenseReportResource.ExpenseReportsTable tableObj = new ExpenseReportResource.ExpenseReportsTable();
        tableObj.setEntities(expenseReportsDao.queryForEmployee(employeeId, start, limit));
        tableObj.setSize(expenseReportsDao.size(employeeId));
        return tableObj;
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.EXPENSE, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        ExpenseReportService.instance().delete(id);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return ExpenseReportService.instance().getReport(id);
    }

    @Override
    public CRUDDao getDao() {
        return expenseReportsDao.instance();
    }

    @XmlRootElement
    @XmlType
    public static class ExpenseReportsTable implements java.io.Serializable {

        protected Long size;
        protected List<ExpenseReport> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ExpenseReport> getEntities() {
            return entities;
        }

        public void setEntities(List<ExpenseReport> entities) {
            this.entities = entities;
        }
    }
}
