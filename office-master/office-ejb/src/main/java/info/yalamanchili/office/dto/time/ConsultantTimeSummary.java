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

    protected BigDecimal availableSickHours;
    protected BigDecimal availablePersonalHours;
    protected BigDecimal availableVacationHours;
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

    public BigDecimal getAvailableSickHours() {
        return availableSickHours;
    }

    public void setAvailableSickHours(BigDecimal availableSickHours) {
        this.availableSickHours = availableSickHours;
    }

    public BigDecimal getAvailablePersonalHours() {
        return availablePersonalHours;
    }

    public void setAvailablePersonalHours(BigDecimal availablePersonalHours) {
        this.availablePersonalHours = availablePersonalHours;
    }

    public BigDecimal getAvailableVacationHours() {
        return availableVacationHours;
    }

    public void setAvailableVacationHours(BigDecimal availableVacationHours) {
        this.availableVacationHours = availableVacationHours;
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
}
