/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import java.math.BigDecimal;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class CorpEmpLeaveRequestValidator {

    public boolean validateLeaveRequest(Employee employee, String category, String hours) {
        BigDecimal leaveHours = BigDecimal.valueOf(Long.valueOf(hours));
        TimeSheetCategory tsCategory = TimeSheetCategory.valueOf(category);
        if (TimeSheetCategory.Unpaid.equals(tsCategory)) {
            return true;
        }
        BigDecimal earned = CorporateTimeSheetDao.instance().getHoursInCurrentYear(employee, TimeSheetCategory.valueOf(category.replace("Spent", "Earned")));
        BigDecimal spent = CorporateTimeSheetDao.instance().getHoursInCurrentYear(employee, tsCategory);
        if (spent.add(leaveHours).subtract(earned).compareTo(BigDecimal.ZERO) < 0) {
            return true;
        } else {
            //TODO send email 
            return false;
        }
    }
}
