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
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    protected Long id;
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
    protected String terminationNotice;

    public void setTerminationNotice(String terminationNotice) {
        this.terminationNotice = terminationNotice;
    }

    public String getTerminationNotice() {
        return terminationNotice;
    }
    protected BillingDuration billingRateDuration;
    protected BillingDuration overTimeDuration;
    protected String visaStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    protected Boolean accountVerificationDocs;
    /**
     * Signed Copy of Work Order
     */
    protected Boolean signedCopyOfWorkOrder;
    /**
     * i9Filled
     */
    protected Boolean i9Filled;
    /**
     * w4 filled
     */
    protected Boolean w4Filled;
    /**
     * Logistics Preparation
     */
    protected Boolean logisticsPreparation;
    protected Boolean hrOrientation;

    public void setHrOrientation(Boolean hrOrientation) {
        this.hrOrientation = hrOrientation;
    }

    public Boolean isHrOrientation() {
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

    public Boolean isAccountVerificationDocs() {
        return accountVerificationDocs;
    }

    public void setAccountVerificationDocs(Boolean accountVerificationDocs) {
        this.accountVerificationDocs = accountVerificationDocs;
    }

    public Boolean isSignedCopyOfWorkOrder() {
        return signedCopyOfWorkOrder;
    }

    public void setSignedCopyOfWorkOrder(Boolean signedCopyOfWorkOrder) {
        this.signedCopyOfWorkOrder = signedCopyOfWorkOrder;
    }

    public Boolean isI9Filled() {
        return i9Filled;
    }

    public void setI9Filled(Boolean i9Filled) {
        this.i9Filled = i9Filled;
    }

    public Boolean isW4Filled() {
        return w4Filled;
    }

    public void setW4Filled(Boolean w4Filled) {
        this.w4Filled = w4Filled;
    }

    public Boolean isLogisticsPreparation() {
        return logisticsPreparation;
    }

    public void setLogisticsPreparation(Boolean logisticsPreparation) {
        this.logisticsPreparation = logisticsPreparation;
    }
    /**
     * 1099 Details
     */
    protected BigDecimal payRate1099;
    protected BigDecimal overTimePayrate1099;
    @Enumerated(EnumType.STRING)
    protected BillingDuration payTimeDuration1099;

    public BigDecimal getPayRate1099() {
        return payRate1099;
    }

    public void setPayRate1099(BigDecimal payRate1099) {
        this.payRate1099 = payRate1099;
    }

    public BigDecimal getOverTimePayrate1099() {
        return overTimePayrate1099;
    }

    public void setOverTimePayrate1099(BigDecimal overTimePayrate1099) {
        this.overTimePayrate1099 = overTimePayrate1099;
    }

    public BillingDuration getPayTimeDuration1099() {
        return payTimeDuration1099;
    }

    public void setPayTimeDuration1099(BillingDuration payTimeDuration1099) {
        this.payTimeDuration1099 = payTimeDuration1099;
    }
    /* Sub Contactor */
    protected String subContractorName;
    protected String subContractorContactName;
    /**
     * subcontractor Invoice Frequency
     */
    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.Index(name = "CI_INVC_FQ")
    protected InvoiceFrequency subcontractorinvoiceFrequency;
    /**
     * subcontractor PaymentTerms
     */
    protected String subcontractorpaymentTerms;
    /**
     * subcontractor W4Filled
     */
    protected Boolean subcontractorw4Filled;
    /**
     * subcontractor certificate of insurance
     */
    protected Boolean subcontractCOI;

    public InvoiceFrequency getSubcontractorinvoiceFrequency() {
        return subcontractorinvoiceFrequency;
    }

    public void setSubcontractorinvoiceFrequency(InvoiceFrequency subcontractorinvoiceFrequency) {
        this.subcontractorinvoiceFrequency = subcontractorinvoiceFrequency;
    }

    public String getSubcontractorpaymentTerms() {
        return subcontractorpaymentTerms;
    }

    public void setSubcontractorpaymentTerms(String subcontractorpaymentTerms) {
        this.subcontractorpaymentTerms = subcontractorpaymentTerms;
    }

    public Boolean getSubcontractorw4Filled() {
        return subcontractorw4Filled;
    }

    public void setSubcontractorw4Filled(Boolean subcontractorw4Filled) {
        this.subcontractorw4Filled = subcontractorw4Filled;
    }

    public Boolean getSubcontractCOI() {
        return subcontractCOI;
    }

    public void setSubcontractCOI(Boolean subcontractCOI) {
        this.subcontractCOI = subcontractCOI;
    }

    public void setSubContractorName(String subContractorName) {
        this.subContractorName = subContractorName;
    }

    public void setSubContractorContactName(String subContractorContactName) {
        this.subContractorContactName = subContractorContactName;
    }

    public String getSubContractorName() {
        return subContractorName;
    }

    public String getSubContractorContactName() {
        return subContractorContactName;
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
