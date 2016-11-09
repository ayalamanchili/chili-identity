/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hemanth
 */
@Component
@Scope("prototype")
public class ProjectSummaryService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    public ContractTable search(Long empId, int start, int limit) {
        List<ClientInformation> cisf = new ArrayList<>();
        ContractTable table = new ContractTable();
        List<ClientInformation> cis = EmployeeDao.instance().findById(empId).getClientInformations();
        cis.stream().sorted((o1, o2) -> o2.getStartDate().compareTo(o1.getStartDate())).forEach(o -> cisf.add(o));
        for (ClientInformation ci : cisf) {
            table.getEntities().add(mapClientInformation(ci));
        }
        if (cis.size() > 0) {
            table.setSize(Integer.valueOf(cis.size()).longValue());
        }
        return table;
    }

    public ContractDto mapClientInformation(ClientInformation ci) {
        Vendor vi = new Vendor();
        Client ct = new Client();
        ContractDto dto = mapper.map(ci, ContractDto.class);
        if (ci.getEmployee() != null) {
            dto.setEmployee(ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
            dto.setEmployeeID(ci.getEmployee().getId());
            dto.setStartDate(ci.getStartDate());
            dto.setEndDate(ci.getEndDate());

        }
        if (ci.getClient() != null) {
            ct = ci.getClient();
            dto.setClient(ct.getName());
        }
        if (ci.getVendor() != null) {
            vi = ci.getVendor();
            dto.setVendor(vi.getName());
        }
        if (ci.getGapPeriod() != null) {
            dto.setGapPeriod(ci.getGapPeriod());
        }
        BigDecimal effectiveBillingRate = getEffectiveBillingRate(ci.getId());
        if (effectiveBillingRate == null) {
            dto.setBillingRate(ci.getBillingRate());
        } else {
            dto.setBillingRate(getEffectiveBillingRate(ci.getId()));
        }

        return dto;
    }

    public ContractTable getResultForReport(Long empId) {
        ContractTable table = new ContractTable();
        List<ClientInformation> cis = new LinkedList<>();
        List<ClientInformation> cisf = new LinkedList<>();
        cis = EmployeeDao.instance().findById(empId).getClientInformations();
        if (cis.size() == 2) {
            cis.stream().sorted((o1, o2) -> o2.getStartDate().compareTo(o1.getStartDate())).forEach(o -> cisf.add(o));
            for (int i = 0; i < cisf.size(); i++) {
                if (i == 0) {
                    cisf.get(i).setGapPeriod(cisf.get(i + 1).getEndDate().toGMTString().substring(0, 11) + " to " + cisf.get(i).getStartDate().toGMTString().substring(0, 11));
                } else {
                    cisf.get(i).setGapPeriod("NA");
                }
            }
            for (ClientInformation ci : cisf) {
                table.getEntities().add(mapClientInformation(ci));
            }
            return table;
        } else if (cis.size() > 0) {
            cis.stream().sorted((o1, o2) -> o2.getStartDate().compareTo(o1.getStartDate())).forEach(o -> cisf.add(o));
            for (int i = 0; i < cisf.size(); i++) {
                if (i == 0 || i == cisf.size() - 1) {
                    cisf.get(i).setGapPeriod("NA");
                } else {
                    cisf.get(i).setGapPeriod(cisf.get(i + 1).getEndDate().toGMTString().substring(0, 11) + " to " + cisf.get(i).getStartDate().toGMTString().substring(0, 11));
                }
            }
            for (ClientInformation ci : cisf) {
                table.getEntities().add(mapClientInformation(ci));
            }
            return table;
        } else {
            for (ClientInformation ci : cis) {
                table.getEntities().add(mapClientInformation(ci));
            }
            return table;
        }

    }

    @Async
    @Transactional
    public void generateAssociateReport(Long empId, String email) {
        ContractTable table = getResultForReport(empId);
        String[] columnOrder = new String[]{"client", "vendor", "startDate", "endDate", "billingRate", "gapPeriod"};
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "CPD History Record Of  " + table.getEntities().get(0).getEmployee(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, email);
    }

    public BigDecimal getEffectiveBillingRate(Long id) {
        Query query = em.createNativeQuery("Select billingRate from BILLINGRATE where clientInformation_id=" + id + " and billingRate is not null and effectiveDate <= NOW() order by effectiveDate desc,updatedTs desc LIMIT 1");
        for (Object obj : query.getResultList()) {
            return (BigDecimal) obj;
        }
        return null;
    }

    public static ProjectSummaryService instance() {
        return SpringContext.getBean(ProjectSummaryService.class);
    }

}
