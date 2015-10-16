/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = Client.class, fields = {"name"}, message = "{client.name.not.unique.msg}")
public class Client extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 1L;
    
    @NotEmpty(message = "{client.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "CLNT_NM")
    protected String name;
    protected String description;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    protected List<Project> projects;
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Address> locations;
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Contact> contacts;
    @ManyToMany(cascade = CascadeType.MERGE)
    protected List<Vendor> vendors;
//    protected String website;
//    protected String paymentTerms;
//    @Enumerated(EnumType.STRING)
//    protected InvoiceFrequency clientinvFrequency;

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    @XmlTransient
    public List<Vendor> getVendors() {
        if (this.vendors == null) {
            this.vendors = new ArrayList<Vendor>();
        }
        return this.vendors;
    }

    public void addVendor(Vendor entity) {
        if (entity == null) {
            return;
        }
        getVendors().add(entity);
//        entity.set(this);
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

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @generated
     */
    @XmlTransient
    public List<Project> getProjects() {
        if (this.projects == null) {
            this.projects = new ArrayList<Project>();
        }
        return this.projects;
    }

    /**
     * @generated
     */
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project entity) {
        if (entity == null) {
            return;
        }
        getProjects().add(entity);
        entity.setClient(this);
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
//      contact.setClient(this);
    }

//    public String getWebsite() {
//        return website;
//    }
//
//    public void setWebsite(String website) {
//        this.website = website;
//    }
//
//    public String getPaymentTerms() {
//        return paymentTerms;
//    }
//
//    public void setPaymentTerms(String paymentTerms) {
//        this.paymentTerms = paymentTerms;
//    }

//    public InvoiceFrequency getClientinvFrequency() {
//        return clientinvFrequency;
//    }
//
//    public void setClientinvFrequency(InvoiceFrequency clientinvFrequency) {
//        this.clientinvFrequency = clientinvFrequency;
//    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", description=" + description + '}';
    }
}
