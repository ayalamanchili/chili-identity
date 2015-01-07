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
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;

/**
 *
 * @author anuyalamanchili
 */
//TODO externalize this?
public class TimeAccuralConstants {

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

    public static BigDecimal lessThanOneYearAccural(Employee emp) {
        if (emp.getHoursPerWeek() == null || emp.getHoursPerWeek().equals(40)) {
            return lessThanOneYearHoursAccural;
        } else {
            return DateUtils.getProratedHours(lessThanOneYearHoursAccural, new BigDecimal("40"), new BigDecimal(emp.getHoursPerWeek()));
        }
    }

    //TODO add similar remaining methods
    public static BigDecimal lessThanOneYearAccuralMax(Employee emp) {
        if (emp.getHoursPerWeek() == null || emp.getHoursPerWeek().equals(40)) {
            return lessThanOneYearHoursAccuralMax;
        } else {
            return DateUtils.getProratedHours(lessThanOneYearHoursAccuralMax, new BigDecimal("40"), new BigDecimal(emp.getHoursPerWeek()));
        }
    }
    //TODO add similar remaining methods
}
