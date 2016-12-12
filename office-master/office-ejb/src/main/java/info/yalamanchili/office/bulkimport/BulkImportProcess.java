/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.yalamanchili.office.entity.bulkimport.BulkImport;

/**
 *
 * @author ayalamanchili
 */
public interface BulkImportProcess {

    public BulkImport submit(BulkImport bulkImport);

    public BulkImport resubmit(BulkImport bulkImport);

    public BulkImport commit(BulkImport bulkImport);

    public BulkImport revert(BulkImport bulkImport);
}
