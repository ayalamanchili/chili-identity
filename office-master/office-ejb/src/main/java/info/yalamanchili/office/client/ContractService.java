/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import com.google.common.base.Strings;
import info.chili.audit.AuditService;
import info.chili.email.Email;
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
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dto.client.ContractSearchDto;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.jms.MessagingService;
import static java.lang.String.format;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import static org.bouncycastle.asn1.cms.CMSObjectIdentifiers.data;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

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

    public ContractTable search(String itemNum, int start, int limit) {
        ContractTable table = new ContractTable();
        String searchQuery = getSearchQuery(itemNum);
        TypedQuery<ClientInformation> query = em.createQuery(searchQuery, ClientInformation.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        for (ClientInformation ci : query.getResultList()) {
            table.getEntities().add(mapClientInformation(ci));
        }
        if (query.getResultList().size() > 0) {
            table.setSize(Integer.valueOf(query.getResultList().size()).longValue());
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
        queryStr.append(" ci ");
        if (StringUtils.isNotBlank(searchDto.getRecruiter())) {
            queryStr.append(" join ci.recruiters as recruiters");
        }
        queryStr.append(" where ");

        if (StringUtils.isNotBlank(searchDto.getRecruiter())) {
            String[] recruiters = searchDto.getRecruiter().split(" ");
            queryStr.append("recruiters.firstName LIKE '%").append(recruiters[0].trim()).append("%' ").append(" and ");
        }
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
        if (!Strings.isNullOrEmpty(searchDto.getStatus())) {
            queryStr.append("ci.status = '").append(searchDto.getStatus().trim()).append("' ").append(" and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    @Async
    @Transactional
    public void sendClientinfoUpdatedEmail(ClientInformation ci, String updatedBy) {
        if (ClientInformationStatus.COMPLETED.equals(ci.getStatus())) {
            String[] roles = {OfficeRoles.OfficeRole.ROLE_BILLING_AND_INVOICING.name(), OfficeRoles.OfficeRole.ROLE_CONTRACTS.name()};
            Email email = new Email();
            email.setTos(MailUtils.instance().getEmailsAddressesForRoles(roles));
            email.setRichText(Boolean.TRUE);
            email.setSubject(" Client Information Has Updated For :" + ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
            String messageText = " Updated Client Information :: Client :" + ci.getClient().getName() + " ; " + " Project : " + ci.getClientProject().getName() + " ; ";
            messageText = messageText.concat(" Item_No :" + ci.getItemNumber()) + " ; ";
            messageText = messageText.concat(" Updated_By :" + updatedBy);
            AuditService auditService = AuditService.instance();
            messageText = messageText + auditService.buildChangesTable(auditService.compare(auditService.mostRecentVersion(ci.getClass(), ci.getId()), ci));
            email.setBody(messageText);
            MessagingService.instance().sendEmail(email);
        }
    }

    @Async
    @Transactional
    public void sendBillingRateUpdatedEmail(ClientInformation ci, Date effectiveDate, String updatedBy) {
        if (ClientInformationStatus.COMPLETED.equals(ci.getStatus())) {
            String[] roles = {OfficeRoles.OfficeRole.ROLE_BILLING_AND_INVOICING.name(), OfficeRoles.OfficeRole.ROLE_CONTRACTS.name()};
            Email email = new Email();
            email.setTos(MailUtils.instance().getEmailsAddressesForRoles(roles));
            email.setRichText(Boolean.TRUE);
            email.setSubject(" Billing Rate Has Updated For : " + ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
            String messageText = " Updated Bill Rate:: " + " ";
            messageText = messageText.concat("Client :" + ci.getClient().getName()) + " ; ";
            messageText = messageText.concat("Item_No :" + ci.getItemNumber()) + " ; ";
            messageText = messageText.concat("Project :" + ci.getClientProject().getName()) + " ; ";
            messageText = messageText.concat("Updated_By :" + updatedBy) + " ; ";
            messageText = messageText.concat("Effective_Date :" + new SimpleDateFormat("MM-dd-yyyy").format(effectiveDate));
            AuditService auditService = AuditService.instance();
            messageText = messageText + auditService.buildChangesTable(auditService.compare(auditService.mostRecentVersion(ci.getClass(), ci.getId()), ci));
            email.setBody(messageText);
            MessagingService.instance().sendEmail(email);
        }
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
        if ((ci.getStartDate().before(new Date()) && ci.getEndDate() != null && ci.getEndDate().after(new Date()))
                || ((ci.getStartDate().before(new Date())) && ci.getEndDate() == null)) {
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
            if (ci.getEmployee().getEmployeeType().getName().equals(EmployeeType.SUBCONTRACTOR)) {
                getEffectiveSubConPayRate(ci, dto);
                getEffectiveSubConOverTimePayRate(ci, dto);
                getEffectiveSubConInvoiceFrequency(ci, dto);
            } else if (ci.getEmployee().getEmployeeType().getName().equals(EmployeeType._1099_CONTRACTOR)) {
                getEffectivePayRate1099(ci, dto);
                getEffectiveOverTimePayRate1099(ci, dto);
                getEffectiveInvoiceFrequency1099(ci, dto);
            }
            getEffectiveBillingRate(ci, dto);
            getEffectiveOvertimeBillingRate(ci, dto);
            getEffectiveBillingInvoiceFrequency(ci, dto);
        }
        return dto;
    }

    public Response generateContractorPlacementInfoReport(String format) {
        ContractTable data = getContractorPlacementInfo(0, 10000);
        String[] columnOrder = new String[]{"employee", "client", "vendor", "itemNumber", "billingRate", "overTimeBillingRate", "invoiceFrequency", "startDate", "endDate",};
        return ReportGenerator.generateReport(data.getEntities(), "contracts", format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
    }

    public void generateSubCReport(ContractSearchDto dto) {
        ContractTable table = getResultForReport(dto);
        String[] columnOrder = new String[]{"employee", "client", "vendor", "clientProject", "billingRate", "overTimeBillingRate", "startDate", "endDate"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "subcontractor", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
    }
    
    public void generateClientReport(ContractSearchDto dto) {
        ContractTable table = getResultForReport(dto);
        String[] columnOrder = new String[]{"employee", "consultantJobTitle", "vendor", "billingRate", "startDate", "endDate", "subContractorName", "subcontractorPayRate"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "workingunderclient", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
    }
    
    public void generateVendorReport(ContractSearchDto dto) {
        ContractTable table = getResultForReport(dto);
        String[] columnOrder = new String[]{"employee", "consultantJobTitle", "client", "billingRate", "startDate", "endDate", "subContractorName", "subcontractorPayRate"};
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "workingundervendor", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, emp.getPrimaryEmail().getEmail());
    }
    
    public ContractTable getResultForReport(ContractSearchDto dto){
        String query = getSearchQuery(dto);
        ContractTable table = new ContractTable();
        TypedQuery<ClientInformation> queryForSub = em.createQuery(query, ClientInformation.class);
        for (ClientInformation ci : queryForSub.getResultList()) {
            table.getEntities().add(mapClientInformation(ci));
        }
        return table;
    }

    public void getEffectiveBillingRate(ClientInformation ci, ContractDto dto) {
        dto.setBillingRate(null);
        Query query = em.createNativeQuery("Select billingRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and billingRate is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setBillingRate((BigDecimal) obj);
        }
    }

    public void getEffectiveOvertimeBillingRate(ClientInformation ci, ContractDto dto) {
        dto.setOverTimeBillingRate(null);
        Query query = em.createNativeQuery("Select overTimeBillingRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and overTimeBillingRate is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setOverTimeBillingRate((BigDecimal) obj);
        }
    }

    public void getEffectiveBillingInvoiceFrequency(ClientInformation ci, ContractDto dto) {
        dto.setInvoiceFrequency(null);
        Query query = em.createNativeQuery("Select billingInvoiceFrequency from BILLINGRATE where clientInformation_id=" + ci.getId() + " and billingInvoiceFrequency is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setInvoiceFrequency(InvoiceFrequency.valueOf((String) obj));
        }
    }

    public void getEffectiveSubConPayRate(ClientInformation ci, ContractDto dto) {
        dto.setSubcontractorPayRate(null);
        Query query = em.createNativeQuery("Select subContractorPayRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorPayRate is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setSubcontractorPayRate((BigDecimal) obj);
        }
    }

    public void getEffectiveSubConOverTimePayRate(ClientInformation ci, ContractDto dto) {
        dto.setSubcontractorOvertimePayRate(null);
        Query query = em.createNativeQuery("Select subContractorOverTimePayRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorOverTimePayRate is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setSubcontractorOvertimePayRate((BigDecimal) obj);
        }
    }

    public void getEffectiveSubConInvoiceFrequency(ClientInformation ci, ContractDto dto) {
        dto.setSubcontractorinvoiceFrequency(null);
        Query query = em.createNativeQuery("Select subContractorInvoiceFrequency from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorInvoiceFrequency is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setSubcontractorinvoiceFrequency(InvoiceFrequency.valueOf((String) obj));
        }
    }

    public void getEffectivePayRate1099(ClientInformation ci, ContractDto dto) {
        dto.setPayRate1099(null);
        Query query = em.createNativeQuery("Select subContractorPayRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorPayRate is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setPayRate1099((BigDecimal) obj);
        }
    }

    public void getEffectiveOverTimePayRate1099(ClientInformation ci, ContractDto dto) {
        dto.setOverTimePayrate1099(null);
        Query query = em.createNativeQuery("Select subContractorOverTimePayRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorOverTimePayRate is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setOverTimePayrate1099((BigDecimal) obj);
        }
    }

    public void getEffectiveInvoiceFrequency1099(ClientInformation ci, ContractDto dto) {
        dto.setInvoiceFrequency1099(null);
        Query query = em.createNativeQuery("Select subContractorInvoiceFrequency from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorInvoiceFrequency is not null and effectiveDate <= NOW() order by effectiveDate desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setInvoiceFrequency1099(InvoiceFrequency.valueOf((String) obj));
        }
    }

    public static ContractService instance() {
        return SpringContext.getBean(ContractService.class);
    }
}
