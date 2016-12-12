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

import info.yalamanchili.office.bulkimport.AbstractBulkImportDocumentProcess;
import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.dao.time.TimeRecordDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeEntry;
import info.yalamanchili.office.model.time.TimeRecord;
import info.yalamanchili.office.model.time.TimeRecordCategory;
import info.yalamanchili.office.model.time.TimeRecordStatus;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component("AvantelTimeDataAdapter")
public class EmployeeTimeDataBulkImportProcessBean extends AbstractBulkImportDocumentProcess<TimeRecord> {

    @Autowired
    protected AvantelEmployeeTimeDataMapper avantelEmployeeTimeDataMapper;
    public static final String CUBICAL = "Cubical";
    public static final String SECOND_FLOOR = "2nd Floor";
    public static final String RECEPTION = "Reception";
    public static final String TIME_IN = "Time_In";
    public static final String TIME_OUT = "Time_Out";

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected TimeRecordDao timeRecordDao;

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        List<TimeEntry> res = avantelEmployeeTimeDataMapper.mapAvantelTimeRecords(bulkImport);
        processTimeEntryRecords(bulkImport, res);
        return bulkImport;
    }

    public void processTimeEntryRecords(BulkImport bulkImport, List<TimeEntry> timeEntries) {
        Set<String> employeeIdsNotFound = new HashSet();
        for (Date entryDate : getDates(timeEntries)) {
            for (String empExtRefId : getEmployeeIds(timeEntries)) {
                if (ExternalRefDao.instance().getExternalRefId("Avantel", empExtRefId) == null) {
                    employeeIdsNotFound.add(empExtRefId);
                    continue;
                }
                String empId = ExternalRefDao.instance().getTargetEntityIdForExternalId("Avantel", empExtRefId);
                Map<String, BigDecimal> hoursPerType = new HashMap();
                // RECEPTION actual time
                StringBuilder notes = new StringBuilder();
                hoursPerType.put(RECEPTION, caluclateBorderMinutes(getTimeEntriesForEmployeeByDate(empExtRefId, entryDate, timeEntries, RECEPTION), notes));
                List<TimeEntry> secondFloorTimeEntries = getTimeEntriesForEmployeeByDate(empExtRefId, entryDate, timeEntries, SECOND_FLOOR);
                // SECOND_FLOOR actual time
                hoursPerType.put(SECOND_FLOOR, caluclateBorderMinutes(secondFloorTimeEntries, notes));
                //Cubucal Hours
                hoursPerType.put(CUBICAL, caluclateMinutes(secondFloorTimeEntries, notes));
                //Time In
                if (secondFloorTimeEntries.size() > 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(secondFloorTimeEntries.get(0).getEntryTimeStamp());
                    Integer hours = calendar.get(Calendar.HOUR_OF_DAY);
                    Integer minutes = calendar.get(Calendar.MINUTE);
                    hoursPerType.put(TIME_IN, new BigDecimal(hours.toString() + "." + minutes.toString()));
                }
                // TIME OUT
                if (secondFloorTimeEntries.size() > 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(secondFloorTimeEntries.get(secondFloorTimeEntries.size() - 1).getEntryTimeStamp());
                    Integer hours = calendar.get(Calendar.HOUR_OF_DAY);
                    Integer minutes = calendar.get(Calendar.MINUTE);
                    hoursPerType.put(TIME_OUT, new BigDecimal(hours.toString() + "." + minutes.toString()));
                }
                TimeRecordStatus status;
                if (secondFloorTimeEntries.size() % 2 == 0) {
                    status = TimeRecordStatus.Saved;
                } else {
                    status = TimeRecordStatus.Error;
                }
                TimeRecord ts = createTimeRecord(empId, entryDate, entryDate, hoursPerType, status, notes.toString());
                if (ts != null) {
                    addBulkImportEntity(bulkImport, ts);
                }
            }
        }
        for (String notFoundEmpId : employeeIdsNotFound) {
            createBulkImportMessage(bulkImport, "employee.ref.not.found", notFoundEmpId, BulkImportMessageType.WARN);
        }
    }

    protected BigDecimal caluclateMinutes(List<TimeEntry> entries, StringBuilder notes) {
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
        long hours = minutes / 60;
        long mins = minutes % 60;
        String totaltime = " ";
        if (mins > 0 && mins < 10) {
            totaltime = hours + "." + "0" + mins;
        } else {
            totaltime = hours + "." + mins;
        }
        return new BigDecimal(totaltime);
    }

    protected BigDecimal caluclateBorderMinutes(List<TimeEntry> entries, StringBuilder notes) {
        long minutes = 0;
        if (entries.size() <= 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        Date timeIn = entries.get(0).getEntryTimeStamp();
        Date timeOut = entries.get(entries.size() - 1).getEntryTimeStamp();
        minutes = minutes + TimeUnit.MILLISECONDS.toMinutes(timeOut.getTime() - timeIn.getTime());
        long hours = minutes / 60;
        long mins = minutes % 60;
        String totaltime = " ";
        if (mins > 0 && mins < 10) {
            totaltime = hours + "." + "0" + mins;
        } else {
            totaltime = hours + "." + mins;
        }
        return new BigDecimal(totaltime);
    }

    protected TimeRecord createTimeRecord(String employeeId, Date startDate, Date endDate, Map<String, BigDecimal> hours, TimeRecordStatus status, String notes) {
        if (timeRecordDao.find(employeeId, startDate, endDate) != null) {
            return null;
        }
        TimeRecord ts = new TimeRecord();
        ts.setCategory(TimeRecordCategory.Regular);
        ts.setStatus(status);
        ts.setEmployeeId(employeeId);
        ts.setStartDate(startDate);
        ts.setEndDate(endDate);
        ts.setNotes(notes);
        ts.setTags(hours);
        timeRecordDao.save(ts);
        return ts;
    }

    protected List<TimeEntry> getTimeEntriesForEmployeeByDate(String empExtRefId, Date entryDate, List<TimeEntry> timeEntries, String location) {
        Predicate<TimeEntry> equalsDate = (TimeEntry te) -> te.getEntryDate().compareTo(entryDate) == 0;
        Predicate<TimeEntry> equalsEmp = (TimeEntry te) -> te.getEmployeeId().equals(empExtRefId);
        Predicate<TimeEntry> equalsLocation = (TimeEntry te) -> te.getLocation().equals(location);
        Predicate<TimeEntry> fullPredicate = equalsDate.and(equalsEmp).and(equalsLocation);
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
    protected TimeRecord saveOnCommit(TimeRecord entity) {
        entity.setStatus(TimeRecordStatus.Approved);
        return entity;
    }

    @Override
    public BulkImport revert(BulkImport bulkImport) {
        bulkImport.getEntities().stream().map((bie) -> bie.getEntityType().substring(bie.getEntityType().indexOf(":") + 1)).map((id) -> new Query(Criteria.where("id").is(id))).map((q) -> mongoTemplate.findOne(q, TimeRecord.class)).forEach((trec) -> {
            mongoTemplate.remove(trec);
        });
        return bulkImport;
    }

    @Override
    public BulkImport commit(BulkImport bulkImport) {
        bulkImport.getEntities().stream().map((bie) -> bie.getEntityType().substring(bie.getEntityType().indexOf(":") + 1)).map((id) -> new Query(Criteria.where("id").is(id))).map((q) -> mongoTemplate.findOne(q, TimeRecord.class)).map((trec) -> {
            if (trec.getStatus().equals(TimeRecordStatus.Saved)) {
                trec.setStatus(TimeRecordStatus.Approved);
            }
            return trec;
        }).forEach((trec) -> {
            mongoTemplate.save(trec);
        });
        return bulkImport;
    }
}
