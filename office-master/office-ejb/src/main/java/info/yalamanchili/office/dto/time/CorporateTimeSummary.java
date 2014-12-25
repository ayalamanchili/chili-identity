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
import java.math.BigDecimal;
import java.util.Date;
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
    protected BigDecimal totalPTOHours;
    protected BigDecimal usedPTOHours;
    protected BigDecimal availablePTOHours;
    /**
     * total hours
     */
    protected BigDecimal totalAccumulatedHours;
    protected BigDecimal totalUsedHours;
    protected BigDecimal totalAvailableHours;
    /**
     *
     */
    protected BigDecimal usedUnpaidHours;
    protected String employee;
    protected Date startDate;

    public CorporateTimeSummary() {
    }

    public CorporateTimeSummary(BigDecimal availablePTOHours, BigDecimal availableVacationHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public BigDecimal getAvailablePTOHours() {
        return availablePTOHours;
    }

    public void setAvailablePTOHours(BigDecimal availablePTOHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public BigDecimal getUsedUnpaidHours() {
        return usedUnpaidHours;
    }

    public void setUsedUnpaidHours(BigDecimal usedUnpaidHours) {
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

    /**
     * @return the totalPTOHours
     */
    public BigDecimal getTotalPTOHours() {
        return totalPTOHours;
    }

    /**
     * @param totalPTOHours the totalPTOHours to set
     */
    public void setTotalPTOHours(BigDecimal totalPTOHours) {
        this.totalPTOHours = totalPTOHours;
    }

    /**
     * @return the usedPTOHours
     */
    public BigDecimal getUsedPTOHours() {
        return usedPTOHours;
    }

    /**
     * @param usedPTOHours the usedPTOHours to set
     */
    public void setUsedPTOHours(BigDecimal usedPTOHours) {
        this.usedPTOHours = usedPTOHours;
    }

    /**
     * @return the totalAccumulatedHours
     */
    public BigDecimal getTotalAccumulatedHours() {
        return totalAccumulatedHours;
    }

    /**
     * @param totalAccumulatedHours the totalAccumulatedHours to set
     */
    public void setTotalAccumulatedHours(BigDecimal totalAccumulatedHours) {
        this.totalAccumulatedHours = totalAccumulatedHours;
    }

    /**
     * @return the totalUsedHours
     */
    public BigDecimal getTotalUsedHours() {
        return totalUsedHours;
    }

    /**
     * @param totalUsedHours the totalUsedHours to set
     */
    public void setTotalUsedHours(BigDecimal totalUsedHours) {
        this.totalUsedHours = totalUsedHours;
    }

    /**
     * @return the totalAvailableHours
     */
    public BigDecimal getTotalAvailableHours() {
        return totalAvailableHours;
    }

    /**
     * @param totalAvailableHours the totalAvailableHours to set
     */
    public void setTotalAvailableHours(BigDecimal totalAvailableHours) {
        this.totalAvailableHours = totalAvailableHours;
    }
}
