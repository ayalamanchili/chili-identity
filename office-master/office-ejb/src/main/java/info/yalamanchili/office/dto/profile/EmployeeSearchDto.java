/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
public class EmployeeSearchDto extends Employee {

    @XmlElement
    @Override
    public List<Address> getAddresss() {
        return super.getAddresss();
    }
}
