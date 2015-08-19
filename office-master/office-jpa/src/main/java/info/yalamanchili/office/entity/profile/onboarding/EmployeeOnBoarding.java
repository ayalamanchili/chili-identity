/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.onboarding;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Madhu.Badiginchala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class EmployeeOnBoarding extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * start date
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull
    protected Date startedDate;

    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected OnBoardingStatus status;
    /**
     *
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_EMP_ON_BRD")
    @NotNull
    protected Employee employee;
    /**
     *
     *
     */
    protected String bpmProcessId;
    /**
     *
     */
    protected String startedBy;
    /**
     *  Getters and Setters
     */

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public OnBoardingStatus getStatus() {
        return status;
    }

    public void setStatus(OnBoardingStatus status) {
        this.status = status;
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

    public String getStartedBy() {
        return startedBy;
    }

    public void setStartedBy(String startedBy) {
        this.startedBy = startedBy;
    }

    @Override
    public String toString() {
        return "EmployeeOnBoarding{" + "startedDate=" + startedDate + ", status=" + status + ", employee=" + employee + ", bpmProcessId=" + bpmProcessId + ", startedBy=" + startedBy + '}';
    }
 
    
}
