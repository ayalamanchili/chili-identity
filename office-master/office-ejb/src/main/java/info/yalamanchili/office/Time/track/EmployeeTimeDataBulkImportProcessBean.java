/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time.track;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bulkimport.BulkImportProcess;
import info.yalamanchili.office.dao.ext.ExternalRefDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeEntry;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class EmployeeTimeDataBulkImportProcessBean implements BulkImportProcess {

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        AvantelEmployeeTimeDataMapper mapper = SpringContext.getBean(AvantelEmployeeTimeDataMapper.class);
        List<TimeEntry> res = mapper.mapAvantelTimeRecords(bulkImport);
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

    protected void processTimeEntryRecords(List<TimeEntry> timeEntries) {
        for (Date date : getDates(timeEntries)) {
            for (String externalRefId : getEmployeeIds(timeEntries)) {
                Employee emp = (Employee) ExternalRefDao.instance().findReferenceEntity(externalRefId);
            }
        }
    }

    protected List<TimeEntry> getTimeEntriesForEmployee(Employee emp, List<TimeEntry> timeEntries) {

        return timeEntries;
    }

    protected List<String> getEmployeeIds(List<TimeEntry> timeEntries) {
        return null;
    }

    protected List<Date> getDates(List<TimeEntry> timeEntries) {
        return null;
    }
}
