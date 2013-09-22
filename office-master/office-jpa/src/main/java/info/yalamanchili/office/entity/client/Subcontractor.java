/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import info.chili.jpa.validation.Unique;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author anuyalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(uniqueConstraints =
        @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = Subcontractor.class, fields = {"name"}, message = "{subcontractor.name.not.unique.msg}")
public class Subcontractor extends AbstractEntity {

    /**
     * sub contractor name
     */
    @NotEmpty(message = "{subcontractor.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "SUB_CNTR_NM")
    protected String name;
    /**
     *
     */
    protected String description;
    /**
     * sub contractor contacts
     */
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Contact> contacts;
    /*
     * sub contrctor locations
     */
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Address> locations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Contact> getContacts() {
        if (this.contacts == null) {
            this.contacts = new ArrayList<Contact>();
        }
        return this.contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        if (contact == null) {
            return;
        }
        getContacts().add(contact);
    }

    @XmlTransient
    public List<Address> getLocations() {
        if (this.locations == null) {
            this.locations = new ArrayList<Address>();
        }
        return this.locations;
    }

    public void setLocations(List<Address> locations) {
        this.locations = locations;
    }

    public void addLocations(Address entity) {
        if (entity == null) {
            return;
        }
        getLocations().add(entity);
    }
}
