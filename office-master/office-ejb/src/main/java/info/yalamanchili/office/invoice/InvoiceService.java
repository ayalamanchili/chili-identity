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
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.InvoiceDao;
import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        InvoiceTable table = new InvoiceTable();
        String queryStr = getSearchQuery(searchDto);
        TypedQuery<Invoice> query = em.createQuery(queryStr, Invoice.class);
        if (!Strings.isNullOrEmpty(searchDto.getInvoiceNumber())) {
            query.setParameter("invoiceNumberParam", searchDto.getInvoiceNumber().trim());
        }
        if (!Strings.isNullOrEmpty(searchDto.getVendor())) {
            query.setParameter("vendorParam", searchDto.getVendor().trim());
        }
        if (!Strings.isNullOrEmpty(searchDto.getEmployee())) {
            query.setParameter("employeeParam", searchDto.getEmployee().trim());
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
        if (!Strings.isNullOrEmpty(searchDto.getVendor())) {
            queryStr.append("inv.clientInformation.vendor.name =:vendorParam").append(" and ");
        }
        if (!Strings.isNullOrEmpty(searchDto.getEmployee())) {
            queryStr.append("inv.clientInformation.employee.lastName =:employeeParam").append(" and ");
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
        String[] columnOrder = new String[]{"employee", "itemNumber", "invoiceNumber", "startDate", "endDate", "invoiceDate", "billingRate", "overTimeBillingRate", "hours", "invoicestatus", "invoicefrequency", "timeSheetstatus"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Invoice Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateActiveInvoicesReport(String email) {
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
