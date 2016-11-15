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
import info.chili.commons.HtmlUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.docs.MakeHTML;
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
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dto.client.ContractSearchDto;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.LockMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 * Reporting service for Employee, client, vendor and contract related
 * information
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class ContractService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    public ContractDto read(Long id) {
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        return mapClientInformation(ci);
    }

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
        TypedQuery<ClientInformation> query = em.createQuery(searchQuery + " order by ci.employee.firstName ASC group by ci.employee ", ClientInformation.class);
        if (searchDto.getStartDate() != null) {
            query.setParameter("startDateStartParam", startDate, TemporalType.DATE);
            query.setParameter("startDateEndParam", DateUtils.addDays(startDate, 31), TemporalType.DATE);
        }
        if (searchDto.getEndDate() != null) {
            query.setParameter("endDateStartParam", endD, TemporalType.DATE);
            query.setParameter("endDateEndParam", DateUtils.addDays(endD, 31), TemporalType.DATE);
        }
        if (searchDto.getRecruitedDateFrom() != null) {
            query.setParameter("startDateParam", searchDto.getRecruitedDateFrom(), TemporalType.DATE);
        }
        if (searchDto.getRecruitedDateTo() != null) {
            query.setParameter("endDateParam", searchDto.getRecruitedDateTo(), TemporalType.DATE);
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
            if (searchDto.getRecruitedDateFrom() != null) {
                sizeQuery.setParameter("startDateParam", searchDto.getRecruitedDateFrom(), TemporalType.DATE);
            }
            if (searchDto.getRecruitedDateTo() != null) {
                sizeQuery.setParameter("endDateParam", searchDto.getRecruitedDateTo(), TemporalType.DATE);
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
        if (searchDto.getPractice()!= null) {
            queryStr.append("ci.practice.name='").append(searchDto.getPractice().trim()).append("' ").append(" and ");
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
        if (searchDto.getRecruitedDateFrom() != null) {
            queryStr.append("ci.startDate between :startDateParam and  ");
        }
        if (searchDto.getRecruitedDateTo() != null) {
            queryStr.append(":endDateParam and  ");
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
            String[] roles = {OfficeRoles.OfficeRole.ROLE_BILLING_AND_INVOICING.name()};
            Email email = new Email();
            email.setTos(MailUtils.instance().getEmailsAddressesForRoles(roles));
            email.setHtml(Boolean.TRUE);
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
            String[] roles = {OfficeRoles.OfficeRole.ROLE_BILLING_AND_INVOICING.name()};
            Email email = new Email();
            email.setTos(MailUtils.instance().getEmailsAddressesForRoles(roles));
            email.setHtml(Boolean.TRUE);
            email.setRichText(Boolean.TRUE);
            email.setSubject("Billing Rate Has Updated For : " + ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
            String messageText = " <b>Updated Bill Rate:</b> " + " ".concat("</br>").concat("</br>");
            messageText = messageText.concat("<b>Client &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp</b>" + ci.getClient().getName()) + "</br>";
            messageText = messageText.concat("<b>Item No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp</b>" + ci.getItemNumber()) + "</br>";
            messageText = messageText.concat("<b>Project &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp</b>" + ci.getClientProject().getName()) + "</br>";
            messageText = messageText.concat("<b>Updated By &nbsp;&nbsp;&nbsp;:&nbsp</b>" + updatedBy) + "</br>";
            messageText = messageText.concat("<b>Effective Date :&nbsp</b>" + new SimpleDateFormat("MM-dd-yyyy").format(effectiveDate)).concat("</br>").concat("</br>");
            AuditService auditService = AuditService.instance();
            messageText = messageText + auditService.buildChangesTable(auditService.compare(auditService.mostRecentVersion(ci.getClass(), ci.getId()), ci));
            email.setBody(messageText);
            MessagingService.instance().sendEmail(email);
        }
    }

    public ContractDto mapClientInformation(ClientInformation ci) {
        ContractDto dto = mapper.map(ci, ContractDto.class);
        Vendor vi = new Vendor();
        Client ct = new Client();
        BigDecimal clientFeePer = new BigDecimal(0);
        if (ci.getEmployee() != null) {
            dto.setContractSignedEntity(ci.getCompany().name());
            dto.setEmployee(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
            dto.setEmployeeType(ci.getEmployee().getEmployeeType().getName());
            dto.setEmployeeID(ci.getEmployee().getId());
            dto.setEmployeeDetails(ci.getEmployee().details());
            dto.setBpmProcessId(ci.getBpmProcessId());
            if (ci.getEmployee().getCompany() != null) {
                dto.setEmployeeCompany(ci.getEmployee().getCompany().getName());
            } else {
                dto.setEmployeeCompany(null);
            }
        }
        //TODO set client
        if (ci.getClient() != null) {
            ct = ci.getClient();
            dto.setClient(ct.getName());
            dto.setClientFeeApplicable(ci.getClientFeeApplicable());
            dto.setDirectClient(ci.getDirectClient());
            if (ci.getClientFee() != null) {
                clientFeePer = new BigDecimal(ci.getClientFee());
                dto.setClientFees(clientFeePer.floatValue());
            } else if (ct.getClientFee() != null) {
                clientFeePer = new BigDecimal(ct.getClientFee());
                dto.setClientFees(clientFeePer.floatValue());
            }
            BigDecimal effectiveBillingRate = getEffectiveBillingRate(ci.getId());
            if (effectiveBillingRate == null) {
                dto.setBillingRate(ci.getBillingRate());
            } else {
                dto.setBillingRate(getEffectiveBillingRate(ci.getId()));
            }
            if (ci.getClientFeeApplicable() != null && ci.getClientFeeApplicable() && clientFeePer != null && clientFeePer.floatValue() > 0) {
                BigDecimal clientFeeVal = clientFeePer.divide(new BigDecimal(100)).multiply(dto.getBillingRate());
                dto.setFinalBillingRate(dto.getBillingRate().subtract(calculateMargin(clientFeeVal, ct.getMaxClientFee(), ct.getMinClientFee())));
            } else if (ci.getClientFeeApplicable() != null && !(ci.getClientFeeApplicable())) {
                dto.setFinalBillingRate(dto.getBillingRate());
            }
        }

        if (ci.getVendor() != null) {
            vi = ci.getVendor();
            dto.setVendor(vi.getName());
            dto.setVendorFees(vi.getVendorFees());
            BigDecimal effectiveBillingRate = getEffectiveBillingRate(ci.getId());
            if (effectiveBillingRate == null) {
                dto.setBillingRate(ci.getBillingRate());
            } else {
                dto.setBillingRate(getEffectiveBillingRate(ci.getId()));
            }
            if (!(ci.getClientFeeApplicable() != null && ci.getClientFeeApplicable()) && vi.getVendorFees() != null) {
                BigDecimal value = new BigDecimal(vi.getVendorFees());
                if (dto.getBillingRate() != null) {
                    BigDecimal vendorFee = value.divide(new BigDecimal(100)).multiply(dto.getBillingRate());
                    dto.setFinalBillingRate(dto.getBillingRate().subtract(calculateMargin(vendorFee, vi.getMaxFees(), vi.getMinFees())));
                }
            } else if (!(ci.getClientFeeApplicable() != null && ci.getClientFeeApplicable()) && vi.getVendorFees() == null) {
                dto.setFinalBillingRate(dto.getBillingRate());
            }
        }
        //payrate
        if (ci.getPayRatePercentage() != null) {
            if (dto.getFinalBillingRate() != null) {
                dto.setPayRate(dto.getFinalBillingRate().multiply(new BigDecimal(ci.getPayRatePercentage())).divide(new BigDecimal(100)));
            } else {
                dto.setPayRate(dto.getBillingRate().multiply(new BigDecimal(ci.getPayRatePercentage())).divide(new BigDecimal(100)));
            }
        } else {
            dto.setPayRate(ci.getPayRate());
        }
        StringBuilder recruiters = new StringBuilder();
        for (Employee rec : ci.getRecruiters()) {
            recruiters.append(rec.getFirstName()).append(" ").append(rec.getLastName()).append(" , ");
        }
        if (!recruiters.toString().isEmpty()) {
            dto.setRecruiter(recruiters.substring(0, recruiters.length() - 2));
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
            if (ci.getSubcontractor().getLocations().size() > 0) {
                Address address = ci.getSubcontractor().getLocations().get(0);
                dto.setSubcontractorAddress(address.getStreet1() + " " + address.getCity() + " " + address.getState() + " " + address.getCountry());
            }
        }
        if (ci.getSubcontractorContact() != null) {
            dto.setSubContractorContactName(ci.getSubcontractorContact().details());
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

    public BigDecimal calculateMargin(BigDecimal fee, BigDecimal maxFee, BigDecimal minFee) {

        BigDecimal margin = BigDecimal.ZERO;

        if (fee != null && fee.floatValue() > 0) {
            if (maxFee != null && minFee != null && fee.floatValue() <= maxFee.floatValue() && fee.floatValue() >= minFee.floatValue()) {
                margin = fee;
            } else if (maxFee != null && fee.floatValue() > maxFee.floatValue()) {
                margin = maxFee;
            } else if (minFee != null && fee.floatValue() < minFee.floatValue()) {
                margin = minFee;
            } else {
                margin = fee;
            }
        }

        return margin;
    }

    @Async
    @Transactional
    public void generateSubCReport(ContractSearchDto dto, String email) {
        ContractTable table = getResultForReport(dto);
        String[] columnOrder = new String[]{"employee", "client", "vendor", "clientProject", "billingRate", "overTimeBillingRate", "startDate", "endDate", "subContractorContactName"};
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Employees Working Under SubContractor " + dto.getSubContractorName(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, email);
    }

    @Async
    @Transactional
    public void generateClientReport(ContractSearchDto dto, String email) {
        ContractTable table = getResultForReport(dto);
        String[] columnOrder = new String[]{"employee", "consultantJobTitle", "vendor", "billingRate", "startDate", "endDate", "clientContact", "subContractorName", "subcontractorPayRate"};
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Employees Working Under Client " + dto.getClient(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, email);
    }

    @Async
    @Transactional
    public void generateVendorReport(ContractSearchDto dto, String email) {
        ContractTable table = getResultForReport(dto);
        String[] columnOrder = new String[]{"employee", "consultantJobTitle", "client", "billingRate", "startDate", "endDate", "vendorRecruiter", "subContractorName", "subcontractorPayRate"};
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Employees Working Under Vendor " + dto.getVendor(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, email);
    }
    
    @Async
    @Transactional
     public void generateServiceTypeReport(ContractSearchDto dto, String email) {
        ContractTable table = getResultForReport(dto);
        String[] columnOrder = new String[]{"employee", "client", "vendor", "startDate", "endDate"};
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Employees Under " + dto.getPractice(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, email);
    }

    @Async
    @Transactional
    public void generateRecruiterReport(ContractSearchDto dto, String email) {
        ContractTable table = searchContractsForRecruiter(dto);
        String[] columnOrder = new String[]{"employee", "client", "vendor", "startDate", "endDate", "billingRate", "recruiter", "clientLocation"};
        String fileName = "";
        if (dto.getRecruiter() != null) {
            fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Employee Recruited By " + dto.getRecruiter(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        } else if (dto.getRecruitedDateFrom() != null && dto.getRecruitedDateTo() != null) {
            String start = org.apache.http.client.utils.DateUtils.formatDate(dto.getRecruitedDateFrom(), "MM-dd-yyyy");
            String end = org.apache.http.client.utils.DateUtils.formatDate(dto.getRecruitedDateTo(), "MM-dd-yyyy");
            fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Employee Recruited Between " + start + " And " + end, OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        }
        MessagingService.instance().emailReport(fileName, email);
    }

    public ContractTable getResultForReport(ContractSearchDto dto) {
        String query = getSearchQuery(dto);
        ContractTable table = new ContractTable();
        Session session = em.getEntityManagerFactory().createEntityManager().unwrap(Session.class);
        org.hibernate.Query queryForSub = session.createQuery(query);
        queryForSub.setReadOnly(true);
        queryForSub.setFetchSize(200);
        queryForSub.setCacheable(false);
        queryForSub.setLockMode("lockmode", LockMode.NONE);
        ScrollableResults scrollableResults = queryForSub.scroll(ScrollMode.FORWARD_ONLY);

        while (scrollableResults.next()) {
            ClientInformation ci = (ClientInformation) scrollableResults.get(0);
            table.getEntities().add(mapClientInformation(ci));
        }
        scrollableResults.close();
        session.close();
        return table;
    }

    public BigDecimal getEffectiveBillingRate(Long id) {
        Query query = em.createNativeQuery("Select billingRate from BILLINGRATE where clientInformation_id=" + id + " and billingRate is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            return (BigDecimal) obj;
        }
        return null;
    }

    public void getEffectiveOvertimeBillingRate(ClientInformation ci, ContractDto dto) {
        dto.setOverTimeBillingRate(null);
        Query query = em.createNativeQuery("Select overTimeBillingRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and overTimeBillingRate is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setOverTimeBillingRate((BigDecimal) obj);
        }
    }

    public BigDecimal getEffectiveBillingRateForInvoice(Long id, Date date) {
        TypedQuery<BillingRate> queryForSub = em.createQuery("from " + BillingRate.class.getCanonicalName() + " where clientInformation_id=:ClientInfoIdParam and billingRate != NULL and effectiveDate <=:startDateParam  order by effectiveDate desc LIMIT 1", BillingRate.class);
        queryForSub.setParameter("ClientInfoIdParam", id);
        queryForSub.setParameter("startDateParam", date);
        if (queryForSub.getResultList() != null && queryForSub.getResultList().size() > 0) {
            return queryForSub.getResultList().get(0).getBillingRate();
        } else {
            return ClientInformationDao.instance().findById(id).getBillingRate();
        }
    }

    public void getEffectiveBillingInvoiceFrequency(ClientInformation ci, ContractDto dto) {
        dto.setInvoiceFrequency(null);
        Query query = em.createNativeQuery("Select billingInvoiceFrequency from BILLINGRATE where clientInformation_id=" + ci.getId() + " and billingInvoiceFrequency is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setInvoiceFrequency(InvoiceFrequency.valueOf((String) obj));
        }
    }

    public void getEffectiveSubConPayRate(ClientInformation ci, ContractDto dto) {
        dto.setSubcontractorPayRate(null);
        Query query = em.createNativeQuery("Select subContractorPayRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorPayRate is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setSubcontractorPayRate((BigDecimal) obj);
        }
    }

    public void getEffectiveSubConOverTimePayRate(ClientInformation ci, ContractDto dto) {
        dto.setSubcontractorOvertimePayRate(null);
        Query query = em.createNativeQuery("Select subContractorOverTimePayRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorOverTimePayRate is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setSubcontractorOvertimePayRate((BigDecimal) obj);
        }
    }

    public void getEffectiveSubConInvoiceFrequency(ClientInformation ci, ContractDto dto) {
        dto.setSubcontractorinvoiceFrequency(null);
        Query query = em.createNativeQuery("Select subContractorInvoiceFrequency from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorInvoiceFrequency is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setSubcontractorinvoiceFrequency(InvoiceFrequency.valueOf((String) obj));
        }
    }

    public void getEffectivePayRate1099(ClientInformation ci, ContractDto dto) {
        dto.setPayRate1099(null);
        Query query = em.createNativeQuery("Select subContractorPayRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorPayRate is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setPayRate1099((BigDecimal) obj);
        }
    }

    public void getEffectiveOverTimePayRate1099(ClientInformation ci, ContractDto dto) {
        dto.setOverTimePayrate1099(null);
        Query query = em.createNativeQuery("Select subContractorOverTimePayRate from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorOverTimePayRate is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setOverTimePayrate1099((BigDecimal) obj);
        }
    }

    public void getEffectiveInvoiceFrequency1099(ClientInformation ci, ContractDto dto) {
        dto.setInvoiceFrequency1099(null);
        Query query = em.createNativeQuery("Select subContractorInvoiceFrequency from BILLINGRATE where clientInformation_id=" + ci.getId() + " and subContractorInvoiceFrequency is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            dto.setInvoiceFrequency1099(InvoiceFrequency.valueOf((String) obj));
        }
    }

    public Response getContractReport(Long id) {
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        if (ci != null) {
            ContractDto dto = mapClientInformation(ci);
            String report = MakeHTML.makeHTML(dto).replaceAll("<null>", "");
            String str = HtmlUtils.cleanData(report);
            byte[] pdf = PDFUtils.convertToPDF(str);
            return Response.ok(pdf)
                    .header("content-disposition", "filename = Contract_Report.pdf")
                    .header("Content-Length", pdf.length)
                    .build();
        } else {
            return null;
        }
    }

    public ContractTable searchContractsForRecruiter(ContractSearchDto dto) {
        ContractTable table = search(dto, 0, 10000);
        List<ContractDto> dtos = new ArrayList();
        List<ContractDto> cdtos = new ArrayList();
        dtos.addAll(table.getEntities());
        ContractTable ctable = new ContractTable();
        for (ContractDto cdto : dtos) {
            cdtos.add(cdto);
        }
        if (activeCPDs(cdtos).size() > 0) {
            ctable.setEntities(activeCPDs(cdtos));
        }
        return ctable;
    }

    public List<ContractDto> activeCPDs(List<ContractDto> dtos) {
        List<ContractDto> results = new ArrayList();
        for (ContractDto dto : dtos) {
            if (dto.getEndDate() != null) {
                if ((dto.getEndDate().after(new Date())) || (dto.getEndDate().equals(new Date()))) {
                    results.add(dto);
                }
            } else {
                results.add(dto);
            }
        }
        return results;
    }

    public static ContractService instance() {
        return SpringContext.getBean(ContractService.class);
    }
}
