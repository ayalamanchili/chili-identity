/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement(name = "Contract")
@XmlType
public class ContractDto implements Serializable {

    /**
     * jobtitle
     */
    protected String consultantJobTitle;
    /**
     * startdate
     */
    protected Date startDate;
    /**
     * enddate
     */
    protected Date endDate;
    /**
     * Client
     */
    protected String client;
    /**
     * Client Contact
     */
    protected String clientContact;
    /**
     * Client Location
     */
    protected String clientLocation;
    /**
     * Vendor
     */
    protected String vendor;
    /**
     * Vendor Contact
     */
    protected String vendorContact;
    /**
     * Vendor Location
     */
    protected String vendorLocation;
    /**
     * Employee
     */
    protected String employee;
    /**
     * Item Number (quick books generated number
     */
    protected String itemNumber;
    /**
     * PayRate
     */
    protected BigDecimal payRate;
    /**
     * BillingRate
     */
    protected BigDecimal billingRate;
    /**
     * OverTime PayRate
     */
    protected BigDecimal overTimePayRate;
    /**
     * over time billing rate
     */
    protected BigDecimal overTimeBillingRate;
    /**
     * Invoice Frequency
     */
    protected InvoiceFrequency invoiceFrequency;
    /**
     * Invoice Delivery Method
     */
    protected InvoiceDeliveryMethod invoiceDeliveryMethod;
    /**
     * recruiter
     */
    protected String recruiter;
    /**
     * Notes
     */
    protected String notes;
    
    protected BillingDuration billingRateDuration;
    
     protected BillingDuration overTimeDuration;
      
    protected String visaStatus;
  

    public void setBillingRateDuration(BillingDuration billingRateDuration) {
        this.billingRateDuration = billingRateDuration;
    }

    public void setOverTimeDuration(BillingDuration overTimeDuration) {
        this.overTimeDuration = overTimeDuration;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public BillingDuration getBillingRateDuration() {
        return billingRateDuration;
    }

    public BillingDuration getOverTimeDuration() {
        return overTimeDuration;
    }

    public String getVisaStatus() {
        return visaStatus;
    }
     
     /**
     * -----------Tracking info---------------------------
     */
    /**
     * Account verification docs
     */
    protected String joiningReport;

    public void setJoiningReport(String joiningReport) {
        this.joiningReport = joiningReport;
    }

    public String getJoiningReport() {
        return joiningReport;
    }

    protected boolean accountVerificationDocs;
    /**
     * Signed Copy of Work Order
     */
    protected boolean signedCopyOfWorkOrder;
    /**
     * i9Filled
     */
    protected boolean i9Filled;
    /**
     * w4 filled
     */
    protected boolean w4Filled;
    /**
     * Logistics Preparation
     */
    protected boolean logisticsPreparation;

    protected boolean hrOrientation;

    public void setHrOrientation(boolean hrOrientation) {
        this.hrOrientation = hrOrientation;
    }

    public boolean isHrOrientation() {
        return hrOrientation;
    }
      
    public String getConsultantJobTitle() {
        return consultantJobTitle;
    }

    public void setConsultantJobTitle(String consultantJobTitle) {
        this.consultantJobTitle = consultantJobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorContact() {
        return vendorContact;
    }

    public void setVendorContact(String vendorContact) {
        this.vendorContact = vendorContact;
    }

    public String getVendorLocation() {
        return vendorLocation;
    }

    public void setVendorLocation(String vendorLocation) {
        this.vendorLocation = vendorLocation;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public BigDecimal getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(BigDecimal billingRate) {
        this.billingRate = billingRate;
    }

    public BigDecimal getOverTimePayRate() {
        return overTimePayRate;
    }

    public void setOverTimePayRate(BigDecimal overTimePayRate) {
        this.overTimePayRate = overTimePayRate;
    }

    public BigDecimal getOverTimeBillingRate() {
        return overTimeBillingRate;
    }

    public void setOverTimeBillingRate(BigDecimal overTimeBillingRate) {
        this.overTimeBillingRate = overTimeBillingRate;
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

    public String getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(String recruiter) {
        this.recruiter = recruiter;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isAccountVerificationDocs() {
        return accountVerificationDocs;
    }

    public void setAccountVerificationDocs(boolean accountVerificationDocs) {
        this.accountVerificationDocs = accountVerificationDocs;
    }

    public boolean isSignedCopyOfWorkOrder() {
        return signedCopyOfWorkOrder;
    }

    public void setSignedCopyOfWorkOrder(boolean signedCopyOfWorkOrder) {
        this.signedCopyOfWorkOrder = signedCopyOfWorkOrder;
    }

    public boolean isI9Filled() {
        return i9Filled;
    }

    public void setI9Filled(boolean i9Filled) {
        this.i9Filled = i9Filled;
    }

    public boolean isW4Filled() {
        return w4Filled;
    }

    public void setW4Filled(boolean w4Filled) {
        this.w4Filled = w4Filled;
    }

    public boolean isLogisticsPreparation() {
        return logisticsPreparation;
    }

    public void setLogisticsPreparation(boolean logisticsPreparation) {
        this.logisticsPreparation = logisticsPreparation;
    }

    @XmlRootElement
    @XmlType
    public static class ContractTable {

        protected Long size;
        protected List<ContractDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ContractDto> getEntities() {
            if (this.entities == null) {
                this.entities = new ArrayList<ContractDto>();
            }
            return entities;
        }

        public void setEntities(List<ContractDto> entities) {
            this.entities = entities;
        }
    }
}
