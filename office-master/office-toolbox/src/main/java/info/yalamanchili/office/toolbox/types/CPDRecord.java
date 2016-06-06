/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox.types;

import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CPDRecord {
    
    protected Long employeeId;
    protected Date startDate;
    protected Date endDate;
    protected String itemNum;
    protected String consultantType;
    protected BigDecimal payRate;
    protected BigDecimal overTimePayrate;
    protected BillingDuration billingDuration;
    protected BillingDuration OverTimeDuration;
    protected String jobTitle;
    protected InvoiceFrequency invoiceFrequency;
    protected InvoiceDeliveryMethod invoiceDeliveryMethod;
    protected Long recID1;
    protected Long recID2;
    protected Long recID3;
    protected Long recID4;
    protected Long subContractorID;
    protected Long subContractorContactID;
    protected BigDecimal subContractorPayRate;
    protected BigDecimal subContractorOverTimePayRate;
    protected InvoiceFrequency subcontractorinvoiceFrequency;
    protected Long venAPID1;
    protected Long venAPID2;
    protected Long venAPID3;
    protected String vacationDetails;
    protected ClientInformationCompany company;
    protected String timeSheetRequirement;
    protected String specialInvoiceInstructions;
    protected String projectEndingForSure;
    protected String visaStatus;
    protected String terminationNotic;
    protected Long venRECID1;
    protected Long venRECID2;
    protected String subContractorComments;
    protected String signedCopyOfWorkOrder;
    protected String subcontractCOI;
    protected String subcontractorW9Form;
    protected String subContractorPaymentTerms;
    protected String vendorPaymentTerms;
    protected String accountingComments;
    protected String hrOrientation;
    protected String logisticPreparation;
    protected String i9Filled;
    protected String w4Filled;
    protected String joiningReport;
    protected String hrComments;
    protected String contractComments;
    protected Long practiceID;
    protected String sectorsAndBUs;
    protected String projectName;
    protected String purchaseOrderNo;
    protected String subContractorWorkOrderNo;
    protected Long vendorID;
    protected Long clientID;
    protected Long middleVendorID;
    protected Long clientLocationID;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    public String getTerminationNotic() {
        return terminationNotic;
    }

    public void setTerminationNotic(String terminationNotic) {
        this.terminationNotic = terminationNotic;
    }



    public BillingDuration getBillingDuration() {
        return billingDuration;
    }

    public void setBillingDuration(BillingDuration billingDuration) {
        this.billingDuration = billingDuration;
    }

    public BillingDuration getOverTimeDuration() {
        return OverTimeDuration;
    }

    public void setOverTimeDuration(BillingDuration OverTimeDuration) {
        this.OverTimeDuration = OverTimeDuration;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public Long getRecID1() {
        return recID1;
    }

    public void setRecID1(Long recID1) {
        this.recID1 = recID1;
    }

    public Long getRecID2() {
        return recID2;
    }

    public void setRecID2(Long recID2) {
        this.recID2 = recID2;
    }

    public Long getRecID3() {
        return recID3;
    }

    public void setRecID3(Long recID3) {
        this.recID3 = recID3;
    }

    public Long getRecID4() {
        return recID4;
    }

    public void setRecID4(Long recID4) {
        this.recID4 = recID4;
    }

    public Long getSubContractorID() {
        return subContractorID;
    }

    public void setSubContractorID(Long subContractorID) {
        this.subContractorID = subContractorID;
    }

    public Long getSubContractorContactID() {
        return subContractorContactID;
    }

    public void setSubContractorContactID(Long subContractorContactID) {
        this.subContractorContactID = subContractorContactID;
    }

    public InvoiceFrequency getSubcontractorinvoiceFrequency() {
        return subcontractorinvoiceFrequency;
    }

    public void setSubcontractorinvoiceFrequency(InvoiceFrequency subcontractorinvoiceFrequency) {
        this.subcontractorinvoiceFrequency = subcontractorinvoiceFrequency;
    }

    public Long getVenAPID1() {
        return venAPID1;
    }

    public void setVenAPID1(Long venAPID1) {
        this.venAPID1 = venAPID1;
    }

    public Long getVenAPID2() {
        return venAPID2;
    }

    public void setVenAPID2(Long venAPID2) {
        this.venAPID2 = venAPID2;
    }

    public Long getVenAPID3() {
        return venAPID3;
    }

    public void setVenAPID3(Long venAPID3) {
        this.venAPID3 = venAPID3;
    }

    public String getVacationDetails() {
        return vacationDetails;
    }

    public void setVacationDetails(String vacationDetails) {
        this.vacationDetails = vacationDetails;
    }

    public ClientInformationCompany getCompany() {
        return company;
    }

    public void setCompany(ClientInformationCompany company) {
        this.company = company;
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

    public String getProjectEndingForSure() {
        return projectEndingForSure;
    }

    public void setProjectEndingForSure(String projectEndingForSure) {
        this.projectEndingForSure = projectEndingForSure;
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }


    public Long getVenRECID1() {
        return venRECID1;
    }

    public void setVenRECID1(Long venRECID1) {
        this.venRECID1 = venRECID1;
    }

    public Long getVenRECID2() {
        return venRECID2;
    }

    public void setVenRECID2(Long venRECID2) {
        this.venRECID2 = venRECID2;
    }

    public String getSubContractorComments() {
        return subContractorComments;
    }

    public void setSubContractorComments(String subContractorComments) {
        this.subContractorComments = subContractorComments;
    }

    public String getSubContractorPaymentTerms() {
        return subContractorPaymentTerms;
    }

    public void setSubContractorPaymentTerms(String subContractorPaymentTerms) {
        this.subContractorPaymentTerms = subContractorPaymentTerms;
    }

    public String getVendorPaymentTerms() {
        return vendorPaymentTerms;
    }

    public void setVendorPaymentTerms(String vendorPaymentTerms) {
        this.vendorPaymentTerms = vendorPaymentTerms;
    }

    public String getAccountingComments() {
        return accountingComments;
    }

    public void setAccountingComments(String accountingComments) {
        this.accountingComments = accountingComments;
    }

    public String getHrOrientation() {
        return hrOrientation;
    }

    public void setHrOrientation(String hrOrientation) {
        this.hrOrientation = hrOrientation;
    }

    public String getLogisticPreparation() {
        return logisticPreparation;
    }

    public void setLogisticPreparation(String logisticPreparation) {
        this.logisticPreparation = logisticPreparation;
    }

    public String getI9Filled() {
        return i9Filled;
    }

    public void setI9Filled(String i9Filled) {
        this.i9Filled = i9Filled;
    }

    public String getW4Filled() {
        return w4Filled;
    }

    public void setW4Filled(String w4Filled) {
        this.w4Filled = w4Filled;
    }

    public String getJoiningReport() {
        return joiningReport;
    }

    public void setJoiningReport(String joiningReport) {
        this.joiningReport = joiningReport;
    }

    public String getHrComments() {
        return hrComments;
    }

    public void setHrComments(String hrComments) {
        this.hrComments = hrComments;
    }

    public String getContractComments() {
        return contractComments;
    }

    public void setContractComments(String contractComments) {
        this.contractComments = contractComments;
    }

    public Long getPracticeID() {
        return practiceID;
    }

    public void setPracticeID(Long practiceID) {
        this.practiceID = practiceID;
    }

    public String getSectorsAndBUs() {
        return sectorsAndBUs;
    }

    public void setSectorsAndBUs(String sectorsAndBUs) {
        this.sectorsAndBUs = sectorsAndBUs;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getSubContractorWorkOrderNo() {
        return subContractorWorkOrderNo;
    }

    public void setSubContractorWorkOrderNo(String subContractorWorkOrderNo) {
        this.subContractorWorkOrderNo = subContractorWorkOrderNo;
    }

    public Long getVendorID() {
        return vendorID;
    }

    public void setVendorID(Long vendorID) {
        this.vendorID = vendorID;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Long getMiddleVendorID() {
        return middleVendorID;
    }

    public void setMiddleVendorID(Long middleVendorID) {
        this.middleVendorID = middleVendorID;
    }

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public BigDecimal getOverTimePayrate() {
        return overTimePayrate;
    }

    public void setOverTimePayrate(BigDecimal overTimePayrate) {
        this.overTimePayrate = overTimePayrate;
    }

    public BigDecimal getSubContractorPayRate() {
        return subContractorPayRate;
    }

    public void setSubContractorPayRate(BigDecimal subContractorPayRate) {
        this.subContractorPayRate = subContractorPayRate;
    }

    public BigDecimal getSubContractorOverTimePayRate() {
        return subContractorOverTimePayRate;
    }

    public void setSubContractorOverTimePayRate(BigDecimal subContractorOverTimePayRate) {
        this.subContractorOverTimePayRate = subContractorOverTimePayRate;
    }

    public String getSignedCopyOfWorkOrder() {
        return signedCopyOfWorkOrder;
    }

    public void setSignedCopyOfWorkOrder(String signedCopyOfWorkOrder) {
        this.signedCopyOfWorkOrder = signedCopyOfWorkOrder;
    }

    public String getSubcontractCOI() {
        return subcontractCOI;
    }

    public void setSubcontractCOI(String subcontractCOI) {
        this.subcontractCOI = subcontractCOI;
    }

    public String getSubcontractorW9Form() {
        return subcontractorW9Form;
    }

    public void setSubcontractorW9Form(String subcontractorW9Form) {
        this.subcontractorW9Form = subcontractorW9Form;
    }

    public String getConsultantType() {
        return consultantType;
    }

    public void setConsultantType(String consultantType) {
        this.consultantType = consultantType;
    }

    public Long getClientLocationID() {
        return clientLocationID;
    }

    public void setClientLocationID(Long clientLocationID) {
        this.clientLocationID = clientLocationID;
    }

    
}
