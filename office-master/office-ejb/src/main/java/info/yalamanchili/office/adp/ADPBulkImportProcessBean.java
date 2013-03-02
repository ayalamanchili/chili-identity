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
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        if (tsp != null) {
            for (AdpRecord record : adpMonthlyHoursImportAdapter.mapADPHoursRecords(bulkImport)) {
                if (record.getEmployee() != null && record.getHours() != null) {
                    TimeSheet timesheet = new TimeSheet();
                    timesheet.setAdpHours(record.getHours());
                    timesheet.setQuickBooksHours(BigDecimal.ZERO);
                    timesheet.setEmployee(record.getEmployee());
                    timesheet.setVersionStatus(VersionStatus.INACTIVE);
                    timesheet.setTimeSheetPeriod(tsp);
                    timesheet.setStartDate(tsp.getStartDate());
                    timesheet.setEndDate(tsp.getEndDate());
                    timesheet = em.merge(timesheet);
                    addBulkImportEntity(bulkImport, timesheet);
                }
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
        bulkImport = em.find(BulkImport.class, bulkImport.getId());
        for (BulkImportEntity entity : bulkImport.getEntities()) {
            Query q = em.createQuery("from " + entity.getEntityType() + " where id=:idParam");
            q.setParameter("idParam", entity.getEntityId());
            if (q.getResultList().size() > 0) {
                TimeSheet ts = (TimeSheet) q.getResultList().get(0);
                //TODO set the timesheet status as active and save the timesheet
                ts.setVersionStatus(VersionStatus.ACTIVE);
                em.merge(ts);
            }
        }
        return em.merge(bulkImport);
    }

    @Override
    public BulkImport revert(BulkImport bulkImport) {
        bulkImport = em.find(BulkImport.class, bulkImport.getId());
        for (BulkImportEntity entity : bulkImport.getEntities()) {
            Query q = em.createQuery("from " + entity.getEntityType() + " where id=:idParam");
            q.setParameter("idParam", entity.getEntityId());
            if (q.getResultList().size() > 0) {
                TimeSheet ts = (TimeSheet) q.getResultList().get(0);
                em.remove(ts);
            }
        }
        return em.merge(bulkImport);
    }

    protected void addBulkImportEntity(BulkImport bulkImport, TimeSheet timesheet) {
        BulkImportEntity biEntity = new BulkImportEntity();
        biEntity.setEntityType(TimeSheet.class.getCanonicalName());
        biEntity.setId(timesheet.getId());
        biEntity = em.merge(biEntity);
        bulkImport.addEntity(biEntity);
    }
}
