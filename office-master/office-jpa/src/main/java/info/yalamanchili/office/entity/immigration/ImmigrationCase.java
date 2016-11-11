/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.ImmigrationCaseType;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Bhavana.Atluri
 */
@Entity
@Audited
@XmlRootElement
@Indexed
public class ImmigrationCase extends AbstractEntity {

    private static final long serialVersionUID = 9993L;

    /**
     * Immigration Case Type
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{immigrationcase.type.not.empty.msg}")
    protected ImmigrationCaseType immigrationCaseType;

    /**
     * employee
     */
    @ManyToOne
    @ForeignKey(name = "FK_Employee_IMM_CASE")
    protected Employee employee;

    /**
     * employeeName
     */
    protected String employeeName;

    protected String email;
    
    @ManyToOne
    @ForeignKey(name = "FK_CMPNY_IMM_CASE")
    protected Company company;

    /**
     * Sponsor type
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{immigrationcase.sponsertype.not.empty.msg}")
    protected SponsorType sponsorType;

    /**
     * The Date the Immigration case is created on
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @org.hibernate.annotations.Index(name = "IMM_CASE_CRT_DATE")
    protected Date createdDate;

    /**
     * The employee who created the immigration case
     */
    protected String createdBy;

    /**
     * Immigration Case status
     */
    @Enumerated(EnumType.STRING)
    protected ImmigrationCaseStatus immigrationCaseStatus;

    public ImmigrationCaseType getImmigrationCaseType() {
        return immigrationCaseType;
    }

    public void setImmigrationCaseType(ImmigrationCaseType immigrationCaseType) {
        this.immigrationCaseType = immigrationCaseType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SponsorType getSponsorType() {
        return sponsorType;
    }

    public void setSponsorType(SponsorType sponsorType) {
        this.sponsorType = sponsorType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ImmigrationCaseStatus getImmigrationCaseStatus() {
        return immigrationCaseStatus;
    }

    public void setImmigrationCaseStatus(ImmigrationCaseStatus immigrationCaseStatus) {
        this.immigrationCaseStatus = immigrationCaseStatus;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "ImmigrationCase{" + "immigrationCaseType=" + immigrationCaseType + ", employee=" + employee + ", employeeName=" + employeeName + ", email=" + email + ", company=" + company + ", sponsorType=" + sponsorType + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", immigrationCaseStatus=" + immigrationCaseStatus + '}';
    }
}