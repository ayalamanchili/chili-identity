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
import info.yalamanchili.office.dao.profile.EmployeeDao.EmployeeTable;
import info.yalamanchili.office.dao.profile.EmployeeDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
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
@Scope("request")
public class ContractReportService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    public static ContractReportService instance() {
        return SpringContext.getBean(ContractReportService.class);
    }

    public EmployeeDao.EmployeeTable empJoinedLeftInAPeriod(int start, int limit, Date startDate, Date endDate, String value) {
        EmployeeTable table = new EmployeeTable();
        List<EmployeeDto> dtos = new ArrayList();
        EmployeeDao.instance().queryBetweenDays(start, limit, startDate, endDate, value).stream().forEach((empObj) -> {
            dtos.add(info.yalamanchili.office.dao.profile.EmployeeDto.map(mapper, (Employee) empObj));
        });
        table.setEntities(dtos);
        table.setSize(Long.valueOf(dtos.size()));
        return table;
    }
    
    @Async
    @Transactional
    public void empJoinedLeftInAPeriodReport(int start, int limit, Date startDate, Date endDate, String value, String email) {
        EmployeeTable table = empJoinedLeftInAPeriod(0, 10000, startDate, endDate, value);
        if (table.getSize() > 0) {
            String[] columnOrder = new String[]{"firstName", "lastName", "startDate", "endDate", "phoneNumber"};
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Emp Joined Or Left In a Period Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, email);
        }
    }
}
