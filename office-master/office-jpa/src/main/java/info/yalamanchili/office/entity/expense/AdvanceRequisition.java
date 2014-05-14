/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
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
    @Lob
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
    @Lob
    protected String notes;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{advancerequisition.status.not.empty.msg}")
    protected AdvanceRequisitionStatus status;
    /**
     * Employee
     */
    @ManyToOne
    @ForeignKey(name = "FK_Emp_AdvanceReqs")
    @NotNull(message = "{advance.requisition.employee.not.empty.msg}")
    protected Employee employee;
    /**
     *
     */
    protected String bpmProcessId;
    /**
     *
     */
    @OneToOne(cascade = CascadeType.ALL)
    protected Transaction transaction;
    /**
     *
     */
    @Transient
    protected Check check;
    /**
     *
     */
    @Transient
    protected BankAccount bankAccount;

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

    public AdvanceRequisitionStatus getStatus() {
        return status;
    }

    public void setStatus(AdvanceRequisitionStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @XmlElement
    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    @XmlElement
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "AdvanceRequisition{" + "purpose=" + purpose + ", amount=" + amount + ", neededBy=" + neededBy + ", dateRequested=" + dateRequested + ", payrollFileNumber=" + payrollFileNumber + ", notes=" + notes + ", status=" + status + ", bpmProcessId=" + bpmProcessId + '}';
    }
}
