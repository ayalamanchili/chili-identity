/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox.types;

import info.yalamanchili.office.entity.client.InvoiceFrequency;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Temporal;

/**
 *
 * @author Madhu.Badiginchala
 */
public class BillingRecord {

    protected Long clientInfoId;
    protected Date effectiveDate;
    protected BigDecimal payRate;
    protected BigDecimal overTimePayrate;
    protected InvoiceFrequency billingInvoiceFrequency;
    protected BigDecimal subContractorPayRate;
    protected BigDecimal subContractorOverTimePayRate;
    protected InvoiceFrequency subContractorInvoiceFrequency;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date updatedTs;

    protected String updatedBy;

    public Long getClientInfoId() {
        return clientInfoId;
    }

    public void setClientInfoId(Long clientInfoId) {
        this.clientInfoId = clientInfoId;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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

    public InvoiceFrequency getBillingInvoiceFrequency() {
        return billingInvoiceFrequency;
    }

    public void setBillingInvoiceFrequency(InvoiceFrequency billingInvoiceFrequency) {
        this.billingInvoiceFrequency = billingInvoiceFrequency;
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

    public InvoiceFrequency getSubContractorInvoiceFrequency() {
        return subContractorInvoiceFrequency;
    }

    public void setSubContractorInvoiceFrequency(InvoiceFrequency subContractorInvoiceFrequency) {
        this.subContractorInvoiceFrequency = subContractorInvoiceFrequency;
    }

    public Date getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Date updatedTs) {
        this.updatedTs = updatedTs;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
