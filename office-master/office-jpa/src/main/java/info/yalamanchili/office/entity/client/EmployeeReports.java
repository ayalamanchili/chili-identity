/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.Company;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
public class EmployeeReports extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    protected Date reportStartDate;
    /**
     *
     */
    protected Date reportEndDate;
    /**
     *
     */
    protected Company company;
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
    protected String statusReport;
    /**
     *
     */
    protected Date submittedDate;
    /**
     *
     */
    protected Project project;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public String getStatusReport() {
        return statusReport;
    }

    public void setStatusReport(String statusReport) {
        this.statusReport = statusReport;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "EmployeeReports{" + "reportStartDate=" + reportStartDate + ", reportEndDate=" + reportEndDate + ", company=" + company + ", preparedBy =" + preparedBy + ", approvedBy =" + approvedBy + ", statusReport=" + statusReport + ", submittedDate =" + submittedDate + ", project=" + project + '}';
    }
}
