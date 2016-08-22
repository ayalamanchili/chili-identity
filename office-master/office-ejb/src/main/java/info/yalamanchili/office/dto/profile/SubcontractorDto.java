/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Address;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
@XmlRootElement(name = "CreateSubcontractor")
@XmlType
public class SubcontractorDto implements Serializable {
    
    protected Long id;

    @NotEmpty(message = "{subcontractor.not.empty.msg}")
    protected String name;
    protected String description;
    protected String website;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date coiEndDate;
    protected Address location;
    protected ContactDto contact;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the coiEndDate
     */
    public Date getCoiEndDate() {
        return coiEndDate;
    }

    /**
     * @param coiEndDate the coiEndDate to set
     */
    public void setCoiEndDate(Date coiEndDate) {
        this.coiEndDate = coiEndDate;
    }

    /**
     * @return the location
     */
    public Address getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Address location) {
        this.location = location;
    }

    /**
     * @return the contact
     */
    public ContactDto getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(ContactDto contact) {
        this.contact = contact;
    }
    
    @Override
    public String toString() {
        return "Create Subcontractor{" + "name=" + name + ", description=" + description + '}';
    }
    
}
