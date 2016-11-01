/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

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
    
    public VendorMasterReportDto() {
    }
    
    public VendorMasterReportDto(Long id, String firstName, String lastName, String employeeType, String vendorName, Date coiEndDate) {
        this.id = id;
        this.employeeName = firstName + " " + lastName;
        this.employeeType = employeeType;
        this.vendorName = vendorName;
        this.coiEndDate = coiEndDate;
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
}
