/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.invoice;

import com.google.common.base.Strings;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.InvoiceDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("prototype")
public class InvoiceService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected InvoiceDao invoiceDao;

    public static InvoiceService instance() {
        return SpringContext.getBean(InvoiceService.class);
    }

    public List<Invoice> search(InvoiceSearchDto searchDto, int start, int limit) {
        String queryStr = getSearchQuery(searchDto);
        TypedQuery<Invoice> query = em.createQuery(queryStr, Invoice.class);
        if (!Strings.isNullOrEmpty(searchDto.getInvoiceNumber())) {
            query.setParameter("invoiceNumberParam", searchDto.getInvoiceNumber().trim());
        }
        if (searchDto.getItemNumber() != null) {
            query.setParameter("itemNumberParam", searchDto.getItemNumber().trim());
        }
        if (searchDto.getStartDate() != null) {
            query.setParameter("startDateParam", searchDto.getStartDate(), TemporalType.DATE);
        }
        if (searchDto.getEndDate() != null) {
            query.setParameter("endDateParam", searchDto.getEndDate(), TemporalType.DATE);
        }
        if (searchDto.getInvoiceDate() != null) {
            query.setParameter("invoiceDateParam", searchDto.getInvoiceDate(), TemporalType.DATE);
        }
        if (searchDto.getInvoiceSentDate() != null) {
            query.setParameter("invoiceSentDateParam", searchDto.getInvoiceSentDate(), TemporalType.DATE);
        }
        if (!Strings.isNullOrEmpty(searchDto.getVendor())) {
            query.setParameter("vendorParam", searchDto.getVendor().trim());
        }
        if (searchDto.getClientInformationCompany() != null) {
            query.setParameter("companyParam", searchDto.getClientInformationCompany());
        }
        if (searchDto.getTimeSheetStatus() != null) {
            query.setParameter("timeSheetStatusParam", searchDto.getTimeSheetStatus());
        }
        if (searchDto.getInvoiceStatus() != null) {
            query.setParameter("invoiceStatusParam", searchDto.getInvoiceStatus());
        }
        return query.getResultList();
    }

    protected String getSearchQuery(InvoiceSearchDto searchDto) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT inv from ").append(Invoice.class.getCanonicalName());
        queryStr.append(" inv where ");
        if (!Strings.isNullOrEmpty(searchDto.getInvoiceNumber())) {
            queryStr.append("inv.invoiceNumber =:invoiceNumberParam").append(" and ");
        }
        if (!Strings.isNullOrEmpty(searchDto.getItemNumber())) {
            queryStr.append("inv.itemNumber =:itemNumberParam").append(" and ");
        }
        if (searchDto.getStartDate() != null) {
            queryStr.append("inv.startDate>=:startDateParam").append(" and ");
        }
        if (searchDto.getEndDate() != null) {
            queryStr.append("inv.endDate<=:endDateParam").append(" and ");
        }
        if (searchDto.getInvoiceDate() != null) {
            queryStr.append("inv.invoiceDate =:invoiceDateParam").append(" and ");
        }
        if (searchDto.getInvoiceSentDate() != null) {
            queryStr.append("inv.invoiceSentDate =:invoiceSentDateParam").append(" and ");
        }
        if (!Strings.isNullOrEmpty(searchDto.getVendor())) {
            queryStr.append("inv.clientInformation.vendor.name =:vendorParam").append(" and ");
        }
        if (searchDto.getClientInformationCompany() != null) {
            queryStr.append("inv.clientInformation.company =:companyParam").append(" and ");
        }
        if (searchDto.getTimeSheetStatus() != null) {
            queryStr.append("inv.timeSheetStatus =:timeSheetStatusParam").append(" and ");
        }
        if (searchDto.getInvoiceStatus() != null) {
            queryStr.append("inv.invoiceStatus =:invoiceStatusParam").append(" and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    @Async
    @Transactional
    public void generateInvoiceSummaryReport(String email) {
        List<InvoiceDto> res = new ArrayList();
        for (Invoice invoice : invoiceDao.query(0, 100000)) {
            res.add(InvoiceDto.map(mapper, invoice));
        }
        String[] columnOrder = new String[]{"employee", "itemNumber", "invoiceNumber", "startDate", "endDate", "invoiceDate", "invoiceSentDate", "billingRate", "overTimeBillingRate", "hours", "invoicestatus", "invoicefrequency", "timeSheetstatus"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Invoice Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateActiveInvoicesReport(String email) {
        String[] types = {"Corporate Employee", "Employee", "Subcontractor", "W2 Contractor", "1099 Contractor", "Intern-Seasonal Employee"};
        List<Employee> emps = EmployeeDao.instance().getEmployeesByType(types);
        List<Invoice> invoices = new ArrayList();
        for (Employee emp : emps) {
            if (emp.getClientInformations() != null) {
                for (ClientInformation ci : emp.getClientInformations()) {
                    if (ci.getEndDate() != null) {
                        if ((ci.getEndDate().after(new Date())) || (ci.getEndDate().equals(new Date()))) {
                            invoices.addAll(ci.getInvoice());
                        }
                    } else {
                        invoices.addAll(ci.getInvoice());
                    }
                }
            }
        }
        List<InvoiceDto> res = new ArrayList();
        for (Invoice invoice : invoices) {
            res.add(InvoiceDto.map(mapper, invoice));
        }
        String[] columnOrder = new String[]{"employee", "itemNumber", "invoiceNumber", "startDate", "endDate", "invoiceDate", "billingRate", "overTimeBillingRate", "hours", "invoicestatus", "invoicefrequency", "timeSheetstatus"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Active Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);

    }

    @Async
    @Transactional
    public void searchforDates(Date startDate, Date endDate, String email) {
        List<Invoice> invoices = new ArrayList();
        invoices.addAll(InvoiceDao.instance().getInvoicesForDates(startDate, endDate));
        List<InvoiceDto> res = new ArrayList();
        for (Invoice invoice : invoices) {
            res.add(InvoiceDto.map(mapper, invoice));
        }
        String[] columnOrder = new String[]{"employee", "itemNumber", "invoiceNumber", "startDate", "endDate", "invoiceDate", "billingRate", "overTimeBillingRate", "hours", "invoicestatus", "invoicefrequency", "timeSheetstatus"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Invoice Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
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
