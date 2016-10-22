/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.ClientInfoComment;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.practice.Practice;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.CIDocument;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Lob;
import javax.persistence.Temporal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
public class ClientInformationDto implements Serializable {

    @Transient
    private static final long serialVersionUID = 11L;
    /**
     * Consultant Job Title at client
     */
    @NotEmpty(message = "{consultantJobTitle.not.empty.msg}")
    protected String consultantJobTitle;
    /**
     * flag to indicate if this is the primary client
     */
    protected Boolean ciPrimary;
    /**
     * startDate
     */
    @NotNull(message = "{startDate.not.empty.msg}")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date startDate;
    /**
     * endDate
     */
    @NotNull(groups = ClientInformation.SubmitChecks.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date endDate;
    /**
     *
     */
    @NotNull
    protected ClientInformationCompany company;
    /**
     * Client
     */
    @NotNull(message = "{client.not.empty.msg}")
    protected Client client;
    /**
     * Client Contact
     */
    protected Contact clientContact;
    /**
     * Client Location
     */
    protected Address clientLocation;
    /**
     * clientFeeApplicable
     */
    protected Boolean clientFeeApplicable;

    /**
     * clientFee
     */
    protected Float clientFee;

    /**
     * directClient
     */
    protected Boolean directClient;
    /**
     * Vendor AP Contact
     */
    protected Set<Contact> clientAPContacts;
    /**
     * Vendor
     */
    protected Vendor vendor;
    /**
     * Vendor Contact
     */
    protected Contact vendorContact;
    /**
     *
     */
    protected String vendorPaymentTerms;

    protected String clientPaymentTerms;
    /**
     * Vendor AP Contact
     */
    @NotNull
    protected Set<Contact> vendorAPContacts;
    /**
     * Vendor Location
     */
    protected Address vendorLocation;
    /**
     * Employee
     */
    protected Employee employee;
    /**
     * Item Number (quick books generated number
     */
    protected String itemNumber;
    /**
     * PayRate
     */
    protected BigDecimal payRate;

    protected Float payRatePercentage;
    /**
     * BillingRate
     */
    @Digits(integer = 10, fraction = 2, message = "{billingRate.not.valid.msg}")
    protected BigDecimal billingRate;
    /**
     * OverTime PayRate
     */
    @Digits(integer = 10, fraction = 2, message = "{overtimePayRate.not.valid.msg}")
    protected BigDecimal overTimePayRate;

    protected Float overTimePayRatePercentage;
    /**
     * over time billing rate
     */
    @Digits(integer = 10, fraction = 2, message = "{overtimeBillingRate.not.valid.msg}")
    protected BigDecimal overTimeBillingRate;
    /**
     * historical billing rates
     */
    protected List<BillingRate> billingRates;

    /**
     * billingRateDuration
     */
    protected BillingDuration billingRateDuration;
    /**
     * overTimeRateDuration
     */
    protected BillingDuration overTimeRateDuration;
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
    protected Set<Employee> recruiters;
    /**
     * Status
     */
    protected String visaStatus;
    /**
     * Notes
     */
    protected String notes;
    /**
     * termination notice
     */
    protected String terminationNotice;
    /**
     * subcontractor
     */
    protected Subcontractor subcontractor;
    /**
     * subcontractorContact;
     */
    protected Contact subcontractorContact;
    /**
     * subcontractor Address
     */
    protected Address subcontractorAddress;
    /**
     * subcontractorPayRate
     */
    @Digits(integer = 10, fraction = 2, message = "{subcontractorPayRate.not.valid.msg}")
    protected BigDecimal subcontractorPayRate;
    /**
     * subcontractorOvertimePayRate
     */
    @Digits(integer = 10, fraction = 2, message = "{subcontractorOvertimePayRate.not.valid.msg}")
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
    /**
     * 1099 Details
     */
    @Digits(integer = 10, fraction = 2, message = "{payRate1099.not.valid.msg}")
    protected BigDecimal payRate1099;
    @Digits(integer = 10, fraction = 2, message = "{overtimePayRate1099.not.valid.msg}")
    protected BigDecimal overTimePayrate1099;
    protected BillingDuration payTimeDuration1099;
    protected String paymentTerms1099;
    protected InvoiceFrequency invoiceFrequency1099;
    /* 
     * comments
     */
    protected List<ClientInfoComment> comments;

    protected Set<CIDocument> cidocument;

    @Lob
    protected String reason;

    @XmlElement
    public Set<CIDocument> getCidocument() {
        return cidocument;
    }

    public void setCidocument(Set<CIDocument> cidocument) {
        this.cidocument = cidocument;
    }

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * -----------Tracking info---------------------------
     */
    /**
     * Account verification docs
     */
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
     * joining report
     */
    protected String joiningReport;
    /**
     * Logistics Preparation
     */
    protected Boolean logisticsPreparation;
    /**
     * HR orientation
     */
    protected Boolean hrOrientation;
    /**
     *
     */
    protected Project clientProject;
    /**
     *
     */
    @NotNull
    protected Set<Contact> vendorRecruiters;
    /**
     *
     */
    protected Vendor middleVendor;

    protected String timeSheetRequirement;

    protected String vacationDetails;

    protected String specialInvoiceInstructions;

    private ClientInformationStatus status;

    protected Boolean isEndDateConfirmed;
    /**
     *
     */
    @NotNull(message = "{practice.not.empty.msg}")
    private Practice practice;
    @NotEmpty(message = "{sector.not.empty.msg}")
    protected String sectorsAndBUs;
    protected String bpmProcessId;

    public ClientInformationDto() {
    }

    public ClientInformationDto(Long id, String itemNumber, BigDecimal billingRate, BigDecimal overTimeBillingRate, InvoiceFrequency invoiceFrequency) {
        this.id = id;
        this.itemNumber = itemNumber;
        this.billingRate = billingRate;
        this.overTimeBillingRate = overTimeBillingRate;
        this.invoiceFrequency = invoiceFrequency;
    }

    public String getConsultantJobTitle() {
        return consultantJobTitle;
    }

    public void setConsultantJobTitle(String consultantJobTitle) {
        this.consultantJobTitle = consultantJobTitle;
    }

    public Boolean getCiPrimary() {
        return ciPrimary;
    }

    public void setCiPrimary(Boolean ciPrimary) {
        this.ciPrimary = ciPrimary;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Contact getClientContact() {
        return clientContact;
    }

    public void setClientContact(Contact clientContact) {
        this.clientContact = clientContact;
    }

    public Address getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(Address clientLocation) {
        this.clientLocation = clientLocation;
    }

    public Boolean getClientFeeApplicable() {
        return clientFeeApplicable;
    }

    public void setClientFeeApplicable(Boolean clientFeeApplicable) {
        this.clientFeeApplicable = clientFeeApplicable;
    }

    public Float getClientFee() {
        return clientFee;
    }

    public void setClientFee(Float clientFee) {
        this.clientFee = clientFee;
    }

    public Boolean getDirectClient() {
        return directClient;
    }

    public void setDirectClient(Boolean directClient) {
        this.directClient = directClient;
    }

    public Set<Contact> getClientAPContacts() {
        if (clientAPContacts == null) {
            this.clientAPContacts = new HashSet<>();
        }
        return clientAPContacts;
    }

    public void setClientAPContacts(Set<Contact> clientAPContacts) {
        this.clientAPContacts = clientAPContacts;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Contact getVendorContact() {
        return vendorContact;
    }

    public void setVendorContact(Contact vendorContact) {
        this.vendorContact = vendorContact;
    }

    public Address getVendorLocation() {
        return vendorLocation;
    }

    public void setVendorLocation(Address vendorLocation) {
        this.vendorLocation = vendorLocation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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

    /**
     * @return @generated
     */
    @XmlTransient
    public List<BillingRate> getBillingRates() {
        if (this.billingRates == null) {
            this.billingRates = new ArrayList<>();
        }
        return this.billingRates;
    }

    public void setBillingRates(List<BillingRate> billingRates) {
        this.billingRates = billingRates;
    }

    public void addBillingRate(BillingRate entity) {
        if (entity == null) {
            return;
        }
        getBillingRates().add(entity);
    }

    public BigDecimal getOverTimePayRate() {
        return overTimePayRate;
    }

    public void setOverTimePayRate(BigDecimal overTimePayRate) {
        this.overTimePayRate = overTimePayRate;
    }

    /**
     * @return the payRatePercentage
     */
    public Float getPayRatePercentage() {
        return payRatePercentage;
    }

    /**
     * @param payRatePercentage the payRatePercentage to set
     */
    public void setPayRatePercentage(Float payRatePercentage) {
        this.payRatePercentage = payRatePercentage;
    }

    /**
     * @return the overTimePayRatePercentage
     */
    public Float getOverTimePayRatePercentage() {
        return overTimePayRatePercentage;
    }

    /**
     * @param overTimePayRatePercentage the overTimePayRatePercentage to set
     */
    public void setOverTimePayRatePercentage(Float overTimePayRatePercentage) {
        this.overTimePayRatePercentage = overTimePayRatePercentage;
    }

    public BigDecimal getOverTimeBillingRate() {
        return overTimeBillingRate;
    }

    public void setOverTimeBillingRate(BigDecimal overTimeBillingRate) {
        this.overTimeBillingRate = overTimeBillingRate;
    }

    public BillingDuration getBillingRateDuration() {
        return billingRateDuration;
    }

    public void setBillingRateDuration(BillingDuration billingRateDuration) {
        this.billingRateDuration = billingRateDuration;
    }

    public BillingDuration getOverTimeRateDuration() {
        return overTimeRateDuration;
    }

    public void setOverTimeRateDuration(BillingDuration overTimeRateDuration) {
        this.overTimeRateDuration = overTimeRateDuration;
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

    public Set<Employee> getRecruiters() {
        if (recruiters == null) {
            this.recruiters = new HashSet<>();
        }
        return recruiters;
    }

    public void setRecruiters(Set<Employee> recruiters) {
        this.recruiters = recruiters;
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public String getTerminationNotice() {
        return terminationNotice;
    }

    public void setTerminationNotice(String terminationNotice) {
        this.terminationNotice = terminationNotice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Subcontractor getSubcontractor() {
        return subcontractor;
    }

    public void setSubcontractor(Subcontractor subcontractor) {
        this.subcontractor = subcontractor;
    }

    public Contact getSubcontractorContact() {
        return subcontractorContact;
    }

    public void setSubcontractorContact(Contact subcontractorContact) {
        this.subcontractorContact = subcontractorContact;
    }

    public Address getSubcontractorAddress() {
        return subcontractorAddress;
    }

    public void setSubcontractorAddress(Address subcontractorAddress) {
        this.subcontractorAddress = subcontractorAddress;
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

    public String getPaymentTerms1099() {
        return paymentTerms1099;
    }

    public void setPaymentTerms1099(String paymentTerms1099) {
        this.paymentTerms1099 = paymentTerms1099;
    }

    @XmlTransient
    public List<ClientInfoComment> getComments() {
        return comments;
    }

    public void setComments(List<ClientInfoComment> comments) {
        this.comments = comments;
    }

    public Boolean getAccountVerificationDocs() {
        return accountVerificationDocs;
    }

    public Boolean getSignedCopyOfWorkOrder() {
        return signedCopyOfWorkOrder;
    }

    public Boolean getI9Filled() {
        return i9Filled;
    }

    public Boolean getW4Filled() {
        return w4Filled;
    }

    public Boolean getLogisticsPreparation() {
        return logisticsPreparation;
    }

    public Boolean getHrOrientation() {
        return hrOrientation;
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

    public String getJoiningReport() {
        return joiningReport;
    }

    public void setJoiningReport(String joiningReport) {
        this.joiningReport = joiningReport;
    }

    public Boolean isHrOrientation() {
        return hrOrientation;
    }

    public void setHrOrientation(Boolean hrOrientation) {
        this.hrOrientation = hrOrientation;
    }

    public Project getClientProject() {
        return clientProject;
    }

    public void setClientProject(Project clientProject) {
        this.clientProject = clientProject;
    }

    public Vendor getMiddleVendor() {
        return middleVendor;
    }

    public void setMiddleVendor(Vendor middleVendor) {
        this.middleVendor = middleVendor;
    }

    public String getTimeSheetRequirement() {
        return timeSheetRequirement;
    }

    public void setTimeSheetRequirement(String timeSheetRequirement) {
        this.timeSheetRequirement = timeSheetRequirement;
    }

    public String getVacationDetails() {
        return vacationDetails;
    }

    public void setVacationDetails(String vacationDetails) {
        this.vacationDetails = vacationDetails;
    }

    public String getSpecialInvoiceInstructions() {
        return specialInvoiceInstructions;
    }

    public void setSpecialInvoiceInstructions(String specialInvoiceInstructions) {
        this.specialInvoiceInstructions = specialInvoiceInstructions;
    }

    public ClientInformationStatus getStatus() {
        return status;
    }

    public void setStatus(ClientInformationStatus status) {
        this.status = status;
    }

    public ClientInformationCompany getCompany() {
        return company;
    }

    public void setCompany(ClientInformationCompany company) {
        this.company = company;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public String getSectorsAndBUs() {
        return sectorsAndBUs;
    }

    public void setSectorsAndBUs(String sectorsAndBUs) {
        this.sectorsAndBUs = sectorsAndBUs;
    }

    public Set<Contact> getVendorAPContacts() {
        if (vendorAPContacts == null) {
            this.vendorAPContacts = new HashSet<>();
        }
        return vendorAPContacts;
    }

    public void setVendorAPContacts(Set<Contact> vendorAPContacts) {
        this.vendorAPContacts = vendorAPContacts;
    }

    public Set<Contact> getVendorRecruiters() {
        if (vendorRecruiters == null) {
            this.vendorRecruiters = new HashSet<>();
        }
        return vendorRecruiters;
    }

    public void setVendorRecruiters(Set<Contact> vendorRecruiters) {
        this.vendorRecruiters = vendorRecruiters;
    }

    public String getVendorPaymentTerms() {
        return vendorPaymentTerms;
    }

    public void setVendorPaymentTerms(String vendorPaymentTerms) {
        this.vendorPaymentTerms = vendorPaymentTerms;
    }

    public String getClientPaymentTerms() {
        return clientPaymentTerms;
    }

    public void setClientPaymentTerms(String clientPaymentTerms) {
        this.clientPaymentTerms = clientPaymentTerms;
    }

    public InvoiceFrequency getInvoiceFrequency1099() {
        return invoiceFrequency1099;
    }

    public void setInvoiceFrequency1099(InvoiceFrequency invoiceFrequency1099) {
        this.invoiceFrequency1099 = invoiceFrequency1099;
    }

    public Boolean getIsEndDateConfirmed() {
        return isEndDateConfirmed;
    }

    public void setIsEndDateConfirmed(Boolean isEndDateConfirmed) {
        this.isEndDateConfirmed = isEndDateConfirmed;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
