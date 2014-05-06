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
import info.yalamanchili.office.Time.CorporateTimeService;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class AdvanceRequisitionService {

    public void submitAdvanceRequisition(AdvanceRequisition entity) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);
        Employee emp = SecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("advance_requisition_process", vars);
    }

    public static AdvanceRequisitionService instance() {
        return SpringContext.getBean(AdvanceRequisitionService.class);
    }
}
