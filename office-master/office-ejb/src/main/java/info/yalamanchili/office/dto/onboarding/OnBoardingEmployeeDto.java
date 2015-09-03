/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.onboarding;

import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.WorkStatus;
import java.io.Serializable;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Madhu.Badiginchala
 */
@XmlRootElement
public class OnBoardingEmployeeDto implements Serializable {

    /**
     *
     */
    protected String inviteCode;
    /**
     *
     */
    @NotEmpty(message = "{firstName.not.empty.msg}")
    protected String firstName;
    /**
     *
     */
    @NotEmpty(message = "{lastName.not.empty.msg}")
    protected String lastName;
    /**
     *
     */
    protected String middleInitial;
    @Past(message = "{dateOfBirth.past.msg}")
    /**
     *
     */
    @NotNull(message = "{dateOfBirth.not.empty.msg}")
    protected Date dateOfBirth;
    /**
     *
     */
    @NotNull(message = "{sex.not.empty.msg}")
    protected Sex sex;
    /**
     *
     */
    protected String imageURL;
    /**
     *
     */
    protected String phoneNumber;
    /**
     *
     */
    protected WorkStatus workStatus;

    @Pattern(regexp = "(^(\\d{9})$)", message = "{invalid.ssn.format}")
    protected String ssn;

    @Valid
    private Address address;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
