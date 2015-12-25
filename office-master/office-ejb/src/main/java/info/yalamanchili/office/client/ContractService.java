/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.entity.profile.ClientInformation;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dto.client.ContractSearchDto;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import info.yalamanchili.office.entity.profile.EmployeeType;
import java.math.BigDecimal;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * Reporting service for Employee, client, vendor and contract related
 * information
 *
 * @author anuyalamanchili
 */
@Component
@Scope("request")
public class ContractService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    public ContractTable getContractorPlacementInfo(int start, int limit) {
        String queryStr = "SELECT ci from " + ClientInformation.class.getCanonicalName() + " ci where ci.endDate>=:dateParam or ci.endDate is null ";
        TypedQuery<ClientInformation> query = em.createQuery(queryStr + " order by ci.employee.firstName ASC group by ci.employee", ClientInformation.class);
        query.setParameter("dateParam", new Date(), TemporalType.DATE);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        String sizeQueryStr = queryStr.replace("SELECT ci", "SELECT count(*)");
        TypedQuery<Long> sizeQuery = em.createQuery(sizeQueryStr, Long.class);
        sizeQuery.setParameter("dateParam", new Date(), TemporalType.DATE);

        ContractTable table = new ContractTable();
        table.setSize(sizeQuery.getSingleResult());
        for (ClientInformation ci : query.getResultList()) {
            table.getEntities().add(mapClientInformation(ci));
        }
        return table;
    }

    public ContractTable search(ContractSearchDto searchDto, int start, int limit) {
        ContractTable table = new ContractTable();
        String searchQuery = getSearchQuery(searchDto);
        Date startDate = searchDto.getStartDate();
        Date endD = searchDto.getEndDate();
        TypedQuery<ClientInformation> query = em.createQuery(searchQuery, ClientInformation.class);
        if (searchDto.getStartDate() != null) {
            query.setParameter("startDateStartParam", startDate, TemporalType.DATE);
            query.setParameter("startDateEndParam", DateUtils.addDays(startDate, 31), TemporalType.DATE);
        }
        if (searchDto.getEndDate() != null) {
            query.setParameter("endDateStartParam", endD, TemporalType.DATE);
            query.setParameter("endDateEndParam", DateUtils.addDays(endD, 31), TemporalType.DATE);
        }
        query.setFirstResult(start);
        query.setMaxResults(limit);
        for (ClientInformation ci : query.getResultList()) {
            table.getEntities().add(mapClientInformation(ci));
        }
        String sizeQueryStr = searchQuery.replace("SELECT ci", "SELECT count(*)");
        if (table.getEntities().size() > 0) {
            TypedQuery<Long> sizeQuery = em.createQuery(sizeQueryStr, Long.class);
            if (searchDto.getStartDate() != null) {
                sizeQuery.setParameter("startDateStartParam", startDate, TemporalType.DATE);
                sizeQuery.setParameter("startDateEndParam", DateUtils.addDays(startDate, 31), TemporalType.DATE);
            }
            if (searchDto.getEndDate() != null) {
                sizeQuery.setParameter("endDateStartParam", endD, TemporalType.DATE);
                sizeQuery.setParameter("endDateEndParam", DateUtils.addDays(endD, 31), TemporalType.DATE);
            }
            table.setSize(sizeQuery.getSingleResult());
        }
        return table;
    }

    public ContractTable search(Long empId, int start, int limit) {
        ContractTable table = new ContractTable();
        List<ClientInformation> cis = EmployeeDao.instance().findById(empId).getClientInformations();
        for (ClientInformation ci : cis) {
            table.getEntities().add(mapClientInformation(ci));
        }
        if (cis.size() > 0) {
            table.setSize(Integer.valueOf(cis.size()).longValue());
        }
        return table;
    }

    protected String getSearchQuery(String searchText) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT ci from ").append(ClientInformation.class.getCanonicalName());
        queryStr.append(" ci where ");
        queryStr.append("ci.employee.firstName LIKE '%").append(searchText).append("%' OR ");
        queryStr.append("ci.employee.lastName LIKE '%").append(searchText).append("%' OR ");
        queryStr.append("ci.itemNumber LIKE '%").append(searchText).append("%'");
        return queryStr.toString();
    }
//TODO this should be refactored to use generic serach

    protected String getSearchQuery(ContractSearchDto searchDto) {
        //TODO should we filter search query by date like reports?
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT ci from ").append(ClientInformation.class.getCanonicalName());
        queryStr.append(" ci where ");
        if (searchDto.getInvoiceFrequency() != null) {
            if (StringUtils.isNotBlank(searchDto.getInvoiceFrequency().toString())) {
                queryStr.append("ci.invoiceFrequency LIKE '%").append(searchDto.getInvoiceFrequency().toString().trim()).append("%' ").append(" and ");
            }
        }
        if (StringUtils.isNotBlank(searchDto.getItemNumber())) {
            queryStr.append("ci.itemNumber LIKE '%").append(searchDto.getItemNumber().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getClient())) {
            queryStr.append("ci.client.name LIKE '%").append(searchDto.getClient().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getVendor())) {
            queryStr.append("ci.vendor.name LIKE '%").append(searchDto.getVendor().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getSubContractorName())) {
            queryStr.append("ci.subcontractor.name LIKE '%").append(searchDto.getSubContractorName().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getEmployeeFirstName())) {
            queryStr.append("ci.employee.firstName LIKE '%").append(searchDto.getEmployeeFirstName().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getEmployeeLastName())) {
            queryStr.append("ci.employee.lastName LIKE '%").append(searchDto.getEmployeeLastName().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getClientState())) {
            queryStr.append("ci.clientLocation.state LIKE '%").append(searchDto.getClientState().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getVendorState())) {
            queryStr.append("ci.vendorLocation.state LIKE '%").append(searchDto.getVendorState().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getClientCity())) {
            queryStr.append("ci.clientLocation.city LIKE '%").append(searchDto.getClientCity().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getVendorCity())) {
            queryStr.append("ci.vendorLocation.city LIKE '%").append(searchDto.getVendorCity().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getRecruiter())) {
            queryStr.append("ci.employee.firstName LIKE '%").append(searchDto.getRecruiter().trim()).append("%' ").append(" and ");
        }

        if (searchDto.getCompany() != null) {
            queryStr.append("ci.company LIKE '%").append(searchDto.getCompany().name().trim()).append("%' ").append(" and ");
        }

        if (StringUtils.isNotBlank(searchDto.getEmployeeType())) {
            queryStr.append("ci.employee.employeeType.name LIKE '%").append(searchDto.getEmployeeType().trim()).append("%' ").append(" and ");
        }

        if ((searchDto.getStartDate()) != null) {
            queryStr.append("ci.startDate between :startDateStartParam and :startDateEndParam").append(" and ");
        }

        if ((searchDto.getEndDate()) != null) {
            queryStr.append("ci.endDate between :endDateStartParam and :endDateEndParam").append(" and ");
        }

        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    public ContractDto mapClientInformation(ClientInformation ci) {
        ContractDto dto = mapper.map(ci, ContractDto.class);
        if (ci.getEmployee() != null) {
            dto.setEmployee(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
            dto.setEmployeeType(ci.getEmployee().getEmployeeType().getName());
            dto.setEmployeeID(ci.getEmployee().getId());
            dto.setEmployeeDetails(ci.getEmployee().details());
        }
        //TODO set client
        if (ci.getClient() != null) {
            dto.setClient(ci.getClient().getName());
        }
        if (ci.getVendor() != null) {
            dto.setVendor(ci.getVendor().getName());
        }
        StringBuilder recruiters = new StringBuilder();
        for (Employee rec : ci.getRecruiters()) {
            recruiters.append(rec.getFirstName()).append(",");
        }
        if (!recruiters.toString().isEmpty()) {
            dto.setRecruiter(recruiters.toString());
        }
        if (ci.getClientContact() != null) {
            dto.setClientContact(ci.getClientContact().details());
        }
        //Client AP Contacts
        StringBuilder cliAP = new StringBuilder();
        for (Contact clientAPcontact : ci.getClientAPContacts()) {
            cliAP.append(clientAPcontact.details());
            cliAP.append(" ");
        }
        if (ci.getClientAPContacts() != null) {
            dto.setClientAPContact(cliAP.toString());
        }
        if (ci.getVendorContact() != null) {
            dto.setVendorContact(ci.getVendorContact().details());
        }
        if (ci.getMiddleVendor() != null) {
            dto.setMiddleVendor(ci.getMiddleVendor().getName());
        }
        if (ci.getClientProject() != null) {
            dto.setClientProject(ci.getClientProject().getName());
            dto.setPurchaseOrderNo(ci.getClientProject().getPurchaseOrderNo());
            dto.setSubContractorWorkOrderNo(ci.getClientProject().getSubContractorWorkOrderNo());
        }
        //vendor payment tersm
        dto.setVendorPaymentTerms(ci.getVendorPaymentTerms());
        //Vendor AP Contacts
        StringBuilder venAP = new StringBuilder();
        for (Contact vendorAPcontact : ci.getVendorAPContacts()) {
            venAP.append(vendorAPcontact.details());
            venAP.append(" ");
        }
        if (ci.getVendorAPContacts() != null) {
            dto.setVendorAPContact(venAP.toString());
        }
        //vendor recruiters
        for (Contact vendorRecruiter : ci.getVendorRecruiters()) {
            dto.setVendorRecruiter(vendorRecruiter.details());
        }
        if (ci.getClientLocation() != null) {
            dto.setClientLocation(ci.getClientLocation().getStreet1() + " " + ci.getClientLocation().getCity() + " " + ci.getClientLocation().getState());
        }
        if (ci.getVendorLocation() != null) {
            dto.setVendorLocation(ci.getVendorLocation().getStreet1() + " " + ci.getVendorLocation().getCity() + " " + ci.getVendorLocation().getState());
        }

        if (ci.getSubcontractor() != null) {
            dto.setSubContractorName(ci.getSubcontractor().getName());
        }

        if (ci.getSubcontractorContact() != null) {
            dto.setSubContractorContactName(ci.getSubcontractorContact().details());
        }
        if (ci.getSubcontractorAddress() != null) {
            dto.setSubcontractorAddress(ci.getSubcontractorAddress().getStreet1() + " " + ci.getSubcontractorAddress().getCity());
        }
        if (ci.getStatus() != null) {
            dto.setStatus(ci.getStatus().toString());
        }
        if (ci.getPractice() != null) {
            dto.setPractice(ci.getPractice().getName());
        }
        // set color coding flags
        if (ci.getStartDate().before(new Date()) && ci.getEndDate() != null && ci.getEndDate().after(new Date())) {
            dto.setIsActive(Boolean.TRUE);
        }
        if (ci.getStartDate().after(new Date())) {
            dto.setIsStarted(Boolean.FALSE);
        }
        if (ci.getEndDate() != null && ci.getEndDate().before(new Date())) {
            dto.setIsEnded(Boolean.TRUE);
        }
        if (!ClientInformationStatus.COMPLETED.equals(ci.getStatus())) {
            dto.setIsReady(Boolean.FALSE);
        }
        //mapEffectiveBillingRate(ci, dto);
        if (!ci.getBillingRates().isEmpty()) {
            if (ci.getEmployee().getEmployeeType().getName().equals(EmployeeType.SUBCONTRACTOR)
                    || (ci.getEmployee().getEmployeeType().getName().equals(EmployeeType._1099_CONTRACTOR))) {
                BillingRate brSubConPayRate = getEffectiveSubConPayRate(ci);
                if (brSubConPayRate != null) {
                    dto.setSubcontractorPayRate(brSubConPayRate.getSubContractorPayRate());
                }
                BillingRate brSubConOverTimePayRate = getEffectiveSubConOverTimePayRate(ci);
                if (brSubConOverTimePayRate != null) {
                    dto.setSubcontractorOvertimePayRate(brSubConOverTimePayRate.getSubContractorOverTimePayRate());
                }
                BillingRate brSubConInvoiceFrequency = getEffectiveSubConInvoiceFrequency(ci);
                if (brSubConInvoiceFrequency != null) {
                    dto.setSubcontractorinvoiceFrequency(brSubConInvoiceFrequency.getSubContractorInvoiceFrequency());
                }
            }
            BillingRate brBillingRate = getEffectiveBillingRate(ci);
            if (brBillingRate != null) {
                dto.setBillingRate(brBillingRate.getBillingRate());
            }
            BillingRate brOvertimeBillingRate = getEffectiveOvertimeBillingRate(ci);
            if (brOvertimeBillingRate != null) {
                dto.setOverTimeBillingRate(brOvertimeBillingRate.getOverTimeBillingRate());
            }
            BillingRate brBillingInvoiceFrequency = getEffectiveBillingInvoiceFrequency(ci);
            if (brBillingInvoiceFrequency != null) {
                dto.setInvoiceFrequency(brBillingInvoiceFrequency.getBillingInvoiceFrequency());
            }
        }
        return dto;
    }

    public Response generateContractorPlacementInfoReport(String format) {
        ContractTable data = getContractorPlacementInfo(0, 10000);
        String[] columnOrder = new String[]{"employee", "client", "vendor", "itemNumber", "billingRate", "overTimeBillingRate", "invoiceFrequency", "startDate", "endDate",};
        return ReportGenerator.generateReport(data.getEntities(), "contracts", format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
    }

    public BillingRate getEffectiveBillingRate(ClientInformation ci) {
        Query query = em.createNativeQuery("Select * from BILLINGRATE br where br.clientInformation_id=" + ci.getId() + " and br.billingRate is not null and br.effectiveDate <= NOW() order by br.effectiveDate desc LIMIT 1", BillingRate.class);
        if (query.getResultList().size() > 0) {
            Object obj = query.getResultList().get(0);
            BillingRate br = (BillingRate) obj;
            return br;
        } else {
            return null;
        }
    }

    public BillingRate getEffectiveBillingInvoiceFrequency(ClientInformation ci) {
        Query query = em.createNativeQuery("Select * from BILLINGRATE br where br.clientInformation_id=" + ci.getId() + " and br.billingInvoiceFrequency is not null and br.effectiveDate <= NOW() order by br.effectiveDate desc LIMIT 1", BillingRate.class);
        if (query.getResultList().size() > 0) {
            Object obj = query.getResultList().get(0);
            BillingRate br = (BillingRate) obj;
            return br;
        } else {
            return null;
        }
    }

    public BillingRate getEffectiveOvertimeBillingRate(ClientInformation ci) {
        Query query = em.createNativeQuery("Select * from BILLINGRATE br where br.clientInformation_id=" + ci.getId() + " and br.overTimeBillingRate is not null and br.effectiveDate <= NOW() order by br.effectiveDate desc LIMIT 1", BillingRate.class);
        if (query.getResultList().size() > 0) {
            Object obj = query.getResultList().get(0);
            BillingRate br = (BillingRate) obj;
            return br;
        } else {
            return null;
        }
    }

    public BillingRate getEffectiveSubConPayRate(ClientInformation ci) {
        Query query = em.createNativeQuery("Select * from BILLINGRATE br where br.clientInformation_id=" + ci.getId() + " and br.subContractorPayRate is not null and br.effectiveDate <= NOW() order by br.effectiveDate desc LIMIT 1", BillingRate.class);
        if (query.getResultList().size() > 0) {
            Object obj = query.getResultList().get(0);
            BillingRate br = (BillingRate) obj;
            return br;
        } else {
            return null;
        }
    }

    public BillingRate getEffectiveSubConOverTimePayRate(ClientInformation ci) {
        Query query = em.createNativeQuery("Select * from BILLINGRATE br where br.clientInformation_id=" + ci.getId() + " and br.subContractorOverTimePayRate is not null and br.effectiveDate <= NOW() order by br.effectiveDate desc LIMIT 1", BillingRate.class);
        if (query.getResultList().size() > 0) {
            Object obj = query.getResultList().get(0);
            BillingRate br = (BillingRate) obj;
            return br;
        } else {
            return null;
        }
    }

    public BillingRate getEffectiveSubConInvoiceFrequency(ClientInformation ci) {
        Query query = em.createNativeQuery("Select * from BILLINGRATE br where br.clientInformation_id=" + ci.getId() + " and br.subContractorInvoiceFrequency is not null and br.effectiveDate <= NOW() order by br.effectiveDate desc LIMIT 1", BillingRate.class);
        if (query.getResultList().size() > 0) {
            Object obj = query.getResultList().get(0);
            BillingRate br = (BillingRate) obj;
            return br;
        } else {
            return null;
        }
    }

    public static ContractService instance() {
        return SpringContext.getBean(ContractService.class);
    }
}
