/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.expenserpt;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
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
//TODO this is invaid but removing this will cause invalid sversionuid issues with bpm process.

    private static long serialVersionUID = 1L;

    @NotEmpty(message = "{expensereport.purpose.not.empty.msg}")
    private String location;

    private String department;

    @NotEmpty(message = "{expensereport.nameOfReport.not.empty.msg}")
    private String nameOfReport;

    @NotEmpty(message = "{expensereport.destination.not.empty.msg}")
    private String destination;

    @NotNull(message = "{expensereport.startDate.not.empty.msg}")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @NotNull(message = "{expenseitem.endDate.not.empty.msg}")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    private String projectName;

    private String projectNumber;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{expensereport.expenseReimbursePaymentMode.not.empty.msg}")
    private ExpenseReimbursePaymentMode expenseReimbursePaymentMode;

    @Temporal(TemporalType.DATE)
    @org.hibernate.annotations.Index(name = "EXP_SUB_DTE")
    private Date submittedDate;

    private String expensesMadeBy;

    private String cardHolderName;

    private Integer payrollFileNumber;

    private String otherDepartment;

    @NotNull(message = "{expensereport.company.not.empty.msg}")
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_EMP_COMPANY_EXP_RPTS")
    private Company company;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Other_Emps_Exp_Rprt")
    protected Employee otherEmployees;

    private String approvedByManager;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedByManagerDate;

    private String approvedByAccountsDept;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedByAccountsDeptDate;

    private String approvedByCEO;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedByCEODate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_EMP_EXP_RPTS")
    private Employee employee;

    @OneToMany(mappedBy = "expenseReport", cascade = CascadeType.ALL)
    @Valid
    protected List<ExpenseItem> expenseItems;

    private String bpmProcessId;

    @Enumerated(EnumType.STRING)
    private ExpenseReportStatus status;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{expensereport.expenseFormPurpose.not.empty.msg}")
    private ExpenseFormType expenseFormType;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{expensereport.departmentType.not.empty.msg}")
    private DepartmentType departmentType;

    private BigDecimal totalExpenses;
    
    private BigDecimal totalPersonalCardExpenses;
    
    private BigDecimal totalCorporateCardExpenses;

    @OneToMany(mappedBy = "expenseReport", cascade = CascadeType.ALL)
    protected Set<ExpenseReceipt> expenseReceipts;

    @Transient
    protected Long approvalManagerId;

    @Transient
    protected String expenseReportNumber;

    public ExpenseReport() {
    }

    /**
     * GETTERS and SETTERS
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ExpenseReport.serialVersionUID = serialVersionUID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNameOfReport() {
        return nameOfReport;
    }

    public void setNameOfReport(String nameOfReport) {
        this.nameOfReport = nameOfReport;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public ExpenseReimbursePaymentMode getExpenseReimbursePaymentMode() {
        return expenseReimbursePaymentMode;
    }

    public void setExpenseReimbursePaymentMode(ExpenseReimbursePaymentMode expenseReimbursePaymentMode) {
        this.expenseReimbursePaymentMode = expenseReimbursePaymentMode;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getExpensesMadeBy() {
        return expensesMadeBy;
    }

    public void setExpensesMadeBy(String expensesMadeBy) {
        this.expensesMadeBy = expensesMadeBy;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Integer getPayrollFileNumber() {
        return payrollFileNumber;
    }

    public void setPayrollFileNumber(Integer payrollFileNumber) {
        this.payrollFileNumber = payrollFileNumber;
    }

    public String getOtherDepartment() {
        return otherDepartment;
    }

    public void setOtherDepartment(String otherDepartment) {
        this.otherDepartment = otherDepartment;
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

    public void setApprovedByCEODate(Date approvedByCEODate) {
        this.approvedByCEODate = approvedByCEODate;
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

    public ExpenseReportStatus getStatus() {
        return status;
    }

    public void setStatus(ExpenseReportStatus status) {
        this.status = status;
    }

    public ExpenseFormType getExpenseFormType() {
        return expenseFormType;
    }

    public void setExpenseFormType(ExpenseFormType expenseFormType) {
        this.expenseFormType = expenseFormType;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
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

    public BigDecimal getTotalPersonalCardExpenses() {
        return totalPersonalCardExpenses;
    }

    public void setTotalPersonalCardExpenses(BigDecimal totalPersonalCardExpenses) {
        this.totalPersonalCardExpenses = totalPersonalCardExpenses;
    }

    public BigDecimal getTotalCorporateCardExpenses() {
        return totalCorporateCardExpenses;
    }

    public void setTotalCorporateCardExpenses(BigDecimal totalCorporateCardExpenses) {
        this.totalCorporateCardExpenses = totalCorporateCardExpenses;
    }
    
    @XmlElement
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @XmlTransient
    public List<ExpenseItem> getExpenseItems() {
        if (this.expenseItems == null) {
            this.expenseItems = new ArrayList();
        }
        return expenseItems;
    }

    public void setExpenseItems(List<ExpenseItem> expenseItems) {
        this.expenseItems = expenseItems;
    }

    @XmlTransient
    public Set<ExpenseReceipt> getExpenseReceipts() {
        if (this.expenseReceipts == null) {
            this.expenseReceipts = new HashSet();
        }
        return expenseReceipts;
    }

    public void setExpenseReceipts(Set<ExpenseReceipt> expenseReceipts) {
        this.expenseReceipts = expenseReceipts;
    }

    public String getExpenseReportNumber() {
        if (getId() != null) {
            return "ERN-" + String.format("%04d", getId());
        } else {
            return null;
        }
    }

    public void setExpenseReportNumber(String expenseReportNumber) {
        this.expenseReportNumber = expenseReportNumber;
    }

    public Employee getOtherEmployees() {
        return otherEmployees;
    }

    public void setOtherEmployees(Employee otherEmployees) {
        this.otherEmployees = otherEmployees;
    }

    @PrePersist
    @PreUpdate
    public void updateTotalAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO.setScale(2);
        for (ExpenseItem item : this.getExpenseItems()) {
            totalAmount = totalAmount.add(item.getAmount());
        }
        this.setTotalExpenses(totalAmount);
    }

    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("\n");
        description.append("Expense Report Number:").append(this.getExpenseReportNumber()).append("\n");
        description.append("Employee:").append(this.getEmployee().getFirstName()).append(" ").append(this.getEmployee().getLastName()).append("\n");
        description.append("Expense Form Type:").append(this.getExpenseFormType()).append("\n");
        description.append("Expense Start Date:").append(this.getStartDate()).append("\n");
        description.append("Expense End date:").append(this.getEndDate()).append("\n");
        return description.toString();
    }

    @Override
    public String toString() {
        return "ExpenseReport{" + "location=" + location + ", department=" + department + ", nameOfReport=" + nameOfReport + ", destination=" + destination + ", startDate=" + startDate + ", endDate=" + endDate + ", projectName=" + projectName + ", projectNumber=" + projectNumber + ", expenseReimbursePaymentMode=" + expenseReimbursePaymentMode + ", submittedDate=" + submittedDate + ", expensesMadeBy=" + expensesMadeBy + ", cardHolderName=" + cardHolderName + ", payrollFileNumber=" + payrollFileNumber + ", otherDepartment=" + otherDepartment + ", approvedByManager=" + approvedByManager + ", approvedByManagerDate=" + approvedByManagerDate + ", approvedByAccountsDept=" + approvedByAccountsDept + ", approvedByAccountsDeptDate=" + approvedByAccountsDeptDate + ", approvedByCEO=" + approvedByCEO + ", approvedByCEODate=" + approvedByCEODate + ", employee=" + employee + ", bpmProcessId=" + bpmProcessId + ", status=" + status + ", expenseFormType=" + expenseFormType + ", departmentType=" + departmentType + ", totalExpenses=" + totalExpenses + ", approvalManagerId=" + approvalManagerId + ", expenseReportNumber=" + expenseReportNumber + '}';
    }
}
