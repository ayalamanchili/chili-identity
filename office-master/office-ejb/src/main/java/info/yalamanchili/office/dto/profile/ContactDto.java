/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Phone;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import info.yalamanchili.office.entity.profile.Sex;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author raghu
 */
@XmlRootElement(name = "Contact")
@XmlType
public class ContactDto implements Serializable {

    protected Long id;
    /**
     * firstName
     */
    @NotEmpty(message = "{firstName.not.empty.msg}")
    protected String firstName;
    /**
     * middleInitial
     */
    protected String middleInitial;
    /**
     * lastName
     */
    @NotEmpty(message = "{lastName.not.empty.msg}")
    protected String lastName;
    /**
     * dateOfBirth
     */
    @Past
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateOfBirth;
    /**
     * Sex
     */
    @Enumerated(EnumType.STRING)
    protected Sex sex;
    /**
     * ImageUrl
     */
    protected String imageURL;
    /**
     * email
     */
    @org.hibernate.validator.constraints.Email
    protected String email;
    /**
     * phoneNumber
     */
    @Valid
    protected List<Phone> phones;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public List<Phone> getPhones() {
        if (this.phones == null) {
            this.phones = new ArrayList<Phone>();
        }
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @XmlRootElement
    @XmlType
    public static class ContactDtoTable implements java.io.Serializable{

        protected Long size;
        protected List<ContactDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ContactDto> getEntities() {
            if (this.entities == null) {
                this.entities = new ArrayList<ContactDto>();
            }
            return entities;
        }

        public void setEntities(List<ContactDto> entities) {
            this.entities = entities;
        }
    }
}
