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
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
 * @author anuyalamanchili
 */
@XmlType
@Entity
@Audited
@XmlRootElement
public class CorporateTimeSheet extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 99991L;
    @NotNull(message = "{corp.ts.hours.not.empty.msg}")
    @Digits(integer = 3, fraction = 4, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal hours;
    /**
     * Employee
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Emp_CorpTimeSheets")
    @NotNull(message = "{corp.ts.employee.not.empty.msg}")
    protected Employee employee;
    /**
     * start date Only populated if the dates differ from time sheet period
     * start and end dates and this has the highest precedence
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{corp.ts.startDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "TME_SHT_STRT_DT")
    protected Date startDate;
    /**
     * end date Only populated if the dates differ from time sheet period start
     * and end dates and this has the highest precedence
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{corp.ts.endDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "TME_SHT_END_DT")
    protected Date endDate;
    /**
     * TimeSheet Category
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{corp.ts.category.not.empty.msg}")
    protected TimeSheetCategory category;
    /**
     * TimeSeet Status
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{corp.ts.status.not.empty.msg}")
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
    @org.hibernate.annotations.Index(name = "CRP_TS_CRT_TS_STMP")
    protected Date createdTimeStamp;
    /**
     *
     */
    @Transient
    protected List<Entry> notifyEmployees;
    /**
     * approved by employee
     */
    protected String approvedBy;

    /**
     *
     */
    public CorporateTimeSheet() {
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

    @XmlElement
    public List<Entry> getNotifyEmployees() {
        return notifyEmployees;
    }

    public void setNotifyEmployees(List<Entry> notifyEmployees) {
        this.notifyEmployees = notifyEmployees;
    }

    @Override
    public String toString() {
        return "CorporateTimeSheet{" + "employee=" + employee.getFirstName() + " " + employee.getLastName() + ",hours=" + hours + ", startDate=" + startDate + ", endDate=" + endDate + ", category=" + category + ", status=" + status + ", notes=" + notes + '}';
    }
    public String describe1() {
        StringBuilder description = new StringBuilder("\n");
        description.append("Employee           :").append(this.getEmployee()).append("\n");
        description.append("Category           :").append(this.getCategory()).append("\n");
        description.append("Start Date         :").append(this.getStartDate()).append("\n");
        description.append("End Date           :").append(this.getEndDate()).append("\n");
        description.append("Hours              :").append(this.getHours()).append("\n");
        return description.toString();
    }

    public String describe() {
        return "Employee=" + employee.getFirstName() + " " + employee.getLastName() + ",hours=" + hours + ", startDate=" + startDate + ", endDate=" + endDate + ", category=" + category + ", status=" + status + ", notes=" + notes;
    }
}
