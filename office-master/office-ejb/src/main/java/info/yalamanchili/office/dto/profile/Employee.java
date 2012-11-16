/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Sex;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class Employee implements Serializable {

    protected Long id;
    protected String username;
    @Size(min = 6, message = "{user.passwordHash.length.invalid.msg}")
    protected String passwordHash;
    @NotEmpty(message = "{firstName.not.empty.msg}")
    protected String firstName;
    @NotEmpty(message = "{lastName.not.empty.msg}")
    protected String lastName;
    protected String middleInitial;
    protected String employeeId;
    @Past(message = "{dateOfBirth.past.msg}")
    @NotNull(message = "{dateOfBirth.not.empty.msg}")
    protected Date dateOfBirth;
    @NotNull(message = "{sex.not.empty.msg}")
    protected Sex sex;
    protected String imageURL;
    protected Date startDate;
    @Email
    @NotEmpty(message = "{email.not.empty.msg}")
    protected String email;
    protected String phoneNumber;
    protected String jobTitle;
    @NotNull(message = "{employeetype.not.null.msg}")
    protected EmployeeType employeeType;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
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

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

     public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", employeeId=" + employeeId + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", imageURL=" + imageURL + ", startDate=" + startDate + ", email=" + email + ", phoneNumber=" + phoneNumber +  '}';
    }

    public static Employee map(Mapper mapper, info.yalamanchili.office.entity.profile.Employee entity) {
        Employee dto = mapper.map(entity, Employee.class);
        if (entity.getPrimaryEmail() != null) {
            dto.setEmail(entity.getPrimaryEmail().getEmail());
        }
        if (entity.getPhones().size() > 0) {
            dto.setPhoneNumber(entity.getPhones().get(0).getPhoneNumber());
        }
        dto.setId(entity.getId());
        return dto;
    }
}
