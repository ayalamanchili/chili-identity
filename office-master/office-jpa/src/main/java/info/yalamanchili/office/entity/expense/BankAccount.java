/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense;

import info.chili.jpa.AbstractHandleEntity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class BankAccount extends AbstractHandleEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    protected String accountFirstName;
    /**
     *
     */
    protected String accountLastName;
    /**
     *
     */
    protected String bankName;
    /**
     *
     */
    protected String bankAddress1;
    /**
     *
     */
    protected String bankAddress2;
    /**
     *
     */
    protected Boolean achBlocked;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    protected AccountType accountType;

    /**
     *
     */
    @NotEmpty(message = "{bankRoutingNumber.not.empty.msg}")
    protected String bankRoutingNumber;
    /**
     *
     */
    @NotEmpty(message = "{bankAccountNumber.not.empty.msg}")
    @Type(type = "encryptedString")
    protected String bankAccountNumber;

    public BankAccount() {
    }

    public String getAccountFirstName() {
        return accountFirstName;
    }

    public void setAccountFirstName(String accountFirstName) {
        this.accountFirstName = accountFirstName;
    }

    public String getAccountLastName() {
        return accountLastName;
    }

    public void setAccountLastName(String accountLastName) {
        this.accountLastName = accountLastName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress1() {
        return bankAddress1;
    }

    public String getBankAddress2() {
        return bankAddress2;
    }

    public void setBankAddress1(String bankAddress1) {
        this.bankAddress1 = bankAddress1;
    }

    public void setBankAddress2(String bankAddress2) {
        this.bankAddress2 = bankAddress2;
    }

    public String getBankRoutingNumber() {
        return bankRoutingNumber;
    }

    public void setBankRoutingNumber(String bankRoutingNumber) {
        this.bankRoutingNumber = bankRoutingNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Boolean getAchBlocked() {
        return achBlocked;
    }

    public void setAchBlocked(Boolean achBlocked) {
        this.achBlocked = achBlocked;
    }

}
