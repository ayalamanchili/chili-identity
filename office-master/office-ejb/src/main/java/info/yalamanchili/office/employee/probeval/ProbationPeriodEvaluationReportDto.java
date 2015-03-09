/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.probeval;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author benerji.v
 */
public class ProbationPeriodEvaluationReportDto implements Serializable {
    
    private String employee;
    private Date startDate;
    private String stage;

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
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
}
