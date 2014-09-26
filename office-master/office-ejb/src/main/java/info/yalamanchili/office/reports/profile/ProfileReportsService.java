/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.profile;

import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
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
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class ProfileReportsService {

    @Autowired
    protected Mapper mapper;

    @Async
    @Transactional
    public void generateEmployeBasicInfoReport(String email) {
        List<EmployeeBasicInfoReportDto> res = new ArrayList<EmployeeBasicInfoReportDto>();
        for (Employee emp : EmployeeDao.instance().query(0, 2000)) {
            EmployeeBasicInfoReportDto dto = mapper.map(emp, EmployeeBasicInfoReportDto.class);
            dto.setEmail(emp.getPrimaryEmail().getEmail());
            if (emp.getPhones().size() > 0) {
                dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
            }
            res.add(dto);
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "employee-basic-info-report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    @Async
    @Transactional
    public void generateEmployeClientInfoReport(String email) {
        List<EmployeeClientInfoReportDto> res = new ArrayList<EmployeeClientInfoReportDto>();
        for (Employee emp : EmployeeDao.instance().query(0, 2000)) {
            for (ClientInformation ci : emp.getClientInformations()) {
                EmployeeClientInfoReportDto dto = new EmployeeClientInfoReportDto();
                dto.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
                if (ci.getClient() != null) {
                    dto.setClientName(ci.getClient().getName());
                }
                if (ci.getVendor() != null) {
                    dto.setVendorName(ci.getVendor().getName());
                }
                dto.setStartDate(ci.getStartDate());
                dto.setEndDate(ci.getEndDate());
                res.add(dto);
            }
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "employee-client-info-report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }
}
