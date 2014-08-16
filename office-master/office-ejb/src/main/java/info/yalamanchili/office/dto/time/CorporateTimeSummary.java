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
    
    protected BigDecimal availablePTOHours;
    protected BigDecimal availableVacationHours;
    protected BigDecimal usedUnpaidHours;
    protected String employee;
    protected Date startDate;

    public CorporateTimeSummary() {
    }

    public CorporateTimeSummary( BigDecimal availablePTOHours, BigDecimal availableVacationHours) {
        this.availablePTOHours = availablePTOHours;
        this.availableVacationHours = availableVacationHours;
    }

    public BigDecimal getAvailablePTOHours() {
        return availablePTOHours;
    }

    public void setAvailablePTOHours(BigDecimal availablePTOHours) {
        this.availablePTOHours = availablePTOHours;
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
