/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qb;

import info.yalamanchili.office.bulkimport.BulkImportProcess;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class QuickBooksBulkImportProcessBean implements BulkImportProcess {

    @Override
    public BulkImport submit(BulkImport bulkImport) {
        System.out.println("ddddddddddddddddd in submit");
        return bulkImport;
    }

    @Override
    public BulkImport resubmit(BulkImport bulkImport) {
        System.out.println("dddddddddddddddd in resubmit");
        return bulkImport;
    }

    @Override
    public BulkImport commit(BulkImport bulkImport) {
        System.out.println("ddddddddddddddd in commit");
        return bulkImport;
    }

    @Override
    public BulkImport revert(BulkImport bulkImport) {
        System.out.println("ddddddddddd in revert");
        return bulkImport;
    }
}
