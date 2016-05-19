/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.invoice;

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

}
