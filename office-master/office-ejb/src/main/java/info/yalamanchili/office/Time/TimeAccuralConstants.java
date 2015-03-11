/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.commons.DateUtils;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anuyalamanchili
 */
//TODO externalize this?
public class TimeAccuralConstants {

    public static final BigDecimal totalMonthlyHours = new BigDecimal("168.00");

    /**
     * monthly hours accrual
     */
    public static final BigDecimal lessThanOneYearHoursAccural = new BigDecimal("6.667");
    public static final BigDecimal twoToFourYearsHoursAccural = new BigDecimal("12.00");
    public static final BigDecimal fiveToTenYearsHoursAccural = new BigDecimal("14.667");
    public static final BigDecimal moreThanTenYearsHoursAccural = new BigDecimal("16.667");
    /**
     * max hours accrual
     */
    public static final BigDecimal lessThanOneYearHoursAccuralMax = new BigDecimal("80.00");
    public static final BigDecimal twoToFourYearsHoursAccuralMax = new BigDecimal("144.00");
    public static final BigDecimal fiveToTenYearsHoursAccuralMax = new BigDecimal("176.00");
    public static final BigDecimal moreThanTenYearsHoursAccuralMax = new BigDecimal("200.00");
    /**
     * yearly Accrual for India team
     */
    public static final BigDecimal indiaTeamMonthlyAccrual = new BigDecimal("12.00");

    public static BigDecimal lessThanOneYearAccuralMax(Employee emp) {
        if (emp.getHoursPerWeek() == null || emp.getHoursPerWeek().equals(40)) {
            return lessThanOneYearHoursAccuralMax;
        } else {
            return DateUtils.getProratedHours(lessThanOneYearHoursAccuralMax, new BigDecimal("40"), new BigDecimal(emp.getHoursPerWeek()));
        }
    }

    public static BigDecimal twoToFourYearsHoursAccuralMax(Employee emp) {
        if (emp.getHoursPerWeek() == null || emp.getHoursPerWeek().equals(40)) {
            return twoToFourYearsHoursAccuralMax;
        } else {
            return DateUtils.getProratedHours(twoToFourYearsHoursAccuralMax, new BigDecimal("40"), new BigDecimal(emp.getHoursPerWeek()));
        }
    }

    public static BigDecimal fiveToTenYearsHoursAccuralMax(Employee emp) {
        if (emp.getHoursPerWeek() == null || emp.getHoursPerWeek().equals(40)) {
            return fiveToTenYearsHoursAccuralMax;
        } else {
            return DateUtils.getProratedHours(fiveToTenYearsHoursAccuralMax, new BigDecimal("40"), new BigDecimal(emp.getHoursPerWeek()));
        }
    }

    public static BigDecimal moreThanTenYearsHoursAccuralMax(Employee emp) {
        if (emp.getHoursPerWeek() == null || emp.getHoursPerWeek().equals(40)) {
            return moreThanTenYearsHoursAccuralMax;
        } else {
            return DateUtils.getProratedHours(moreThanTenYearsHoursAccuralMax, new BigDecimal("40"), new BigDecimal(emp.getHoursPerWeek()));
        }
    }

    //Utils
    protected static BigDecimal getPTOAccuredHours(BigDecimal accrual, Employee emp) {
        BigDecimal ptoAccuredWithUnpaidHours = getPTOAccuredHoursWithUnpaid(accrual, emp);
        if (emp.getHoursPerWeek() == null || emp.getHoursPerWeek().equals(40)) {
            return ptoAccuredWithUnpaidHours;
        } else {
            return DateUtils.getProratedHours(ptoAccuredWithUnpaidHours, new BigDecimal("40"), new BigDecimal(emp.getHoursPerWeek()));
        }
    }

    protected static BigDecimal getPTOAccuredHoursWithUnpaid(BigDecimal accural, Employee emp) {
        BigDecimal unpaidHours = getUnpaidHoursDuringAccuralPeriod(emp);
        if (unpaidHours.compareTo(BigDecimal.ZERO) > 0) {
            return DateUtils.getProratedHours(accural, totalMonthlyHours, totalMonthlyHours.subtract(unpaidHours)).setScale(4);
        } else {
            return accural;
        }
    }

    protected static BigDecimal getUnpaidHoursDuringAccuralPeriod(Employee emp) {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        List<TimeSheetCategory> category = new ArrayList<TimeSheetCategory>();
        category.add(TimeSheetCategory.Unpaid);
        List<TimeSheetStatus> status = new ArrayList<TimeSheetStatus>();
        status.add(TimeSheetStatus.Approved);
        status.add(TimeSheetStatus.Pending);
        return dao.getHoursInMonth(emp, category, status, DateUtils.getNextMonth(new Date(), -1));

    }
}
