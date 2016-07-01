/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.InvoiceStatus;
import info.yalamanchili.office.entity.client.TimeSheetStatus;
import info.yalamanchili.office.entity.profile.ClientInformation;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement
@XmlType
class InvoiceUpdateDto implements Serializable {

    @NotNull(message = "{invoiceNumber.not.empty.msg}")
    protected String invoiceNumber;

    @NotNull(message = "{startDate.not.empty.msg}")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date startDate;

    @NotNull(message = "{endDate.not.empty.msg}")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date endDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date invoiceDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date invoiceSentDate;

    protected BigDecimal billingRate;

    protected BigDecimal overTimeBillingRate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClinetInfo_Invoice")
    protected ClientInformation clientInformation;

    @NotEmpty(message = "{itemNumber.not.empty.msg}")
    protected String itemNumber;

    @NotNull(message = "{invoiceFrequency.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency invoiceFrequency;

    @NotNull(message = "{hours.not.empty.msg}")
    protected BigDecimal hours;

    @Lob
    protected String notes;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{invoice.status.not.empty.msg}")
    protected InvoiceStatus invoiceStatus;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{timeSheetStatus.not.empty.msg}")
    protected TimeSheetStatus timeSheetStatus;
    /**
     *
     */
    @Transient
    protected String employee;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceSentDate() {
        return invoiceSentDate;
    }

    public void setInvoiceSentDate(Date invoiceSentDate) {
        this.invoiceSentDate = invoiceSentDate;
    }

    public BigDecimal getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(BigDecimal billingRate) {
        this.billingRate = billingRate;
    }

    public BigDecimal getOverTimeBillingRate() {
        return overTimeBillingRate;
    }

    public void setOverTimeBillingRate(BigDecimal overTimeBillingRate) {
        this.overTimeBillingRate = overTimeBillingRate;
    }

    public ClientInformation getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public InvoiceFrequency getInvoiceFrequency() {
        return invoiceFrequency;
    }

    public void setInvoiceFrequency(InvoiceFrequency invoiceFrequency) {
        this.invoiceFrequency = invoiceFrequency;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public TimeSheetStatus getTimeSheetStatus() {
        return timeSheetStatus;
    }

    public void setTimeSheetStatus(TimeSheetStatus timeSheetStatus) {
        this.timeSheetStatus = timeSheetStatus;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

}
