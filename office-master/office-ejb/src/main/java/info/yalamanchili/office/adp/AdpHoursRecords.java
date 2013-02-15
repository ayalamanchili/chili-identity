/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.adp;

import java.math.BigDecimal;

/**
 *
 * @author Prashanthi
 */
public class AdpHoursRecords {

    protected String employeeId;
    protected BigDecimal hours;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "AdpHoursRecords{" + "employeeId=" + employeeId + ", hours=" + hours + '}';
    }
}
