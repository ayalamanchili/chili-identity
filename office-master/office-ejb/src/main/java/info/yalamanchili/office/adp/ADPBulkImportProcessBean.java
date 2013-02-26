/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.adp;

import info.yalamanchili.office.bulkimport.BulkImportProcess;
import info.yalamanchili.office.entity.VersionStatus;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportEntity;
import info.yalamanchili.office.entity.time.TimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class ADPBulkImportProcessBean implements BulkImportProcess {

    private final static Logger logger = Logger.getLogger(ADPBulkImportProcessBean.class.getName());
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    ADPMonthlyHoursImportAdapter adpMonthlyHoursImportAdapter;

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        TimeSheetPeriod tsp = adpMonthlyHoursImportAdapter.getImportMonth(bulkImport);
        for (AdpRecord record : adpMonthlyHoursImportAdapter.mapADPHoursRecords(bulkImport)) {
            if (record.getEmployee() != null) {
                TimeSheet timesheet = new TimeSheet();
                timesheet.setAdpHours(record.getHours());
                timesheet.setEmployee(record.getEmployee());
//                timesheet.setVersionStatus(VersionStatus.INACTIVE);
                timesheet.setTimeSheetPeriod(tsp);
                timesheet = em.merge(timesheet);
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
    public BulkImport commit(BulkImport bulkImport) {

        return bulkImport;
    }

    @Override
    public BulkImport revert(BulkImport bulkImport) {

        return bulkImport;
    }

    protected void addBulkImportEntity(BulkImport bulkImport, TimeSheet timesheet) {
        BulkImportEntity biEntity = new BulkImportEntity();
        biEntity.setEntityType(TimeSheet.class.getCanonicalName());
        biEntity.setId(timesheet.getId());
        bulkImport.addEntity(biEntity);
    }
}
