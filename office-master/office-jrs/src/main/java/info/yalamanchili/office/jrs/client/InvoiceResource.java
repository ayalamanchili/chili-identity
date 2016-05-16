/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.client.InvoiceDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/invoice")
@Component
@Scope("prototype")
public class InvoiceResource extends CRUDResource<Invoice> {

    @Autowired
    public InvoiceDao invoiceDao;

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected Mapper mapper;

    @Override
    public CRUDDao getDao() {
        return invoiceDao;
    }

    @GET
    @Path("/{id}/{start}/{limit}")
    public InvoiceResource.InvoiceTable table(@PathParam("id") Long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        InvoiceResource.InvoiceTable tableObj = new InvoiceResource.InvoiceTable();
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        tableObj.setEntities(ci.getInvoice());
        tableObj.setSize(Long.valueOf(ci.getInvoice().size()));
        return tableObj;
    }

    @PUT
    @Validate
    @Path("/save/{id}")
    public Invoice saveInvoice(@PathParam("id") Long id, Invoice invoice) {
        Invoice inv = new Invoice();
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        inv.setEmployee(ci.getEmployee().getFirstName());
        inv.setStartDate(invoice.getStartDate());
        inv.setEndDate(invoice.getEndDate());
        inv.setBillingRate(invoice.getBillingRate());
        inv.setOverTimeBillingRate(invoice.getOverTimeBillingRate());
        inv.setItemNumber(invoice.getItemNumber());
        inv.setInvoiceFrequency(invoice.getInvoiceFrequency());
        inv.setInvoiceDate(invoice.getInvoiceDate());
        inv.setHours(invoice.getHours());
        inv.setStatus(invoice.getStatus());
        inv.setTimeSheetStatus(invoice.getTimeSheetStatus());
        inv.setInvoiceNumber(invoice.getInvoiceNumber());
        inv.setNotes(invoice.getNotes());
        inv.setClientInformation(ci);
        ClientInformationDao.instance().save(ci);
        InvoiceDao.instance().save(inv);
        return invoice;
    }

    @PUT
    @Validate
    @Path("/update-Invoice/{id}")
    public Invoice update(@PathParam("id") Long id, Invoice invoice) {
        Invoice inv = invoiceDao.findById(id);
        inv.setEmployee(invoice.getEmployee());
        inv.setStartDate(invoice.getStartDate());
        inv.setEndDate(invoice.getEndDate());
        inv.setBillingRate(invoice.getBillingRate());
        inv.setOverTimeBillingRate(invoice.getOverTimeBillingRate());
        inv.setItemNumber(invoice.getItemNumber());
        inv.setInvoiceFrequency(invoice.getInvoiceFrequency());
        inv.setInvoiceDate(invoice.getInvoiceDate());
        inv.setHours(invoice.getHours());
        inv.setStatus(invoice.getStatus());
        inv.setTimeSheetStatus(invoice.getTimeSheetStatus());
        inv.setInvoiceNumber(invoice.getInvoiceNumber());
        inv.setNotes(invoice.getNotes());
        inv.setId(id);
        em.merge(inv);
        return inv;
    }

    @GET
    @Path("/clone/{id}")
    @Override
    public Invoice clone(@PathParam("id") Long id) {
        return invoiceDao.clone(id);
    }

    @GET
    @Path("/read/{id}")
    public Invoice readInvoice(@PathParam("id") Long id) {
        return invoiceDao.findById(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);

    }

    @XmlRootElement
    @XmlType
    public static class InvoiceTable implements java.io.Serializable {

        protected Long size;
        protected List<Invoice> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Invoice> getEntities() {
            return entities;
        }

        public void setEntities(List<Invoice> entities) {
            this.entities = entities;
        }
    }
}
