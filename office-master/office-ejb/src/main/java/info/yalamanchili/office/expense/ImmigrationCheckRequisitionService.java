/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.dao.expense.ImmigrationCheckRequisitionDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("request")
public class ImmigrationCheckRequisitionService {
    
    @Autowired
    protected ImmigrationCheckRequisitionDao immigrationCheckRequisitionDao;
    
    public void submitImmigrationCheckRequisition(ImmigrationCheckRequisition entity) {
        Map<String, Object> vars = new HashMap<>();        
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        entity.setSubmittedBy(emp);
        entity.setRequestedDate(new Date());
        vars.put("entity", entity);        
        vars.put("currentEmployee", entity.getEmployee());
        
        String processId = OfficeBPMService.instance().startProcess("immigration_check_requisition_process", vars);
        entity.setBpmProcessId(processId);
    }

    protected Task getTaskForTicket(ImmigrationCheckRequisition immigrationCheckRequisition) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(immigrationCheckRequisition.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        ImmigrationCheckRequisition ticket = immigrationCheckRequisitionDao.findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ticket.getBpmProcessId(), true);
        immigrationCheckRequisitionDao.delete(id);
    }
    
    
    public static ImmigrationCheckRequisitionService instance() {
        return SpringContext.getBean(ImmigrationCheckRequisitionService.class);
    }
    
}
