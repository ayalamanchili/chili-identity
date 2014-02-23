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
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class ConsultantTimeService {

    @Autowired
    protected ConsultantTimeSheetDao consultantTimeSheetDao;

    public void submitLeaveRequest(ConsultantTimeSheet request) {
        Employee emp=SecurityService.instance().getCurrentUser();
        request.setEmployee(emp);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("leaveRequest", request);
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("consultant_emp_leave_request_process", vars);
    }

    public static ConsultantTimeService instance() {
        return SpringContext.getBean(ConsultantTimeService.class);
    }
}
