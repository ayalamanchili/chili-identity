/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.perfeval;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author prasanthi.p
 */
public class ProbationPeriodEvaluationReportDto implements Serializable {

    protected Date evaluationDate;
    protected String trainingRequirments;
    protected String additionalComments;
    protected String hrNotes;
    protected String employee;

    /**
     * @return the evaluationDate
     */
    public Date getEvaluationDate() {
        return evaluationDate;
    }

    /**
     * @param evaluationDate the evaluationDate to set
     */
    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    /**
     * @return the trainingRequirments
     */
    public String getTrainingRequirments() {
        return trainingRequirments;
    }

    /**
     * @param trainingRequirments the trainingRequirments to set
     */
    public void setTrainingRequirments(String trainingRequirments) {
        this.trainingRequirments = trainingRequirments;
    }

    /**
     * @return the additionalComments
     */
    public String getAdditionalComments() {
        return additionalComments;
    }

    /**
     * @param additionalComments the additionalComments to set
     */
    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    /**
     * @return the hrNotes
     */
    public String getHrNotes() {
        return hrNotes;
    }

    /**
     * @param hrNotes the hrNotes to set
     */
    public void setHrNotes(String hrNotes) {
        this.hrNotes = hrNotes;
    }

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
}
