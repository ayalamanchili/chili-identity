/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.time;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author prasanthi.p
 */
@XmlRootElement
@XmlType
public class ConsultantTimeSummary implements Serializable {
    /**
     * PTO
     */
    protected Float totalPTOHours;
    protected Float usedPTOHours;
    protected Float availablePTOHours;
    /**
     * total hours
     */
    protected Float totalAccumulatedHours;
    protected Float totalUsedHours;
    protected Float totalAvailableHours;
    /**
     *
     *
     */
    protected Float usedUnpaidHours;
    protected String employee;
    protected Date startDate;

    public ConsultantTimeSummary() {
    }

    public ConsultantTimeSummary( Float availablePTOHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public Float getTotalPTOHours() {
        return totalPTOHours;
    }

    public void setTotalPTOHours(Float totalPTOHours) {
        this.totalPTOHours = totalPTOHours;
    }

    public Float getUsedPTOHours() {
        return usedPTOHours;
    }

    public void setUsedPTOHours(Float usedPTOHours) {
        this.usedPTOHours = usedPTOHours;
    }

    public Float getAvailablePTOHours() {
        return availablePTOHours;
    }

    public void setAvailablePTOHours(Float availablePTOHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public Float getUsedUnpaidHours() {
        return usedUnpaidHours;
    }

    public void setUsedUnpaidHours(Float usedUnpaidHours) {
        this.usedUnpaidHours = usedUnpaidHours;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Float getTotalAccumulatedHours() {
        return totalAccumulatedHours;
    }

    public void setTotalAccumulatedHours(Float totalAccumulatedHours) {
        this.totalAccumulatedHours = totalAccumulatedHours;
    }

    public Float getTotalUsedHours() {
        return totalUsedHours;
    }

    public void setTotalUsedHours(Float totalUsedHours) {
        this.totalUsedHours = totalUsedHours;
    }

    public Float getTotalAvailableHours() {
        return totalAvailableHours;
    }

    public void setTotalAvailableHours(Float totalAvailableHours) {
        this.totalAvailableHours = totalAvailableHours;
    }
}
