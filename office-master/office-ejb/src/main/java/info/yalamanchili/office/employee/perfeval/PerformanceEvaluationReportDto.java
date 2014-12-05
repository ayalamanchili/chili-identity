/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.perfeval;

import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReportStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author prasanthi.p
 */
public class PerformanceEvaluationReportDto implements Serializable {

    protected String employee;
    /**
     *
     */
    protected BigDecimal rating;
    /**
     *
     */
    protected String physicalYear;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    protected ExpenseReportStatus status;

    /**
     * @return the employee
     */
    public String getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(String employee) {
        this.employee = employee;
    }

    /**
     * @return the rating
     */
    public BigDecimal getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    /**
     * @return the physicalYear
     */
    public String getPhysicalYear() {
        return physicalYear;
    }

    /**
     * @param physicalYear the physicalYear to set
     */
    public void setPhysicalYear(String physicalYear) {
        this.physicalYear = physicalYear;
    }

    /**
     * @return the status
     */
    public ExpenseReportStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ExpenseReportStatus status) {
        this.status = status;
    }
}
