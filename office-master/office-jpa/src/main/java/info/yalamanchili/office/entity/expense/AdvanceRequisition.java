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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
    @org.hibernate.annotations.Index(name = "ADV_REQ_RQST_DT")
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
    protected String approvedBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date approvedDate;
    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL)
    protected List<Transaction> transactions;
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
    /**
     *
     */
    @Transient
    protected String repaymentMonths;

    /**
     *
     */
    @Transient
    protected String repaymentNotes;

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

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    @XmlTransient
    public List<Transaction> getTransactions() {
        if (this.transactions == null) {
            this.transactions = new ArrayList<Transaction>();
        }
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.getTransactions().add(transaction);
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
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

    public String getRepaymentMonths() {
        return repaymentMonths;
    }

    public void setRepaymentMonths(String repaymentMonths) {
        this.repaymentMonths = repaymentMonths;
    }

    public String getRepaymentNotes() {
        return repaymentNotes;
    }

    public void setRepaymentNotes(String repaymentNotes) {
        this.repaymentNotes = repaymentNotes;
    }
    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("\n");
        description.append("Employee    :").append(this.getEmployee().getFirstName()).append(" ").append(this.getEmployee().getLastName()).append("\n");
        description.append("purpose     :").append(this.getPurpose()).append("\n");
        description.append("Amount      :").append(this.getAmount()).append("\n");
        description.append("Needed By   :").append(this.getNeededBy()).append("\n");
        return description.toString();
    }

    @Override
    public String toString() {
        return "AdvanceRequisition{" + "purpose=" + purpose + ", amount=" + amount + ", neededBy=" + neededBy + ", dateRequested=" + dateRequested + ", payrollFileNumber=" + payrollFileNumber + ", notes=" + notes + ", status=" + status + ", bpmProcessId=" + bpmProcessId + '}';
    }
}
