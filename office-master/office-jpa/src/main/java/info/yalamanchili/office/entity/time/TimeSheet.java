/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.VersionStatus;
import info.yalamanchili.office.entity.client.StatementOfWork;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author ayalamanchili
 */
@Entity
@XmlRootElement
@XmlType
@Audited
public class TimeSheet extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * quickbooksRate
     */
    protected BigDecimal quickBooksRate;
    /**
     * quickBooks Hours
     */
    @NotNull(message = "{quickBooksHours.not.empty.msg}")
    @Digits(integer = 3, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal quickBooksHours;
    /**
     * Adp Rate
     */
    protected BigDecimal adpRate;
    /**
     * ADP Hours
     */
    @NotNull(message = "{adpHours.not.empty.msg}")
    @Digits(integer = 3, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal adpHours;
    /**
     * start date Only populated if the dates differ from time sheet period
     * start and end dates
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "TME_SHT_STRT_DT")
    protected Date startDate;
    /**
     * end date Only populated if the dates differ from time sheet period start
     * and end dates
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{endDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "TME_SHT_END_DT")
    protected Date endDate;
    /**
     * notes
     */
    @Lob
    protected String notes;
    /**
     *
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_TimeSheetPeriod_TimeSheets")
    @NotNull(message = "{timeSheetPeriod.not.empty.msg}")
    protected TimeSheetPeriod timeSheetPeriod;
    /**
     *
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_TimeSheets")
    @NotNull(message = "{employee.not.empty.msg}")
    protected Employee employee;
    /**
     *
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_StatementOfWork_TimeSheets")
    protected StatementOfWork statementOfWork;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected VersionStatus versionStatus;

    public BigDecimal getQuickBooksRate() {
        return quickBooksRate;
    }

    public void setQuickBooksRate(BigDecimal quickBooksRate) {
        this.quickBooksRate = quickBooksRate;
    }

    public BigDecimal getQuickBooksHours() {
        return quickBooksHours;
    }

    public void setQuickBooksHours(BigDecimal quickBooksHours) {
        this.quickBooksHours = quickBooksHours;
    }

    public BigDecimal getAdpRate() {
        return adpRate;
    }

    public void setAdpRate(BigDecimal adpRate) {
        this.adpRate = adpRate;
    }

    public BigDecimal getAdpHours() {
        return adpHours;
    }

    public void setAdpHours(BigDecimal adpHours) {
        this.adpHours = adpHours;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TimeSheetPeriod getTimeSheetPeriod() {
        return timeSheetPeriod;
    }

    public void setTimeSheetPeriod(TimeSheetPeriod timeSheetPeriod) {
        this.timeSheetPeriod = timeSheetPeriod;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StatementOfWork getStatementOfWork() {
        return statementOfWork;
    }

    public void setStatementOfWork(StatementOfWork statementOfWork) {
        this.statementOfWork = statementOfWork;
    }

    public VersionStatus getVersionStatus() {
        return versionStatus;
    }

    public void setVersionStatus(VersionStatus versionStatus) {
        this.versionStatus = versionStatus;
    }

    @PrePersist
    @PreUpdate
    protected void preSave() {
        //TODO invoke validator also
        if (this.versionStatus == null) {
            this.versionStatus = VersionStatus.ACTIVE;
        }
    }

    @Override
    public String toString() {
        return "TimeSheet{" + "quickBooksRate=" + quickBooksRate + ", quickBooksHours=" + quickBooksHours + ", adpRate=" + adpRate + ", adpHours=" + adpHours + ", startDate=" + startDate + ", endDate=" + endDate + ", notes=" + notes + ", timeSheetPeriod=" + timeSheetPeriod + ", employee=" + employee + ", statementOfWork=" + statementOfWork + '}';
    }
}
