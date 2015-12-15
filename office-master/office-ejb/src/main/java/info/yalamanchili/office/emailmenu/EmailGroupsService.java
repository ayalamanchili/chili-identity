/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.emailmenu;

import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.reports.profile.EmployeeBasicInfoReportDto;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("prototype")
public class EmailGroupsService {

    @Autowired
    protected Mapper mapper;

    @Async
    @Transactional(readOnly = true)
    public void getemailMenuReportsReport(String email, String employeeType) {
        List<EmployeeBasicInfoReportDto> res = new ArrayList<>();
        for (Employee emp : EmployeeDao.instance().getAllEmployeesByType(employeeType.trim())) {
            EmployeeBasicInfoReportDto dto = mapper.map(emp, EmployeeBasicInfoReportDto.class);
            dto.setFirstName(emp.getFirstName());
            dto.setLastName(emp.getLastName());
            dto.setEmail(EmployeeDao.instance().getPrimaryEmail(emp));
            dto.setType(emp.getEmployeeType().getName());
            res.add(dto);
        }
        String[] columnOrder = new String[]{"firstName", "lastName", "type", "email"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Email-Group-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }
}
