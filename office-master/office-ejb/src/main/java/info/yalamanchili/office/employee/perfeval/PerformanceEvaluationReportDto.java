/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.perfeval;

import java.io.Serializable;

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
    protected Double prevYearRating;
    /**
     *
     */
    protected String evaluationFYYear;
    /**
     *
     */
    protected String stage;
    /**
     *
     */
    protected String manager;
    /**
     *
     */
    protected String managerReviewStarted;

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
     * @return the evaluationFYYear
     */
    public String getEvaluationFYYear() {
        return evaluationFYYear;
    }

    /**
     * @param evaluationFYYear the evaluationFYYear to set
     */
    public void setEvaluationFYYear(String evaluationFYYear) {
        this.evaluationFYYear = evaluationFYYear;
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
    public String getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Double getPrevYearRating() {
        return prevYearRating;
    }

    public void setPrevYearRating(Double prevYearRating) {
        this.prevYearRating = prevYearRating;
    }

   
    public String getManagerReviewStarted() {
        return managerReviewStarted;
    }

    public void setManagerReviewStarted(String managerReviewStarted) {
        this.managerReviewStarted = managerReviewStarted;
    }
}
