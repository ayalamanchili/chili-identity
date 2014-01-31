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
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.bpm.time.CorpEmpLeaveRequest;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dto.time.CorporateYealyTimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("request")
public class CorporateTimeService {

    @Autowired
    protected CorporateTimeSheetDao corporateTimeSheetDao;

    public void submitLeaveRequest(CorpEmpLeaveRequest request) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("request", request);
        vars.put("currentEmployee", SecurityService.instance().getCurrentUser());
        OfficeBPMService.instance().startProcess("corp_emp_leave_request_process", vars);
    }

    public CorporateYealyTimeSummary getYearlySummary(Employee employee) {
        CorporateYealyTimeSummary summary = new CorporateYealyTimeSummary();
        summary.setAvailablePersonalHours(getYearlyPeronalBalance(employee));
        summary.setAvailableSickHours(getYearlySickBalance(employee));
        summary.setAvailableVacationHours(getYearlyVacationBalance(employee));
        return summary;
    }

    public BigDecimal getYearlySickBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Sick_Earned);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Sick_Spent);
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyPeronalBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Personal_Earned);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Personal_Spent);
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyVacationBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Vacation_Earned);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Vacation_Spent);
        return earned.subtract(spent);
    }

    public static CorporateTimeService instance() {
        return SpringContext.getBean(CorporateTimeService.class);
    }
}
