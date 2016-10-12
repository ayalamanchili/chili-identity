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
import info.yalamanchili.office.Time.track.EmployeeTimeDataBulkImportProcessBean;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.time.TimeRecordDao;
import info.yalamanchili.office.dto.time.AvantelTimeSummaryDto;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
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
import org.springframework.scheduling.annotation.Async;
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
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected CorporateTimeSheetDao corporateTimeSheetDao;

    /**
     * this will generate a summary report of timerecords based on start and end
     * dates
     *
     * @param dto
     */
    public void getAllEmployeesSummaryReport(String email, TimeRecordDao.TimeRecordSearchDto dto) {

        List<AvantelTimeSummaryDto> res = new ArrayList();

        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE)) {

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
                    hours = hours.add(value.abs().toBigInteger());
                    minutes = minutes.add(((value.subtract(new BigDecimal(hours))).multiply(new BigDecimal(10).pow(2))).toBigInteger());
                    cubicleHours = cubicleHours.add(new BigDecimal((hours.multiply(new BigInteger("60"))).add(minutes)));
                    // adding receptionHours  
                    value = BigDecimal.ZERO;
                    hours = BigInteger.ZERO;
                    minutes = BigInteger.ZERO;
                    value = (timeRecord.getTags().get(EmployeeTimeDataBulkImportProcessBean.RECEPTION)).setScale(2, RoundingMode.HALF_EVEN);
                    hours = hours.add(value.abs().toBigInteger());
                    minutes = minutes.add(((value.subtract(new BigDecimal(hours))).multiply(new BigDecimal(10).pow(2))).toBigInteger());
                    receptionHours = receptionHours.add(new BigDecimal((hours.multiply(new BigInteger("60"))).add(minutes)));
                    // adding secondFloorHours  
                    value = BigDecimal.ZERO;
                    hours = BigInteger.ZERO;
                    minutes = BigInteger.ZERO;
                    value = (timeRecord.getTags().get(EmployeeTimeDataBulkImportProcessBean.SECOND_FLOOR)).setScale(2, RoundingMode.HALF_EVEN);
                    hours = hours.add(value.abs().toBigInteger());
                    minutes = minutes.add(((value.subtract(new BigDecimal(hours))).multiply(new BigDecimal(10).pow(2))).toBigInteger());
                    secondFloorHours = secondFloorHours.add(new BigDecimal((hours.multiply(new BigInteger("60"))).add(minutes)));
                }
                // calculating cubicleHours  
                long minutes = 0;
                long hours = 0;
                long mins = 0;
                String totaltime = " ";
                minutes = cubicleHours.longValue();
                hours = minutes / 60;
                mins = minutes % 60;
                if (mins > 0 && mins < 10) {
                    totaltime = hours + "." + "0" + mins;
                } else {
                    totaltime = hours + "." + mins;
                }
                totaltime = hours + "." + mins;
                summaryRec.setCubicalHours(new BigDecimal(totaltime));
                // calculating receptionHours  
                minutes = 0;
                hours = 0;
                mins = 0;
                totaltime = " ";
                minutes = receptionHours.longValue();
                hours = minutes / 60;
                mins = minutes % 60;
                if (mins > 0 && mins < 10) {
                    totaltime = hours + "." + "0" + mins;
                } else {
                    totaltime = hours + "." + mins;
                }
                summaryRec.setReceptionHours(new BigDecimal(totaltime));
                // calculating secondFloorHours 
                minutes = 0;
                hours = 0;
                mins = 0;
                totaltime = " ";
                minutes = secondFloorHours.longValue();
                hours = minutes / 60;
                mins = minutes % 60;
                if (mins > 0 && mins < 10) {
                    totaltime = hours + "." + "0" + mins;
                } else {
                    totaltime = hours + "." + mins;
                }
                summaryRec.setSecondFloorHours(new BigDecimal(totaltime));

                summaryRec.setEmployee(emp.getFirstName() + " " + emp.getLastName());
                summaryRec.setStartDate(dto.getStartDate());
                summaryRec.setEndDate(dto.getEndDate());
                summaryRec.setAvailablePaidTimeOffHours(corporateTimeSheetDao.getPTOAccruedTimeSheet(emp).getHours());

                res.add(summaryRec);
            }
        }

        // Columns order in the report can be set with either of below options
        // # 1 AbstractColumn class used to create Column order, titcle and format. Added the columsn in the required order to List<AbstractColumn> and 
        //     then the List<AbstractColumn> has to be passed to ReportGenerator class. 
        // # 2 String Array = Give the columns in the required order in the String Array and pass it to ReportGenerator class 
        // # 1 AbstraceColumn - Setting columns names and order. Add Columns to the List.
//        AbstractColumn columnEmpNo = createColumn("employee", String.class,"Employee");
//        AbstractColumn columnStartDate = createColumn("startDate", Date.class,"Start Date");
//        AbstractColumn columnEndDate = createColumn("endDate", Date.class,"End Date");
//        AbstractColumn columnReception = createColumn("receptionHours", BigDecimal.class,"Reception Hours");        
//        AbstractColumn columnSecondFloor = createColumn("secondFloorHours", BigDecimal.class,"Second Floor Hours");
//        AbstractColumn columnCubical = createColumn("cubicalHours", BigDecimal.class,"Cubical Hours");
//        AbstractColumn columnAvailablePTO = createColumn("availablePTOHours", BigDecimal.class,"Available PTO Hours");
//        List<AbstractColumn> columns = new ArrayList<> ();
//        columns.add(columnEmpNo);
//        columns.add(columnStartDate);
//        columns.add(columnEndDate);
//        columns.add(columnReception);
//        columns.add(columnSecondFloor);
//        columns.add(columnCubical);
//        columns.add(columnAvailablePTO);
        // # 2 String Array - Setting columns names and order
        String[] columnOrder = new String[]{"employee", "startDate", "endDate", "receptionHours", "secondFloorHours", "cubicalHours", "availablePaidTimeOffHours"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Attendance-Summary", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    @Async
    @Transactional
    public void generateEmpAttendenceReport(List<TimeRecord> timeRcrds, String email, Employee emp) {
        List<AvantelTimeSummaryDto> res = new ArrayList();
        for (TimeRecord tr : timeRcrds) {
            res.add(populateAttendenceValues(tr, emp));
        }
        String[] columnOrder = new String[]{"employee", "startDate", "endDate", "timeIn", "timeOut", "receptionHours", "secondFloorHours", "cubicalHours", "status"};
        String fileName = ReportGenerator.generateExcelOrderedReport(res, "Employee Attendence Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, email);
    }

    public List<AvantelTimeSummaryDto> generateBranchAttendenceReport(TimeRecordDao.TimeRecordSearchDto dto) {
        List<AvantelTimeSummaryDto> res = new ArrayList();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE)) {
            if (emp.getBranch() != null) {
                if (Branch.Hyderabad.name().equals(emp.getBranch().name().trim())) {
                    TimeRecord.TimeRecordsTable table = timeRecordDao.getTimeRecords(emp.getId().toString(), dto.getStartDate(), dto.getEndDate(), 0, 10000);
                    if (table.getSize() > 0) {
                        List<TimeRecord> list = new ArrayList();
                        list.addAll(table.getEntities());
                        for (TimeRecord tr : list) {
                            res.add(populateAttendenceValues(tr, emp));
                        }
                    }
                }
            }
        }
        return res;
    }

    public AvantelTimeSummaryDto populateAttendenceValues(TimeRecord tr, Employee emp) {
        AvantelTimeSummaryDto dto = new AvantelTimeSummaryDto();
        dto.setEmployee(emp.getFirstName() + " " + emp.getLastName());
        dto.setStartDate(tr.getStartDate());
        dto.setEndDate(tr.getEndDate());
        dto.setTimeIn(tr.getTags().get("Time_In"));
        dto.setTimeOut(tr.getTags().get("Time_Out"));
        dto.setReceptionHours(tr.getTags().get("Reception"));
        dto.setSecondFloorHours(tr.getTags().get("2nd Floor"));
        dto.setCubicalHours(tr.getTags().get("Cubical"));
        dto.setStatus(tr.getStatus().name());
        return dto;
    }

    public static TimeRecordService instance() {
        return SpringContext.getBean(TimeRecordService.class);
    }

//    private AbstractColumn createColumn(String property, Class type,String title)throws ColumnBuilderException {
//        AbstractColumn columnState = ColumnBuilder.getNew().setColumnProperty(property, type.getName()).setTitle(title).build();
//        return columnState;
//    }
}
