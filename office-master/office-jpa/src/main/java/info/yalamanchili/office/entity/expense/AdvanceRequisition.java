/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense;

import info.chili.jpa.AbstractEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author prasanthi.p
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class AdvanceRequisition extends AbstractEntity {

    @Lob
    protected String purpose;
    @NotNull(message = "{amount.not.empty.msg}")
    protected BigDecimal amount;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{neededBy.not.empty.msg}")
    protected Date neededBy;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{dateRequested.not.empty.msg}")
    protected Date dateRequested;
    @NotEmpty(message = "{payrollFileNumbe.not.empty.msg}")
    protected String payrollFileNumbe;
//    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull(message = "{transaction.not.empty.msg}")
    protected Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getNeededBy() {
        return neededBy;
    }

    public void setNeededBy(Date neededBy) {
        this.neededBy = neededBy;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getPayrollFileNumbe() {
        return payrollFileNumbe;
    }

    public void setPayrollFileNumbe(String payrollFileNumbe) {
        this.payrollFileNumbe = payrollFileNumbe;
    }

    @Override
    public String toString() {
        return "Expense{" + "purpose=" + purpose + ", amount=" + amount + ", neededBy=" + neededBy + ", dateRequested=" + dateRequested + ",transaction=" + transaction + ", payrollFileNumbe=" + payrollFileNumbe + '}';
    }
}
