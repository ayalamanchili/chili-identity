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
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

/**
 *
 * @author Prasanthi.p
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class ExpenseReport extends AbstractEntity {

    protected static long serialVersionUID = 1L;
    /**
     *
     */
    protected String name;
    /**
     *
     */
    @Lob
    protected String description;
    /**
     *
     */
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    @org.hibernate.annotations.Index(name = "EXP_RPT_STRT_DT")
    protected Date startDate;

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    @org.hibernate.annotations.Index(name = "EXP_RPT_END_DT")
    protected Date endDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date submittedDate;
    /**
     *
     */
    protected String department;
    /**
     *
     */
    protected String approvedBy;
    /**
     *
     */
    protected String approvedDate;
    /**
     *
     */
    protected String paidDate;
    /**
     *
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_Expenses")
    @NotNull(message = "{employee.not.empty.msg}")
    protected Employee employee;
    /**
     *
     */
    @OneToMany(mappedBy = "expenseReport", cascade = CascadeType.ALL)
    protected List<ExpenseItem> expenseItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the submittedDate
     */
    public Date getSubmittedDate() {
        return submittedDate;
    }

    /**
     * @param submittedDate the submittedDate to set
     */
    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the approvedBy
     */
    public String getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param approvedBy the approvedBy to set
     */
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * @return the approvedDate
     */
    public String getApprovedDate() {
        return approvedDate;
    }

    /**
     * @param approvedDate the approvedDate to set
     */
    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    /**
     * @return the paidDate
     */
    public String getPaidDate() {
        return paidDate;
    }

    /**
     * @param paidDate the paidDate to set
     */
    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the expenseItems
     */
    public List<ExpenseItem> getExpenseItems() {
        return expenseItems;
    }

    /**
     * @param expenseItems the expenseItems to set
     */
    public void setExpenseItems(List<ExpenseItem> expenseItems) {
        this.expenseItems = expenseItems;
    }
}
