/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.benefits;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Benarji.v
 */
@Indexed
@XmlRootElement
@XmlType
@Entity
@Audited
public class BenefitEnrollment extends AbstractEntity {

    protected static long serialVersionUID = 1L;

    @ManyToOne
    @ForeignKey(name = "FK_EMP_BNF_ENRO")
    protected Employee employee;

    @NotNull(message = "{benefitYear.not.empty.msg}")
    protected String enrolledYear;

    protected Boolean enrolled;

    @NotNull(message = "{benefitType.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    protected BenefitType benefitType;

    @OneToOne
    @ForeignKey(name = "FK_HLTH_INS_WVR")
    protected HealthInsuranceWaiver healthInsuranceWaiver;

    protected String comments;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date effectiveDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateRequested;

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
     * @return the enrolled
     */
    public Boolean getEnrolled() {
        return enrolled;
    }

    /**
     * @param enrolled the enrolled to set
     */
    public void setEnrolled(Boolean enrolled) {
        this.enrolled = enrolled;
    }

    /**
     * @return the benefitType
     */
    public BenefitType getBenefitType() {
        return benefitType;
    }

    /**
     * @param benefitType the benefitType to set
     */
    public void setBenefitType(BenefitType benefitType) {
        this.benefitType = benefitType;
    }

    /**
     * @return the healthInsuranceWaiver
     */
    @XmlTransient
    public HealthInsuranceWaiver getHealthInsuranceWaiver() {
        return healthInsuranceWaiver;
    }

    /**
     * @param healthInsuranceWaiver the healthInsuranceWaiver to set
     */
    public void setHealthInsuranceWaiver(HealthInsuranceWaiver healthInsuranceWaiver) {
        this.healthInsuranceWaiver = healthInsuranceWaiver;
    }

    /**
     * @return the comments
     */
    @XmlTransient
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the effectiveDate
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * @param effectiveDate the effectiveDate to set
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * @return the dateRequested
     */
    public Date getDateRequested() {
        return dateRequested;
    }

    /**
     * @param dateRequested the dateRequested to set
     */
    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    /**
     * @return the enrolledYear
     */
    public String getEnrolledYear() {
        return enrolledYear;
    }

    /**
     * @param enrolledYear the enrolledYear to set
     */
    public void setEnrolledYear(String enrolledYear) {
        this.enrolledYear = enrolledYear;
    }

    @Override
    public String toString() {
        return "BenefitEnrollment{" + "employee=" + employee + ", enrolledYear=" + enrolledYear + ", enrolled=" + enrolled + ", benefitType=" + benefitType + ", healthInsuranceWaiver=" + healthInsuranceWaiver + ", comments=" + comments + ", effectiveDate=" + effectiveDate + ", dateRequested=" + dateRequested + '}';
    }

}
