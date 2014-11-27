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
import info.yalamanchili.office.dao.expense.ExpenseDao;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.entity.expense.Expense;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghu
 */
@Path("secured/expense")
@Component
@Transactional
@Scope("request")
public class ExpenseResource extends CRUDResource<Expense> {

    @Autowired
    public ExpenseDao expenseDao;

    @Override
    public CRUDDao getDao() {
        return expenseDao;
    }

    @GET
    @Validate
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public ExpenseTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ExpenseTable tableObj = new ExpenseTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class ExpenseTable implements java.io.Serializable{

        protected Long size;
        protected List<Expense> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Expense> getEntities() {
            return entities;
        }

        public void setEntities(List<Expense> entities) {
            this.entities = entities;
        }
    }
}
