/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Employee;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class EmployeeSaveDto extends Employee {

    @XmlElement
    @Override
    public String getSsn() {
        return ssn;
    }

    @Override
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
