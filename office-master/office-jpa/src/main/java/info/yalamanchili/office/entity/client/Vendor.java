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
import info.yalamanchili.office.entity.profile.VendorStatus;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author raghu
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = Vendor.class, fields = {"name"}, message = "{vendor.name.not.unique.msg}")
public class Vendor extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * name
     */
    @NotEmpty(message = "{vendor.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "VNDR_NM")
    protected String name;
    /**
     * vendor description
     */
    protected String description;
    /*
     * vendor type
     */
    @org.hibernate.annotations.Index(name = "VNDR_TYPE")
    @Enumerated(EnumType.STRING)
    @Field
    protected VendorType vendorType;
    /*
     * vendor locations
     */
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Address> locations;
    /**
     * clients
     */
    @ManyToMany(mappedBy = "vendors", cascade = CascadeType.MERGE)
    protected List<Client> clients;
    /**
     * vendor contacts
     */
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Contact> contacts;

    /**
     * vendor Account Payable contacts
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Vendor_AcctPayContacts")
    protected List<Contact> acctPayContacts;

    protected String website;
    protected String paymentTerms;
    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency vendorinvFrequency;
    @Enumerated(EnumType.STRING)
    protected InvoiceDeliveryMethod vendorinvDeliveryMethod;
    @Temporal(TemporalType.DATE)
    protected Date msaValDate;
    @Temporal(TemporalType.DATE)
    protected Date msaExpDate;
    protected String terminationNotice;
    protected Float vendorFees;
    protected BigDecimal minFees;
    protected BigDecimal maxFees;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date coiEndDate;
    
    @Enumerated(EnumType.STRING)
    @Field
    protected VendorStatus vendorStatus;

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

    public VendorType getVendorType() {
        return vendorType;
    }

    public void setVendorType(VendorType vendorType) {
        this.vendorType = vendorType;
    }
    /**
     *
     * @return the msaValDate
     *
     */
    public Date getMsaValDate() {
        return msaValDate;
    }

    /**
     * @param msaValDate the msaValDate to set
     */
    public void setMsaValDate(Date msaValDate) {
        this.msaValDate = msaValDate;
    }

    /**
     * @return the msaExpDate
     */
    public Date getMsaExpDate() {
        return msaExpDate;
    }

    /**
     * @param msaExpDate the msaExpDate to set
     */
    public void setMsaExpDate(Date msaExpDate) {
        this.msaExpDate = msaExpDate;
    }

    /**
     * @return the terminationNotice
     */
    public String getTerminationNotice() {
        return terminationNotice;
    }

    /**
     * @param terminationNotice the terminationNotice to set
     */
    public void setTerminationNotice(String terminationNotice) {
        this.terminationNotice = terminationNotice;
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

    @XmlTransient
    public List<Contact> getAcctPayContacts() {
        if (this.acctPayContacts == null) {
            this.acctPayContacts = new ArrayList<Contact>();
        }
        return this.acctPayContacts;
    }

    public void setAcctPayContacts(List<Contact> acctPayContacts) {
        this.acctPayContacts = acctPayContacts;
    }

    public void addAcctPayContact(Contact acctPayContact) {
        if (acctPayContact == null) {
            return;
        }
        getAcctPayContacts().add(acctPayContact);
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

    public InvoiceFrequency getVendorinvFrequency() {
        return vendorinvFrequency;
    }

    public void setVendorinvFrequency(InvoiceFrequency vendorinvFrequency) {
        this.vendorinvFrequency = vendorinvFrequency;
    }

    public Float getVendorFees() {
        return vendorFees;
    }

    public void setVendorFees(Float vendorFees) {
        this.vendorFees = vendorFees;
    }

    public BigDecimal getMinFees() {
        return minFees;
    }

    public void setMinFees(BigDecimal minFees) {
        this.minFees = minFees;
    }

    public BigDecimal getMaxFees() {
        return maxFees;
    }

    public void setMaxFees(BigDecimal maxFees) {
        this.maxFees = maxFees;
    }

    public InvoiceDeliveryMethod getVendorinvDeliveryMethod() {
        return vendorinvDeliveryMethod;
    }

    public void setVendorinvDeliveryMethod(InvoiceDeliveryMethod vendorinvDeliveryMethod) {
        this.vendorinvDeliveryMethod = vendorinvDeliveryMethod;
    }

    public Date getCoiEndDate() {
        return coiEndDate;
    }

    public void setCoiEndDate(Date coiEndDate) {
        this.coiEndDate = coiEndDate;
    }
    
    /**
     * @return the VendorStatus
     */
    public VendorStatus getVendorStatus() {
        return vendorStatus;
    }

    /**
     * @param VendorStatus the VendorStatus to set
     */
    public void setVendorStatus(VendorStatus vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    @Override
    public String toString() {
        return "Vendor{" + "name=" + name + ", description=" + description + '}';
    }
}
