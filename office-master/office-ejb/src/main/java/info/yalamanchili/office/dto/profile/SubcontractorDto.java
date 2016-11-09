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
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.SubcontractorStatus;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
@XmlRootElement(name = "Subcontractor")
@XmlType
public class SubcontractorDto implements Serializable {

    protected Long id;

    @NotEmpty(message = "{subcontractor.not.empty.msg}")
    protected String name;
    // protected String description;
    protected String website;
    protected String paymentTerms;
    protected InvoiceFrequency invoiceFrequency;
    protected InvoiceDeliveryMethod invoiceDeliveryMethod;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{subcontractor.coiEndDate.not.null.msg}")
    protected Date coiEndDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{subcontractor.msaValDate.not.null.msg}")
    protected Date msaValDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{subcontractor.msaExpDate.not.null.msg}")
    protected Date msaExpDate;
    @NotNull(message = "{subcontractor.terminationNoticePeriod.not.null.msg}")
    protected Integer terminationNoticePeriod;
    @Enumerated(EnumType.STRING)
    protected SubcontractorStatus subcontractorStatus;
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

//    /**
//     * @return the description
//     */
//    public String getDescription() {
//        return description;
//    }
//
//    /**
//     * @param description the description to set
//     */
//    public void setDescription(String description) {
//        this.description = description;
//    }
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

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public InvoiceFrequency getInvoiceFrequency() {
        return invoiceFrequency;
    }

    public void setInvoiceFrequency(InvoiceFrequency invoiceFrequency) {
        this.invoiceFrequency = invoiceFrequency;
    }

    public InvoiceDeliveryMethod getInvoiceDeliveryMethod() {
        return invoiceDeliveryMethod;
    }

    public void setInvoiceDeliveryMethod(InvoiceDeliveryMethod invoiceDeliveryMethod) {
        this.invoiceDeliveryMethod = invoiceDeliveryMethod;
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

    public Date getMsaValDate() {
        return msaValDate;
    }

    public void setMsaValDate(Date msaValDate) {
        this.msaValDate = msaValDate;
    }

    public Date getMsaExpDate() {
        return msaExpDate;
    }

    public void setMsaExpDate(Date msaExpDate) {
        this.msaExpDate = msaExpDate;
    }

    public Integer getTerminationNoticePeriod() {
        return terminationNoticePeriod;
    }

    public void setTerminationNoticePeriod(Integer terminationNoticePeriod) {
        this.terminationNoticePeriod = terminationNoticePeriod;
    }
    /**
     * @return the subcontractorStatus
     */
    public SubcontractorStatus getSubcontractorStatus() {
        return subcontractorStatus;
    }

    /**
     * @param subcontractorStatus the subcontractorStatus to set
     */
    public void setSubcontractorStatus(SubcontractorStatus subcontractorStatus) {
        this.subcontractorStatus = subcontractorStatus;
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
        return "SubcontractorDto{" + "id=" + id + ", name=" + name + ", website=" + website + ", paymentTerms=" + paymentTerms + ", invoiceFrequency=" + invoiceFrequency + ", invoiceDeliveryMethod=" + invoiceDeliveryMethod + ", coiEndDate=" + coiEndDate + ", msaValDate=" + msaValDate + ", msaExpDate=" + msaExpDate + ", terminationNoticePeriod=" + terminationNoticePeriod + ", location=" + location + ", contact=" + contact + '}';
    }

}
