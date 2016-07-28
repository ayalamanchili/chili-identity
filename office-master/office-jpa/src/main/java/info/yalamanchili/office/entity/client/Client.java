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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Address> locations;
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Contact> contacts;
    @ManyToMany(cascade = CascadeType.MERGE)
    protected Set<Vendor> vendors;
    protected String website;
    protected String paymentTerms;
    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency clientinvFrequency;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Client_AcctPayContacts")
    protected List<Contact> clientAcctPayContacts;
    protected Float clientFee;
    protected Float maxClientFee;
    protected Float minClientFee;

    public Float getClientFee() {
        return clientFee;
    }

    public void setClientFee(Float clientFee) {
        this.clientFee = clientFee;
    }

    public Float getMaxClientFee() {
        return maxClientFee;
    }

    public void setMaxClientFee(Float maxClientFee) {
        this.maxClientFee = maxClientFee;
    }

    public Float getMinClientFee() {
        return minClientFee;
    }

    public void setMinClientFee(Float minClientFee) {
        this.minClientFee = minClientFee;
    }
    
    public void setVendors(Set<Vendor> vendors) {
        this.vendors = vendors;
    }

    @XmlTransient
    public Set<Vendor> getVendors() {
        if (vendors == null) {
            vendors = new HashSet<Vendor>();
        }
        return vendors;
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

    public void addClientAcctPayContact(Contact clientAcctPayContact) {
        if (clientAcctPayContact == null) {
            return;
        }
        getClientAcctPayContacts().add(clientAcctPayContact);
    }

    @XmlTransient
    public List<Contact> getClientAcctPayContacts() {
        if (this.clientAcctPayContacts == null) {
            this.clientAcctPayContacts = new ArrayList<Contact>();
        }
        return this.clientAcctPayContacts;
    }

    public void setClientAcctPayContacts(List<Contact> clientAcctPayContacts) {
        this.clientAcctPayContacts = clientAcctPayContacts;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public InvoiceFrequency getClientinvFrequency() {
        return clientinvFrequency;
    }

    public void setClientinvFrequency(InvoiceFrequency clientinvFrequency) {
        this.clientinvFrequency = clientinvFrequency;
    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", description=" + description + '}';
    }
}
