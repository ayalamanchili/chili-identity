/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import java.math.BigDecimal;

/**
 *
 * @author anuyalamanchili
 */
public interface TimeAccuralConstants {

    /**
     * monthly hours accrual
     */
    BigDecimal lessThanOneYearHoursAccural = new BigDecimal("6.6667");
    BigDecimal twoToFourYearsHoursAccural = new BigDecimal("12.00");
    BigDecimal fiveToTenYearsHoursAccural = new BigDecimal("14.667");
    BigDecimal moreThanTenYearsHoursAccural = new BigDecimal("14.667");
    /**
     * max hours accrual
     */
    BigDecimal lessThanOneYearHoursAccuralMax = new BigDecimal("80.00");
    BigDecimal twoToFourYearsHoursAccuralMax = new BigDecimal("12.00");
    BigDecimal fiveToTenYearsHoursAccuralMax = new BigDecimal("14.667");
    BigDecimal moreThanTenYearsHoursAccuralMax = new BigDecimal("14.667");
}
