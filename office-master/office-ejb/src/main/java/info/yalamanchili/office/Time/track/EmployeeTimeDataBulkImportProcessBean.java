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
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeEntry;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BulkImport commit(BulkImport bulkImport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BulkImport revert(BulkImport bulkImport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void processTimeEntryRecords(List<TimeEntry> timeEntries) {
//        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        getDates(timeEntries).stream().forEach((entryDate) -> {
            getEmployeeIds(timeEntries).stream().forEach((empExtRefId) -> {
                Employee emp = (Employee) ExternalRefDao.instance().findReferenceEntity(empExtRefId);
                getTimeEntriesForEmployeeByDate(empExtRefId, entryDate, timeEntries).stream().forEach((timeEntry) -> {
                    CorporateTimeSheet ts = new CorporateTimeSheet();
                    ts.setCategory(TimeSheetCategory.Regular);
                    ts.setStatus(TimeSheetStatus.Saved);
                    ts.setEmployee(emp);
                    ts.setStartDate(entryDate);
                    ts.setEndDate(entryDate);
//                    dao.save(ts);
                });
            });
        });
    }

    protected List<TimeEntry> getTimeEntriesForEmployeeByDate(String empExtRefId, Date entryDate, List<TimeEntry> timeEntries) {
        List<TimeEntry> res = new ArrayList();
        Predicate<TimeEntry> equalsDate = (TimeEntry te) -> te.getEntryDate().compareTo(entryDate) == 0;
        Predicate<TimeEntry> equalsEmp = (TimeEntry te) -> te.getEmployeeId().equals(empExtRefId);
        Predicate<TimeEntry> fullPredicate = equalsDate.and(equalsEmp);
        return timeEntries.stream().filter(fullPredicate)
                .collect(Collectors.toList());
    }

    protected Set<String> getEmployeeIds(List<TimeEntry> timeEntries) {
        Set<String> employeeIds = new HashSet();
        timeEntries.stream().forEach((te) -> {
            employeeIds.add(te.getEmployeeId());
        });
        return employeeIds;
    }

    protected Set<Date> getDates(List<TimeEntry> timeEntries) {
        Set<Date> dates = new HashSet();
        timeEntries.stream().forEach((te) -> {
            dates.add(te.getEntryDate());
        });
        return dates;
    }
}
