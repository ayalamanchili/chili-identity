/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.onboarding;

import info.yalamanchili.office.dto.profile.EmergencyContactDto;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.WorkStatus;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    protected String phoneNumber;

    @Size(min = 0, max = 4, message = "{phone.countryCode.length.invalid.msg}")
    protected String countryCode;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    protected WorkStatus workStatus;

    @Pattern(regexp = "(^(\\d{9})$)", message = "{invalid.ssn.format}")
    @NotEmpty(message = "{ssn.not.empty.msg}")
    protected String ssn;

    @Valid
    @NotNull
    private Address address;

    @Valid
    @NotNull
    private BankAccount bankAccount;

    @Valid
    private List<Dependent> dependent;

    @Valid
    private EmployeeAdditionalDetails employeeAdditionalDetails;

    @Valid
    private List<EmergencyContactDto> emergencyContact;

    private List<EmployeeDocument> documents;

    public List<EmployeeDocument> getDocuments() {
        if (this.documents == null) {
            this.documents = new ArrayList();
        }
        return documents;
    }

    public void setDocuments(List<EmployeeDocument> documents) {
        this.documents = documents;
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Dependent> getDependent() {
        if (this.dependent == null) {
            this.dependent = new ArrayList();
        }
        return dependent;
    }

    public void setDependent(List<Dependent> dependent) {
        this.dependent = dependent;
    }

    public EmployeeAdditionalDetails getEmployeeAdditionalDetails() {
        return employeeAdditionalDetails;
    }

    public void setEmployeeAdditionalDetails(EmployeeAdditionalDetails employeeAdditionalDetails) {
        this.employeeAdditionalDetails = employeeAdditionalDetails;
    }

    @Size(min = 1, message = "{emergencycontact.min.size.msg}")
    public List<EmergencyContactDto> getEmergencyContact() {
        if (this.emergencyContact == null) {
            this.emergencyContact = new ArrayList();
        }
        return emergencyContact;
    }

    public void setEmergencyContact(List<EmergencyContactDto> emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
