/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.expenserpt;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Prasanthi.p
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class ExpenseReport extends AbstractEntity {

    private static long serialVersionUID = 1L;
    /**
     *
     */
    @NotEmpty(message = "{expensereport.location.not.empty.msg}")
    private String location;
    /**
     *
     */
    private String department;
    /**
     *
     */
    @NotNull(message = "{expensereport.startDate.not.empty.msg}")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    /**
     *
     */
    @NotNull(message = "{expenseitem.endDate.not.empty.msg}")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    /**
     *
     */
    private String projectName;
    /**
     *
     */
    private String projectNumber;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    private ExpenseReimbursePaymentMode expenseReimbursePaymentMode;
    /**
     *
    */ 
    @Temporal(TemporalType.DATE)
    @org.hibernate.annotations.Index(name = "EXP_SUB_DTE")
    private Date submittedDate;
    /**
     *
     */
    private String approvedByManager;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedByManagerDate;
    /**
     *
     */
    private String approvedByAccountsDept;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedByAccountsDeptDate;
    /**
     *
     */
    private String approvedByCEO;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedByCEODate;
    /**
     *
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_EMP_EXP_RPTS")
    private Employee employee;
    /**
     *
     */
    @OneToMany(mappedBy = "expenseReport", cascade = CascadeType.ALL)
    @Valid
    protected List<ExpenseItem> expenseItems;
    /**
     *
     */
    private String bpmProcessId;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    private ExpenseReportStatus status;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{expensereport.expenseFormPurpose.not.empty.msg}")
    private ExpenseFormType expenseFormType;
    /**
     *
     */

    private BigDecimal totalExpenses;
    /**
     *
     */
    @OneToMany(mappedBy = "expenseReport", cascade = CascadeType.ALL)
    protected List<ExpenseReceipt> expenseReceipts;
    /**
     *
     */
    @Transient
    protected Long approvalManagerId;

    /**
     *
     */
    public ExpenseReport() {
    }

    /**
     * GETTERS and SETTERS
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     *
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     *
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     *
     */
    public String getProjectNumber() {
        return projectNumber;
    }

    /**
     *
     */
    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    /**
     *
     */
    public Date getSubmittedDate() {
        return submittedDate;
    }

    /**
     *
     */
    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    /**
     *
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     *
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<ExpenseItem> getExpenseItems() {
        if (this.expenseItems == null) {
            this.expenseItems = new ArrayList();
        }
        return expenseItems;
    }

    /**
     *
     */
    public void setExpenseItems(List<ExpenseItem> expenseItems) {
        this.expenseItems = expenseItems;
    }

    /**
     *
     */
    public String getBpmProcessId() {
        return bpmProcessId;
    }

    /**
     *
     */
    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    /**
     *
     */
    public ExpenseReportStatus getStatus() {
        return status;
    }

    /**
     *
     */
    public void setStatus(ExpenseReportStatus status) {
        this.status = status;
    }

    public String getApprovedByManager() {
        return approvedByManager;
    }

    public void setApprovedByManager(String approvedByManager) {
        this.approvedByManager = approvedByManager;
    }

    public Date getApprovedByManagerDate() {
        return approvedByManagerDate;
    }

    public void setApprovedByManagerDate(Date approvedByManagerDate) {
        this.approvedByManagerDate = approvedByManagerDate;
    }

    public String getApprovedByAccountsDept() {
        return approvedByAccountsDept;
    }

    public void setApprovedByAccountsDept(String approvedByAccountsDept) {
        this.approvedByAccountsDept = approvedByAccountsDept;
    }

    public Date getApprovedByAccountsDeptDate() {
        return approvedByAccountsDeptDate;
    }

    public void setApprovedByAccountsDeptDate(Date approvedByAccountsDeptDate) {
        this.approvedByAccountsDeptDate = approvedByAccountsDeptDate;
    }

    public String getApprovedByCEO() {
        return approvedByCEO;
    }

    public void setApprovedByCEO(String approvedByCEO) {
        this.approvedByCEO = approvedByCEO;
    }

    public Date getApprovedByCEODate() {
        return approvedByCEODate;
    }

    @XmlTransient
    public List<ExpenseReceipt> getExpenseReceipts() {
        if (this.expenseReceipts == null) {
            this.expenseReceipts = new ArrayList();
        }
        return expenseReceipts;
    }

    public void setExpenseReceipts(List<ExpenseReceipt> expenseReceipts) {
        this.expenseReceipts = expenseReceipts;
    }

    public void setApprovedByCEODate(Date approvedByCEODate) {
        this.approvedByCEODate = approvedByCEODate;
    }

    public ExpenseFormType getExpenseFormType() {
        return expenseFormType;
    }

    public void setExpenseFormType(ExpenseFormType expenseFormType) {
        this.expenseFormType = expenseFormType;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Long getApprovalManagerId() {
        return approvalManagerId;
    }

    public void setApprovalManagerId(Long approvalManagerId) {
        this.approvalManagerId = approvalManagerId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ExpenseReport.serialVersionUID = serialVersionUID;
    }

    public ExpenseReimbursePaymentMode getExpenseReimbursePaymentMode() {
        return expenseReimbursePaymentMode;
    }

    public void setExpenseReimbursePaymentMode(ExpenseReimbursePaymentMode expenseReimbursePaymentMode) {
        this.expenseReimbursePaymentMode = expenseReimbursePaymentMode;
    }

    @Override
    public String toString() {
        return "ExpenseReport{" + "location=" + location + ", department=" + department + ", startDate=" + startDate + ", endDate=" + endDate + ", projectName=" + projectName + ", projectNumber=" + projectNumber + ", expenseReimbursePaymentMode=" + expenseReimbursePaymentMode + ", submittedDate=" + submittedDate + ", approvedByManager=" + approvedByManager + ", approvedByManagerDate=" + approvedByManagerDate + ", approvedByAccountsDept=" + approvedByAccountsDept + ", approvedByAccountsDeptDate=" + approvedByAccountsDeptDate + ", approvedByCEO=" + approvedByCEO + ", approvedByCEODate=" + approvedByCEODate + ", employee=" + employee + ", expenseItems=" + expenseItems + ", bpmProcessId=" + bpmProcessId + ", status=" + status + ", expenseFormType=" + expenseFormType + ", totalExpenses=" + totalExpenses + ", expenseReceipts=" + expenseReceipts + ", approvalManager=" + approvalManagerId + '}';
    }
    

}
