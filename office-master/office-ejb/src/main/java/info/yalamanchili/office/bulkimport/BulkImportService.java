/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.time.BPMTimeService;
import info.yalamanchili.office.dao.bulkimport.BulkImportDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportStatus;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    @PersistenceContext
    protected EntityManager em;

    public String saveBulkUpload(BulkImport entity) {
        entity.setStatus(BulkImportStatus.NEW);
        entity = bulkImportDao.save(entity);
        entity.setBpmProcessId(BPMTimeService.instance().startBulkImportProcess(entity));
        return bulkImportDao.save(entity).getId().toString();
    }

    public void delete(Long id) {
        BulkImport entity = bulkImportDao.findById(id);
        BulkImportProcess adapter = (BulkImportProcess) SpringContext.getBean(entity.getAdapter());
        adapter.revert(entity);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        bulkImportDao.delete(id);
    }

    public List<Entry> getBulkImportAdapters() {
        List<Entry> res = new ArrayList<Entry>();
        Integer i = 0;
        for (String name : SpringContext.getApplicationContext().getBeanNamesForType(BulkImportProcess.class)) {
            Entry e = new Entry();
            e.setId(i.toString());
//            if (name.contains("BulkImportProcessBean")) {
//                name = name.replace("BulkImportProcessBean", "");
//            }
            e.setValue(name);
            res.add(e);
            i++;
        }
        return res;
    }
}
