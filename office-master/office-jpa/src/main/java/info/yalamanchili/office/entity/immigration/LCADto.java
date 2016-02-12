/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Madhu.Badiginchala
 */
@XmlRootElement
@XmlType
public class LCADto extends LCA {

    protected Set<Employee> employees;

    protected Set<Employee> worked;

    public Set<Employee> getEmployees() {
        if (employees == null) {
            this.employees = new HashSet<>();
        }
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> getWorked() {
        if (worked == null) {
            this.worked = new HashSet<>();
        }
        return worked;
    }

    public void setWorked(Set<Employee> worked) {
        this.worked = worked;
    }

}
