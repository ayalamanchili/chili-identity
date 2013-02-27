/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportStatus;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class BulkImportCommit implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        BulkImport bulkImport = (BulkImport) execution.getVariable("bulkImport");
        BulkImportProcess adapter = (BulkImportProcess) SpringContext.getBean(bulkImport.getAdapter());
        bulkImport.setStatus(BulkImportStatus.APPROVED);
        bulkImport = adapter.commit(bulkImport);
        execution.setVariable("bulkImport", bulkImport);
    }
}
