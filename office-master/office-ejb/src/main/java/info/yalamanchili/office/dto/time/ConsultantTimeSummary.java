/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
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
 * @author prasanthi.p
 */
@XmlRootElement
@XmlType
public class ConsultantTimeSummary implements Serializable {

    /**
     * Vacation
     */
    protected BigDecimal totalVacationHours;
    protected BigDecimal usedVacationHours;
    protected BigDecimal availableVacationHours;
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
     *
     */
    protected BigDecimal usedUnpaidHours;
    protected String employee;
    protected Date startDate;

    public ConsultantTimeSummary() {
    }

    public ConsultantTimeSummary( BigDecimal availablePTOHours ,BigDecimal availableVacationHours) {
        this.availablePTOHours = availablePTOHours;
        this.availableVacationHours = availableVacationHours;
    }

    public BigDecimal getTotalVacationHours() {
        return totalVacationHours;
    }

    public void setTotalVacationHours(BigDecimal totalVacationHours) {
        this.totalVacationHours = totalVacationHours;
    }

    public BigDecimal getUsedVacationHours() {
        return usedVacationHours;
    }

    public void setUsedVacationHours(BigDecimal usedVacationHours) {
        this.usedVacationHours = usedVacationHours;
    }

    public BigDecimal getAvailableVacationHours() {
        return availableVacationHours;
    }

    public void setAvailableVacationHours(BigDecimal availableVacationHours) {
        this.availableVacationHours = availableVacationHours;
    }

    public BigDecimal getTotalPTOHours() {
        return totalPTOHours;
    }

    public void setTotalPTOHours(BigDecimal totalPTOHours) {
        this.totalPTOHours = totalPTOHours;
    }

    public BigDecimal getUsedPTOHours() {
        return usedPTOHours;
    }

    public void setUsedPTOHours(BigDecimal usedPTOHours) {
        this.usedPTOHours = usedPTOHours;
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

    public BigDecimal getTotalAccumulatedHours() {
        return totalAccumulatedHours;
    }

    public void setTotalAccumulatedHours(BigDecimal totalAccumulatedHours) {
        this.totalAccumulatedHours = totalAccumulatedHours;
    }

    public BigDecimal getTotalUsedHours() {
        return totalUsedHours;
    }

    public void setTotalUsedHours(BigDecimal totalUsedHours) {
        this.totalUsedHours = totalUsedHours;
    }

    public BigDecimal getTotalAvailableHours() {
        return totalAvailableHours;
    }

    public void setTotalAvailableHours(BigDecimal totalAvailableHours) {
        this.totalAvailableHours = totalAvailableHours;
    }
}
