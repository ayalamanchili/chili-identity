/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Madhu.Badiginchala
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class ImmigrationCheckRequisition extends AbstractEntity {

    private static long serialVersionUID = 1L;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @org.hibernate.annotations.Index(name = "IMG_CHK_REQ_RQST_DT")
    private Date requestedDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{neededBy.not.empty.msg}")
    private Date neededByDate;
    /**
     *
     */
    @NotNull(message = "{amount.not.empty.msg}")
    private BigDecimal amount;
    /**
     *
     */
    @NotNull(message = "{mailingAddress.not.empty.msg}")
    private String mailingAddress;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{ImmigrationCaseType.not.empty.msg}")
    private ImmigrationCaseType caseType;
    /**
     *
     */
    @Lob
    private String purpose;
    /**
     *
     */
    @NotEmpty
    private String attorneyName;

    /**
     *
     */
    private String submittedBy;
    /**
     *
     */
    private String approvedBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedDate;
    /**
     *
     */
    private String accountedBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkIssuedDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date accountDeptReceivedDate;
    /**
     *
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Emp_ImgCheckReqs")
    private Employee employee;
    /**
     *
     */
    protected String employeeName;
    /**
     *
     */
    @OneToMany(mappedBy = "immigrationCheckRequisition", cascade = CascadeType.ALL)
    protected List<CheckRequisitionItem> items;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    private ImmigrationCheckRequisitionStatus status;
    /**
     *
     */
    private String bpmProcessId;

    private String companyName;

    /**
     * GETTERS and SETTERS
     */
    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getNeededByDate() {
        return neededByDate;
    }

    public void setNeededByDate(Date neededByDate) {
        this.neededByDate = neededByDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public ImmigrationCaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(ImmigrationCaseType caseType) {
        this.caseType = caseType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAttorneyName() {
        return attorneyName;
    }

    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
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

    public String getAccountedBy() {
        return accountedBy;
    }

    public void setAccountedBy(String accountedBy) {
        this.accountedBy = accountedBy;
    }

    public Date getCheckIssuedDate() {
        return checkIssuedDate;
    }

    public void setCheckIssuedDate(Date checkIssuedDate) {
        this.checkIssuedDate = checkIssuedDate;
    }

    public Date getAccountDeptReceivedDate() {
        return accountDeptReceivedDate;
    }

    public void setAccountDeptReceivedDate(Date accountDeptReceivedDate) {
        this.accountDeptReceivedDate = accountDeptReceivedDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @XmlTransient
    public List<CheckRequisitionItem> getItems() {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        return items;
    }

    public void setItems(List<CheckRequisitionItem> items) {
        this.items = items;
    }

    public ImmigrationCheckRequisitionStatus getStatus() {
        return status;
    }

    public void setStatus(ImmigrationCheckRequisitionStatus status) {
        this.status = status;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @PrePersist
    @PreUpdate
    public void updateTotalAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO.setScale(2);
        for (CheckRequisitionItem item : this.getItems()) {
            totalAmount = totalAmount.add(item.getAmount());
        }
        this.setAmount(totalAmount);
    }

    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("\n");
        description.append("Employee         :").append(this.getEmployeeName()).append("\n");
        description.append("Case Type        :").append(this.getCaseType()).append("\n");
        description.append("Attorney Name    :").append(this.getAttorneyName()).append("\n");
        description.append("Amount           :").append(this.getAmount()).append("\n");
        description.append("Requested Date   :").append(this.getRequestedDate()).append("\n");
        return description.toString();
    }

    @Override
    public String toString() {
        return "ImmigrationCheckRequisition{" + "requestedDate=" + requestedDate + ", neededByDate=" + neededByDate + ", amount=" + amount + ", mailingAddress=" + mailingAddress + ", caseType=" + caseType + ", purpose=" + purpose + ", attorneyName=" + attorneyName + ", submittedBy=" + submittedBy + ", approvedBy=" + approvedBy + ", approvedDate=" + approvedDate + ", accountedBy=" + accountedBy + ", checkIssuedDate=" + checkIssuedDate + ", accountDeptReceivedDate=" + accountDeptReceivedDate + ", status=" + status + ", bpmProcessId=" + bpmProcessId + '}';
    }

}
