/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class BulkImportProcessServcie {

    public BulkImport submit(BulkImport bulkImport) {
        BulkImportAdapter adapter = (BulkImportAdapter) SpringContext.getBean(bulkImport.getAdapter());
        return adapter.submit(bulkImport);
    }

    public BulkImport resubmit(BulkImport bulkImport) {
        return null;
    }

    public BulkImport commit(BulkImport bulkImport) {
        return null;
    }

    public BulkImport revert(BulkImport bulkImport) {
        return null;
    }
}
