/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.yalamanchili.office.bpm.profile.BPMProfileService;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component("bpmTimeService")
public class BPMTimeService {

    private final static Logger logger = Logger.getLogger(BPMProfileService.class.getName());
    @Autowired
    protected OfficeBPMService officeBPMService;

    @Async
    public void submitOverTimePayRequest(List<Entry> request) {
        Map<String, Object> vars = new HashMap<String, Object>();
        for (Entry entry : request) {
            vars.put(entry.getId(), entry.getValue());
        }
        vars.put("requestedDate", new Date());
        officeBPMService.startProcess("overtime_hours_adjustment_process", vars);
    }

    @Async
    public void startBulkImportProcess(BulkImport bulkImport) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("bulkImport", bulkImport);
        officeBPMService.startProcess("bulkimport_process", vars);
    }

    public static BPMTimeService instance() {
        return (BPMTimeService) SpringContext.getBean("bpmTimeService");
    }
}
