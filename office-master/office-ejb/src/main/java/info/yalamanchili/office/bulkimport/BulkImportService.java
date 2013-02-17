/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.bulkimport.BulkImportDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class BulkImportService {

    @Autowired
    protected BulkImportDao bulkImportDao;

    public List<Entry> getBulkImportAdapters() {
        List<Entry> res = new ArrayList<Entry>();
        Integer i = 0;
        for (String name : SpringContext.getApplicationContext().getBeanNamesForType(BulkImportAdapter.class)) {
            Entry e = new Entry();
            e.setId(i.toString());
            e.setValue(name);
            res.add(e);
            i++;
        }
        return res;
    }
}
