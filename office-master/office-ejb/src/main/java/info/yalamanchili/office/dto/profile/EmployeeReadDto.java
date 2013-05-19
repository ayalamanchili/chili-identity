/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.chili.security.SecurityUtils;
import info.yalamanchili.office.entity.profile.Employee;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class EmployeeReadDto extends Employee {

    protected boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    @XmlElement
    public String getSsn() {
        return SecurityUtils.OBFUSCATED_STR;
    }
}