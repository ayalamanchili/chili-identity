/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportStatus;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 *
 * @author ayalamanchili
 */
public class BulkImportCommit implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        BulkImport bulkImport = (BulkImport) execution.getVariable("bulkImport");
        BulkImportProcess adapter = (BulkImportProcess) SpringContext.getBean(bulkImport.getAdapter());
        bulkImport.setStatus(BulkImportStatus.APPROVED);
        adapter.commit(bulkImport);
    }
}
