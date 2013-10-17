/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;

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
                dto.setClientContact(ci.getClientContact().getFirstName() + " " + ci.getClientContact().getLastName());
            }
            if (ci.getVendorContact() != null) {
                dto.setVendorContact(ci.getVendorContact().getFirstName() + " " + ci.getVendorContact().getLastName());
            }
            if (ci.getClientLocation() != null) {
                dto.setClientLocation(ci.getClientLocation().getStreet1() + " " + ci.getClientLocation().getState());
            }
            if (ci.getVendorLocation() != null) {
                dto.setVendorLocation(ci.getVendorLocation().getStreet1() + " " + ci.getVendorLocation().getState());
            }

            if (ci.getSubcontractor() != null) {
                dto.setSubContractorName(ci.getSubcontractor().getName());
            }

            if (ci.getSubcontractorContact() != null) {
                dto.setSubContractorContactName(ci.getSubcontractorContact().getFirstName() + " " + ci.getSubcontractorContact().getLastName());
            }
            //etc
            table.getEntities().add(dto);
        }
        return table;
    }

    public String generateContractorPlacementInfoReport(String format) {
        String fileName = "contracts." + format;
        ContractTable data = getContractorPlacementInfo(0, 10000);
        try {
            ReportGenerator.generateReport(data.getEntities(), format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + fileName);
        } catch (JRException e) {
            e.printStackTrace();
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "system", "Error generating error");
        }
        return fileName;
    }

    public static ContractService instance() {
        return SpringContext.getBean(ContractService.class);
    }
}
