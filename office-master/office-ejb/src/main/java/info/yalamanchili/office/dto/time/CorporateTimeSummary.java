/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.time;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
public class CorporateTimeSummary implements Serializable {

    /**
     * PTO
     */
    protected String totalAccumulatedPTOHours;
    protected String usedPTOHours;
    protected String availablePTOHours;
    /**
     * unpaid
     */
    protected String usedUnpaidHours;
    protected String employee;
    protected String startDate;

    public CorporateTimeSummary() {
    }

    public CorporateTimeSummary(String availablePTOHours, String availableVacationHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public String getAvailablePTOHours() {
        return availablePTOHours;
    }

    public void setAvailablePTOHours(String availablePTOHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public String getUsedUnpaidHours() {
        return usedUnpaidHours;
    }

    public void setUsedUnpaidHours(String usedUnpaidHours) {
        this.usedUnpaidHours = usedUnpaidHours;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the totalPTOHours
     */
    public String getTotalAccumulatedPTOHours() {
        return totalAccumulatedPTOHours;
    }

    /**
     * @param totalAccumulatedPTOHours the totalPTOHours to set
     */
    public void setTotalAccumulatedPTOHours(String totalAccumulatedPTOHours) {
        this.totalAccumulatedPTOHours = totalAccumulatedPTOHours;
    }

    /**
     * @return the usedPTOHours
     */
    public String getUsedPTOHours() {
        return usedPTOHours;
    }

    /**
     * @param usedPTOHours the usedPTOHours to set
     */
    public void setUsedPTOHours(String usedPTOHours) {
        this.usedPTOHours = usedPTOHours;
    }
}
