/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.notification;

import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class NotificationGroupSaveDto extends NotificationGroup {

    @Override
    @XmlElement
    public List<Employee> getEmployees() {
        if (this.employees == null) {
            this.employees = new ArrayList<>();
        }

        return employees;
    }

    @Override
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
