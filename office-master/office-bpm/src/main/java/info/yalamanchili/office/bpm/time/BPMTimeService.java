/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.commons.DateUtils;
import info.yalamanchili.office.bpm.profile.BPMProfileService;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.profile.Employee;
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
        Map<String, Object> vars = new HashMap<>();
        for (Entry entry : request) {
            vars.put(entry.getId(), entry.getValue());
        }
        vars.put("requestedDate", new Date());
        officeBPMService.startProcess("overtime_hours_adjustment_process", vars);
    }

    public String startBulkImportProcess(BulkImport bulkImport) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("bulkImport", bulkImport);
        vars.put("bulkImportId", bulkImport.getId());
        return officeBPMService.startProcess("bulkimport_process", vars);
    }

    @Async
    public void startNewEmpTimeProcess(Employee emp) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("employee", emp);
        //TODO currently the date time set to middle of day at 12.00 PM should be change to 12.00 AM (begining)
        vars.put("twoMonthCompletionDate", DateUtils.getNextMonth(emp.getStartDate(), 2));
        vars.put("sixMonthCompletionDate", DateUtils.getNextMonth(emp.getStartDate(), 6));
        vars.put("oneYearCompletionDate", DateUtils.getNextYear(emp.getStartDate(), 1));
        officeBPMService.startProcess("new_employee_time_process", vars);
    }

    public static BPMTimeService instance() {
        return (BPMTimeService) SpringContext.getBean("bpmTimeService");
    }
}
