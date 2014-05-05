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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @NotEmpty(message = "{purpose.not.empty.msg}")
    protected String purpose;
    /**
     *
     */
    @NotNull(message = "{amount.not.empty.msg}")
    protected BigDecimal amount;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{neededBy.not.empty.msg}")
    protected Date neededBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateRequested;
    /**
     *
     */
    protected String payrollFileNumber;
    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL)
    protected List<Transaction> transactions;

    public AdvanceRequisition() {
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

    public String getPayrollFileNumber() {
        return payrollFileNumber;
    }

    public void setPayrollFileNumber(String payrollFileNumber) {
        this.payrollFileNumber = payrollFileNumber;
    }

    @XmlTransient
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "AdvanceRequisition{" + "purpose=" + purpose + ", amount=" + amount + ", neededBy=" + neededBy + ", dateRequested=" + dateRequested + ", payrollFileNumber=" + payrollFileNumber + '}';
    }

}
