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
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.dao.client.InvoiceDao;
import info.yalamanchili.office.dao.client.MissingInvoicesReportDto;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.entity.client.InvoiceStatus;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.invoice.GenericsDatesDto;
import info.yalamanchili.office.invoice.InvoiceDatesDto;
import info.yalamanchili.office.invoice.InvoiceSearchDto;
import info.yalamanchili.office.invoice.InvoiceService;
import info.yalamanchili.office.invoice.InvoiceService.InvoiceTable;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.apache.commons.lang3.time.DateUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
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
        tableObj.setEntities(invoiceDao.getInvoices(id, 0, 10));
        tableObj.setSize(10l);
        return tableObj;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER','ROLE_ADMIN')")
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
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER')")
    public Invoice saveInvoice(@PathParam("id") Long id, Invoice invoice) {
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        if (invoice.getStartDate() != null && invoice.getEndDate() != null) {
            if (invoice.getEndDate().before(invoice.getStartDate())) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invoicePeriodTo.not.before.invoicePeriodFrom", "InvoicePeriod EndDate should not be prior to InvoicePeriod StartDate");
            } else if (invoice.getStartDate().before(ci.getStartDate()) || (ci.getEndDate() != null && invoice.getEndDate().after(DateUtils.addDays(ci.getEndDate(), 8)))) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invoicePeriod.should.matchwith.projectperiod", "InvoicePeriod should be in between Project StartDate and Project EndDate");
            }
        }
        Invoice inv = new Invoice();
        inv.setEmployee(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
        inv.setStartDate(invoice.getStartDate());
        inv.setEndDate(invoice.getEndDate());
        inv.setInvoiceDate(new Date());
        inv.setBillingRate(invoice.getBillingRate());
        inv.setOverTimeBillingRate(invoice.getOverTimeBillingRate());
        inv.setItemNumber(ci.getItemNumber());
        inv.setInvoiceFrequency(ci.getInvoiceFrequency());
        inv.setHours(invoice.getHours());
        inv.setInvoiceStatus(invoice.getInvoiceStatus());
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
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER')")
    public Invoice update(@PathParam("id") Long id, InvoiceUpdateDto invoice) {
        Invoice inv = invoiceDao.findById(id);
        if (invoice.getStartDate() != null && invoice.getEndDate() != null) {
            Date cpdStartDate = inv.getClientInformation().getStartDate();
            Date cpdEndDate = inv.getClientInformation().getEndDate();
            if (invoice.getEndDate().before(invoice.getStartDate())) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invoicePeriodTo.not.before.invoicePeriodFrom", "InvoicePeriod EndDate should not be prior to InvoicePeriod StartDate");
            } else if (invoice.getStartDate().before(cpdStartDate) || (cpdEndDate != null && invoice.getEndDate().after(DateUtils.addDays(cpdEndDate, 8)))) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invoicePeriod.should.matchwith.projectperiod", "InvoicePeriod should be in between Project StartDate and Project EndDate");
            }
        }
        inv.setEmployee(invoice.getEmployee());
        inv.setBillingRate(invoice.getBillingRate());
        inv.setOverTimeBillingRate(invoice.getOverTimeBillingRate());
        inv.setHours(invoice.getHours());
        inv.setStartDate(invoice.getStartDate());
        inv.setEndDate(invoice.getEndDate());
        inv.setInvoiceStatus(invoice.getInvoiceStatus());
        inv.setTimeSheetStatus(invoice.getTimeSheetStatus());
        inv.setInvoiceNumber(invoice.getInvoiceNumber());
        inv.setNotes(invoice.getNotes());
        inv.setId(id);
        em.merge(inv);
        return inv;
    }

    @PUT
    @Validate
    @Path("/update-multiple-Invoice/{id}")
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER')")
    public List<Invoice> submitMultipleInvoice(@PathParam("id") Long id, MultipleInvoicesDto invoice) {
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        List<Invoice> listInvoices = new ArrayList();
        if (invoice.getInvoiceItems() != null && invoice.getInvoiceItems().size() > 0) {
            for (InvoiceItemDto item : invoice.getInvoiceItems()) {
                Invoice inv = new Invoice();
                if (item.getStartDate() != null && item.getEndDate() != null) {
                    if (item.getEndDate().before(item.getStartDate())) {
                        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invoicePeriodTo.not.before.invoicePeriodFrom", "InvoicePeriod EndDate should not be prior to InvoicePeriod StartDate");
                    } else if (item.getStartDate().before(ci.getStartDate()) || (ci.getEndDate() != null && item.getEndDate().after(DateUtils.addDays(ci.getEndDate(), 8)))) {
                        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invoicePeriod.should.matchwith.projectperiod", "InvoicePeriod should be in between Project StartDate and Project EndDate");
                    }
                }
                inv.setEmployee(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
                inv.setItemNumber(ci.getItemNumber());
                inv.setInvoiceFrequency(ci.getInvoiceFrequency());
                inv.setInvoiceDate(new Date());
                inv.setBillingRate(item.getBillingRate());
                inv.setOverTimeBillingRate(item.getOverTimeBillingRate());
                inv.setHours(item.getHours());
                inv.setStartDate(item.getStartDate());
                inv.setEndDate(item.getEndDate());
                inv.setInvoiceStatus(item.getInvoiceStatus());
                inv.setTimeSheetStatus(item.getTimeSheetStatus());
                inv.setInvoiceNumber(item.getInvoiceNumber());
                inv.setNotes(item.getNotes());
                inv.setClientInformation(ci);
                ClientInformationDao.instance().save(ci);
                InvoiceDao.instance().save(inv);
                listInvoices.add(inv);
            }
        }
        return listInvoices;
    }

    @PUT
    @Path("/submit-invoice/{id}")
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER')")
    public Invoice submit(@PathParam("id") Long id, InvoiceDatesDto dto) {
        Invoice inv = invoiceDao.findById(id);
        if (dto.getInvoiceSentDate() != null) {
            inv.setInvoiceSentDate(dto.getInvoiceSentDate());
            inv.setInvoiceStatus(InvoiceStatus.Submitted);
        } else if (dto.getDoNotSendInv() != null && dto.getDoNotSendInv().equals(Boolean.TRUE)) {
            inv.setInvoiceStatus(InvoiceStatus.Do_Not_Send_Invoice);
        } else if (dto.getVmsUploadDate() != null) {
            inv.setInvoiceSentDate(dto.getVmsUploadDate());
            inv.setInvoiceStatus(InvoiceStatus.VMS_Upload);
        }
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
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER')")
    public Invoice readInvoice(@PathParam("id") Long id) {
        return invoiceDao.findById(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER')")
    public void delete(@PathParam("id") Long id) {
        invoiceDao.delete(id);
    }

    @GET
    @Path("/search/{searchText}/{start}/{limit}")
    @Transactional(readOnly = true)
    @Override
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER', 'ROLE_ADMIN')")
    public List<Invoice> search(@PathParam("searchText") String searchText, @PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("column") List<String> columns) {
        columns = new ArrayList<String>();
        columns.add("itemNumber");
        columns.add("invoiceNumber");
        //TODO add remaining columns
        return getDao().sqlSearch(searchText, start, limit, columns, false);
    }

    @GET
    @Path("/search-invoice-by-emp/{start}/{limit}")
    @Transactional(readOnly = true)
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER', 'ROLE_ADMIN')")
    public List<Invoice> searchInvoiceByEmp(@PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("empId") Long empId) {
        Employee emp = EmployeeDao.instance().findById(empId);
        List<Invoice> search = invoiceDao.search(emp.getFirstName(), emp.getLastName(), start, limit);
        return search;
    }

    @GET
    @Path("/getInvoice/{empId}")
    public List<Invoice> getInvoice(@PathParam("empId") Long empId) {
        Employee emp = EmployeeDao.instance().findById(empId);
        List<Invoice> search = invoiceDao.search(emp.getFirstName(), emp.getLastName());
        return search;
    }

    @PUT
    @Path("/adv-search/{start}/{limit}")
    @Transactional(readOnly = true)
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER', 'ROLE_ADMIN')")
    public List<Invoice> search(InvoiceSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return InvoiceService.instance().search(dto, start, limit);
    }

    @GET
    @Path("/invoice-summary-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CEO', 'ROLE_CONTRACTS_ADMIN', 'ROLE_BILLING_ADMIN')")
    public void generateInvoiceSummaryReport() {
        InvoiceService.instance().generateInvoiceSummaryReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    @GET
    @Path("/active-clientinfo-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CEO', 'ROLE_CONTRACTS_ADMIN', 'ROLE_BILLING_ADMIN')")
    public void generateActiveInvoicesReport() {
        InvoiceService.instance().generateActiveInvoicesReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }

    @PUT
    @Path("/reports")
    @PreAuthorize("hasAnyRole('ROLE_INVOICE_MANAGER', 'ROLE_ADMIN')")
    public void searchForInvoiceDates(GenericsDatesDto dto) {
        String email = currentEmpEmail();
        InvoiceService.instance().searchforDates(dto.getStartDate(), dto.getEndDate(), email);
    }

    private String currentEmpEmail() {
        return OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail();
    }

    @GET
    @Path("/missing-invoice-report")
    public void generateMissingInvoiceReport(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
        String email = currentEmpEmail();
        InvoiceService.instance().generateMissingInvoiceReport(startDate, endDate, email);
    }

    @GET
    @Path("/search-missing-invoices/{start}/{limit}")
    public List<MissingInvoicesReportDto> searchMissingInvoices(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
        List<MissingInvoicesReportDto> missingInvoiceList = InvoiceService.instance().missingInvoiceList(startDate, endDate);
        return missingInvoiceList;
    }
}
