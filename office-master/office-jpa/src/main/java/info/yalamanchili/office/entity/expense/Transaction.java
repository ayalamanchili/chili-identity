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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author prasanthi.p
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(name = "TransactionRec")
public class Transaction extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     *
     */
    @Lob
    protected String paymentInfo;
    /**
     *
     */
    @NotNull(message = "{amount.not.empty.msg}")
    protected BigDecimal amount;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date postedDate;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{transactionType.not.empty.msg}")
    protected TransactionType transactionType;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected TransactionStatus transactionStatus;
    /**
     *
     */
    @OneToMany(mappedBy = "parentTransaction", cascade = CascadeType.ALL)
    protected List<Transaction> childrenTransactions;
    /**
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_ParentTrans_Transactions")
    protected Transaction parentTransaction;

    /**
     *
     */
    @Transient
    @Valid
    protected Check check;
    /**
     *
     */
    @Transient
    @Valid
    protected BankAccount bankAccount;

    public Transaction() {
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @XmlTransient
    public List<Transaction> getChildrenTransactions() {
        return childrenTransactions;
    }

    public void setChildrenTransactions(List<Transaction> childrenTransactions) {
        this.childrenTransactions = childrenTransactions;
    }

    public Transaction getParentTransaction() {
        return parentTransaction;
    }

    public void setParentTransaction(Transaction parentTransaction) {
        this.parentTransaction = parentTransaction;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "paymentInfo=" + paymentInfo + ", amount=" + amount + ", postedDate=" + postedDate + ", transactionType=" + transactionType + ", transactionStatus=" + transactionStatus + '}';
    }
}
