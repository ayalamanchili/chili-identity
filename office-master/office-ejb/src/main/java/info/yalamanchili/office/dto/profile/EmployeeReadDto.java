/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Employee;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class EmployeeReadDto extends Employee {

    @Override
    public String getSsn() {
        return "*********";
    }
}