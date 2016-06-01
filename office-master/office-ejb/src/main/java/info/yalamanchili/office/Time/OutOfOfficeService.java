/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.OutOfOfficeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.entity.time.OutOfOfficeRequestStatus;
import java.util.HashMap;
import java.util.Map;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("prototype")
public class OutOfOfficeService {

    @Autowired
    protected Mapper mapper;

    public void submitRequest(OutOfOfficeRequest entity) {
        Employee emp;
        Map<String, Object> vars = new HashMap<>();
        emp = OfficeSecurityService.instance().getCurrentUser();
        entity.setEmployee(emp);
        entity.setStatus(OutOfOfficeRequestStatus.PENDING_MANAGER_APPROVAL);
        entity = OutOfOfficeDao.instance().save(entity);
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        vars.put("notifyEmployees", entity.getNotifyEmployees());
        vars.put("entityId", entity.getId());
        entity.setBpmProcessId(OfficeBPMService.instance().startProcess("outof_office_process", vars));
        OutOfOfficeDao.instance().getEntityManager().merge(entity);
    }

    public void updateRequest(OutOfOfficeRequest entity) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        submitRequest(entity);
    }

    public void delete(Long id) {
        OutOfOfficeRequest ticket = OutOfOfficeDao.instance().findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ticket.getBpmProcessId(), true);
        OutOfOfficeDao.instance().findById(id);
    }

    public static OutOfOfficeService instance() {
        return SpringContext.getBean(OutOfOfficeService.class);
    }

}
