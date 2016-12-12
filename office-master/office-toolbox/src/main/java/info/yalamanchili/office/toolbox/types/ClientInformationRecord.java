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
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ayalamanchili
 */
public class ClientInformationRecord {

    protected String employeeId;
    protected String itemNumber;
    protected String clientName;
    protected String vendorName;
    protected Date startDate;
    protected Date endDate;
    protected BigDecimal billingRate;
    protected BillingDuration billingDuration;
    protected BigDecimal overtimePayRate;
    protected BillingDuration overtimeBillingDuration;
    protected InvoiceFrequency invoiceFrequency;
    protected InvoiceDeliveryMethod invoiceDeliveryMethod;
    protected String visaStatus;
    protected String vendorPaymentTerm;
    protected String notes;
    protected boolean signedCopyOfWO;
    protected boolean hrOrientation;
    protected boolean logisticsPreparation;
    protected boolean i9Filled;
    protected boolean w4Filled;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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

    public BigDecimal getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(BigDecimal billingRate) {
        this.billingRate = billingRate;
    }

    public BillingDuration getBillingDuration() {
        return billingDuration;
    }

    public void setBillingDuration(BillingDuration billingDuration) {
        this.billingDuration = billingDuration;
    }

    public BigDecimal getOvertimePayRate() {
        return overtimePayRate;
    }

    public void setOvertimePayRate(BigDecimal overtimePayRate) {
        this.overtimePayRate = overtimePayRate;
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

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public String getVendorPaymentTerm() {
        return vendorPaymentTerm;
    }

    public void setVendorPaymentTerm(String vendorPaymentTerm) {
        this.vendorPaymentTerm = vendorPaymentTerm;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isSignedCopyOfWO() {
        return signedCopyOfWO;
    }

    public void setSignedCopyOfWO(boolean signedCopyOfWO) {
        this.signedCopyOfWO = signedCopyOfWO;
    }

    public boolean isHrOrientation() {
        return hrOrientation;
    }

    public void setHrOrientation(boolean hrOrientation) {
        this.hrOrientation = hrOrientation;
    }

    public boolean isLogisticsPreparation() {
        return logisticsPreparation;
    }

    public void setLogisticsPreparation(boolean logisticsPreparation) {
        this.logisticsPreparation = logisticsPreparation;
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

    @Override
    public String toString() {
        return "ClientInformationRecord{" + "employeeId=" + employeeId + ", itemNumber=" + itemNumber + ", clientName=" + clientName + ", vendorName=" + vendorName + ", startDate=" + startDate + ", endDate=" + endDate + ", billingRate=" + billingRate + ", billingDuration=" + billingDuration + ", overtimePayRate=" + overtimePayRate + ", overtimeBillingDuration=" + overtimeBillingDuration + ", invoiceFrequency=" + invoiceFrequency + ", invoiceDeliveryMethod=" + invoiceDeliveryMethod + ", visaStatus=" + visaStatus + ", vendorPaymentTerm=" + vendorPaymentTerm + ", notes=" + notes + ", signedCopyOfWO=" + signedCopyOfWO + ", hrOrientation=" + hrOrientation + ", logisticsPreparation=" + logisticsPreparation + ", i9Filled=" + i9Filled + ", w4Filled=" + w4Filled + '}';
    }
    

}
