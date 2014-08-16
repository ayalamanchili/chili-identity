/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.commons.DateUtils;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import java.math.BigDecimal;
import java.util.Date;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 *
 * @author ayalamanchili
 */
public class NewEmpTimeCompletionJob implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Employee emp = (Employee) execution.getVariable("employee");
        emp = EmployeeDao.instance().findById(emp.getId());
        if (emp == null) {
            //TODO Throw fault error?
            return;
        }
        if ("New Employee Two Month Completion Job".equals(execution.getCurrentActivityName())) {
            runTwoMonthCompletionJob(emp, execution);
        }
        if ("New Employee Six Month Completion Job".equals(execution.getCurrentActivityName())) {
            runSixMonthCompletionJob(emp, execution);
        }
        if ("New Employee One Year Completion Job".equals(execution.getCurrentActivityName())) {
            runOneYearCompletionJob(emp, execution);
        }
    }

    protected void runTwoMonthCompletionJob(Employee emp, DelegateExecution execution) {
        Date startDate = emp.getStartDate();
        Date twoMonthCompletion = (Date) execution.getVariable("twoMonthCompletionDate");
        Date endDate = DateUtils.getLastDayCurrentOfYear();
        long proratedDays = DateUtils.getBetweenDay(startDate, endDate);
        BigDecimal proratedHours = DateUtils.getProratedHours(new BigDecimal("40.00"), new BigDecimal("365"), new BigDecimal(proratedDays));
        CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.PTO_Earned, proratedHours, startDate, endDate);
        //Create prorated timesheets for PTO,vacation
    }

    protected void runSixMonthCompletionJob(Employee emp, DelegateExecution execution) {
        Date sixMonthCompletionDate = (Date) execution.getVariable("sixMonthCompletionDate");
        //5 vacation days after 6 months
        CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_Earned, new BigDecimal(40), sixMonthCompletionDate, DateUtils.getNextMonth(sixMonthCompletionDate, 6));

    }

    protected void runOneYearCompletionJob(Employee emp, DelegateExecution execution) {
//        Date oneYearCompletionDate = (Date) execution.getVariable("oneYearCompletionDate");
        //5 vacation days after 1 year
//        CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_Earned, new BigDecimal(40), DateUtils.getFirstDayOfYear(new Date().getYear()), DateUtils.getLastDayOfYear(new Date().getYear()));
        // prorated vacation ,PTO 
    }
}
