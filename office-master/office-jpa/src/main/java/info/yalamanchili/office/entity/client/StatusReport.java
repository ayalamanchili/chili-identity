/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.ClientInformation;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;
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
    @NotNull
    protected Date reportStartDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull
    protected Date reportEndDate;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    protected ProjectStatus status;
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
    @Lob
    @NotEmpty
    protected String report;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date submittedDate;
    /**
     *
     */
    @ManyToOne
    @ForeignKey(name = "FK_PROJECT_STATUS_RPTS")
    @NotNull
    protected Project project;

    /**
     * employee
     */
    @ManyToOne
    @ForeignKey(name = "FK_CLNT_INFO_SRV_TKTS")
    @NotNull
    protected ClientInformation clientInformation;

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

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    @XmlElement
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @XmlTransient
    public ClientInformation getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
    }

    @PrePersist
    @PreUpdate
    protected void populateAuditData() {
        if (getSubmittedDate() == null) {
            this.submittedDate = new Date();
        }
        if (getPreparedBy() == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            this.preparedBy = auth.getName();
        }
    }

    @Override
    public String toString() {
        return "StatusReport{" + "reportStartDate=" + reportStartDate + ", reportEndDate=" + reportEndDate + ", preparedBy=" + preparedBy + ", approvedBy=" + approvedBy + ", statusReport=" + report + ", submittedDate=" + submittedDate + '}';
    }

}
