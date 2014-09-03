/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
@Transactional
public class ConsultantEmpLeaveRequestProcessBean {

    public boolean validateLeaveRequest(Employee employee, ConsultantTimeSheet entity) {
        //TODO
        return true;
    }
    protected static Set<TimeSheetCategory> noValidationsCategories = new HashSet<TimeSheetCategory>();

    static {
        noValidationsCategories.add(TimeSheetCategory.Unpaid);
        noValidationsCategories.add(TimeSheetCategory.JuryDuty);
        noValidationsCategories.add(TimeSheetCategory.Bereavement);
        noValidationsCategories.add(TimeSheetCategory.Maternity);
        noValidationsCategories.add(TimeSheetCategory.Other);
    }

    public void sendLeaveRequestRejectedEmail(Employee employee) {
        //TODO
    }

    public static ConsultantEmpLeaveRequestProcessBean instance() {
        return SpringContext.getBean(ConsultantEmpLeaveRequestProcessBean.class);
    }
}
