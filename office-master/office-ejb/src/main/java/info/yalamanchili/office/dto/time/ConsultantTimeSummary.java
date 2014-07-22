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
     * Personal
     */
    protected BigDecimal totalPersonalHours;
    protected BigDecimal usedPersonalHours;
    protected BigDecimal availablePersonalHours;
    /**
     * Sick
     */
    protected BigDecimal totalSickHours;
    protected BigDecimal usedSickHours;
    protected BigDecimal availableSickHours;
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

    public ConsultantTimeSummary(BigDecimal availableSickHours, BigDecimal availablePersonalHours, BigDecimal availableVacationHours) {
        this.availableSickHours = availableSickHours;
        this.availablePersonalHours = availablePersonalHours;
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

    public BigDecimal getTotalPersonalHours() {
        return totalPersonalHours;
    }

    public void setTotalPersonalHours(BigDecimal totalPersonalHours) {
        this.totalPersonalHours = totalPersonalHours;
    }

    public BigDecimal getUsedPersonalHours() {
        return usedPersonalHours;
    }

    public void setUsedPersonalHours(BigDecimal usedPersonalHours) {
        this.usedPersonalHours = usedPersonalHours;
    }

    public BigDecimal getAvailablePersonalHours() {
        return availablePersonalHours;
    }

    public void setAvailablePersonalHours(BigDecimal availablePersonalHours) {
        this.availablePersonalHours = availablePersonalHours;
    }

    public BigDecimal getTotalSickHours() {
        return totalSickHours;
    }

    public void setTotalSickHours(BigDecimal totalSickHours) {
        this.totalSickHours = totalSickHours;
    }

    public BigDecimal getUsedSickHours() {
        return usedSickHours;
    }

    public void setUsedSickHours(BigDecimal usedSickHours) {
        this.usedSickHours = usedSickHours;
    }

    public BigDecimal getAvailableSickHours() {
        return availableSickHours;
    }

    public void setAvailableSickHours(BigDecimal availableSickHours) {
        this.availableSickHours = availableSickHours;
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
