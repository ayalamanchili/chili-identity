/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.bulkimport.BulkImportDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.entity.bulkimport.BulkImportStatus;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class BulkImportSubmit implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        BulkImportDao dao = BulkImportDao.instance();
        BulkImport bulkImport = dao.findById((Long) execution.getVariable("bulkImportId"));
        BulkImportProcess adapter = (BulkImportProcess) SpringContext.getBean(bulkImport.getAdapter());
        try {
            bulkImport = adapter.submit(bulkImport);
            bulkImport.setStatus(BulkImportStatus.SUBMITTED);
        } catch (Exception e) {
            BulkImportMessage msg = new BulkImportMessage();
            msg.setCode("ERROR");
            msg.setDescription(e.getLocalizedMessage());
            msg.setMessageType(BulkImportMessageType.ERROR);
            bulkImport.addMessage(msg);
            bulkImport.setStatus(BulkImportStatus.ERROR);
            BulkImportDao.instance().save(bulkImport);
            BulkImportDao.instance().getEntityManager().flush();
            execution.setVariable("bulkImportError", e.getLocalizedMessage());
            //TODO details
        } finally {
            execution.setVariable("bulkImport", bulkImport);
        }
        dao.save(bulkImport);
    }
}
