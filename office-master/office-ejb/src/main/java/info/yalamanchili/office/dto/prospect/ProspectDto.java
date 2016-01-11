/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.prospect;

import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.hr.PetitionFor;
import info.yalamanchili.office.entity.hr.PlacedBy;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.hr.TransferEmployeeType;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Sex;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement(name = "Prospect")
@XmlType
public class ProspectDto implements Serializable {

    protected Long id;

    @NotEmpty(message = "{firstName.not.empty.msg}")
    protected String firstName;

    @NotEmpty(message = "{lastName.not.empty.msg}")
    protected String lastName;

    @Email(message = "Enter a valid email address")
    @NotEmpty(message = "{prospect.email.not.empty.msg}")
    protected String email;

    @Size(max = 4)
    protected String countryCode;

    @NotEmpty(message = "{prospect.phoneNumber.not.empty.msg}")
    @Size(min = 10, max = 10, message = "{prospect.phoneNumber.lenght.invalid.msg}")
    protected String phoneNumber;

    @Size(max = 5)
    protected String extension;

    protected Sex sex;

    protected Date startDate;

    protected String screenedBy;
    @NotEmpty(message = "{referredBy.not.empty.msg}")
    protected String referredBy;

    @NotEmpty(message = "{resumeUrl.not.empty.msg}")
    protected String resumeURL;

    protected Date dateOfBirth;

    protected String comment;

    @Valid
    private Address address;

    @Enumerated(EnumType.STRING)
    protected ProspectStatus status;

    @Enumerated(EnumType.STRING)
    protected PetitionFor petitionFiledFor;

    @Enumerated(EnumType.STRING)
    protected TransferEmployeeType trfEmpType;

    @Enumerated(EnumType.STRING)
    protected PlacedBy placedBy;

    protected Date dateOfJoining;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date processDocSentDate;

    protected String employee;

    protected String gender;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String name) {
        this.employee = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getProcessDocSentDate() {
        return processDocSentDate;
    }

    public void setProcessDocSentDate(Date processDocSentDate) {
        this.processDocSentDate = processDocSentDate;
    }

    public ProspectDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getScreenedBy() {
        return screenedBy;
    }

    public void setScreenedBy(String screenedBy) {
        this.screenedBy = screenedBy;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getResumeURL() {
        return resumeURL;
    }

    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }

    public ProspectStatus getStatus() {
        return status;
    }

    public void setStatus(ProspectStatus status) {
        this.status = status;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PetitionFor getPetitionFiledFor() {
        return petitionFiledFor;
    }

    public void setPetitionFiledFor(PetitionFor petitionFiledFor) {
        this.petitionFiledFor = petitionFiledFor;
    }

    public TransferEmployeeType getTrfEmpType() {
        return trfEmpType;
    }

    public void setTrfEmpType(TransferEmployeeType trfEmpType) {
        this.trfEmpType = trfEmpType;
    }

    public PlacedBy getPlacedBy() {
        return placedBy;
    }

    public void setPlacedBy(PlacedBy placedBy) {
        this.placedBy = placedBy;
    }

   

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "ProspectDto{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", sex=" + sex + ", startDate=" + startDate + ", screenedBy=" + screenedBy + ", referredBy=" + referredBy + ", resumeURL=" + resumeURL + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", status=" + status + ", processDocSentDate=" + processDocSentDate + '}';
    }

    public static ProspectDto map(Mapper mapper, info.yalamanchili.office.entity.hr.Prospect entity) {
        ProspectDto prospectContact = mapper.map(entity, ProspectDto.class);
        prospectContact.setEmployee(entity.getContact().getFirstName() + " " + entity.getContact().getLastName());
        mapper.map(entity.getContact(), prospectContact);
        if (entity.getContact().getPhones().size() > 0) {
            prospectContact.setPhoneNumber(entity.getContact().getPhones().get(0).getPhoneNumber());
            prospectContact.setExtension(entity.getContact().getPhones().get(0).getExtension());
            prospectContact.setCountryCode(entity.getContact().getPhones().get(0).getCountryCode());
        }
        if (entity.getContact().getAddresss().size() > 0) {
            prospectContact.setAddress(entity.getContact().getAddresss().get(0));
        }
        if (entity.getContact().getEmails().size() > 0) {
            prospectContact.setEmail(entity.getContact().getEmails().get(0).getEmail());
        }
        if (entity.getContact().getDateOfBirth() != null) {
            prospectContact.setDateOfBirth(entity.getContact().getDateOfBirth());
        }
        if (entity.getContact().getSex() != null) {
            prospectContact.setGender(entity.getContact().getSex().name().toLowerCase());
        }
        if (entity.getDateOfJoining() != null) {
            prospectContact.setDateOfJoining(entity.getDateOfJoining());
        }
        if (entity.getPlacedBy() != null) {
            prospectContact.setPlacedBy(entity.getPlacedBy());
        }
        if (entity.getTrfEmpType() != null) {
            prospectContact.setTrfEmpType(entity.getTrfEmpType());
        }
        if (entity.getPetitionFieldFor() != null) {
            prospectContact.setPetitionFiledFor(entity.getPetitionFieldFor());
        }
        prospectContact.setId(entity.getId());
        return prospectContact;
    }
}
