/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox.types;

import java.math.BigDecimal;

/**
 *
 * @author ayalamanchili
 */
public class ClientInformationRecord {

    protected String employeeId;
    protected String itemNumber;
    protected String clientName;
    protected String vendorName;
    protected BigDecimal payRate;
    protected String billRateDuration;
    protected String frequency;
    protected String deliveryMethod;
    protected String visaStatus;
    protected String notes;

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

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public String getBillRateDuration() {
        return billRateDuration;
    }

    public void setBillRateDuration(String billRateDuration) {
        this.billRateDuration = billRateDuration;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
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

    @Override
    public String toString() {
        return "ClientInformationRecord{" + "employeeId=" + employeeId + ", itemNumber=" + itemNumber + ", clientName=" + clientName + ", vendorName=" + vendorName + ", payRate=" + payRate + ", billRateDuration=" + billRateDuration + ", frequency=" + frequency + ", deliveryMethod=" + deliveryMethod + ", visaStatus=" + visaStatus + ", notes=" + notes + '}' + "\n";
    }

}
