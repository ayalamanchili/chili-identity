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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author prasanthi.p
 */
public class Transaction extends AbstractEntity {

    @Lob
    protected String paymentInfo;
    @NotNull(message = "{amount.not.empty.msg}")
    protected BigDecimal amount;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{date.not.empty.msg}")
    protected Date date;
    @Enumerated(EnumType.STRING)
    @Field
    protected TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    @Field
    protected TransactionStatus transactionStatus;
    protected Transaction parentTransaction;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Transaction getParentTransaction() {
        return parentTransaction;
    }

    public void setParentTransaction(Transaction parentTransaction) {
        this.parentTransaction = parentTransaction;
    }

    @Override
    public String toString() {
        return "Expense{" + "paymentInfo=" + paymentInfo + ", amount=" + amount + ", date=" + date + ", parentTransaction=" + parentTransaction + ",transactionStatus=" + transactionStatus + ", transactionType=" + transactionType + '}';
    }
}
