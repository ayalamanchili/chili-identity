/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.chili.security.SecurityUtils;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.Sex;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement(name = "Employee")
@XmlType
public class EmployeeDto implements Serializable {

    protected Long id;
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
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    @Email(message = "Enter a valid email address ")
    @NotEmpty(message = "{email.not.empty.msg}")
    protected String email;
    protected String phoneNumber;
    protected String phoneNumberExt;
    protected String jobTitle;
    @NotNull(message = "{employeetype.not.null.msg}")
    protected EmployeeType employeeType;
    protected String ssn;

    public EmployeeDto() {
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

    public String getPhoneNumberExt() {
        return phoneNumberExt;
    }

    public void setPhoneNumberExt(String phoneNumberExt) {
        this.phoneNumberExt = phoneNumberExt;
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

    public String getSsn() {
        return SecurityUtils.OBFUSCATED_STR;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", employeeId=" + employeeId + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", imageURL=" + imageURL + ", startDate=" + startDate + ", email=" + email + ", phoneNumber=" + phoneNumber + ", jobTitle=" + jobTitle + ", employeeType=" + employeeType + '}';
    }

    public static EmployeeDto map(Mapper mapper, info.yalamanchili.office.entity.profile.Employee entity) {
        EmployeeDto dto = mapper.map(entity, EmployeeDto.class);
        if (entity.getPrimaryEmail() != null) {
            dto.setEmail(entity.getPrimaryEmail().getEmail());
        }
        if (entity.getPhones().size() > 0) {
            Phone phone = entity.getPhones().get(0);
            dto.setPhoneNumber(phone.getPhoneNumber());
            dto.setPhoneNumberExt(phone.getExtension());
        }
        dto.setId(entity.getId());
        return dto;
    }
}
