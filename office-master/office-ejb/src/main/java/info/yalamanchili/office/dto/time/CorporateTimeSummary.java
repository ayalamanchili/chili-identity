/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.time;

import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
public class CorporateTimeSummary implements Serializable {

    protected BigDecimal availableSickHours;
    protected BigDecimal availablePersonalHours;
    protected BigDecimal availableVacationHours;

    public CorporateTimeSummary() {
    }

    public CorporateTimeSummary(BigDecimal availableSickHours, BigDecimal availablePersonalHours, BigDecimal availableVacationHours) {
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
