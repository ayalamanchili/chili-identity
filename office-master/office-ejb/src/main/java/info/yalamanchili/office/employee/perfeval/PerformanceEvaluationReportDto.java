/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.perfeval;

import info.yalamanchili.office.entity.employee.PerformanceEvaluationStage;
import java.io.Serializable;
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
    protected Double rating;
    /**
     *
     */
    protected String physicalYear;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    protected PerformanceEvaluationStage stage;

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
     * @return the rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * @return the stage
     */
    public PerformanceEvaluationStage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(PerformanceEvaluationStage stage) {
        this.stage = stage;
    }
}
