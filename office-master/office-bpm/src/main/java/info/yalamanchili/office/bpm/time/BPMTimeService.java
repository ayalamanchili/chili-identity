/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.yalamanchili.office.bpm.profile.BPMProfileService;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void submitOverTimeAdjustmentHoursRequest(List<Entry> request) {
        Map<String, Object> vars = new HashMap<String, Object>();
        for (Entry entry : request) {
            vars.put(entry.getId(), entry.getValue());
        }
        officeBPMService.startProcess("overtime_hours_adjustment_process", vars);
    }
//TODO remove
//    @PostConstruct
//    public void registerProcesses() {
//        OfficeBPMService.instance().registerProcess("overtime_hours_adjustment_process", "info/yalamanchili/office/overtime_hours_adjustment_process.bpmn20.xml");
//    }

    public static BPMTimeService instance() {
        return (BPMTimeService) SpringContext.getBean("bpmTimeService");
    }
}
