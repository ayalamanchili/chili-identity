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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
    @NotEmpty (message = "{bankRoutingNumber.not.empty.msg}")
    protected String bankRoutingNumber;
    /**
     *
     */
    @NotEmpty (message = "{bankAccountNumber.not.empty.msg}")
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

}
