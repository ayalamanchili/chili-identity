/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time.track;

import info.yalamanchili.office.entity.time.TimeEntry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.time.DateUtils;
import static org.junit.Assert.*;

/**
 *
 * @author ayalamanchili
 */
public class EmployeeTimeDataBulkImportProcessBeanTest {

    public EmployeeTimeDataBulkImportProcessBeanTest() {
    }

//    @Test
    public void testGetTimeEntriesForEmployeesByDate() {
        List<TimeEntry> timeEntries = new ArrayList();
        Date today = new Date();
        Date tomorrow = DateUtils.addDays(today, 1);
        TimeEntry te1 = new TimeEntry();
        te1.setEmployeeId("1200");
        te1.setEntryDate(today);
        te1.setEntryTimeStamp(new Date());
        timeEntries.add(te1);
        TimeEntry te2 = new TimeEntry();
        te2.setEmployeeId("1200");
        te2.setEntryDate(today);
        te2.setEntryTimeStamp(DateUtils.addHours(new Date(), 1));
        timeEntries.add(te2);
        TimeEntry te3 = new TimeEntry();
        te3.setEmployeeId("1200");
        te3.setEntryDate(today);
        te3.setEntryTimeStamp(DateUtils.addHours(new Date(), 2));
        timeEntries.add(te3);
        TimeEntry te4 = new TimeEntry();
        te4.setEmployeeId("1200");
        te4.setEntryDate(today);
        te4.setEntryTimeStamp(DateUtils.addHours(new Date(), 3));
        timeEntries.add(te4);
        EmployeeTimeDataBulkImportProcessBean instance = new EmployeeTimeDataBulkImportProcessBean();
        instance.processTimeEntryRecords(null, timeEntries);

    }

//    @Test
    public void testGetEmployees() {
        List<TimeEntry> timeEntries = new ArrayList();
        TimeEntry te1 = new TimeEntry();
        te1.setEmployeeId("1200");
        timeEntries.add(te1);
        TimeEntry te2 = new TimeEntry();
        te2.setEmployeeId("1201");
        timeEntries.add(te2);
        TimeEntry te3 = new TimeEntry();
        te3.setEmployeeId("1200");
        timeEntries.add(te3);
        EmployeeTimeDataBulkImportProcessBean instance = new EmployeeTimeDataBulkImportProcessBean();
        Set<String> expResult = null;
        Set<String> result = instance.getEmployeeIds(timeEntries);
        assertEquals(2, result.size());
    }

//    @Test
    public void testGetDates() {
        List<TimeEntry> timeEntries = new ArrayList();
        TimeEntry te1 = new TimeEntry();
        te1.setEntryDate(new Date());
        timeEntries.add(te1);
        TimeEntry te2 = new TimeEntry();
        te2.setEntryDate(new Date());
        timeEntries.add(te2);
        TimeEntry te3 = new TimeEntry();
        te3.setEntryDate(DateUtils.addDays(new Date(), 1));
        timeEntries.add(te3);
        EmployeeTimeDataBulkImportProcessBean instance = new EmployeeTimeDataBulkImportProcessBean();
        Set<Date> expResult = null;
        Set<Date> result = instance.getDates(timeEntries);
        assertEquals(2, result.size());
    }
}
