/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

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
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dto.client.ContractSearchDto;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Phone;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.StringUtils;

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
        String queryStr = "SELECT ci from " + ClientInformation.class.getCanonicalName() + " ci where ci.startDate <= :dateParam AND (ci.endDate >= :dateParam or ci.endDate is null)";

        TypedQuery<ClientInformation> query = em.createQuery(queryStr, ClientInformation.class);
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
        TypedQuery<ClientInformation> query = em.createQuery(searchQuery, ClientInformation.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        for (ClientInformation ci : query.getResultList()) {
            table.getEntities().add(mapClientInformation(ci));
        }
        String sizeQueryStr = searchQuery.replace("SELECT ci", "SELECT count(*)");
        if (table.getEntities().size() > 0) {
            TypedQuery<Long> sizeQuery = em.createQuery(sizeQueryStr, Long.class);
            table.setSize(sizeQuery.getSingleResult());
        }
        return table;
    }

    public ContractTable search(String searchText, int start, int limit) {
        ContractTable table = new ContractTable();
        String searchQuery = getSearchQuery(searchText);
        TypedQuery<ClientInformation> query = em.createQuery(searchQuery, ClientInformation.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        for (ClientInformation ci : query.getResultList()) {
            table.getEntities().add(mapClientInformation(ci));
        }
        String sizeQueryStr = searchQuery.replace("SELECT ci", "SELECT count(*)");
        if (table.getEntities().size() > 0) {
            TypedQuery<Long> sizeQuery = em.createQuery(sizeQueryStr, Long.class);
            table.setSize(sizeQuery.getSingleResult());
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

    protected String getSearchQuery(ContractSearchDto searchDto) {
        //TODO should we filter search query by date like reports?
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT ci from ").append(ClientInformation.class.getCanonicalName());
        queryStr.append(" ci where ");
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
            queryStr.append("ci..subcontractor.name LIKE '%").append(searchDto.getSubContractorName().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getEmployeeFirstName())) {
            queryStr.append("ci.employee.firstName LIKE '%").append(searchDto.getEmployeeFirstName().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getEmployeeLastName())) {
            queryStr.append("ci.employee.lastName LIKE '%").append(searchDto.getEmployeeLastName().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getState())) {
            queryStr.append("ci.address.state LIKE '%").append(searchDto.getState().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getCity())) {
            queryStr.append("ci.address.city LIKE '%").append(searchDto.getCity().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getCompany())) {
            queryStr.append("ci.address.company LIKE '%").append(searchDto.getCompany().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getCompany())) {
            queryStr.append("ci.company.name LIKE '%").append(searchDto.getCompany().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getEmployeeType())) {
            queryStr.append("ci.employeeType.name LIKE '%").append(searchDto.getEmployeeType().trim()).append("%' ").append(" and ");
        }
        if (StringUtils.isNotBlank(searchDto.getInvoiceFrequency().name())) {
            queryStr.append("ci.invoiceFrequency LIKE '%").append(searchDto.getInvoiceFrequency().name().trim()).append("%' ").append(" and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    protected ContractDto mapClientInformation(ClientInformation ci) {
        ContractDto dto = mapper.map(ci, ContractDto.class);
        dto.setEmployee(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
        //map employee type 
        dto.setEmployeeType(ci.getEmployee().getEmployeeType().getName());
        //TODO set client
        if (ci.getClient() != null) {
            dto.setClient(ci.getClient().getName());
        }
        if (ci.getVendor() != null) {
            dto.setVendor(ci.getVendor().getName());
        }
        if (ci.getRecruiter() != null) {
            dto.setRecruiter(ci.getRecruiter().getFirstName() + " " + ci.getRecruiter().getLastName());
        }
        if (ci.getClientContact() != null) {
            dto.setClientContact(ci.getClientContact().details());
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
        if (ci.getVendorRecruiter() != null) {
            dto.setVendorRecruiter(ci.getVendorRecruiter().getFirstName() + " " + ci.getVendorRecruiter().getLastName());
        }
        if (ci.getVendorAPContact() != null) {
            StringBuilder acctpayCnt = new StringBuilder();
            acctpayCnt.append("Name: " + ci.getVendorAPContact().getFirstName());
            acctpayCnt.append(" ");
            acctpayCnt.append(ci.getVendorAPContact().getLastName());
            acctpayCnt.append("<br/>");
            for (Email email : ci.getVendorAPContact().getEmails()) {
                acctpayCnt.append("Email: " + email.getEmail() + "<br/>");
            }

            for (Phone phone : ci.getVendorAPContact().getPhones()) {
                if (phone.getExtension() != null) {
                    acctpayCnt.append("Phone: " + phone.getPhoneNumber() + " ext: " + phone.getExtension());
                } else {
                    acctpayCnt.append("Phone: " + phone.getPhoneNumber());
                }
                acctpayCnt.append("<br/>");
            }

            dto.setVendorAPContact(acctpayCnt.toString());
            // dto.setVendorAPContact(ci.getVendorAPContact().getFirstName() + " " + ci.getVendorAPContact().getLastName());
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
        return dto;
    }

    public Response generateContractorPlacementInfoReport(String format) {
        ContractTable data = getContractorPlacementInfo(0, 10000);
        return ReportGenerator.generateReport(data.getEntities(), "contracts", format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot());
    }

    public static ContractService instance() {
        return SpringContext.getBean(ContractService.class);
    }
}
