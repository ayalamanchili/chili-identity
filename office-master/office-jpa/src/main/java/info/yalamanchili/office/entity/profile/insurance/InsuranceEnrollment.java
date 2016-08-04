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
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
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
public class InsuranceEnrollment extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    protected Boolean enrolled;

    @Enumerated(EnumType.STRING)
    protected InsuranceType type;

    @ManyToOne
    @ForeignKey(name = "FK_EMP_INSU_ENRO")
    protected Employee employee;

    protected String comments;

    protected String year;

    protected InsuranceEnrollmentStatus status;

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
     * @return the type
     */
    public InsuranceType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(InsuranceType type) {
        this.type = type;
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
     * @return the comments
     */
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
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the status
     */
    public InsuranceEnrollmentStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(InsuranceEnrollmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InsuranceEnrollment{" + "enrolled=" + enrolled + ", type=" + type + ", employee=" + employee + ", comments=" + comments + ", year=" + year + ", status=" + status + '}';
    }

}
