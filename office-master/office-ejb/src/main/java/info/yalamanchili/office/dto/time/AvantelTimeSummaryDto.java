/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.time;

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
public class AvantelTimeSummaryDto {

    private String employee;
    private BigDecimal receptionHours;
    private BigDecimal secondFloorHours;
    private BigDecimal cubicalHours;
    private BigDecimal availablePaidTimeOffHours;
//  protected BigDecimal monthlyAccuredHours;
//  protected BigDecimal totalavailablePTOHours;
//  protected BigDecimal usedPTOHours;
    private Date startDate;
    private Date endDate;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public BigDecimal getReceptionHours() {
        return receptionHours;
    }

    public void setReceptionHours(BigDecimal receptionHours) {
        this.receptionHours = receptionHours;
    }

    public BigDecimal getSecondFloorHours() {
        return secondFloorHours;
    }

    public void setSecondFloorHours(BigDecimal secondFloorHours) {
        this.secondFloorHours = secondFloorHours;
    }

    public BigDecimal getCubicalHours() {
        return cubicalHours;
    }

    public void setCubicalHours(BigDecimal cubicalHours) {
        this.cubicalHours = cubicalHours;
    }

    public BigDecimal getAvailablePaidTimeOffHours() {
        return availablePaidTimeOffHours;
    }

    public void setAvailablePaidTimeOffHours(BigDecimal availablePaidTimeOffHours) {
        this.availablePaidTimeOffHours = availablePaidTimeOffHours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public AvantelTimeSummaryDto() {
    }

}
