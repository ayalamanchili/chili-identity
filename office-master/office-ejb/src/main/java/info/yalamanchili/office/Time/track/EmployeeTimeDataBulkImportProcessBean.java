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
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.model.time.TimeRecord;
import info.yalamanchili.office.model.time.TimeRecordCategory;
import info.yalamanchili.office.model.time.TimeRecordStatus;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class EmployeeTimeDataBulkImportProcessBean extends AbstractBulkImportProcess<CorporateTimeSheet> {

    @Autowired
    protected AvantelEmployeeTimeDataMapper avantelEmployeeTimeDataMapper;

    protected static final String SECOND_FLOOR = "2nd Floor";
    protected static final String RECEPTION = "Reception";

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected MongoOperations mongoTemplate;

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        List<TimeEntry> res = avantelEmployeeTimeDataMapper.mapAvantelTimeRecords(bulkImport);
        processTimeEntryRecords(bulkImport, res);
        return bulkImport;
    }

    public void processTimeEntryRecords(BulkImport bulkImport, List<TimeEntry> timeEntries) {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        Set<String> employeeIdsNotFound = new HashSet();
        for (Date entryDate : getDates(timeEntries)) {
            for (String empExtRefId : getEmployeeIds(timeEntries)) {
                if (ExternalRefDao.instance().findReferenceEntity(empExtRefId) == null) {
                    employeeIdsNotFound.add(empExtRefId);
                    continue;
                }
                Employee emp = (Employee) ExternalRefDao.instance().findReferenceEntity(empExtRefId);
                // second floor actual time
                StringBuilder secondFloorActualTimeNotes = new StringBuilder();
                long secondFloorActualTimeMinutes = caluclateMinutes(getTimeEntriesForEmployeeByDate(empExtRefId, entryDate, timeEntries, SECOND_FLOOR), secondFloorActualTimeNotes);
                createTimeRecord(emp.getId().toString(), secondFloorActualTimeMinutes, entryDate, entryDate, SECOND_FLOOR, secondFloorActualTimeNotes.toString());
//                    addBulkImportEntity(bulkImport, ts);
                // reception actual time
                StringBuilder receptionActualTimeNotes = new StringBuilder();
                long receptionActualTime = caluclateMinutes(getTimeEntriesForEmployeeByDate(empExtRefId, entryDate, timeEntries, RECEPTION), receptionActualTimeNotes);
                createTimeRecord(emp.getId().toString(), secondFloorActualTimeMinutes, entryDate, entryDate, RECEPTION, receptionActualTimeNotes.toString());
//                    addBulkImportEntity(bulkImport, ts);
            }
        }
        for (String notFoundEmpId : employeeIdsNotFound) {
            createBulkImportMessage(bulkImport, "employee.ref.not.found", notFoundEmpId, BulkImportMessageType.WARN);
        }
    }

    protected long caluclateMinutes(List<TimeEntry> entries, StringBuilder notes) {
        long minutes = 0;
        Date timeIn = null;
        Date timeOut = null;
        for (TimeEntry timeEntry : entries) {
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
            notes.append(timeEntry.describe()).append("\n");
        }
        return minutes;
    }

    protected void createTimeRecord(String employeeId, long minutes, Date startDate, Date endDate, String location, String notes) {
        TimeRecord ts = new TimeRecord();
        ts.setHours(new BigDecimal((double) minutes / (double) 60).setScale(2, RoundingMode.UP));
        ts.setCategory(TimeRecordCategory.Regular);
        ts.setStatus(TimeRecordStatus.Saved);
        ts.setEmployeeId(employeeId);
        ts.setStartDate(startDate);
        ts.setEndDate(endDate);
        ts.setNotes(notes);
        ts.getTags().add(location);
        mongoTemplate.save(ts);
    }

    protected List<TimeEntry> getTimeEntriesForEmployeeByDate(String empExtRefId, Date entryDate, List<TimeEntry> timeEntries, String location) {
        List<TimeEntry> res = new ArrayList();
        Predicate<TimeEntry> equalsDate = (TimeEntry te) -> te.getEntryDate().compareTo(entryDate) == 0;
        Predicate<TimeEntry> equalsEmp = (TimeEntry te) -> te.getEmployeeId().equals(empExtRefId);
        Predicate<TimeEntry> equalsLocation = (TimeEntry te) -> te.getLocation().equals(location);
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

    @Override
    protected CorporateTimeSheet saveOnCommit(CorporateTimeSheet entity) {
        entity.setStatus(TimeSheetStatus.Approved);
        return entity;
    }
}
