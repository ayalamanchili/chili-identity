/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.onboarding;

import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author phani.y
 */
@XmlRootElement
@XmlType
public class JoiningFormDto implements Serializable {

    protected Employee employee;

//    TODO add all elements for the the joining form.
    //employee
    //employee addtional details
    //dependents
    //ememrgency contacts
    //more

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
