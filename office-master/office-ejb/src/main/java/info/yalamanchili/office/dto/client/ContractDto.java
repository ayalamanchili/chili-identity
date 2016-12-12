/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.client;

import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
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
     *
     */
    protected String contractSignedEntity;
    /**
     *
     */
    protected ClientInformationCompany company;
    /**
     * Client
     */
    protected String client;

    /**
     * ClientFeeApplicable
     */
    protected Boolean clientFeeApplicable;
    /**
     * DirectClient
     */
    protected Boolean directClient;

    protected String bpmProcessId;
    /**
     * Client Contact
     */
    protected String clientContact;
    /**
     * Client Location
     */
    protected String clientLocation;
    /**
     *
     */
    protected String clientAPContact;
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
    protected String vendorAPContact;
    protected String vendorPaymentTerms;
    protected String clientPaymentTerms;
    protected String vendorRecruiter;
    protected String middleVendor;
    protected String clientProject;
    protected String purchaseOrderNo;
    protected String timeSheetRequirement;
    protected String specialInvoiceInstructions;
    protected String subContractorWorkOrderNo;

    /**
     * Employee
     */
    protected String employee;
    protected String employeeDetails;
    /**
     * employee tpe
     */
    protected String employeeType;
    /**
     * Item Number (quick books generated number
     */
    protected String itemNumber;
    /**
     * PayRate
     */
    protected BigDecimal payRate;
    /**
     * PayRatePercentage
     */
    protected Float payRatePercentage;
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
    protected BillingDuration billingRateDuration;
    protected BillingDuration overTimeRateDuration;
    protected String visaStatus;
    protected Boolean isActive;
    protected Boolean isEnded;
    protected Boolean isStarted;
    protected Boolean isReady;

    /**
     * -----------Tracking info---------------------------
     */
    /**
     * Account verification docs
     */
    protected String joiningReport;

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
    /**
     * 1099 Details
     */
    protected BigDecimal payRate1099;
    protected BigDecimal overTimePayrate1099;
    protected BillingDuration payTimeDuration1099;
    protected String paymentTerms1099;
    protected InvoiceFrequency invoiceFrequency1099;

    /**
     * subcontractorPayRate
     */
    protected String subContractorName;
    /*
     * subContractorContactName
     */
    protected String subContractorContactName;

    /**
     * subcontractor Address
     */
    protected String subcontractorAddress;

    protected String subContractorContactEmail;

    protected String subContractorContactPhone;

    protected String subcontractorContact;

    protected BigDecimal subcontractorPayRate;
    /**
     * subcontractorOvertimePayRate
     */
    protected BigDecimal subcontractorOvertimePayRate;
    /**
     * subcontractor Invoice Frequency
     */
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

    protected String status;

    protected String practice;

    protected String sectorsAndBUs;

    protected String employeeCompany;

    protected long employeeID;

    protected Float vendorFees;

    protected Float clientFees;

    protected BigDecimal finalBillingRate;

    protected String gapPeriod;

    public ContractDto() {
    }

    public ContractDto(Long id, String firstName, String lastName, String client, String vendor, BigDecimal billingRate, BillingDuration billnigDuration, Date startDate, Date endDate, String employeeType, ClientInformationCompany company) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.vendor = vendor;
        this.billingRate = billingRate;
        this.billingRateDuration = billnigDuration;
        this.employee = firstName + " " + lastName;
        this.employeeType = employeeType;
        this.company = company;
    }

    public ContractDto(Long id, String firstName, String lastName, String client, String vendor, BigDecimal billingRate, BillingDuration billnigDuration, Date startDate, Date endDate, String employeeType, ClientInformationCompany company, BigDecimal payRate, Float payRatePercentage) {
        this(id, firstName, lastName, client, vendor, billingRate, billnigDuration, startDate, endDate, employeeType, company);
        this.payRate = payRate;
        this.payRatePercentage = payRatePercentage;
    }

    public void setPaymentTerms1099(String paymentTerms1099) {
        this.paymentTerms1099 = paymentTerms1099;
    }

    public String getPaymentTerms1099() {
        return paymentTerms1099;
    }

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

    /* 
     * Sub Contactor 
     */
    public String getSubcontractorAddress() {
        return subcontractorAddress;
    }

    public void setSubcontractorAddress(String subcontractorAddress) {
        this.subcontractorAddress = subcontractorAddress;
    }

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
        if (subContractorContactName == null) {
            return subContractorContactName;
        } else {
            return subContractorContactName.replaceAll("<br/>", ", ");
        }

    }

    public BigDecimal getSubcontractorPayRate() {
        return subcontractorPayRate;
    }

    public void setSubcontractorPayRate(BigDecimal subcontractorPayRate) {
        this.subcontractorPayRate = subcontractorPayRate;
    }

    public BigDecimal getSubcontractorOvertimePayRate() {
        return subcontractorOvertimePayRate;
    }

    public void setSubcontractorOvertimePayRate(BigDecimal subcontractorOvertimePayRate) {
        this.subcontractorOvertimePayRate = subcontractorOvertimePayRate;
    }

    public String getTerminationNotice() {
        return terminationNotice;
    }

    public void setTerminationNotice(String terminationNotice) {
        this.terminationNotice = terminationNotice;
    }

    public String getVendorPaymentTerms() {
        return vendorPaymentTerms;
    }

    public void setVendorPaymentTerms(String vendorPaymentTerms) {
        this.vendorPaymentTerms = vendorPaymentTerms;
    }

    public void setVendorAPContact(String vendorAPContact) {
        this.vendorAPContact = vendorAPContact;
    }

    public String getVendorAPContact() {
        return vendorAPContact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBillingRateDuration(BillingDuration billingRateDuration) {
        this.billingRateDuration = billingRateDuration;
    }

    public void setOverTimeRateDuration(BillingDuration overTimeRateDuration) {
        this.overTimeRateDuration = overTimeRateDuration;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public BillingDuration getBillingRateDuration() {
        return billingRateDuration;
    }

    public BillingDuration getOverTimeRateDuration() {
        return overTimeRateDuration;
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setJoiningReport(String joiningReport) {
        this.joiningReport = joiningReport;
    }

    public String getJoiningReport() {
        return joiningReport;
    }

    public void setHrOrientation(Boolean hrOrientation) {
        this.hrOrientation = hrOrientation;
    }

    public Boolean getHrOrientation() {
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

    public Boolean getClientFeeApplicable() {
        return clientFeeApplicable;
    }

    public void setClientFeeApplicable(Boolean clientFeeApplicable) {
        this.clientFeeApplicable = clientFeeApplicable;
    }

    public Boolean getDirectClient() {
        return directClient;
    }

    public void setDirectClient(Boolean directClient) {
        this.directClient = directClient;
    }

    public String getClientContact() {
        if (clientContact == null) {
            return clientContact;
        } else {
            return clientContact.replaceAll("<br/>", ", ");
        }
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

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
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

    public Float getPayRatePercentage() {
        return payRatePercentage;
    }

    public void setPayRatePercentage(Float payRatePercentage) {
        this.payRatePercentage = payRatePercentage;
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

    public Boolean getAccountVerificationDocs() {
        return accountVerificationDocs;
    }

    public void setAccountVerificationDocs(Boolean accountVerificationDocs) {
        this.accountVerificationDocs = accountVerificationDocs;
    }

    public Boolean getSignedCopyOfWorkOrder() {
        return signedCopyOfWorkOrder;
    }

    public void setSignedCopyOfWorkOrder(Boolean signedCopyOfWorkOrder) {
        this.signedCopyOfWorkOrder = signedCopyOfWorkOrder;
    }

    public Boolean getI9Filled() {
        return i9Filled;
    }

    public void setI9Filled(Boolean i9Filled) {
        this.i9Filled = i9Filled;
    }

    public Boolean getW4Filled() {
        return w4Filled;
    }

    public void setW4Filled(Boolean w4Filled) {
        this.w4Filled = w4Filled;
    }

    public Boolean getLogisticsPreparation() {
        return logisticsPreparation;
    }

    public void setLogisticsPreparation(Boolean logisticsPreparation) {
        this.logisticsPreparation = logisticsPreparation;
    }

    public String getVendorRecruiter() {
        if (vendorRecruiter == null) {
            return vendorRecruiter;
        } else {
            return vendorRecruiter.replaceAll("<br/>", ", ");
        }
    }

    public void setVendorRecruiter(String vendorRecruiter) {
        this.vendorRecruiter = vendorRecruiter;
    }

    public String getMiddleVendor() {
        return middleVendor;
    }

    public void setMiddleVendor(String middleVendor) {
        this.middleVendor = middleVendor;
    }

    public String getClientProject() {
        return clientProject;
    }

    public void setClientProject(String clientProject) {
        this.clientProject = clientProject;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getTimeSheetRequirement() {
        return timeSheetRequirement;
    }

    public void setTimeSheetRequirement(String timeSheetRequirement) {
        this.timeSheetRequirement = timeSheetRequirement;
    }

    public String getSpecialInvoiceInstructions() {
        return specialInvoiceInstructions;
    }

    public void setSpecialInvoiceInstructions(String specialInvoiceInstructions) {
        this.specialInvoiceInstructions = specialInvoiceInstructions;
    }

    public String getSubContractorWorkOrderNo() {
        return subContractorWorkOrderNo;
    }

    public void setSubContractorWorkOrderNo(String subContractorWorkOrderNo) {
        this.subContractorWorkOrderNo = subContractorWorkOrderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSectorsAndBUs() {
        return sectorsAndBUs;
    }

    public void setSectorsAndBUs(String sectorsAndBUs) {
        this.sectorsAndBUs = sectorsAndBUs;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getEmployeeCompany() {
        return employeeCompany;
    }

    public void setEmployeeCompany(String employeeCompany) {
        this.employeeCompany = employeeCompany;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getContractSignedEntity() {
        return contractSignedEntity;
    }

    public void setContractSignedEntity(String contractSignedEntity) {
        this.contractSignedEntity = contractSignedEntity;
    }

    public ClientInformationCompany getCompany() {
        return company;
    }

    public void setCompany(ClientInformationCompany company) {
        this.company = company;
    }

    public String getClientAPContact() {
        return clientAPContact;
    }

    public void setClientAPContact(String clientAPContact) {
        this.clientAPContact = clientAPContact;
    }

    public InvoiceFrequency getInvoiceFrequency1099() {
        return invoiceFrequency1099;
    }

    public void setInvoiceFrequency1099(InvoiceFrequency invoiceFrequency1099) {
        this.invoiceFrequency1099 = invoiceFrequency1099;
    }

    public String getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(String employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsEnded() {
        return isEnded;
    }

    public void setIsEnded(Boolean isEnded) {
        this.isEnded = isEnded;
    }

    public Boolean getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(Boolean isStarted) {
        this.isStarted = isStarted;
    }

    public Boolean getIsReady() {
        return isReady;
    }

    public void setIsReady(Boolean isReady) {
        this.isReady = isReady;
    }

    public String getClientPaymentTerms() {
        return clientPaymentTerms;
    }

    public void setClientPaymentTerms(String clientPaymentTerms) {
        this.clientPaymentTerms = clientPaymentTerms;
    }

    public BigDecimal getFinalBillingRate() {
        return finalBillingRate;
    }

    public void setFinalBillingRate(BigDecimal finalBillingRate) {
        this.finalBillingRate = finalBillingRate;
    }

    public Float getVendorFees() {
        return vendorFees;
    }

    public void setVendorFees(Float vendorFees) {
        this.vendorFees = vendorFees;
    }

    public Float getClientFees() {
        return clientFees;
    }

    public void setClientFees(Float clientFees) {
        this.clientFees = clientFees;
    }

    public String getGapPeriod() {
        return gapPeriod;
    }

    public void setGapPeriod(String gapPeriod) {
        this.gapPeriod = gapPeriod;
    }

    /**
     * @return the bpmProcessId
     */
    public String getBpmProcessId() {
        return bpmProcessId;
    }

    /**
     * @param bpmProcessId the bpmProcessId to set
     */
    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    @XmlRootElement
    @XmlType
    public static class ContractTable implements java.io.Serializable {

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
                this.entities = new ArrayList<>();
            }
            return entities;
        }

        public void setEntities(List<ContractDto> entities) {
            this.entities = entities;
        }

    }
}
