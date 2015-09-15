/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.onboarding;

import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author phani.y
 */
@XmlRootElement
@XmlType
public class JoiningFormsDto implements Serializable {

    protected Employee employee;
    
    protected EmployeeAdditionalDetails empAddnlDetails;
    
    protected List<Dependent> dependent;
    
    protected Address address;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeAdditionalDetails getEmpAddnlDetails() {
        return empAddnlDetails;
    }

    public void setEmpAddnlDetails(EmployeeAdditionalDetails empAddnlDetails) {
        this.empAddnlDetails = empAddnlDetails;
    }

    public List<Dependent> getDependent() {
        return dependent;
    }

    public void setDependent(List<Dependent> dependent) {
        this.dependent = dependent;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
