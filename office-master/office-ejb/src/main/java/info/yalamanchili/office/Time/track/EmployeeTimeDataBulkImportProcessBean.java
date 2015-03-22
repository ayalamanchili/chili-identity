/**
 * ;
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time.track;

import info.yalamanchili.office.bulkimport.BulkImportProcess;
import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeEntry;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class EmployeeTimeDataBulkImportProcessBean implements BulkImportProcess {

    @Autowired
    protected AvantelEmployeeTimeDataMapper avantelEmployeeTimeDataMapper;

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        List<TimeEntry> res = avantelEmployeeTimeDataMapper.mapAvantelTimeRecords(bulkImport);
        processTimeEntryRecords(res);
        return bulkImport;
    }

    @Override
    public BulkImport resubmit(BulkImport bulkImport) {
        return bulkImport;
    }

    @Override
    public BulkImport commit(BulkImport bulkImport) {
        return bulkImport;
    }

    @Override
    public BulkImport revert(BulkImport bulkImport) {
        return bulkImport;
    }

    public void processTimeEntryRecords(List<TimeEntry> timeEntries) {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        for (Date entryDate : getDates(timeEntries)) {
            for (String empExtRefId : getEmployeeIds(timeEntries)) {
                if(empExtRefId.equals("12000")){
                    System.out.println("asdf");
                }
                if (ExternalRefDao.instance().findReferenceEntity(empExtRefId) == null) {
                    continue;
                }
                Employee emp = (Employee) ExternalRefDao.instance().findReferenceEntity(empExtRefId);
                long minutes = 0;
                Date timeIn = null;
                Date timeOut = null;
                for (TimeEntry timeEntry : getTimeEntriesForEmployeeByDate(empExtRefId, entryDate, timeEntries)) {
                    if (timeIn == null) {
                        timeIn = timeEntry.getEntryTimeStamp();
                    } else {
                        timeOut = timeEntry.getEntryTimeStamp();
                    }
                    if (timeIn != null && timeOut != null) {
                        //TODO save timein and out;
                        minutes = minutes + TimeUnit.MILLISECONDS.toMinutes(timeOut.getTime() - timeIn.getTime());
                        timeIn = null;
                        timeOut = null;
                    }
                }
                CorporateTimeSheet ts = new CorporateTimeSheet();
                ts.setHours(new BigDecimal(minutes / 60));
                ts.setCategory(TimeSheetCategory.Regular);
                ts.setStatus(TimeSheetStatus.Saved);
                ts.setEmployee(emp);
                ts.setStartDate(entryDate);
                ts.setEndDate(entryDate);
                dao.save(ts);
            }
        }
    }

    protected List<TimeEntry> getTimeEntriesForEmployeeByDate(String empExtRefId, Date entryDate, List<TimeEntry> timeEntries) {
        List<TimeEntry> res = new ArrayList();
        for (TimeEntry te : timeEntries) {
            if (te.getEntryDate().compareTo(entryDate) == 0 && te.getEmployeeId().equals(empExtRefId)) {
                res.add(te);
            }
        }
        return res;
    }

    protected Set<String> getEmployeeIds(List<TimeEntry> timeEntries) {
        Set<String> employeeIds = new HashSet();
        for (TimeEntry te : timeEntries) {
            employeeIds.add(te.getEmployeeId());
        }
        return employeeIds;
    }

    protected Set<Date> getDates(List<TimeEntry> timeEntries) {
        Set<Date> dates = new HashSet();
        for (TimeEntry te : timeEntries) {
            dates.add(te.getEntryDate());
        }
        return dates;
    }
}
