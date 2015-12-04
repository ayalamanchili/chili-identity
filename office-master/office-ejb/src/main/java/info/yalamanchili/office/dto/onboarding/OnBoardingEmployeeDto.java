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
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.WorkStatus;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    
    @Valid
    private BankAccount bankAccount;
    
    @Valid
    private List<Dependent> dependent;
    
    @Valid
    private EmployeeAdditionalDetails employeeAdditionalDetails;
    
    @Valid
    private List<EmergencyContactDto> emergencyContact;
    
    private List<EmployeeDocument> document;

    public List<EmployeeDocument> getDocument() {
        return document;
    }

    public void setDocument(List<EmployeeDocument> document) {
        this.document = document;
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

    public List<EmergencyContactDto> getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(List<EmergencyContactDto> emergencyContact) {
        this.emergencyContact = emergencyContact;
    }



}
