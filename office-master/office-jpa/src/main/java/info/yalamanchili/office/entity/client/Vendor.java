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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author raghu
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(uniqueConstraints =
        @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = Vendor.class, fields = {"name"}, message = "{vendor.name.not.unique.msg}")
public class Vendor extends AbstractEntity {

    @NotEmpty(message = "{vendor.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "VNDR_NM")
    protected String name;
    protected String description;
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Address> locations;
    @ManyToMany(mappedBy = "vendors", cascade = CascadeType.MERGE)
    protected List<Client> clients;

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @XmlTransient
    public List<Client> getClients() {
        if (this.clients == null) {
            this.clients = new ArrayList<Client>();
        }
        return this.clients;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Contact> contacts;

    public void setDescription(String description) {
        this.description = description;
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

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        if (contact == null) {
            return;
        }
        getContacts().add(contact);
//      contact.setClient(this);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @XmlTransient
    public List<Address> getLocations() {
        if (this.locations == null) {
            this.locations = new ArrayList<Address>();
        }
        return this.locations;
    }

    @XmlTransient
    public List<Contact> getContacts() {
        if (this.contacts == null) {
            this.contacts = new ArrayList<Contact>();
        }
        return this.contacts;
    }

    @Override
    public String toString() {
        return "Vendor{" + "name=" + name + ", description=" + description + '}';
    }
}
