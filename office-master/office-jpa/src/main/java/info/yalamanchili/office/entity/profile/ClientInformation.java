/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.ClientInfoComment;
import info.yalamanchili.office.entity.client.Invoice;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.practice.Practice;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

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
@Entity
@Audited
public class ClientInformation extends AbstractEntity {

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
    @org.hibernate.annotations.Index(name = "CI_START_DATE_IDX")
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    /**
     * endDate
     */
    @org.hibernate.annotations.Index(name = "CI_END_DATE_IDX")
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(groups = SubmitChecks.class)
    protected Date endDate;
    
    protected String gapPeriod;

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
    /**
     * a cpd can have a different company than that payroll company
     */
    @org.hibernate.annotations.Index(name = "CI_CMPNY_IDX")
    @NotNull
    @Enumerated(EnumType.STRING)
    protected ClientInformationCompany company;
    /**
     * Client
     */

    @ManyToOne
    @ForeignKey(name = "FK_Client_ClientInformations")
    @NotNull(message = "{client.not.empty.msg}")
    protected Client client;
    /**
     * Client Contact
     */
    @ManyToOne
    @ForeignKey(name = "FK_ClientContact_ClientInformations")
    @NotNull(groups = VendorChecks.class)
    protected Contact clientContact;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clientinformation_client_apcontacts")
    @ForeignKey(name = "FK_ClientAPContacts_ClientInformations")
    @Size(min = 1 ,groups = VendorChecks.class, message = "may not be null")
    protected Set<Contact> clientAPContacts;
    /**
     * Client Location
     */
    @ManyToOne
    @ForeignKey(name = "FK_ClientLocation_ClientInformations")
    @NotNull(groups = SubmitChecks.class)
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
     * Vendor
     */
    @ManyToOne
    @ForeignKey(name = "FK_Vendor_ClientInformations")
    @NotNull(groups = SubmitChecks.class, message = "cannot be null")
    protected Vendor vendor;
    /**
     * Vendor Contact
     */
    @ManyToOne
    @ForeignKey(name = "FK_VendorContact_ClientInformations")
    protected Contact vendorContact;

    /**
     * Vendor AP Contact
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clientinformation_vendor_apcontacts")
    @ForeignKey(name = "FK_VendorAPContacts_ClientInformations")
    @NotNull(groups = SubmitChecks.class)
    protected Set<Contact> vendorAPContacts;
    /**
     * Vendor Location
     */
    @ManyToOne
    @ForeignKey(name = "FK_VendorLocation_ClientInformations")
    @NotNull(groups = SubmitChecks.class)
    protected Address vendorLocation;
    /**
     * Employee
     */
    @ManyToOne
    @ForeignKey(name = "FK_Employee_ClientInformations")
    protected Employee employee;
    /**
     * Item Number (quick books generated number
     */
    @org.hibernate.annotations.Index(name = "CI_ITEM_IDX")
    protected String itemNumber;
    /**
     * PayRate
     */
    protected BigDecimal payRate;
    
    protected Float payRatePercentage;
    /**
     * BillingRate
     */
    @NotNull(groups = SubmitChecks.class)
    protected BigDecimal billingRate;
    /**
     * OverTime PayRate
     */
    protected BigDecimal overTimePayRate;
    
    protected Float overTimePayRatePercentage;
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
    @NotNull(groups = SubmitChecks.class)
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
    @ManyToMany(fetch = FetchType.EAGER)
    @ForeignKey(name = "FK_Recruiters_ClientInformations")
    protected Set<Employee> recruiters;
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
    @ManyToOne
    @ForeignKey(name = "FK_SubCntr_ClientInformations")
    @NotNull(groups = SubcontractorChecks.class, message = "{subcontractor.not.empty.msg}")
    protected Subcontractor subcontractor;
    /**
     * subcontractorContact;
     */
    @ManyToOne
    @ForeignKey(name = "FK_SubCntrContact_ClientInformations")
    @NotNull(groups = SubcontractorChecks.class, message = "{subcontractorContact.not.empty.msg}")
    protected Contact subcontractorContact;
    /**
     * subcontractor Address
     */
    @ManyToOne
    @ForeignKey(name = "FK_SubCntrLocation_ClientInformations")
    protected Address subcontractorAddress;
    /**
     * subcontractorPayRate
     */
    protected BigDecimal subcontractorPayRate;
    /**
     * subcontractorOvertimePayRate
     */
    @NotNull(groups = SubcontractorChecks.class, message = "{subcontractorOvertimePayRate.not.empty.msg}")
    protected BigDecimal subcontractorOvertimePayRate;
    /**
     * subcontractor Invoice Frequency
     */
    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.Index(name = "CI_INVC_FQ")
    @NotNull(groups = SubcontractorChecks.class, message = "{subcontractorinvoiceFrequency.not.empty.msg}")
    protected InvoiceFrequency subcontractorinvoiceFrequency;
    /**
     * subcontractor PaymentTerms
     */
    @NotNull(groups = SubcontractorChecks.class, message = "{subcontractorpaymentTerms.not.empty.msg}")
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
    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency invoiceFrequency1099;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clientinformation_vendor_recruiters")
    @ForeignKey(name = "FK_VendorRecruiters_ClientInformations")
    @NotNull(groups = SubmitChecks.class)
    protected Set<Contact> vendorRecruiters;

    @ManyToOne
    @ForeignKey(name = "FK_MiddleVendor_ClientInformations")
    protected Vendor middleVendor;

    protected String timeSheetRequirement;

    @NotNull(groups = SubmitChecks.class)
    protected String vendorPaymentTerms;

    @NotNull(groups = VendorChecks.class)
    protected String clientPaymentTerms;

    protected String specialInvoiceInstructions;

    @Enumerated(EnumType.STRING)
    private ClientInformationStatus status;

    @ManyToOne
    @ForeignKey(name = "FK_Practice_ClientInformation")
    @NotNull(message = "{practice.not.empty.msg}")
    private Practice practice;

    @Field
    @NotEmpty(message = "{sectorsAndBUs.not.empty.msg}")
    protected String sectorsAndBUs;

    protected Boolean isEndDateConfirmed;
    /**
     *
     */
    protected String bpmProcessId;

    @OneToMany(mappedBy = "clientInformation", fetch = FetchType.EAGER)
    protected List<Invoice> invoice;
    
    protected Boolean active;

    public Boolean isIsEndDateConfirmed() {
        return isEndDateConfirmed;
    }

    public void setIsEndDateConfirmed(Boolean isEndDateConfirmed) {
        this.isEndDateConfirmed = isEndDateConfirmed;
    }

    public ClientInformation() {
        super();
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
       
    public String getGapPeriod() {
        return gapPeriod;
    }

    public void setGapPeriod(String gapPeriod) {
        this.gapPeriod = gapPeriod;
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

    public ClientInformationCompany getCompany() {
        return company;
    }

    public void setCompany(ClientInformationCompany company) {
        this.company = company;
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
        entity.setClientInformation(this);
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

    public Set<Employee> getRecruiters() {
        if (this.recruiters == null) {
            this.recruiters = new HashSet();
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
        if (this.vendorAPContacts == null) {
            this.vendorAPContacts = new HashSet();
        }
        return vendorAPContacts;
    }

    public void setVendorAPContacts(Set<Contact> vendorAPContacts) {
        this.vendorAPContacts = vendorAPContacts;
    }

    public Set<Contact> getVendorRecruiters() {
        if (this.vendorRecruiters == null) {
            this.vendorRecruiters = new HashSet();
        }
        return vendorRecruiters;
    }

    public void setVendorRecruiters(Set<Contact> vendorRecruiters) {
        this.vendorRecruiters = vendorRecruiters;
    }

    public Set<Contact> getClientAPContacts() {
        if (this.clientAPContacts == null) {
            this.clientAPContacts = new HashSet();
        }
        return clientAPContacts;
    }

    public void setClientAPContacts(Set<Contact> clientAPContacts) {
        this.clientAPContacts = clientAPContacts;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    public InvoiceFrequency getInvoiceFrequency1099() {
        return invoiceFrequency1099;
    }

    public void setInvoiceFrequency1099(InvoiceFrequency invoiceFrequency1099) {
        this.invoiceFrequency1099 = invoiceFrequency1099;
    }

    @OneToMany(mappedBy = "clientInformation", cascade = CascadeType.ALL)
    protected Set<CIDocument> cidocument;

    @XmlTransient
    public Set<CIDocument> getCidocument() {
        if (this.cidocument == null) {
            this.cidocument = new HashSet();
        }
        return cidocument;
    }

    public void setCidocument(Set<CIDocument> cidocument) {
        this.cidocument = cidocument;
    }

    public void addCidocument(CIDocument entity) {
        if (entity == null) {
            return;
        }
        getCidocument().add(entity);
        entity.setClientInformation(this);
    }

    @XmlTransient
    public List<Invoice> getInvoice() {
        if (this.invoice == null) {
            this.invoice = new ArrayList();
        }
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    public void addInvoice(Invoice entity) {
        if (entity == null) {
            return;
        }
        getInvoice().add(entity);
        entity.setClientInformation(this);
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("\n");
        description.append("Employee    : ").append(this.getEmployee().getFirstName()).append(" ").append(this.getEmployee().getLastName()).append("\n");
        description.append("Client      : ").append(this.getClient().getName()).append("\n");
        if (this.getVendor() != null) {
            description.append("Vendor      : ").append(this.getVendor().getName()).append("\n");
        }
        description.append("Item Number : ").append(this.getItemNumber()).append("\n");
        return description.toString();
    }

    @Override
    public String toString() {
        return "ClientInformation{" + "consultantJobTitle=" + consultantJobTitle + ", ciPrimary=" + ciPrimary + ", startDate=" + startDate + ", endDate=" + endDate + ", itemNumber=" + itemNumber + ", payRate=" + payRate + ", billingRate=" + billingRate + ", subcontractorinvoiceFrequency=" + subcontractorinvoiceFrequency + '}';
    }

    public interface SubmitChecks {

    }
    
    public interface SubcontractorChecks {
        
    }
    
    public interface VendorChecks {
        
    }
}
