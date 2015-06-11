/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.Time.track.EmployeeTimeDataBulkImportProcessBean;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.TimeRecordDao;
import info.yalamanchili.office.dto.time.AvantelTimeSummaryDto;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.model.time.TimeRecord;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
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
    @Autowired
    protected Mapper mapper;

    /**
     * this will generate a summary report of timerecords based on start and end
     * dates
     *
     * @param dto
     */
    public void getAllEmployeesSummaryReport(String email, TimeRecordDao.TimeRecordSearchDto dto) {
        List<AvantelTimeSummaryDto> res = new ArrayList();

        //
        //for loop of all india team employees (corporate employee whose branch is india)
        // find all time records get hours data and add and populate dto.
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee")) {

            if (Branch.Hyderabad.equals(emp.getBranch())) {

                AvantelTimeSummaryDto summaryRec = new AvantelTimeSummaryDto();

                BigDecimal cubicleHours = BigDecimal.ZERO;
                BigDecimal receptionHours = BigDecimal.ZERO;
                BigDecimal secondFloorHours = BigDecimal.ZERO;
          
                for (TimeRecord timeRecord : timeRecordDao.findAll(emp.getId().toString(), dto.getStartDate(), dto.getEndDate())) {
                    
                    // adding cubicleHours  
                     BigDecimal value = BigDecimal.ZERO;
                     BigInteger hours = BigInteger.ZERO;
                     BigInteger minutes = BigInteger.ZERO;
                     value = (timeRecord.getTags().get(EmployeeTimeDataBulkImportProcessBean.CUBICAL)).setScale(2, RoundingMode.HALF_EVEN);
                     hours = value.abs().toBigInteger();
                     minutes = ((value.subtract(new BigDecimal(hours))).multiply(new BigDecimal(10).pow(2))).toBigInteger();
                     cubicleHours = cubicleHours.add(new BigDecimal((hours.multiply(new BigInteger("60"))).add(minutes)));
                     // adding receptionHours  
                     value = BigDecimal.ZERO;
                     hours = BigInteger.ZERO;
                     minutes = BigInteger.ZERO;
                     value = (timeRecord.getTags().get(EmployeeTimeDataBulkImportProcessBean.RECEPTION)).setScale(2, RoundingMode.HALF_EVEN);
                     hours = value.abs().toBigInteger();
                     minutes = ((value.subtract(new BigDecimal(hours))).multiply(new BigDecimal(10).pow(2))).toBigInteger();
                     receptionHours = receptionHours.add(new BigDecimal((hours.multiply(new BigInteger("60"))).add(minutes)));
                     // adding secondFloorHours  
                     value = BigDecimal.ZERO;
                     hours = BigInteger.ZERO;
                     minutes = BigInteger.ZERO;
                     value = (timeRecord.getTags().get(EmployeeTimeDataBulkImportProcessBean.SECOND_FLOOR)).setScale(2, RoundingMode.HALF_EVEN);
                     hours = value.abs().toBigInteger();
                     minutes = ((value.subtract(new BigDecimal(hours))).multiply(new BigDecimal(10).pow(2))).toBigInteger();
                     secondFloorHours = secondFloorHours.add(new BigDecimal((hours.multiply(new BigInteger("60"))).add(minutes)));
                }
                
                long minutes = 0;
                long hours = 0;
                long mins = 0;
                String totaltime = " ";
                minutes = cubicleHours.longValue();
                hours = minutes / 60;
                mins  = minutes % 60;
                 if (mins > 0 && mins < 10) {
                    totaltime = hours+"."+"0"+mins;
                }
                else {
                    totaltime = hours+"."+mins;
                }
                totaltime = hours+"."+mins;
                summaryRec.setCubicalHours(new BigDecimal(totaltime));
                
                minutes = 0;
                hours = 0;
                mins = 0;
                totaltime = " ";
                minutes = receptionHours.longValue();
                hours = minutes / 60;
                mins  = minutes % 60;
                 if (mins > 0 && mins < 10) {
                    totaltime = hours+"."+"0"+mins;
                }
                else {
                    totaltime = hours+"."+mins;
                }
                summaryRec.setReceptionHours(new BigDecimal(totaltime));
                
                minutes = 0;
                hours = 0;
                mins = 0;
                totaltime = " ";
                minutes = secondFloorHours.longValue();
                hours = minutes / 60;
                mins  = minutes % 60;
                if (mins > 0 && mins < 10) {
                    totaltime = hours+"."+"0"+mins;
                }
                else {
                    totaltime = hours+"."+mins;
                }
                summaryRec.setSecondFloorHours(new BigDecimal(totaltime));
                
                summaryRec.setEmployee(emp.getFirstName() + " " + emp.getLastName());
                summaryRec.setStartDate(dto.getStartDate());
                summaryRec.setEndDate(dto.getEndDate());
                res.add(summaryRec);
            }
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "Attandance-Summary", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    public static TimeRecordService instance() {
        return SpringContext.getBean(TimeRecordService.class);
    }
}
