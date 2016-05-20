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
import info.yalamanchili.office.dao.profile.EmployeeDao;
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

    public OutOfOfficeRequest submitRequest(OutOfOfficeRequest entity) {
        Employee emp;
        Map<String, Object> vars = new HashMap<>();
        if (entity.getEmployee().getId() != null) {
            emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
        } else {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        entity.setEmployee(emp);
        entity.setStatus(OutOfOfficeRequestStatus.PENDING_MANAGER_APPROVAL);
        OutOfOfficeRequest officeRequest = OutOfOfficeDao.instance().save(entity);
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        vars.put("notifyEmployees", entity.getNotifyEmployees());
        vars.put("entityId", officeRequest.getId());
        String process = OfficeBPMService.instance().startProcess("outof_office_process", vars);
        entity.setBpmProcessId(process);
        return entity;
    }

    public static OutOfOfficeService instance() {
        return SpringContext.getBean(OutOfOfficeService.class);
    }

}
