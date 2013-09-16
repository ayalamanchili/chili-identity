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
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import java.util.ArrayList;

import java.util.List;
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
        String queryStr = "SELECT ci from " + ClientInformation.class.getCanonicalName() + " ci where ci.startDate <= :dateParam AND ci.endDate >= :dateParam";

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
            //TODO set client
            if (ci.getClient() != null) {
                dto.setClient(ci.getClient().getName());
            }
            if (ci.getVendor() != null) {
                dto.setVendor(ci.getVendor().getName());
            }
            //etc
            table.getEntities().add(dto);
        }
        return table;
    }

    public Response generateContractorPlacementInfoReport(String format) {
        javax.ws.rs.core.Response.ResponseBuilder response;
        String fileName = "contracts";
        ContractTable data = getContractorPlacementInfo(0, 10000);
        try {
            ReportGenerator.generateReport(data.getEntities(), format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + fileName);
            response = javax.ws.rs.core.Response.ok(fileName.getBytes());
        } catch (JRException e) {
            response = javax.ws.rs.core.Response.serverError();
        }
        return response.build();
    }

    public static ContractService instance() {
        return SpringContext.getBean(ContractService.class);
    }
}
