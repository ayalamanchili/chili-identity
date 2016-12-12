/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import info.yalamanchili.office.entity.profile.Contact;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramana.Lukalapu
 */
@XmlRootElement
public class VendorMasterReportDto implements Serializable {

    protected Long id;
    protected String vendorName;
    protected String webSite;
    protected String vendorType;
    protected String vendorFees;
    protected String vendorLocations;
    protected String recruiterContact;
    protected String acctPayContact;
    protected String employeeName;
    protected String employeeType;
    protected String vendorPaymentTerms;
    protected Date coiEndDate;
    protected String vendorStatus;
    @Temporal(TemporalType.DATE)
    protected Date msaValDate;
    @Temporal(TemporalType.DATE)
    protected Date msaExpDate;
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Contact> contacts;
    
    public VendorMasterReportDto() {
    }
    
    public VendorMasterReportDto(Long id, String firstName, String lastName, String employeeType, String vendorName, Date msaValDate, Date msaExpDate) {
        this.id = id;
        this.employeeName = firstName + " " + lastName;
        this.employeeType = employeeType;
        this.vendorName = vendorName;
//        this.msaValDate = msaValDate;
//        this.msaExpDate = msaExpDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getVendorFees() {
        return vendorFees;
    }

    public void setVendorFees(String vendorFees) {
        this.vendorFees = vendorFees;
    }

    public String getVendorLocations() {
        return vendorLocations;
    }

    public void setVendorLocations(String vendorLocations) {
        this.vendorLocations = vendorLocations;
    }

    public String getRecruiterContact() {
        return recruiterContact;
    }

    public void setRecruiterContact(String recruiterContact) {
        this.recruiterContact = recruiterContact;
    }

    public String getAcctPayContact() {
        return acctPayContact;
    }

    public void setAcctPayContact(String acctPayContact) {
        this.acctPayContact = acctPayContact;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getVendorPaymentTerms() {
        return vendorPaymentTerms;
    }

    public void setVendorPaymentTerms(String vendorPaymentTerms) {
        this.vendorPaymentTerms = vendorPaymentTerms;
    }

    public Date getCoiEndDate() {
        return coiEndDate;
    }

    public void setCoiEndDate(Date coiEndDate) {
        this.coiEndDate = coiEndDate;
    }

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
     * @return the msaValDate
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
    
    public String getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(String vendorStatus) {
        this.vendorStatus = vendorStatus;
    }
}
