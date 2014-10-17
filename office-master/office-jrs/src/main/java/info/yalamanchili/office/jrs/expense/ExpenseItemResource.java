/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.expense.ExpenseItemDao;
import info.yalamanchili.office.entity.expense.ExpenseItem;
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
 * @author Prasanthi.p
 */
@Path("secured/expenseitem")
@Component
@Transactional
@Scope("request")
public class ExpenseItemResource extends CRUDResource<ExpenseItem> {

    @Autowired
    public ExpenseItemDao expenseItemDao;

    @GET
    @Path("/{start}/{limit}")
    public ExpenseItemResource.ExpenseItemTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ExpenseItemResource.ExpenseItemTable tableObj = new ExpenseItemResource.ExpenseItemTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @Override
    public CRUDDao getDao() {
        return expenseItemDao;
    }

    @XmlRootElement
    @XmlType
    public static class ExpenseItemTable implements java.io.Serializable {

        protected Long size;
        protected List<ExpenseItem> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ExpenseItem> getEntities() {
            return entities;
        }

        public void setEntities(List<ExpenseItem> entities) {
            this.entities = entities;
        }
    }
}
