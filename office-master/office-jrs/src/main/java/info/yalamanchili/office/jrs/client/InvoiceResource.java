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
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.invoice.InvoiceSearchDto;
import info.yalamanchili.office.invoice.InvoiceService;
import info.yalamanchili.office.invoice.InvoiceService.InvoiceTable;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER')")
    public InvoiceTable table(@PathParam("id") Long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        InvoiceTable tableObj = new InvoiceTable();
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        tableObj.setEntities(ci.getInvoice());
        tableObj.setSize(Long.valueOf(ci.getInvoice().size()));
        return tableObj;
    }

    @GET
    @Path("/{start}/{limit}")
    //TODO add invoice mgr role check using pre auth
    //TODO caching?
    public InvoiceTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        InvoiceTable tableObj = new InvoiceTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Path("/save/{id}")
    //TODO add invoice mgr role check using pre auth
    public Invoice saveInvoice(@PathParam("id") Long id, Invoice invoice) {
        Invoice inv = new Invoice();
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        inv.setEmployee(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
        inv.setStartDate(invoice.getStartDate());
        inv.setEndDate(invoice.getEndDate());
        inv.setBillingRate(invoice.getBillingRate());
        inv.setOverTimeBillingRate(invoice.getOverTimeBillingRate());
        inv.setItemNumber(invoice.getItemNumber());
        inv.setInvoiceFrequency(invoice.getInvoiceFrequency());
        inv.setInvoiceDate(invoice.getInvoiceDate());
        inv.setHours(invoice.getHours());
        inv.setInvoiceStatus(invoice.getInvoiceStatus());
        inv.setTimeSheetStatus(invoice.getTimeSheetStatus());
        inv.setInvoiceNumber(invoice.getInvoiceNumber());
        inv.setNotes(invoice.getNotes());
        inv.setClientInformation(ci);
        ClientInformationDao.instance().save(ci);
        InvoiceDao.instance().save(inv);
        //sendInvoiceCreatedNotification(inv);
        return invoice;
    }

    @PUT
    @Validate
    @Path("/update-Invoice/{id}")
    //TODO add invoice mgr role check using pre auth
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
        inv.setInvoiceStatus(invoice.getInvoiceStatus());
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
    //TODO add invoice mgr role check using pre auth
    public Invoice readInvoice(@PathParam("id") Long id) {
        return invoiceDao.findById(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    //TODO add invoice mgr role check using pre auth
    public void delete(@PathParam("id") Long id) {
        super.delete(id);

    }

    @GET
    @Path("/search/{searchText}/{start}/{limit}")
    @Transactional(readOnly = true)
    @Override
    //TODO add invoice mgr role check using pre auth
    public List<Invoice> search(@PathParam("searchText") String searchText, @PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("column") List<String> columns) {
        columns = new ArrayList<String>();
        columns.add("itemNumber");
        columns.add("invoiceNumber");
        //TODO add remaining columns
        return getDao().sqlSearch(searchText, start, limit, columns, false);
    }

    @PUT
    @Path("/adv-search/{start}/{limit}")
    @Transactional(readOnly = true)
    //TODO add invoice mgr role check using pre auth
    public List<Invoice> search(InvoiceSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return InvoiceService.instance().search(dto, start, limit);
    }

    @GET
    @Path("/invoice-summary-report")
    //TODO add invoice mgr role check using pre auth
    public void generateInvoiceSummaryReport() {
        InvoiceService.instance().generateInvoiceSummaryReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/active-clientinfo-report")
    //TODO add invoice mgr role check using pre auth
    public void generateActiveInvoicesReport() {
        InvoiceService.instance().generateActiveInvoicesReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

}
