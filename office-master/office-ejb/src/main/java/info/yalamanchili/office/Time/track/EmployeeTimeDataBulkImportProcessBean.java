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

import info.yalamanchili.office.bulkimport.AbstractBulkImportProcess;
import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeEntry;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class EmployeeTimeDataBulkImportProcessBean extends AbstractBulkImportProcess<CorporateTimeSheet> {

    @Autowired
    protected AvantelEmployeeTimeDataMapper avantelEmployeeTimeDataMapper;

    @PersistenceContext
    protected EntityManager em;

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        List<TimeEntry> res = avantelEmployeeTimeDataMapper.mapAvantelTimeRecords(bulkImport);
        processTimeEntryRecords(bulkImport, res);
        return bulkImport;
    }

    public void processTimeEntryRecords(BulkImport bulkImport, List<TimeEntry> timeEntries) {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        for (Date entryDate : getDates(timeEntries)) {
            for (String empExtRefId : getEmployeeIds(timeEntries)) {
                if (ExternalRefDao.instance().findReferenceEntity(empExtRefId) == null) {
                    createBulkImportMessage(bulkImport, "employee.ref.not.found", empExtRefId, BulkImportMessageType.WARN);
                    continue;
                }
                Employee emp = (Employee) ExternalRefDao.instance().findReferenceEntity(empExtRefId);
                long minutes = 0;
                Date timeIn = null;
                Date timeOut = null;
                StringBuilder notes = new StringBuilder();
                for (TimeEntry timeEntry : getTimeEntriesForEmployeeByDate(empExtRefId, entryDate, timeEntries)) {
                    if (timeIn == null) {
                        timeIn = timeEntry.getEntryTimeStamp();
                    } else {
                        timeOut = timeEntry.getEntryTimeStamp();
                    }
                    if (timeIn != null && timeOut != null) {
                        minutes = minutes + TimeUnit.MILLISECONDS.toMinutes(timeOut.getTime() - timeIn.getTime());
                        timeIn = null;
                        timeOut = null;
                    }
                    notes.append(timeEntry.describe() + "\n");
                }
                if (dao.findTimeSheet(emp, TimeSheetCategory.Regular, entryDate, entryDate) == null) {
                    CorporateTimeSheet ts = new CorporateTimeSheet();
                    ts.setHours(new BigDecimal((double) minutes / (double) 60).setScale(2, RoundingMode.UP));
                    ts.setCategory(TimeSheetCategory.Regular);
                    ts.setStatus(TimeSheetStatus.Saved);
                    ts.setEmployee(emp);
                    ts.setStartDate(entryDate);
                    ts.setEndDate(entryDate);
                    ts.setNotes(notes.toString());
                    ts = dao.save(ts);
                    addBulkImportEntity(bulkImport, ts);
                }
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

    @Override
    protected CorporateTimeSheet saveOnCommit(CorporateTimeSheet entity) {
        entity.setStatus(TimeSheetStatus.Approved);
        return entity;
    }
}
