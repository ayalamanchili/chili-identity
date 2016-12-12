/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.invoice;

import info.yalamanchili.office.dao.client.MissingInvoicesReportDto;
import com.google.common.base.Strings;
import info.chili.commons.DateUtils;
import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.client.ContractReportService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.InvoiceDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
        String[] columnOrder = new String[]{"employee", "itemNumber", "invoiceNumber", "startDate", "endDate", "invoiceDate", "hours", "invoicestatus", "timeSheetstatus"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Invoice Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateMissingInvoiceReport(Date startDate, Date endDate, String email) {
        List<MissingInvoicesReportDto> missingInvoices = missingInvoiceList(startDate, endDate);
        String[] columnOrder = new String[]{"employee", "itemNumber", "invFrequency", "missingInvPeriodFrom", "missingInvPeriodTo"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(missingInvoices, "Missing Invoices Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    TreeSet<Date> dates = new TreeSet();

    public List<MissingInvoicesReportDto> missingInvoiceList(Date startDate, Date endDate) {
        List<MissingInvoicesReportDto> missingInvoices = new ArrayList();
        ClientInformationDao ciDao = ClientInformationDao.instance();
        //TODO get active CPDS during the report start and end date range
        for (ContractDto contract : ContractReportService.instance().getAllActiveCPDsBetween(startDate, DateUtils.getNextDay(endDate, -31))) {
            ClientInformation cpd = ciDao.findById(contract.getId());
            if (!InvoiceDeliveryMethod.DO_NOT_SEND_INVOICES.equals(cpd.getInvoiceDeliveryMethod())) {
                if (cpd.getInvoice().size() > 0) {
                    //fix AIOOBE with dates set
                    dates.clear();
                    List<Invoice> invoices = invoiceDao.getInvoicesForDates(cpd, DateUtils.getNextDay(startDate, -31), DateUtils.getNextDay(endDate, 31));
                    if (invoices.size() > 0) {
                        Map<Date, Invoice> sortInvoicesWRTStartDate = sortInvoicesWRTStartDate(invoices);
                        Invoice firstInvoice = sortInvoicesWRTStartDate.get(dates.first());
                        if (!startDate.equals(DateUtils.getNextDay(dates.first(), 0))) {
                            if (startDate.after(cpd.getStartDate()) || startDate.equals(cpd.getStartDate())) {
                                MissingInvoicesReportDto dto = new MissingInvoicesReportDto();
                                dto.setEmployee(contract.getEmployee());
                                dto.setItemNumber(cpd.getItemNumber());
                                dto.setInvFrequency(cpd.getInvoiceFrequency().name());
                                if (startDate.before(dates.first())) {
                                    dto.setMissingInvPeriodFrom(startDate);
                                    dto.setMissingInvPeriodTo(DateUtils.getNextDay(dates.first(), -1));
                                    missingInvoices.add(dto);
                                } else if (!startDate.after(firstInvoice.getStartDate()) && !startDate.before(firstInvoice.getEndDate())) {
                                    dto.setMissingInvPeriodFrom(startDate);
                                    dto.setMissingInvPeriodTo(endDate);
                                    missingInvoices.add(dto);
                                }
                            } else {
                                MissingInvoicesReportDto dto = new MissingInvoicesReportDto();
                                dto.setEmployee(contract.getEmployee());
                                dto.setItemNumber(cpd.getItemNumber());
                                dto.setInvFrequency(cpd.getInvoiceFrequency().name());
                                dto.setMissingInvPeriodFrom(DateUtils.getNextDay(cpd.getStartDate(), 0));
                                dto.setMissingInvPeriodTo(DateUtils.getNextDay(firstInvoice.getStartDate(), -1));
                                missingInvoices.add(dto);
                            }
                        }
                        Invoice lastInvoice = sortInvoicesWRTStartDate.get(dates.last());
                        //avoid NPE issue with cpd end date
                        if (!endDate.equals(lastInvoice.getEndDate()) && cpd.getEndDate() != null) {
                            if (endDate.before(cpd.getEndDate()) || endDate.equals(cpd.getEndDate())) {
                                if (endDate.after(lastInvoice.getEndDate())) {
                                    MissingInvoicesReportDto dto = new MissingInvoicesReportDto();
                                    dto.setEmployee(contract.getEmployee());
                                    dto.setItemNumber(cpd.getItemNumber());
                                    dto.setInvFrequency(cpd.getInvoiceFrequency().name());
                                    if (startDate.before(lastInvoice.getEndDate())) {
                                        dto.setMissingInvPeriodFrom(DateUtils.getNextDay(lastInvoice.getEndDate(), 1));
                                        dto.setMissingInvPeriodTo(endDate);
                                        missingInvoices.add(dto);
                                    } else {
                                        dto.setMissingInvPeriodFrom(startDate);
                                        dto.setMissingInvPeriodTo(endDate);
                                        missingInvoices.add(dto);
                                    }
                                }
                            } else {
                                MissingInvoicesReportDto dto = new MissingInvoicesReportDto();
                                dto.setEmployee(contract.getEmployee());
                                dto.setItemNumber(cpd.getItemNumber());
                                dto.setInvFrequency(cpd.getInvoiceFrequency().name());
                                dto.setMissingInvPeriodFrom(DateUtils.getNextDay(lastInvoice.getEndDate(), 1));
                                dto.setMissingInvPeriodTo(cpd.getEndDate());
                                missingInvoices.add(dto);
                            }
                        }
                        for (int i = 0; i < dates.size(); i++) {
                            Invoice inv1 = (Invoice) sortInvoicesWRTStartDate.values().toArray()[i];
                            Invoice inv2 = new Invoice();
                            if (dates.size() > (i + 1)) {
                                inv2 = (Invoice) sortInvoicesWRTStartDate.values().toArray()[i + 1];
                            }
                            if (inv2 != null && inv2.getId() != null) {
                                Date date1 = inv1.getEndDate();
                                Date date2 = inv2.getStartDate();
                                //** condition for checking invoices missinv only between start and end date
                                if (startDate.after(inv1.getEndDate()) && endDate.before(inv2.getStartDate())) {
                                    if (!date2.equals(DateUtils.getNextDay(date1, 1))) {
                                        MissingInvoicesReportDto dto = new MissingInvoicesReportDto();
                                        dto.setEmployee(contract.getEmployee());
                                        dto.setItemNumber(cpd.getItemNumber());
                                        dto.setInvFrequency(cpd.getInvoiceFrequency().name());
                                        dto.setMissingInvPeriodFrom(DateUtils.getNextDay(date1, 1));
                                        dto.setMissingInvPeriodTo(DateUtils.getNextDay(date2, -1));
                                        missingInvoices.add(dto);
                                    } else if (endDate.after(inv2.getStartDate())) {
                                        if (!date2.equals(DateUtils.getNextDay(date1, 1))) {
                                            MissingInvoicesReportDto dto = new MissingInvoicesReportDto();
                                            dto.setEmployee(contract.getEmployee());
                                            dto.setItemNumber(cpd.getItemNumber());
                                            dto.setInvFrequency(cpd.getInvoiceFrequency().name());
                                            dto.setMissingInvPeriodFrom(DateUtils.getNextDay(date1, 1));
                                            dto.setMissingInvPeriodTo(DateUtils.getNextDay(date2, -1));
                                            missingInvoices.add(dto);
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        return missingInvoices;
    }

    private Map<Date, Invoice> sortInvoicesWRTStartDate(List<Invoice> invoices) {
        Map<Date, Invoice> invoicesSortedMap = new TreeMap<>();
        Set<Date> dates = new TreeSet();
        for (Invoice inv : invoices) {
            invoicesSortedMap.put(inv.getStartDate(), inv);
            dates.add(inv.getStartDate());
        }
        this.dates.addAll(dates);
        return invoicesSortedMap;
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
