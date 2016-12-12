/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.VendorType;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.VendorStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
@XmlRootElement(name = "CreateVendor")
@XmlType
public class VendorDto implements Serializable {

    protected Long id;

    @NotEmpty(message = "{vendor.not.empty.msg}")
    protected String name;

    protected String description;
    @Enumerated(EnumType.STRING)
    protected VendorType vendorType;
    protected String website;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "{vendor.msaValDate.not.null.msg}")
    protected Date msaValDate;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "{vendor.msaExpDate.not.null.msg}")
    protected Date msaExpDate;
    @NotEmpty(message = "{vendor.terminationNotice.not.empty.msg}")
    protected String terminationNotice;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date coiEndDate;
    @Enumerated(EnumType.STRING)
    protected VendorStatus vendorStatus;
    protected String paymentTerms;
    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency vendorinvFrequency;
    protected Float vendorFees;
    protected BigDecimal minFees;

    protected BigDecimal maxFees;
    @Enumerated(EnumType.STRING)
    protected InvoiceDeliveryMethod vendorinvDeliveryMethod;
    protected Address location;
    protected ContactDto contact;
    protected ContactDto vendorAcctPayContact;

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
     * @return the vendorType
     */
    public VendorType getVendorType() {
        return vendorType;
    }

    /**
     * @param vendorType the vendorType to set
     */
    public void setVendorType(VendorType vendorType) {
        this.vendorType = vendorType;
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
     *
     *
     * @return the msaExpDate
     */
    public Date getMsaExpDate() {
        return msaExpDate;
    }

    /**
     *
     * @param msaExpDate the msaExpDate to set
     *
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
     * @return the vendorStatus
     */
    public VendorStatus getVendorStatus() {
        return vendorStatus;
    }

    /**
     * @param vendorStatus the vendorStatus to set
     */
    public void setVendorStatus(VendorStatus vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    /**
     * @return the paymentTerms
     */
    public String getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * @param paymentTerms the paymentTerms to set
     */
    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    /**
     * @return the vendorinvFrequency
     */
    public InvoiceFrequency getVendorinvFrequency() {
        return vendorinvFrequency;
    }

    /**
     * @param vendorinvFrequency the vendorinvFrequency to set
     */
    public void setVendorinvFrequency(InvoiceFrequency vendorinvFrequency) {
        this.vendorinvFrequency = vendorinvFrequency;
    }

    /**
     * @return the vendorFees
     */
    public Float getVendorFees() {
        return vendorFees;
    }

    /**
     * @param vendorFees the vendorFees to set
     */
    public void setVendorFees(Float vendorFees) {
        this.vendorFees = vendorFees;
    }

    /**
     * @return the minFees
     */
    public BigDecimal getMinFees() {
        return minFees;
    }

    /**
     * @param minFees the minFees to set
     */
    public void setMinFees(BigDecimal minFees) {
        this.minFees = minFees;
    }

    /**
     * @return the maxFees
     */
    public BigDecimal getMaxFees() {
        return maxFees;
    }

    /**
     * @param maxFees the maxFees to set
     */
    public void setMaxFees(BigDecimal maxFees) {
        this.maxFees = maxFees;
    }

    /**
     * @return the vendorinvDeliveryMethod
     */
    public InvoiceDeliveryMethod getVendorinvDeliveryMethod() {
        return vendorinvDeliveryMethod;
    }

    /**
     * @param vendorinvDeliveryMethod the vendorinvDeliveryMethod to set
     */
    public void setVendorinvDeliveryMethod(InvoiceDeliveryMethod vendorinvDeliveryMethod) {
        this.vendorinvDeliveryMethod = vendorinvDeliveryMethod;
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

    /**
     * @return the vendorAcctPayContact
     */
    public ContactDto getVendorAcctPayContact() {
        return vendorAcctPayContact;
    }

    /**
     * @param vendorAcctPayContact the vendorAcctPayContact to set
     */
    public void setVendorAcctPayContact(ContactDto vendorAcctPayContact) {
        this.vendorAcctPayContact = vendorAcctPayContact;
    }

    @Override
    public String toString() {
        return "Create Vendor{" + "name=" + name + ", description=" + description + '}';
    }

}
