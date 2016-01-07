/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.employee.statusreport;

import com.google.common.base.Strings;
import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.client.ProjectStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author prasanthi.p
 */
@Indexed
@XmlRootElement
@XmlType
@Entity
@Audited
public class StatusReport extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{reportStartDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "RPT_START_DT_IDX")
    protected Date reportStartDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{reportEndDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "RPT_END_DT_IDX")
    protected Date reportEndDate;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{status.not.empty.msg}")
    protected ProjectStatus status;
    /**
     *
     */
    @Lob
    protected String report;
    /**
     * Employee
     */
    @ManyToOne
    @ForeignKey(name = "FK_EMP_STS_RPTS")
    protected Employee employee;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected StatusReportStage stage;
    /**
     *
     */
    protected String preparedBy;
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

    public Date getReportStartDate() {
        return reportStartDate;
    }

    public void setReportStartDate(Date reportStartDate) {
        this.reportStartDate = reportStartDate;
    }

    public Date getReportEndDate() {
        return reportEndDate;
    }

    public void setReportEndDate(Date reportEndDate) {
        this.reportEndDate = reportEndDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StatusReportStage getStage() {
        return stage;
    }

    public void setStage(StatusReportStage stage) {
        this.stage = stage;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
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
    @Valid
    protected ReportDocument reportDocument;

    public ReportDocument getReportDocument() {
        return reportDocument;
    }

    public void setReportDocument(ReportDocument reportDocument) {
        this.reportDocument = reportDocument;
    }

    @PrePersist
    @PreUpdate
    protected void populateAuditData() {
        if (getSubmittedDate() == null) {
            this.submittedDate = new Date();
        }
        if (Strings.isNullOrEmpty(getPreparedBy())) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            this.preparedBy = auth.getName();
        }
    }
    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("\n");
        description.append("Employee            :").append(this.getEmployee().getFirstName()).append(" ").append(this.getEmployee().getLastName()).append("\n");
        description.append("Report Start Date  :").append(this.getReportStartDate()).append("\n");
        description.append("Report End Date   :").append(this.getReportEndDate()).append("\n");
        description.append("Approved By        :").append(this.getApprovedBy()).append("\n");
        description.append("Approved Date      :").append(this.getApprovedDate()).append("\n");
        return description.toString();
    }
}
