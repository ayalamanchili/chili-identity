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
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
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

    @NotNull
    protected String year;

    protected Boolean enrolled;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    protected BenefitType benefitType;

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
     * @return the Year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(String year) {
        this.year = year;
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

}
