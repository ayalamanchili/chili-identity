/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox.types;

import info.yalamanchili.office.entity.client.ClientInfoComment;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.practice.Practice;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CPDRecord {
    protected String consultantJobTitle;
    protected Date startDate;
    protected Date endDate;
    protected boolean endPreviousProject;
    protected Date previousProjectEndDate;
    protected Long clientID;
    protected Long clientContactID;
    protected Long clientLocationID;
    protected Long vendorID;
    protected Long vendorContactID;
    protected Long vendorLocationID;
    protected Long vendorAPContactID;
    protected Long employeeID;
    protected String itemNumber;
    protected BigDecimal payRate;
    protected BigDecimal billingRate;
    protected BigDecimal overTimePayRate;
    protected BigDecimal overTimeBillingRate;
    protected BillingDuration billingDuration;
    protected List<BillingRate> billingRates;
    protected BillingDuration billingRateDuration;
    protected BillingDuration overtimeBillingDuration;
    protected InvoiceFrequency invoiceFrequency;
    protected InvoiceDeliveryMethod invoiceDeliveryMethod;  
    protected Long employeeRecruiterID;
    protected String visaStatus;
    protected String notes;
    protected String terminationNotice;
    protected Long subcontractorID;
    protected Long subcontractorContactID;
    protected Long subcontractorLocationID;
    protected BigDecimal subcontractorpayRate;
    protected BigDecimal subcontractoroverTimePayRate;
    protected InvoiceFrequency subcontractorinvoiceFrequency;
    protected String subcontractorpaymentTerms;
    protected Boolean subcontractorw4Filled;
    protected Boolean subcontractCOI;
    protected BigDecimal payRate1099;
    protected BigDecimal overTimePayrate1099;
    protected BillingDuration payTimeDuration1099;
    protected String paymentTerms1099;
    protected List<ClientInfoComment> comments;
    protected Boolean accountVerificationDocs;
    protected Boolean signedCopyOfWorkOrder;
    protected Boolean i9Filled;
    protected Boolean w4Filled;
    protected String joiningReport;
    protected Boolean logisticsPreparation;
    protected Boolean hrOrientation;
    protected Project clientProject;
    protected Contact vendorRecruiter;
    protected Vendor middleVendor;
    protected Boolean isCPDFilled;
    protected String timeSheetRequirement;
    protected String vendorPaymentTerms;
    protected String specialInvoiceInstructions;
    protected ClientInformationStatus status;
    protected Practice practice;
    protected String sectorsAndBUs;

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

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Long getClientContactID() {
        return clientContactID;
    }

    public void setClientContactID(Long clientContactID) {
        this.clientContactID = clientContactID;
    }

    public Long getClientLocationID() {
        return clientLocationID;
    }

    public void setClientLocationID(Long clientLocationID) {
        this.clientLocationID = clientLocationID;
    }

    public Long getVendorID() {
        return vendorID;
    }

    public void setVendorID(Long vendorID) {
        this.vendorID = vendorID;
    }

    public Long getVendorContactID() {
        return vendorContactID;
    }

    public void setVendorContactID(Long vendorContactID) {
        this.vendorContactID = vendorContactID;
    }

    public Long getVendorLocationID() {
        return vendorLocationID;
    }

    public void setVendorLocationID(Long vendorLocationID) {
        this.vendorLocationID = vendorLocationID;
    }

    public Long getVendorAPContactID() {
        return vendorAPContactID;
    }

    public void setVendorAPContactID(Long vendorAPContactID) {
        this.vendorAPContactID = vendorAPContactID;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
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

    public BillingDuration getBillingDuration() {
        return billingDuration;
    }

    public void setBillingDuration(BillingDuration billingDuration) {
        this.billingDuration = billingDuration;
    }

    public List<BillingRate> getBillingRates() {
        return billingRates;
    }

    public void setBillingRates(List<BillingRate> billingRates) {
        this.billingRates = billingRates;
    }

    public BillingDuration getBillingRateDuration() {
        return billingRateDuration;
    }

    public void setBillingRateDuration(BillingDuration billingRateDuration) {
        this.billingRateDuration = billingRateDuration;
    }

    public BillingDuration getOvertimeBillingDuration() {
        return overtimeBillingDuration;
    }

    public void setOvertimeBillingDuration(BillingDuration overtimeBillingDuration) {
        this.overtimeBillingDuration = overtimeBillingDuration;
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

    public Long getEmployeeRecruiterID() {
        return employeeRecruiterID;
    }

    public void setEmployeeRecruiterID(Long employeeRecruiterID) {
        this.employeeRecruiterID = employeeRecruiterID;
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTerminationNotice() {
        return terminationNotice;
    }

    public void setTerminationNotice(String terminationNotice) {
        this.terminationNotice = terminationNotice;
    }

    public Long getSubcontractorID() {
        return subcontractorID;
    }

    public void setSubcontractorID(Long subcontractorID) {
        this.subcontractorID = subcontractorID;
    }

    public Long getSubcontractorContactID() {
        return subcontractorContactID;
    }

    public void setSubcontractorContactID(Long subcontractorContactID) {
        this.subcontractorContactID = subcontractorContactID;
    }

    public Long getSubcontractorLocationID() {
        return subcontractorLocationID;
    }

    public void setSubcontractorLocationID(Long subcontractorLocationID) {
        this.subcontractorLocationID = subcontractorLocationID;
    }

    public BigDecimal getSubcontractorpayRate() {
        return subcontractorpayRate;
    }

    public void setSubcontractorpayRate(BigDecimal subcontractorpayRate) {
        this.subcontractorpayRate = subcontractorpayRate;
    }

    public BigDecimal getSubcontractoroverTimePayRate() {
        return subcontractoroverTimePayRate;
    }

    public void setSubcontractoroverTimePayRate(BigDecimal subcontractoroverTimePayRate) {
        this.subcontractoroverTimePayRate = subcontractoroverTimePayRate;
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

    public List<ClientInfoComment> getComments() {
        return comments;
    }

    public void setComments(List<ClientInfoComment> comments) {
        this.comments = comments;
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

    public String getJoiningReport() {
        return joiningReport;
    }

    public void setJoiningReport(String joiningReport) {
        this.joiningReport = joiningReport;
    }

    public Boolean getLogisticsPreparation() {
        return logisticsPreparation;
    }

    public void setLogisticsPreparation(Boolean logisticsPreparation) {
        this.logisticsPreparation = logisticsPreparation;
    }

    public Boolean getHrOrientation() {
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

    public String getVendorPaymentTerms() {
        return vendorPaymentTerms;
    }

    public void setVendorPaymentTerms(String vendorPaymentTerms) {
        this.vendorPaymentTerms = vendorPaymentTerms;
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
    
    
    
}
