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

    public List<ContractDto> getContractorPlacementInfo() {
        List<ContractDto> res = new ArrayList<ContractDto>();
        TypedQuery<ClientInformation> q = em.createQuery("SELECT ci from " + ClientInformation.class.getCanonicalName() + " ci where ci.startDate <= :dateParam AND ci.endDate >= :dateParam", ClientInformation.class);
        q.setParameter("dateParam", new Date(), TemporalType.DATE);
        for (ClientInformation ci : q.getResultList()) {
            ContractDto dto = mapper.map(ci, ContractDto.class);
            dto.setEmployee(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
            //TODO set client
            //vendor
            //etc
            res.add(dto);
        }
        return res;
    }

    public Response generateContractorPlacementInfoReport(String format) {
        javax.ws.rs.core.Response.ResponseBuilder response;
        String fileName = "contracts";
        List<ContractDto> data = getContractorPlacementInfo();
        try {
            ReportGenerator.generateReport(data, format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + fileName);
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
