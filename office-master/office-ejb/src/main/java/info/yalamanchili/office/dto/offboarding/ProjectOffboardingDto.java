/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.offboarding;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
@XmlRootElement
@XmlType
public class ProjectOffboardingDto implements Serializable {

    @NotNull(message = "{endDate.not.null}")
    protected Date endDate;

    @NotEmpty
    protected String notes;

    protected String specialNotes;

    protected Boolean projectInPipeline;
    @NotNull
    protected Long clientInformtaionId;

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

    /**
     * @return the projectInPipeline
     */
    public Boolean getProjectInPipeline() {
        return projectInPipeline;
    }

    /**
     * @param projectInPipeline the projectInPipeline to set
     */
    public void setProjectInPipeline(Boolean projectInPipeline) {
        this.projectInPipeline = projectInPipeline;
    }

    /**
     * @return the clientInformtaionId
     */
    public Long getClientInformtaionId() {
        return clientInformtaionId;
    }

    /**
     * @param clientInformtaionId the clientInformtaionId to set
     */
    public void setClientInformtaionId(Long clientInformtaionId) {
        this.clientInformtaionId = clientInformtaionId;
    }

    /**
     * @return the specialNotes
     */
    public String getSpecialNotes() {
        return specialNotes;
    }

    /**
     * @param specialNotes the specialNotes to set
     */
    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    @Override
    public String toString() {
        return "ProjectOffboarding{" + "endDate=" + endDate + ", notes=" + notes + ", specialNotes=" + specialNotes + ", projectInPipeline=" + projectInPipeline + '}';
    }

}
