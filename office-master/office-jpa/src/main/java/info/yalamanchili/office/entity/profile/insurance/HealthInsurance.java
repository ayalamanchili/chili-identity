/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.insurance;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author prasanthi.p
 */
@Indexed
@XmlRootElement
@XmlType
@Entity
@Audited
public class HealthInsurance extends AbstractEntity {

    protected static long serialVersionUID = 1L;

    protected Boolean enrolled;
    
    @ManyToOne
    @ForeignKey(name = "FK_EMP_INSU_ENRO")
    protected Employee employee;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateRequested;

    @OneToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_HLTH_INS_WVR")
    @Valid
    protected HealthInsuranceWaiver healthInsuranceWaiver;
    /**
     *
     */

    @OneToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_INS_ENR")
    @Valid
    protected InsuranceEnrollment insuranceEnrollment;

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
     * @return the healthInsuranceWaiver
     */
    @XmlElement
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
     * @return the insuranceEnrollment
     */
    @XmlElement
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

    @Override
    public String toString() {
        return "HealthInsurance{" + "enrolled=" + enrolled + ", employee=" + employee + ", dateRequested=" + dateRequested + ", healthInsuranceWaiver=" + healthInsuranceWaiver + ", insuranceEnrollment=" + insuranceEnrollment + '}';
    }

}
