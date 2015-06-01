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
import info.yalamanchili.office.dao.time.TimeRecordDao;
import info.yalamanchili.office.dto.time.AvantelTimeSummaryDto;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("prototype")
public class TimeRecordService {

    @Autowired
    protected TimeRecordDao timeRecordDao;

    /**
     * this will generate a summary report of timerecords based on start and end
     * dates
     *
     * @param dto
     */
    public void report(TimeRecordDao.TimeRecordSearchDto dto, String email) {
        List<AvantelTimeSummaryDto> res = new ArrayList();
        //for loop of all india team employees (corporate employee whose branch is india)
        // find all time records get hours data and add and populate dto.
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "attandance-summary", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);

    }

    public static CorporateTimeService instance() {
        return SpringContext.getBean(CorporateTimeService.class);
    }
}
