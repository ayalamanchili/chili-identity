/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.profile;

import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
    public void generateEmployeBasicInfoReport(Employee currentEmp) {
        List<EmployeeBasicInfoReportDto> res = new ArrayList<EmployeeBasicInfoReportDto>();
        for (Employee emp : EmployeeDao.instance().query(0, 2000)) {
            res.add(mapper.map(emp, EmployeeBasicInfoReportDto.class));
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "employee-basic-info-report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), currentEmp.getPrimaryEmail().getEmail());
    }
}
