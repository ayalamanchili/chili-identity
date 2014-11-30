/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.expenserpt;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseCategoryDao;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseCategory;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanthi
 */
@Path("secured/expensecategory")
@Component
@Transactional
@Scope("request")
public class ExpenseCategoryResource extends CRUDResource<ExpenseCategory> {

    @Autowired
    public ExpenseCategoryDao expenseCategoryDao;

    @GET
    @Path("/{start}/{limit}")
    public ExpenseCategoryResource.ExpenseCategoryTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ExpenseCategoryResource.ExpenseCategoryTable tableObj = new ExpenseCategoryResource.ExpenseCategoryTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @Override
    public CRUDDao getDao() {
        return expenseCategoryDao;
    }

    @XmlRootElement
    @XmlType
    public static class ExpenseCategoryTable implements java.io.Serializable{

        protected Long size;
        protected List<ExpenseCategory> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ExpenseCategory> getEntities() {
            return entities;
        }

        public void setEntities(List<ExpenseCategory> entities) {
            this.entities = entities;
        }
    }
}
