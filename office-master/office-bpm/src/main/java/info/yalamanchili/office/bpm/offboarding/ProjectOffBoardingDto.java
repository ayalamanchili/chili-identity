/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.offboarding;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement
@XmlType
public class ProjectOffBoardingDto implements Serializable {

    /**
     *
     */
    @NotEmpty(message = "{clientName.not.empty}")
    protected String clientName;
    /**
     *
     */
    @NotEmpty(message="{vendorName.not.empty}")
    protected String vendorName;
    /**
     *
     */
    @NotNull(message="{endDate.not.null}")
    protected Date endDate;
    /**
     *
     */
    protected Long employeeId;
    /**
     *
     */
    protected String notes;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "ProjectEndDetails{" + "clientName=" + clientName + ", vendorName=" + vendorName + ", endDate=" + endDate + ", notes=" + notes + '}';
    }
}
