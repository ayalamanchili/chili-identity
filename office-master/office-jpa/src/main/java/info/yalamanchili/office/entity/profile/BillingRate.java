/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author raghu.l
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class BillingRate extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * PayRate
     */
    protected BigDecimal payRate;
    /**
     * BillingRate
     */
    //@NotNull(message = "{billingRate.not.empty.msg}")
    @Digits(integer=10, fraction=2, message = "{billingRate.not.valid.msg}")
    protected BigDecimal billingRate;
    /**
     * OverTime PayRate
     */
    @Digits(integer=10, fraction=2, message = "{overtimePayRate.not.valid.msg}")
    protected BigDecimal overTimePayRate;
    /**
     * over time billing rate
     */
    @Digits(integer=10, fraction=2, message = "{overtimeBillingRate.not.valid.msg}")
    protected BigDecimal overTimeBillingRate;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClinetInfo_BillingRates")
    protected ClientInformation clientInformation;
    
    @org.hibernate.annotations.Index(name = "BillingRate_EffectiveDate_IDX")
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{effectiveDate.not.empty.msg}")
    protected Date effectiveDate;

    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency billingInvoiceFrequency;

    protected BigDecimal subContractorPayRate;

    protected BigDecimal subContractorOverTimePayRate;

    @Enumerated(EnumType.STRING)
    protected InvoiceFrequency subContractorInvoiceFrequency;

    @org.hibernate.annotations.Index(name = "BillingRate_UpdatedTS_IDX")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date updatedTs;

    protected String updatedBy;

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

    public ClientInformation getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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
