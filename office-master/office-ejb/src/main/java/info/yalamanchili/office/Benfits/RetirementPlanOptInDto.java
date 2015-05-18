/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetirementPlanOptIn;

import java.io.Serializable;

/**
 *
 * @author chaitanya.k
 */
public class RetirementPlanOptInDto implements Serializable {

    protected String employee;
    /**
     *
     */
    protected String comment;

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
     * @return the employee
     */
    public String getComments() {
        return employee;
    }

    /**
     * @param comment the employee to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setManager(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
