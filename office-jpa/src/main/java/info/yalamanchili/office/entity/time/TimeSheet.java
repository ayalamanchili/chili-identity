/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.client.StatementOfWork;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

/**
 *
 * @author ayalamanchili
 */
@Entity
@XmlRootElement
@XmlType
@Audited
public class TimeSheet extends AbstractEntity {

    @NotNull
    protected TimeSheetCategory timeSheetCategory;
    @NotNull
    protected TimeSheetStatus timeSheetStatus;
    protected BigDecimal paidRate;
    protected BigDecimal billedRate;
    protected Double mondayPaidHours;
    protected Double mondayBilledHours;
    protected Double tuesdayPaidHours;
    protected Double tuesdayBilledHours;
    protected Double wednesdayPaidHours;
    protected Double wednesdayBilledHours;
    protected Double thursdayPaidHours;
    protected Double thursdayBilledHours;
    protected Double fridayPaidHours;
    protected Double fridayBilledHours;
    protected Double saturdayPaidHours;
    protected Double saturdayBilledHours;
    protected Double sundayPaidHours;
    protected Double sundayBilledHours;
    protected String notes;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_TimeSheetPeriod_TimeSheets")
    protected TimeSheetPeriod timeSheetPeriod;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_StatementOfWork_TimeSheets")
    protected StatementOfWork statementOfWork;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_TimeSheets")
    protected Employee employee;

    public TimeSheetCategory getTimeSheetCategory() {
        return timeSheetCategory;
    }

    public void setTimeSheetCategory(TimeSheetCategory timeSheetCategory) {
        this.timeSheetCategory = timeSheetCategory;
    }

    public TimeSheetStatus getTimeSheetStatus() {
        return timeSheetStatus;
    }

    public void setTimeSheetStatus(TimeSheetStatus timeSheetStatus) {
        this.timeSheetStatus = timeSheetStatus;
    }

    public BigDecimal getPaidRate() {
        return paidRate;
    }

    public void setPaidRate(BigDecimal paidRate) {
        this.paidRate = paidRate;
    }

    public BigDecimal getBilledRate() {
        return billedRate;
    }

    public void setBilledRate(BigDecimal billedRate) {
        this.billedRate = billedRate;
    }

    public Double getMondayPaidHours() {
        return mondayPaidHours;
    }

    public void setMondayPaidHours(Double mondayPaidHours) {
        this.mondayPaidHours = mondayPaidHours;
    }

    public Double getMondayBilledHours() {
        return mondayBilledHours;
    }

    public void setMondayBilledHours(Double mondayBilledHours) {
        this.mondayBilledHours = mondayBilledHours;
    }

    public Double getTuesdayPaidHours() {
        return tuesdayPaidHours;
    }

    public void setTuesdayPaidHours(Double tuesdayPaidHours) {
        this.tuesdayPaidHours = tuesdayPaidHours;
    }

    public Double getTuesdayBilledHours() {
        return tuesdayBilledHours;
    }

    public void setTuesdayBilledHours(Double tuesdayBilledHours) {
        this.tuesdayBilledHours = tuesdayBilledHours;
    }

    public Double getWednesdayPaidHours() {
        return wednesdayPaidHours;
    }

    public void setWednesdayPaidHours(Double wednesdayPaidHours) {
        this.wednesdayPaidHours = wednesdayPaidHours;
    }

    public Double getWednesdayBilledHours() {
        return wednesdayBilledHours;
    }

    public void setWednesdayBilledHours(Double wednesdayBilledHours) {
        this.wednesdayBilledHours = wednesdayBilledHours;
    }

    public Double getThursdayPaidHours() {
        return thursdayPaidHours;
    }

    public void setThursdayPaidHours(Double thursdayPaidHours) {
        this.thursdayPaidHours = thursdayPaidHours;
    }

    public Double getThursdayBilledHours() {
        return thursdayBilledHours;
    }

    public void setThursdayBilledHours(Double thursdayBilledHours) {
        this.thursdayBilledHours = thursdayBilledHours;
    }

    public Double getFridayPaidHours() {
        return fridayPaidHours;
    }

    public void setFridayPaidHours(Double fridayPaidHours) {
        this.fridayPaidHours = fridayPaidHours;
    }

    public Double getFridayBilledHours() {
        return fridayBilledHours;
    }

    public void setFridayBilledHours(Double fridayBilledHours) {
        this.fridayBilledHours = fridayBilledHours;
    }

    public Double getSaturdayPaidHours() {
        return saturdayPaidHours;
    }

    public void setSaturdayPaidHours(Double saturdayPaidHours) {
        this.saturdayPaidHours = saturdayPaidHours;
    }

    public Double getSaturdayBilledHours() {
        return saturdayBilledHours;
    }

    public void setSaturdayBilledHours(Double saturdayBilledHours) {
        this.saturdayBilledHours = saturdayBilledHours;
    }

    public Double getSundayPaidHours() {
        return sundayPaidHours;
    }

    public void setSundayPaidHours(Double sundayPaidHours) {
        this.sundayPaidHours = sundayPaidHours;
    }

    public Double getSundayBilledHours() {
        return sundayBilledHours;
    }

    public void setSundayBilledHours(Double sundayBilledHours) {
        this.sundayBilledHours = sundayBilledHours;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TimeSheetPeriod getTimeSheetPeriod() {
        return timeSheetPeriod;
    }

    public void setTimeSheetPeriod(TimeSheetPeriod timeSheetPeriod) {
        this.timeSheetPeriod = timeSheetPeriod;
    }

    public StatementOfWork getStatementOfWork() {
        return statementOfWork;
    }

    public void setStatementOfWork(StatementOfWork statementOfWork) {
        this.statementOfWork = statementOfWork;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "TimeSheet{" + "timeSheetCategory=" + timeSheetCategory + ", timeSheetStatus=" + timeSheetStatus + ", paidRate=" + paidRate + ", billedRate=" + billedRate + ", mondayPaidHours=" + mondayPaidHours + ", mondayBilledHours=" + mondayBilledHours + ", tuesdayPaidHours=" + tuesdayPaidHours + ", tuesdayBilledHours=" + tuesdayBilledHours + ", wednesdayPaidHours=" + wednesdayPaidHours + ", wednesdayBilledHours=" + wednesdayBilledHours + ", thursdayPaidHours=" + thursdayPaidHours + ", thursdayBilledHours=" + thursdayBilledHours + ", fridayPaidHours=" + fridayPaidHours + ", fridayBilledHours=" + fridayBilledHours + ", saturdayPaidHours=" + saturdayPaidHours + ", saturdayBilledHours=" + saturdayBilledHours + ", sundayPaidHours=" + sundayPaidHours + ", sundayBilledHours=" + sundayBilledHours + ", notes=" + notes + ", timeSheetPeriod=" + timeSheetPeriod + ", statementOfWork=" + statementOfWork + '}';
    }
}
