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
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
@Transactional
public class CorpEmpLeaveRequestProcessBean {

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
            //Send email about request rejection to employee
            return false;
        }
    }

    public void saveApprovedLeaveRequest(Employee emp, TimeSheetCategory category, String hours, String startDate, String endDate, String notes) {
        BigDecimal leaveHours = BigDecimal.valueOf(Long.valueOf(hours));
        CorporateTimeSheet ts = new CorporateTimeSheet();
        ts.setEmployee(emp);
        ts.setCategory(TimeSheetCategory.Sick_Spent);
        ts.setHours(leaveHours);
        //TODO fix
        ts.setStartDate(new Date());
        ts.setEndDate(new Date());
        ts.setNotes(notes);
        ts.setStatus(TimeSheetStatus.Approved);
        CorporateTimeSheetDao.instance().save(ts);
    }

    public void sendValidationFailedRejectionEmail(Employee emp) {
//TODO send email to emp that his leave request was denied since no availabel leaves
    }

}
