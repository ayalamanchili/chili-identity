/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qb;

import info.yalamanchili.office.bulkimport.BulkImportAdapter;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class QuickBooksBulkImportAdapter implements BulkImportAdapter {

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        return null;
    }

    @Override
    public BulkImport resubmit(BulkImport bulkImport) {
        return null;
    }

    @Override
    public BulkImport commit(BulkImport bulkImport) {
        return null;
    }

    @Override
    public BulkImport revert(BulkImport bulkImport) {
        return null;
    }
}
