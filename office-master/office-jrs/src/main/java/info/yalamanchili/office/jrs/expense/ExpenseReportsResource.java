/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.expense.ExpenseReportsDao;
import info.yalamanchili.office.entity.expense.ExpenseReport;
import info.yalamanchili.office.expense.ExpeneseReportSaveDto;
import info.yalamanchili.office.expense.ExpenseReportsService;
import info.yalamanchili.office.jrs.CRUDResource;
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
public class ExpenseReportsResource extends CRUDResource<ExpenseReport> {

    @PUT
    @Validate
    @Path("/save")
    @CacheEvict(value = OfficeCacheKeys.EXPENSE, allEntries = true)
    public ExpenseReport save(ExpeneseReportSaveDto dto) {
        return ExpenseReportsService.instance().save(dto);
    }

    @GET
    @Path("/{start}/{limit}")
    public ExpenseReportsResource.ExpenseReportsTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ExpenseReportsResource.ExpenseReportsTable tableObj = new ExpenseReportsResource.ExpenseReportsTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.EXPENSE, allEntries = true)
    @Override
    public void delete(@PathParam("id") Long id) {
        ExpenseReportsService.instance().delete(id);
    }

    @GET
    @Path("/report")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return ExpenseReportsService.instance().getReport(id);
    }

    @Override
    public CRUDDao getDao() {
        return ExpenseReportsDao.instance();
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
