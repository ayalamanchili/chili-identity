/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.time;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author prasanthi.p
 */
@XmlRootElement
@XmlType
public class TimeRecordSummary {

    protected String Employee;
    protected BigDecimal reception;
    protected BigDecimal secondndFloor;
    protected BigDecimal Cubical;
    protected BigDecimal availablePTOHours;
    protected BigDecimal monthlyAccuredHours;
    protected BigDecimal totalavailablePTOHours;
    protected BigDecimal usedPTOHours;

    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String Employee) {
        this.Employee = Employee;
    }

    public BigDecimal getReception() {
        return reception;
    }

    public void setReception(BigDecimal reception) {
        this.reception = reception;
    }

    public BigDecimal getSecondndFloor() {
        return secondndFloor;
    }

    public void setSecondndFloor(BigDecimal secondndFloor) {
        this.secondndFloor = secondndFloor;
    }

    public BigDecimal getCubical() {
        return Cubical;
    }

    public void setCubical(BigDecimal Cubical) {
        this.Cubical = Cubical;
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

    public TimeRecordSummary() {
    }
}
