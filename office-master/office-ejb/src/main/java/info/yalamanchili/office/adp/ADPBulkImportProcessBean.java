/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.adp;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bulkimport.AbstractBulkImportProcess;
import info.yalamanchili.office.dao.time.TimeSheetDao;
import info.yalamanchili.office.entity.VersionStatus;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.entity.time.TimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component("ADPDataImportAdapter")
public class ADPBulkImportProcessBean extends AbstractBulkImportProcess<TimeSheet> {

    private final static Logger logger = Logger.getLogger(ADPBulkImportProcessBean.class.getName());
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    ADPMonthlyHoursImportAdapter adpMonthlyHoursImportAdapter;

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        TimeSheetPeriod tsp = adpMonthlyHoursImportAdapter.getImportMonth(bulkImport);
        if (tsp != null) {
            for (AdpRecord record : adpMonthlyHoursImportAdapter.mapADPHoursRecords(bulkImport)) {
                TimeSheet timesheet = new TimeSheet();
                timesheet.setAdpHours(record.getHours());
                timesheet.setQuickBooksHours(BigDecimal.ZERO);
                timesheet.setEmployee(record.getEmployee());
                timesheet.setVersionStatus(VersionStatus.INACTIVE);
                timesheet.setTimeSheetPeriod(tsp);
                timesheet.setStartDate(tsp.getStartDate());
                timesheet.setEndDate(tsp.getEndDate());
                try {
                    timesheet = TimeSheetDao.instance().save(timesheet);
                } catch (ServiceException e) {
                    adpMonthlyHoursImportAdapter.createBulkImportMessage(bulkImport, "timesheet.invalid", e.getErrors().getErrors().get(0).getDescription(), BulkImportMessageType.ERROR);
                }
                addBulkImportEntity(bulkImport, timesheet);
            }
        }
        return em.merge(bulkImport);
    }

    @Override
    public BulkImport resubmit(BulkImport bulkImport) {
        return bulkImport;
    }

    @Override
    protected TimeSheet saveOnCommit(TimeSheet entity) {
        entity.setVersionStatus(VersionStatus.ACTIVE);
        return entity;
    }
}
