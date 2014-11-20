/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * Transfer object to pass json based report string
 */
package info.yalamanchili.office.entity.employee.statusreport;

import java.io.Serializable;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * used to store to JSON string for the report Field in the entity
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class ReportDocument implements Serializable {

    /**
     *
     */
    @Size(min = 3, max = 370)
    protected String projectDescription;
    /**
     * Project Phase 1
     */
    @Size(max = 40)
    protected String projectPhase1Name;
    /**
     *
     */
    @Size(max = 90)
    protected String projectPhase1Deliverable;
    /**
     *
     */
    @Size(max = 20)
    protected String projectPhase1EndDate;
    /**
     *
     */
    @Size(max = 20)
    protected String projectPhase1Status;
    /**
     * Project Phase 2
     */
    @Size(max = 40)
    protected String projectPhase2Name;
    /**
     *
     */
    @Size(max = 90)
    protected String projectPhase2Deliverable;
    /**
     *
     */
    @Size(max = 20)
    protected String projectPhase2EndDate;
    /**
     *
     */
    @Size(max = 20)
    protected String projectPhase2Status;
    /**
     * Project Phase 3
     */
    @Size(max = 40)
    protected String projectPhase3Name;
    /**
     *
     */
    @Size(max = 90)
    protected String projectPhase3Deliverable;
    /**
     *
     */
    @Size(max = 20)
    protected String projectPhase3EndDate;
    /**
     *
     */
    @Size(max = 20)
    protected String projectPhase3Status;
    /**
     * Project Phase 4
     */
    @Size(max = 40)
    protected String projectPhase4Name;
    /**
     *
     */
    @Size(max = 90)
    protected String projectPhase4Deliverable;
    /**
     *
     */
    @Size(max = 20)
    protected String projectPhase4EndDate;
    /**
     *
     */
    @Size(max = 20)
    protected String projectPhase4Status;
    /**
     *
     */
    @Size(min = 3, max = 400, message = "{reportDocument.statusDescription.length.invalid.msg}")
    protected String statusDescription;
    /**
     *
     */
    @Size(min = 3, max = 400, message = "{reportDocument.accomplishments.length.invalid.msg}")
    protected String accomplishments;
    /**
     *
     */
    @Size(min = 3, max = 400, message = "{reportDocument.scheduledActivities.length.invalid.msg}")
    protected String scheduledActivities;

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectPhase1Name() {
        return projectPhase1Name;
    }

    public void setProjectPhase1Name(String projectPhase1Name) {
        this.projectPhase1Name = projectPhase1Name;
    }

    public String getProjectPhase1Deliverable() {
        return projectPhase1Deliverable;
    }

    public void setProjectPhase1Deliverable(String projectPhase1Deliverable) {
        this.projectPhase1Deliverable = projectPhase1Deliverable;
    }

    public String getProjectPhase1EndDate() {
        return projectPhase1EndDate;
    }

    public void setProjectPhase1EndDate(String projectPhase1EndDate) {
        this.projectPhase1EndDate = projectPhase1EndDate;
    }

    public String getProjectPhase1Status() {
        return projectPhase1Status;
    }

    public void setProjectPhase1Status(String projectPhase1Status) {
        this.projectPhase1Status = projectPhase1Status;
    }

    public String getProjectPhase2Name() {
        return projectPhase2Name;
    }

    public void setProjectPhase2Name(String projectPhase2Name) {
        this.projectPhase2Name = projectPhase2Name;
    }

    public String getProjectPhase2Deliverable() {
        return projectPhase2Deliverable;
    }

    public void setProjectPhase2Deliverable(String projectPhase2Deliverable) {
        this.projectPhase2Deliverable = projectPhase2Deliverable;
    }

    public String getProjectPhase2EndDate() {
        return projectPhase2EndDate;
    }

    public void setProjectPhase2EndDate(String projectPhase2EndDate) {
        this.projectPhase2EndDate = projectPhase2EndDate;
    }

    public String getProjectPhase2Status() {
        return projectPhase2Status;
    }

    public void setProjectPhase2Status(String projectPhase2Status) {
        this.projectPhase2Status = projectPhase2Status;
    }

    public String getProjectPhase3Name() {
        return projectPhase3Name;
    }

    public void setProjectPhase3Name(String projectPhase3Name) {
        this.projectPhase3Name = projectPhase3Name;
    }

    public String getProjectPhase3Deliverable() {
        return projectPhase3Deliverable;
    }

    public void setProjectPhase3Deliverable(String projectPhase3Deliverable) {
        this.projectPhase3Deliverable = projectPhase3Deliverable;
    }

    public String getProjectPhase3EndDate() {
        return projectPhase3EndDate;
    }

    public void setProjectPhase3EndDate(String projectPhase3EndDate) {
        this.projectPhase3EndDate = projectPhase3EndDate;
    }

    public String getProjectPhase3Status() {
        return projectPhase3Status;
    }

    public void setProjectPhase3Status(String projectPhase3Status) {
        this.projectPhase3Status = projectPhase3Status;
    }

    public String getProjectPhase4Name() {
        return projectPhase4Name;
    }

    public void setProjectPhase4Name(String projectPhase4Name) {
        this.projectPhase4Name = projectPhase4Name;
    }

    public String getProjectPhase4Deliverable() {
        return projectPhase4Deliverable;
    }

    public void setProjectPhase4Deliverable(String projectPhase4Deliverable) {
        this.projectPhase4Deliverable = projectPhase4Deliverable;
    }

    public String getProjectPhase4EndDate() {
        return projectPhase4EndDate;
    }

    public void setProjectPhase4EndDate(String projectPhase4EndDate) {
        this.projectPhase4EndDate = projectPhase4EndDate;
    }

    public String getProjectPhase4Status() {
        return projectPhase4Status;
    }

    public void setProjectPhase4Status(String projectPhase4Status) {
        this.projectPhase4Status = projectPhase4Status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getAccomplishments() {
        return accomplishments;
    }

    public void setAccomplishments(String accomplishments) {
        this.accomplishments = accomplishments;
    }

    public String getScheduledActivities() {
        return scheduledActivities;
    }

    public void setScheduledActivities(String scheduledActivities) {
        this.scheduledActivities = scheduledActivities;
    }
}
