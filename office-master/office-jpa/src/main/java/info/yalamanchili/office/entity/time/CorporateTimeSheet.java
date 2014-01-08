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
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
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
public class CorporateTimeSheet extends AbstractEntity implements Serializable {

    @NotNull(message = "{hours.not.empty.msg}")
    @Digits(integer = 3, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal hours;
    /**
     * Employee
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Emp_CorpTimeSheets")
    @NotNull(message = "{employee.not.empty.msg}")
    protected Employee employee;
    /**
     * start date Only populated if the dates differ from time sheet period
     * start and end dates and this has the highest precedence
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "TME_SHT_STRT_DT")
    protected Date startDate;
    /**
     * end date Only populated if the dates differ from time sheet period start
     * and end dates and this has the highest precedence
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
    @NotNull
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

    @Override
    public String toString() {
        return "CorporateTimeSheet{" + "employee=" + employee + ", startDate=" + startDate + ", endDate=" + endDate + ", category=" + category + ", status=" + status + ", notes=" + notes + '}';
    }

}
