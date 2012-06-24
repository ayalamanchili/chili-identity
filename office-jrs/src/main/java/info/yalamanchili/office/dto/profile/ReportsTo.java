/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author yalamanchili
 */
@XmlRootElement
@XmlType
public class ReportsTo {

    protected String firstName;
    protected String lastName;
    protected String middleInitial;
    protected String reportsToRole;
    protected boolean rtPrimary;
    protected String email;
    protected String phoneNumber;

    public ReportsTo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getReportsToRole() {
        return reportsToRole;
    }

    public void setReportsToRole(String reportsToRole) {
        this.reportsToRole = reportsToRole;
    }

    public boolean isRtPrimary() {
        return rtPrimary;
    }

    public void setRtPrimary(boolean rtPrimary) {
        this.rtPrimary = rtPrimary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ReportsTo{" + "firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", reportsToRole=" + reportsToRole + ", rtPrimary=" + rtPrimary + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }

    //TODO move this to seperate class?
    public static ReportsTo mapReportsTo(Mapper mapper, info.yalamanchili.office.entity.profile.ReportsTo entity) {
        ReportsTo reportsTo = mapper.map(entity, ReportsTo.class);
        mapper.map(entity.getContact(), reportsTo);
        if (entity.getContact().getPhones().size() > 0) {
            mapper.map(entity.getContact().getPhones().get(0), reportsTo);
        }
        if (entity.getContact().getPrimaryEmail() != null) {
            mapper.map(entity.getContact().getPrimaryEmail(), reportsTo);
        }
        return reportsTo;
    }
}
