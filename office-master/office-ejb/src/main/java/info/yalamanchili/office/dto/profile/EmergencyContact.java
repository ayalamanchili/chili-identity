/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Sex;
import java.io.Serializable;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author anu
 */
@XmlRootElement
@XmlType
public class EmergencyContact implements Serializable {

    protected Long id;
    @NotEmpty(message = "{relation.not.empty.msg}")
    protected String relation;
    protected Boolean ecPrimary;
    @NotEmpty(message = "{firstName.not.empty.msg}")
    protected String firstName;
    protected String middleInitial;
    @NotEmpty(message = "{lastName.not.empty.msg}")
    protected String lastName;
    protected Sex sex;
    @Email
//    @NotEmpty(message = "{emergencycontact.email.not.empty.msg}")
    protected String email;
    @Size(min = 10, max = 10)
    @NotEmpty(message = "{emergencycontact.phoneNumber.not.empty.msg}")
    protected String phoneNumber;

    public EmergencyContact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Boolean getEcPrimary() {
        return ecPrimary;
    }

    public void setEcPrimary(Boolean ecPrimary) {
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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
        return "EmergencyContact{" + "id=" + id + ", relation=" + relation + ", ecPrimary=" + ecPrimary + ", firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName=" + lastName + ", sex=" + sex + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
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
        emergencyContact.setId(entity.getId());
        return emergencyContact;
    }
}
