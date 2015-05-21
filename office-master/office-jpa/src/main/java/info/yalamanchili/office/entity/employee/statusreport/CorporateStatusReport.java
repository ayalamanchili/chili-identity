/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.employee.statusreport;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

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
    private String report;

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
    
}
