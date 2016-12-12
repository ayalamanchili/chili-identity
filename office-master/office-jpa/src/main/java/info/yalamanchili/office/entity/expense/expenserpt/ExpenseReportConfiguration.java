/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.expenserpt;

import java.math.BigDecimal;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class ExpenseReportConfiguration {

    protected BigDecimal mileageRate = new BigDecimal("0.50");

    @ManagedAttribute
    public BigDecimal getMileageRate() {
        return mileageRate;
    }

    public void setMileageRate(BigDecimal mileageRate) {
        this.mileageRate = mileageRate;
    }

    
}
