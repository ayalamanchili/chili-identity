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
 * @author anu
 */
@XmlRootElement
@XmlType
public class EmergencyContact {

    protected String relation;
    protected boolean ecPrimary;
    protected String firstName;
    protected String middleInitial;
    protected String lastName;
    protected String email;
    protected String phoneNumber;

    public EmergencyContact() {
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public boolean isEcPrimary() {
        return ecPrimary;
    }

    public void setEcPrimary(boolean ecPrimary) {
        this.ecPrimary = ecPrimary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "EmergencyContact{" + "relation=" + relation + ", ecPrimary=" + ecPrimary + ", firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }
    
      //TODO move this to seperate class?
    public static EmergencyContact map(Mapper mapper, info.yalamanchili.office.entity.profile.EmergencyContact entity) {
        EmergencyContact emergencyContact = mapper.map(entity, EmergencyContact.class);
        mapper.map(entity.getContact(), emergencyContact);
        if (entity.getContact().getPhones().size() > 0) {
            mapper.map(entity.getContact().getPhones().get(0), emergencyContact);
        }
        if (entity.getContact().getPrimaryEmail() != null) {
            mapper.map(entity.getContact().getPrimaryEmail(), emergencyContact);
        }
        return emergencyContact;
    }
}
