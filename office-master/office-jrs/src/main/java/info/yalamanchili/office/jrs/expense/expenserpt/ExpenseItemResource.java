/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.expenserpt;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseItemDao;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseItem;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        //TODO is this code duplicated??
        ExpenseItem item = expenseItemDao.findById(id);
        ExpenseReport report = item.getExpenseReport();
        if (report.getExpenseItems().size() == 1) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "min.item.count", "Expense Report should have atleat one item.");
        }
        report.getExpenseItems().remove(item);
        report.updateTotalAmount();
        getDao().delete(id);
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
