/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author ayalamanchili
 */
@XmlType
@Entity
@Audited
@XmlRootElement
public class ConsultantTimeSheet extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 99992L;
    /**
     *
     */
    @NotNull(message = "{hours.not.empty.msg}")
    @Digits(integer = 4, fraction = 4, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal hours;
    /**
     * Employee
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Emp_ConsultantTimeSheets")
    @NotNull(message = "{employee.not.empty.msg}")
    protected Employee employee;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "TME_SHT_STRT_DT")
    protected Date startDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{endDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "TME_SHT_END_DT")
    protected Date endDate;
    /**
     * TimeSheet Category
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{category.not.empty.msg}")
    protected TimeSheetCategory category;
    /**
     * TimeSeet Status
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected TimeSheetStatus status;
    /**
     * notes
     */
    @Lob
    protected String notes;
    /**
     * BPM process Id associated with the request
     */
    protected String bpmProcessId;
    /**
     * created Time Stamp
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "CON_TS_CRT_TS_STMP")
    protected Date createdTimeStamp;
    /**
     * approved by employee
     */
    protected String approvedBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date approvedDate;

    /**
     *
     */
    public ConsultantTimeSheet() {
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TimeSheetCategory getCategory() {
        return category;
    }

    public void setCategory(TimeSheetCategory category) {
        this.category = category;
    }

    public TimeSheetStatus getStatus() {
        return status;
    }

    public void setStatus(TimeSheetStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    @Override
    public String toString() {
        return "ConsultantTimeSheet{" + "employee=" + employee + ", startDate=" + startDate + ", endDate=" + endDate + ", category=" + category + ", status=" + status + ", notes=" + notes + '}';
    }
}
