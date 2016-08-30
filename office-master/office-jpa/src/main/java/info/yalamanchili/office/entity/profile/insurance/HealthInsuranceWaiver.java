/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.insurance;

import info.chili.jpa.AbstractHandleEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author prasanthi.p
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(name = "HealthInsuranceWaiver")
public class HealthInsuranceWaiver extends AbstractHandleEntity {

    protected static long serialVersionUID = 1L;

    protected String fileUrl;

    @OneToOne(cascade = CascadeType.ALL)
    protected InsuranceEnrollment insuranceEnrollment;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date submittedDate;

    protected String waivingCoverageFor;

    protected String waivingCoverageDueTo;

    protected String spouseName;

    protected String dependentName;

    protected String spouseNameOfCarrier;

    protected String otherNameOfCarrier;

    @Enumerated(EnumType.STRING)
    protected InsuranceCoverageType otherCarrierType;
    //

    /**
     * @return the fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * @param fileUrl the fileUrl to set
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * @return the insuranceEnrollment
     */
    public InsuranceEnrollment getInsuranceEnrollment() {
        return insuranceEnrollment;
    }

    /**
     * @param insuranceEnrollment the insuranceEnrollment to set
     */
    public void setInsuranceEnrollment(InsuranceEnrollment insuranceEnrollment) {
        this.insuranceEnrollment = insuranceEnrollment;
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
     * @return the waivingCoverageFor
     */
    public String getWaivingCoverageFor() {
        return waivingCoverageFor;
    }

    /**
     * @param waivingCoverageFor the waivingCoverageFor to set
     */
    public void setWaivingCoverageFor(String waivingCoverageFor) {
        this.waivingCoverageFor = waivingCoverageFor;
    }

    /**
     * @return the waivingCoverageDueTo
     */
    public String getWaivingCoverageDueTo() {
        return waivingCoverageDueTo;
    }

    /**
     * @param waivingCoverageDueTo the waivingCoverageDueTo to set
     */
    public void setWaivingCoverageDueTo(String waivingCoverageDueTo) {
        this.waivingCoverageDueTo = waivingCoverageDueTo;
    }

    /**
     * @return the spouseName
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * @param spouseName the spouseName to set
     */
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    /**
     * @return the dependentName
     */
    public String getDependentName() {
        return dependentName;
    }

    /**
     * @param dependentName the dependentName to set
     */
    public void setDependentName(String dependentName) {
        this.dependentName = dependentName;
    }

    /**
     * @return the spouseNameOfCarrier
     */
    public String getSpouseNameOfCarrier() {
        return spouseNameOfCarrier;
    }

    /**
     * @param spouseNameOfCarrier the spouseNameOfCarrier to set
     */
    public void setSpouseNameOfCarrier(String spouseNameOfCarrier) {
        this.spouseNameOfCarrier = spouseNameOfCarrier;
    }

    /**
     * @return the otherNameOfCarrier
     */
    public String getOtherNameOfCarrier() {
        return otherNameOfCarrier;
    }

    /**
     * @param otherNameOfCarrier the otherNameOfCarrier to set
     */
    public void setOtherNameOfCarrier(String otherNameOfCarrier) {
        this.otherNameOfCarrier = otherNameOfCarrier;
    }

    /**
     * @return the otherCarrierType
     */
    public InsuranceCoverageType getOtherCarrierType() {
        return otherCarrierType;
    }

    /**
     * @param otherCarrierType the otherCarrierType to set
     */
    public void setOtherCarrierType(InsuranceCoverageType otherCarrierType) {
        this.otherCarrierType = otherCarrierType;
    }

    @Override
    public String toString() {
        return "HealthInsuranceWaiver{" + "fileUrl=" + fileUrl + ", insuranceEnrollment=" + insuranceEnrollment + ", submittedDate=" + submittedDate + ", waivingCoverageFor=" + waivingCoverageFor + ", waivingCoverageDueTo=" + waivingCoverageDueTo + ", spouseName=" + spouseName + ", dependentName=" + dependentName + ", spouseNameOfCarrier=" + spouseNameOfCarrier + ", otherNameOfCarrier=" + otherNameOfCarrier + ", otherCarrierType=" + otherCarrierType + '}';
    }
}
