/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.message;

import java.io.Serializable;

/**
 *
 * @author raghu
 */
public class Shortemp {
    
    protected Long id;

    public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    protected String employeeName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
