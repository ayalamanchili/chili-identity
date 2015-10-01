/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.prospect;

import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
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
@XmlRootElement(name = "EmergencyContact")
@XmlType
public class ProspectDto implements Serializable {

    protected Long id;

    @NotEmpty(message = "{firstName.not.empty.msg}")
    protected String firstName;

    @NotEmpty(message = "{lastName.not.empty.msg}")
    protected String lastName;

    @Email(message = "Enter a valid email address")
    protected String email;

    @NotEmpty(message = "{prospect.phoneNumber.not.empty.msg}")
    @Size(min = 10, max = 10, message = "{prospect.phoneNumber.lenght.invalid.msg}")
    protected String phoneNumber;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date startDate;

    protected String screenedBy;
    protected String referredBy;

    @NotEmpty(message = "{resumeUrl.not.empty.msg}")
    protected String resumeURL;

    @Enumerated(EnumType.STRING)
    protected ProspectStatus status;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        return "ProspectDto{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", startDate=" + startDate + ", screenedBy=" + screenedBy + ", referredBy=" + referredBy + ", resumeURL=" + resumeURL + ", status=" + status + '}';
    }

    public static ProspectDto map(Mapper mapper, info.yalamanchili.office.entity.hr.Prospect entity) {
        ProspectDto prospectContact = mapper.map(entity, ProspectDto.class);
        mapper.map(entity.getContact(), prospectContact);
        if (entity.getContact().getPhones().size() > 0) {
            prospectContact.setPhoneNumber(entity.getContact().getPhones().get(0).getPhoneNumber());
        }
        if (entity.getContact().getEmails().size() > 0) {
            prospectContact.setEmail(entity.getContact().getEmails().get(0).getEmail());
        }
        prospectContact.setId(entity.getId());
        return prospectContact;
    }
}
