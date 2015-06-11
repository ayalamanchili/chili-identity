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

    protected String Employee;
    protected BigDecimal receptionHours;
    protected BigDecimal secondFloorHours;
    protected BigDecimal cubicalHours;
    protected BigDecimal availablePTOHours;
    protected BigDecimal monthlyAccuredHours;
    protected BigDecimal totalavailablePTOHours;
    protected BigDecimal usedPTOHours;
    protected Date startDate;
    protected Date endDate;
    

    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String Employee) {
        this.Employee = Employee;
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

    public BigDecimal getAvailablePTOHours() {
        return availablePTOHours;
    }

    public void setAvailablePTOHours(BigDecimal availablePTOHours) {
        this.availablePTOHours = availablePTOHours;
    }

    public BigDecimal getMonthlyAccuredHours() {
        return monthlyAccuredHours;
    }

    public void setMonthlyAccuredHours(BigDecimal monthlyAccuredHours) {
        this.monthlyAccuredHours = monthlyAccuredHours;
    }

    public BigDecimal getTotalavailablePTOHours() {
        return totalavailablePTOHours;
    }

    public void setTotalavailablePTOHours(BigDecimal totalavailablePTOHours) {
        this.totalavailablePTOHours = totalavailablePTOHours;
    }

    public BigDecimal getUsedPTOHours() {
        return usedPTOHours;
    }

    public void setUsedPTOHours(BigDecimal usedPTOHours) {
        this.usedPTOHours = usedPTOHours;
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
