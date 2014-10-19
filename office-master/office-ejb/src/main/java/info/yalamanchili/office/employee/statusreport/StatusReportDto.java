/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.statusreport;

import info.yalamanchili.office.entity.employee.statusreport.StatusReport;
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
public class StatusReportDto extends StatusReport implements Serializable {
    /**
     *
     */
    protected String projectDescription;
    /**
     * Project Phase 1
     */
    protected String projectPhase1Name;

    protected String projectPhase1Deliverable;

    protected String projectPhase1EndDate;

    protected String projectPhase1Status;
    /**
     * Project Phase 2
     */
    protected String projectPhase2Name;

    protected String projectPhase2Deliverable;

    protected String projectPhase2EndDate;

    protected String projectPhase2Status;
    /**
     * Project Phase 3
     */
    protected String projectPhase3Name;

    protected String projectPhase3Deliverable;

    protected String projectPhase3EndDate;

    protected String projectPhase3Status;
    /**
     * Project Phase 4
     */
    protected String projectPhase4Name;

    protected String projectPhase4Deliverable;

    protected String projectPhase4EndDate;

    protected String projectPhase4Status;
    /**
     *
     */
    @Size(min = 3, max = 400)
    protected String statusDescription;
    /**
     *
     */
    @Size(min = 3, max = 400)
    protected String accomplishments;
    /**
     *
     */
    @Size(min = 3, max = 400)
    protected String scheduledActivities;
}
