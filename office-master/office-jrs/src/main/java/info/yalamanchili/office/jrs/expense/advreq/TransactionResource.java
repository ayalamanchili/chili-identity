/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.advreq;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.expense.advreq.TransactionDao;
import info.yalamanchili.office.entity.expense.Transaction;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/transaction")
@Component
@Transactional
@Scope("request")
public class TransactionResource extends CRUDResource<Transaction> {

    @Autowired
    public TransactionDao transactionDao;

    @PUT
    @Override
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_EXPENSE')")
    public Transaction save(Transaction entity) {
        return super.save(entity);
    }

    @Override
    public CRUDDao getDao() {
        return transactionDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_EXPENSE')")
    public TransactionTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        TransactionTable tableObj = new TransactionTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class TransactionTable implements java.io.Serializable {

        protected Long size;
        protected List<Transaction> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Transaction> getEntities() {
            return entities;
        }

        public void setEntities(List<Transaction> entities) {
            this.entities = entities;
        }
    }
}
