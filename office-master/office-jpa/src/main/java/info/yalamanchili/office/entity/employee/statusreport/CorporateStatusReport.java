/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.employee.statusreport;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.model.time.TimePeriod;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author benerji.v
 */
@Indexed
@XmlRootElement
@XmlType
@Entity
@Audited
public class CorporateStatusReport extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{reportStartDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "CRP_RPT_START_DT_IDX")
    private Date reportStartDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{reportEndDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "CRP_RPT_END_DT_IDX")
    private Date reportEndDate;
    /**
     *
     */
    @Lob
    @NotEmpty
    private String report;
    /**
     * Employee
     */
    @ManyToOne
    @ForeignKey(name = "FK_EMP_CRP_STS_RPTS")
    protected Employee employee;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected CropStatusReportStatus status;
    /**
     *
     */
    protected String approvedBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date submittedDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date approvedDate;
    /**
     * bpmProcessId
     */
    protected String bpmProcessId;

    public CorporateStatusReport() {
    }

    /**
     * @return the reportStartDate
     */
    public Date getReportStartDate() {
        return reportStartDate;
    }

    /**
     * @param reportStartDate the reportStartDate to set
     */
    public void setReportStartDate(Date reportStartDate) {
        this.reportStartDate = reportStartDate;
    }

    /**
     * @return the reportEndDate
     */
    public Date getReportEndDate() {
        return reportEndDate;
    }

    /**
     * @param reportEndDate the reportEndDate to set
     */
    public void setReportEndDate(Date reportEndDate) {
        this.reportEndDate = reportEndDate;
    }

    /**
     * @return the report
     */
    public String getReport() {
        return report;
    }

    /**
     * @param report the report to set
     */
    public void setReport(String report) {
        this.report = report;
    }

    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CropStatusReportStatus getStatus() {
        return status;
    }

    public void setStatus(CropStatusReportStatus status) {
        this.status = status;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }
    @Transient
    protected TimePeriod statusReportPeriod;

    public TimePeriod getStatusReportPeriod() {
        return statusReportPeriod;
    }

    public void setStatusReportPeriod(TimePeriod statusReportPeriod) {
        this.statusReportPeriod = statusReportPeriod;
    }
    @Transient
    protected String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "CorporateStatusReport{" + "reportStartDate=" + reportStartDate + ", reportEndDate=" + reportEndDate + ", report=" + report + ", employee=" + employee + ", stage=" + status + ", approvedBy=" + approvedBy + ", submittedDate=" + submittedDate + ", approvedDate=" + approvedDate + ", bpmProcessId=" + bpmProcessId + '}';
    }
}
