/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qb;

import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;

/**
 *
 * @author ayalamanchili
 */
public class QuickBooksRecord {

    protected Employee employee;
    protected BigDecimal hours;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "QBHoursRecords{" + "employee=" + employee + ", hours=" + hours + '}';
    }
}
