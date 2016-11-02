/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prasanthi.p
 */
@XmlRootElement
public class LCAMasterReportDto implements Serializable {

    protected String visaClassification;

    protected String socCodesAndOccupations;

    protected String candidateNames;

    protected Long totalWorkingPositions;

    protected Long totalPendingPositions;

    protected String workedByEmployees;

    protected String company;

    protected String lcaAddress1;

    protected String lcaAddress2;

    protected String lcaCurrWageLvl;

    protected BigDecimal lcaCurrMinWage;

    protected BigDecimal lcaCurrMaxWage;

    protected String jobTitle;

    protected String withdrawnLCANumber;

    protected String lcaNumber;

    protected Date lcaFiledDate;

    protected Date lcaValidFromDate;

    protected Date lcaValidToDate;

    protected String status;

    protected String clientName;

    protected String vendorName;

    protected Date lcaPostingSentToVendor;

    protected Date responseOnLcaPosting;

    protected Date reminderEmail;

    protected Date certifiedLcaSentConsultant;

    protected Date lcaPostingSSTLocation;

    // Public Inspection File PIF
    protected Date lcaFiledInPIF;

    protected String nonDisplacement;

    public LCAMasterReportDto() {
    }

    public String getVisaClassification() {
        return visaClassification;
    }

    public void setVisaClassification(String visaClassification) {
        this.visaClassification = visaClassification;
    }

    public String getSocCodesAndOccupations() {
        return socCodesAndOccupations;
    }

    public void setSocCodesAndOccupations(String socCodesAndOccupations) {
        this.socCodesAndOccupations = socCodesAndOccupations;
    }

    public String getCandidateNames() {
        return candidateNames;
    }

    public void setCandidateNames(String candidateNames) {
        this.candidateNames = candidateNames;
    }

    public Long getTotalWorkingPositions() {
        return totalWorkingPositions;
    }

    public void setTotalWorkingPositions(Long totalWorkingPositions) {
        this.totalWorkingPositions = totalWorkingPositions;
    }

    public Long getTotalPendingPositions() {
        return totalPendingPositions;
    }

    public void setTotalPendingPositions(Long totalPendingPositions) {
        this.totalPendingPositions = totalPendingPositions;
    }

    public String getWorkedByEmployees() {
        return workedByEmployees;
    }

    public void setWorkedByEmployees(String workedByEmployees) {
        this.workedByEmployees = workedByEmployees;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLcaAddress1() {
        return lcaAddress1;
    }

    public void setLcaAddress1(String lcaAddress1) {
        this.lcaAddress1 = lcaAddress1;
    }

    public String getLcaAddress2() {
        return lcaAddress2;
    }

    public void setLcaAddress2(String lcaAddress2) {
        this.lcaAddress2 = lcaAddress2;
    }

    public String getLcaCurrWageLvl() {
        return lcaCurrWageLvl;
    }

    public void setLcaCurrWageLvl(String lcaCurrWageLvl) {
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

    public String getWithdrawnLCANumber() {
        return withdrawnLCANumber;
    }

    public void setWithdrawnLCANumber(String withdrawnLCANumber) {
        this.withdrawnLCANumber = withdrawnLCANumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getNonDisplacement() {
        return nonDisplacement;
    }

    public void setNonDisplacement(String nonDisplacement) {
        this.nonDisplacement = nonDisplacement;
    }

}
