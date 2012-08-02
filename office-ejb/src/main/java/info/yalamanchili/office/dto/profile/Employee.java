/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Sex;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class Employee implements Serializable {

    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String middleInitial;
    protected Date dateOfBirth;
    protected Sex sex;
    protected String imageURL;
    protected Date startDate;
    protected String email;
    protected String phoneNumber;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", imageURL=" + imageURL + ", startDate=" + startDate + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }

    public static Employee map(Mapper mapper, info.yalamanchili.office.entity.profile.Employee entity) {
        Employee dto = mapper.map(entity, Employee.class);
        if (entity.getPrimaryEmail() != null) {
            dto.setEmail(entity.getPrimaryEmail().getEmail());
        }
        if (entity.getPhones().size() > 0) {
            dto.setPhoneNumber(entity.getPhones().get(0).getPhoneNumber());
        }
        return dto;
    }
}
