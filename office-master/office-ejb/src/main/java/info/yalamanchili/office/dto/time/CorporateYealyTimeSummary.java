/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.time;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
public class CorporateYealyTimeSummary {

    protected BigDecimal availableSickHours;
    protected BigDecimal availablePersonalHours;
    protected BigDecimal availableVacationHours;

    public CorporateYealyTimeSummary() {
    }

    public CorporateYealyTimeSummary(BigDecimal availableSickHours, BigDecimal availablePersonalHours, BigDecimal availableVacationHours) {
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

}
