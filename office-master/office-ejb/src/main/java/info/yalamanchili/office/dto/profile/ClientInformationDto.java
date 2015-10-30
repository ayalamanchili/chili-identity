/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.Company;
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
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
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
    @Field
    @NotEmpty(message = "{consultantJobTitle.not.empty.msg}")
    protected String consultantJobTitle;
    /**
     * flag to indicate if this is the primary client
     */
    @Field(index = Index.UN_TOKENIZED)
    protected Boolean ciPrimary;
    /**
     * startDate
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    /**
     * endDate
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date endDate;
    /**
     * flag to indicate to end of previous project.
     */
    @Transient
    protected boolean endPreviousProject;
    /**
     *
     */
    @Transient
    protected Date previousProjectEndDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClientInfo_Employees")
    protected Company company;
    /**
     * Client
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Client_ClientInformations")
    @NotNull(message = "{client.not.empty.msg}")
    protected Client client;
    /**
     * Client Contact
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClientContact_ClientInformations")
    protected Contact clientContact;
    /**
     * Client Location
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClientLocation_ClientInformations")
    protected Address clientLocation;
    /**
     * Vendor
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Vendor_ClientInformations")
    protected Vendor vendor;
    /**
     * Vendor Contact
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_VendorContact_ClientInformations")
    protected Contact vendorContact;

    /**
     * Vendor AP Contact
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_VendorAPContact_ClientInformations")
    protected Contact vendorAPContact;
    /**
     * Vendor Location
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_VendorLocation_ClientInformations")
    protected Address vendorLocation;
    /**
     * Employee
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_ClientInformations")
    protected Employee employee;
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
     * historical billing rates
     */
    @OneToMany(mappedBy = "clientInformation", cascade = CascadeType.ALL)
    protected List<BillingRate> billingRates;

    /**
     * billingRateDuration
     */
    @Enumerated(EnumType.STRING)
    protected BillingDuration billingRateDuration;
    /**
     * overTimeRateDuration
     */
    @Enumerated(EnumType.STRING)
    protected BillingDuration overTimeRateDuration;
    /**
     * Invoice Frequency
     */
    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.Index(name = "CI_INVC_FQ")
    protected InvoiceFrequency invoiceFrequency;
    /**
     * Invoice Delivery Method
     */
    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.Index(name = "CI_INVC_DEL_MTHD")
    protected InvoiceDeliveryMethod invoiceDeliveryMethod;
    /**
     * recruiter
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Recruiter_ClientInformations")
    protected Employee recruiter;
    /**
     * Status
     */
    protected String visaStatus;
    /**
     * Notes
     */
    @Lob
    protected String notes;
    /**
     * termination notice
     */
    protected String terminationNotice;
    /**
     * subcontractor
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_SubCntr_ClientInformations")
    protected Subcontractor subcontractor;
    /**
     * subcontractorContact;
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_SubCntrContact_ClientInformations")
    protected Contact subcontractorContact;
    /**
     * subcontractor Address
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_SubCntrLocation_ClientInformations")
    protected Address subcontractorAddress;
    /**
     * subcontractorPayRate
     */
    protected BigDecimal subcontractorPayRate;
    /**
     * subcontractorOvertimePayRate
     */
    protected BigDecimal subcontractorOvertimePayRate;
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
    /**
     * 1099 Details
     */
    protected BigDecimal payRate1099;
    protected BigDecimal overTimePayrate1099;
    @Enumerated(EnumType.STRING)
    protected BillingDuration payTimeDuration1099;
    protected String paymentTerms1099;
    /* 
     * comments
     */
    @OneToMany(mappedBy = "clientInformation", cascade = CascadeType.ALL)
    protected List<ClientInfoComment> comments;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_ClientProject_ClientInformations")
    protected Project clientProject;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_VendorRecruiter_ClientInformations")
    protected Contact vendorRecruiter;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_MiddleVendor_ClientInformations")
    protected Vendor middleVendor;

    protected Boolean isCPDFilled;

    protected String timeSheetRequirement;

    protected String vacationDetails;

    protected String specialInvoiceInstructions;

    @Enumerated(EnumType.STRING)
    private ClientInformationStatus status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Practice_ClientInformation")
    @NotNull(message = "{practice.not.empty.msg}")
    private Practice practice;

    @Field
    @NotEmpty(message = "{sector.not.empty.msg}")
    protected String sectorsAndBUs;

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

    public boolean isEndPreviousProject() {
        return endPreviousProject;
    }

    public void setEndPreviousProject(boolean endPreviousProject) {
        this.endPreviousProject = endPreviousProject;
    }

    public Date getPreviousProjectEndDate() {
        return previousProjectEndDate;
    }

    public void setPreviousProjectEndDate(Date previousProjectEndDate) {
        this.previousProjectEndDate = previousProjectEndDate;
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

    public Contact getVendorAPContact() {
        return vendorAPContact;
    }

    public void setVendorAPContact(Contact vendorAPContact) {
        this.vendorAPContact = vendorAPContact;
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
     * @generated
     */
    @XmlTransient
    public List<BillingRate> getBillingRates() {
        if (this.billingRates == null) {
            this.billingRates = new ArrayList<BillingRate>();
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

    public Employee getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Employee recruiter) {
        this.recruiter = recruiter;
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

    public Contact getVendorRecruiter() {
        return vendorRecruiter;
    }

    public void setVendorRecruiter(Contact vendorRecruiter) {
        this.vendorRecruiter = vendorRecruiter;
    }

    public Vendor getMiddleVendor() {
        return middleVendor;
    }

    public void setMiddleVendor(Vendor middleVendor) {
        this.middleVendor = middleVendor;
    }

    public Boolean getIsCPDFilled() {
        return isCPDFilled;
    }

    public void setIsCPDFilled(Boolean isCPDFilled) {
        this.isCPDFilled = isCPDFilled;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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

    @Override
    public String toString() {
        return "ClientInformationDto{" + "consultantJobTitle=" + consultantJobTitle + ", ciPrimary=" + ciPrimary + ", startDate=" + startDate + ", endDate=" + endDate + ", itemNumber=" + itemNumber + ", payRate=" + payRate + ", billingRate=" + billingRate + ", subcontractorinvoiceFrequency=" + subcontractorinvoiceFrequency + '}';
    }

}
