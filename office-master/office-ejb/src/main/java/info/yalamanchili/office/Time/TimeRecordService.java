/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.TimeRecordDao;
import info.yalamanchili.office.dto.time.AvantelTimeSummaryDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("prototype")
public class TimeRecordService {

    @Autowired  
    protected TimeRecordDao timeRecordDao;

    @Transactional(readOnly = true)
    public void getAllEmployeesSummaryReport(String email) {
        List<AvantelTimeSummaryDto> summary = new ArrayList<AvantelTimeSummaryDto>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee")) {
//            summary.add(getMonthlySummary(emp));
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(summary, "attendence-time-summary", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    public static CorporateTimeService instance() {
        return SpringContext.getBean(CorporateTimeService.class);
    }
}
