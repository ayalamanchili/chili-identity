/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.dao.profile.EmployeeDao;
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
@XmlRootElement(name = "EmergencyContact")
@XmlType
public class EmergencyContactDto implements Serializable {

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
    @Email(message = "Enter a valid email address")
//    @NotEmpty(message = "{emergencycontact.email.not.empty.msg}")
    protected String email;
    @Size(min = 0, max = 4, message = "{emergnecycontact.countryCode.length.invalid.msg}")
    protected String countryCode;
    @Size(min = 0, max = 5, message = "{emergnecycontact.extension.length.invalid.msg}")
    protected String extension;
    @Size(min = 10, max = 10, message = "{emergnecycontact.phoneNumber.lenght.invalid.msg}")
    @NotEmpty(message = "{emergencycontact.phoneNumber.not.empty.msg}")
    protected String phoneNumber;

    public EmergencyContactDto() {
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

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return "EmergencyContact{" + "id=" + id + ", relation=" + relation + ", ecPrimary=" + ecPrimary + ", firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName=" + lastName + ", sex=" + sex + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }

    //TODO move this to seperate class?
    public static EmergencyContactDto map(Mapper mapper, info.yalamanchili.office.entity.profile.EmergencyContact entity) {
        EmergencyContactDto emergencyContact = mapper.map(entity, EmergencyContactDto.class);
        mapper.map(entity.getContact(), emergencyContact);
        if (entity.getContact().getPhones().size() > 0) {
            mapper.map(entity.getContact().getPhones().get(0), emergencyContact);
            if (entity.getContact().getPhones().get(0).getCountryCode() != null) {
                mapper.map(entity.getContact().getPhones().get(0).getCountryCode(), emergencyContact);
            }
            if (entity.getContact().getPhones().get(0).getExtension() != null) {
                mapper.map(entity.getContact().getPhones().get(0).getExtension(), emergencyContact);
            }

        }
        emergencyContact.setEmail(EmployeeDao.instance().getPrimaryEmail(entity.getContact().getId()));
        emergencyContact.setId(entity.getId());
        return emergencyContact;
    }
}
