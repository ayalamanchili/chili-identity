/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
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
public class BillingRate extends AbstractEntity{
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_ClinetInfo_BillingRate")
    protected ClientInformation clientinfo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{effectiveDate.not.empty.msg}")
    protected Date effectiveDate;
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
    
      public void setClientinfo(ClientInformation clientinfo) {
        this.clientinfo = clientinfo;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public void setBillingRate(BigDecimal billingRate) {
        this.billingRate = billingRate;
    }

    public void setOverTimePayRate(BigDecimal overTimePayRate) {
        this.overTimePayRate = overTimePayRate;
    }

    public void setOverTimeBillingRate(BigDecimal overTimeBillingRate) {
        this.overTimeBillingRate = overTimeBillingRate;
    }

    public ClientInformation getClientinfo() {
        return clientinfo;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public BigDecimal getPayRate() {
        return payRate;
    }

    public BigDecimal getBillingRate() {
        return billingRate;
    }

    public BigDecimal getOverTimePayRate() {
        return overTimePayRate;
    }

    public BigDecimal getOverTimeBillingRate() {
        return overTimeBillingRate;
    }
}
