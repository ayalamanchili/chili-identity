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
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Madhu.Badiginchala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class LCA extends AbstractEntity {

    private static final long serialVersionUID = 11L;

    @NotNull(message = "{lca.visaclassification.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    protected VisaClassificationType visaClassification;

    @Enumerated(EnumType.STRING)
    protected SOCCodesAndOccupations socCodesAndOccupations;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Emp_Lca")
    private Employee employee;

    protected String candidateNames;

    protected Long totalWorkingPositions;

    protected Long totalPendingPositions;

    @ManyToMany(fetch = FetchType.EAGER)
    @ForeignKey(name = "FK_LCA_WorkedBy")
    protected Set<Employee> workedByEmployees;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_LCA_Company")
    protected Company company;

    @OneToOne(cascade = CascadeType.ALL)
    protected Address lcaAddress1;

    @OneToOne(cascade = CascadeType.ALL)
    protected Address lcaAddress2;

    @NotNull(message = "{lca.lcaCurrWageLvl.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    protected LCAWageLevels lcaCurrWageLvl;

    @NotNull(message = "{lca.lcaCurrMinWage.not.empty.msg}")
    protected BigDecimal lcaCurrMinWage;

    protected BigDecimal lcaCurrMaxWage;

    @NotNull(message = "{lca.jobTitle.not.empty.msg}")
    protected String jobTitle;

    protected String withdrawnLCANumber;

    @NotNull(message = "{lca.lcaNumber.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "LCA_NBR")
    protected String lcaNumber;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaFiledDate;

    @NotNull(message = "{lca.lcaValidFromDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "LCA_VALID_FROM_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaValidFromDate;

    @NotNull(message = "{lca.lcaValidToDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "LCA_VALID_TO_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaValidToDate;

    @Enumerated(EnumType.STRING)
    protected LCAStatus status;

    protected String clientName;

    protected String vendorName;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaPostingSentToVendor;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date responseOnLcaPosting;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date reminderEmail;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date certifiedLcaSentConsultant;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaPostingSSTLocation;

    // Public Inspection File PIF
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaFiledInPIF;

    @Enumerated(EnumType.STRING)
    protected Polar nonDisplacement;

    public Address getLcaAddress1() {
        return lcaAddress1;
    }

    public void setLcaAddress1(Address lcaAddress1) {
        this.lcaAddress1 = lcaAddress1;
    }

    public Address getLcaAddress2() {
        return lcaAddress2;
    }

    public void setLcaAddress2(Address lcaAddress2) {
        this.lcaAddress2 = lcaAddress2;
    }

    public LCAWageLevels getLcaCurrWageLvl() {
        return lcaCurrWageLvl;
    }

    public void setLcaCurrWageLvl(LCAWageLevels lcaCurrWageLvl) {
        this.lcaCurrWageLvl = lcaCurrWageLvl;
    }

    public BigDecimal getLcaCurrMinWage() {
        return lcaCurrMinWage;
    }

    public void setLcaCurrMinWage(BigDecimal lcaCurrMinWage) {
        this.lcaCurrMinWage = lcaCurrMinWage;
    }

    public BigDecimal getLcaCurrMaxWage() {
        return lcaCurrMaxWage;
    }

    public void setLcaCurrMaxWage(BigDecimal lcaCurrMaxWage) {
        this.lcaCurrMaxWage = lcaCurrMaxWage;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLcaNumber() {
        return lcaNumber;
    }

    public void setLcaNumber(String lcaNumber) {
        this.lcaNumber = lcaNumber;
    }

    public Date getLcaFiledDate() {
        return lcaFiledDate;
    }

    public void setLcaFiledDate(Date lcaFiledDate) {
        this.lcaFiledDate = lcaFiledDate;
    }

    public Date getLcaValidFromDate() {
        return lcaValidFromDate;
    }

    public void setLcaValidFromDate(Date lcaValidFromDate) {
        this.lcaValidFromDate = lcaValidFromDate;
    }

    public Date getLcaValidToDate() {
        return lcaValidToDate;
    }

    public void setLcaValidToDate(Date lcaValidToDate) {
        this.lcaValidToDate = lcaValidToDate;
    }

    public VisaClassificationType getVisaClassification() {
        return visaClassification;
    }

    public void setVisaClassification(VisaClassificationType visaClassification) {
        this.visaClassification = visaClassification;
    }

    public SOCCodesAndOccupations getSocCodesAndOccupations() {
        return socCodesAndOccupations;
    }

    public void setSocCodesAndOccupations(SOCCodesAndOccupations socCodesAndOccupations) {
        this.socCodesAndOccupations = socCodesAndOccupations;
    }

    public Long getTotalWorkingPositions() {
        return totalWorkingPositions;
    }

    public void setTotalWorkingPositions(Long totalWorkingPositions) {
        this.totalWorkingPositions = totalWorkingPositions;
    }

    public LCAStatus getStatus() {
        return status;
    }

    public void setStatus(LCAStatus status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getTotalPendingPositions() {
        return totalPendingPositions;
    }

    public void setTotalPendingPositions(Long totalPendingPositions) {
        this.totalPendingPositions = totalPendingPositions;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Date getLcaPostingSentToVendor() {
        return lcaPostingSentToVendor;
    }

    public void setLcaPostingSentToVendor(Date lcaPostingSentToVendor) {
        this.lcaPostingSentToVendor = lcaPostingSentToVendor;
    }

    public Date getResponseOnLcaPosting() {
        return responseOnLcaPosting;
    }

    public void setResponseOnLcaPosting(Date responseOnLcaPosting) {
        this.responseOnLcaPosting = responseOnLcaPosting;
    }

    public Date getReminderEmail() {
        return reminderEmail;
    }

    public void setReminderEmail(Date reminderEmail) {
        this.reminderEmail = reminderEmail;
    }

    public Date getCertifiedLcaSentConsultant() {
        return certifiedLcaSentConsultant;
    }

    public void setCertifiedLcaSentConsultant(Date certifiedLcaSentConsultant) {
        this.certifiedLcaSentConsultant = certifiedLcaSentConsultant;
    }

    public Date getLcaPostingSSTLocation() {
        return lcaPostingSSTLocation;
    }

    public void setLcaPostingSSTLocation(Date lcaPostingSSTLocation) {
        this.lcaPostingSSTLocation = lcaPostingSSTLocation;
    }

    public Date getLcaFiledInPIF() {
        return lcaFiledInPIF;
    }

    public void setLcaFiledInPIF(Date lcaFiledInPIF) {
        this.lcaFiledInPIF = lcaFiledInPIF;
    }

    public Polar getNonDisplacement() {
        return nonDisplacement;
    }

    public void setNonDisplacement(Polar nonDisplacement) {
        this.nonDisplacement = nonDisplacement;
    }

    public Set<Employee> getWorkedByEmployees() {
        if (this.workedByEmployees == null) {
            this.workedByEmployees = new HashSet<>();
        }
        return workedByEmployees;
    }

    public void setWorkedByEmployees(Set<Employee> workedByEmployees) {
        this.workedByEmployees = workedByEmployees;
    }

    public void addWorkedByEmployee(Employee emp) {
        if (emp == null) {
            return;
        }
        getWorkedByEmployees().add(emp);
    }

    public String getWithdrawnLCANumber() {
        return withdrawnLCANumber;
    }

    public void setWithdrawnLCANumber(String withdrawnLCANumber) {
        this.withdrawnLCANumber = withdrawnLCANumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCandidateNames() {
        return candidateNames;
    }

    public void setCandidateNames(String candidateNames) {
        this.candidateNames = candidateNames;
    }

    @Override
    public String toString() {
        return "LCA{" + "visaClassification=" + visaClassification + ", socCodesAndOccupations=" + socCodesAndOccupations + ", employee=" + employee + ", lcaEmployeeName=" + candidateNames + ", totalWorkingPositions=" + totalWorkingPositions + ", totalPendingPositions=" + totalPendingPositions + ", workedByEmployees=" + workedByEmployees + ", company=" + company + ", lcaAddress1=" + lcaAddress1 + ", lcaAddress2=" + lcaAddress2 + ", lcaCurrWageLvl=" + lcaCurrWageLvl + ", lcaCurrMinWage=" + lcaCurrMinWage + ", lcaCurrMaxWage=" + lcaCurrMaxWage + ", jobTitle=" + jobTitle + ", withdrawnLCANumber=" + withdrawnLCANumber + ", lcaNumber=" + lcaNumber + ", lcaFiledDate=" + lcaFiledDate + ", lcaValidFromDate=" + lcaValidFromDate + ", lcaValidToDate=" + lcaValidToDate + ", status=" + status + ", clientName=" + clientName + ", vendorName=" + vendorName + ", lcaPostingSentToVendor=" + lcaPostingSentToVendor + ", responseOnLcaPosting=" + responseOnLcaPosting + ", reminderEmail=" + reminderEmail + ", certifiedLcaSentConsultant=" + certifiedLcaSentConsultant + ", lcaPostingSSTLocation=" + lcaPostingSSTLocation + ", lcaFiledInPIF=" + lcaFiledInPIF + ", nonDisplacement=" + nonDisplacement + '}';
    }

}
