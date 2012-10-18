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
import javax.validation.constraints.Digits;
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
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal mondayPaidHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal mondayBilledHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal tuesdayPaidHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal tuesdayBilledHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal wednesdayPaidHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal wednesdayBilledHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal thursdayPaidHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal thursdayBilledHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal fridayPaidHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal fridayBilledHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal saturdayPaidHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal saturdayBilledHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal sundayPaidHours;
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal sundayBilledHours;
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

    public BigDecimal getMondayPaidHours() {
        return mondayPaidHours;
    }

    public void setMondayPaidHours(BigDecimal mondayPaidHours) {
        this.mondayPaidHours = mondayPaidHours;
    }

    public BigDecimal getMondayBilledHours() {
        return mondayBilledHours;
    }

    public void setMondayBilledHours(BigDecimal mondayBilledHours) {
        this.mondayBilledHours = mondayBilledHours;
    }

    public BigDecimal getTuesdayPaidHours() {
        return tuesdayPaidHours;
    }

    public void setTuesdayPaidHours(BigDecimal tuesdayPaidHours) {
        this.tuesdayPaidHours = tuesdayPaidHours;
    }

    public BigDecimal getTuesdayBilledHours() {
        return tuesdayBilledHours;
    }

    public void setTuesdayBilledHours(BigDecimal tuesdayBilledHours) {
        this.tuesdayBilledHours = tuesdayBilledHours;
    }

    public BigDecimal getWednesdayPaidHours() {
        return wednesdayPaidHours;
    }

    public void setWednesdayPaidHours(BigDecimal wednesdayPaidHours) {
        this.wednesdayPaidHours = wednesdayPaidHours;
    }

    public BigDecimal getWednesdayBilledHours() {
        return wednesdayBilledHours;
    }

    public void setWednesdayBilledHours(BigDecimal wednesdayBilledHours) {
        this.wednesdayBilledHours = wednesdayBilledHours;
    }

    public BigDecimal getThursdayPaidHours() {
        return thursdayPaidHours;
    }

    public void setThursdayPaidHours(BigDecimal thursdayPaidHours) {
        this.thursdayPaidHours = thursdayPaidHours;
    }

    public BigDecimal getThursdayBilledHours() {
        return thursdayBilledHours;
    }

    public void setThursdayBilledHours(BigDecimal thursdayBilledHours) {
        this.thursdayBilledHours = thursdayBilledHours;
    }

    public BigDecimal getFridayPaidHours() {
        return fridayPaidHours;
    }

    public void setFridayPaidHours(BigDecimal fridayPaidHours) {
        this.fridayPaidHours = fridayPaidHours;
    }

    public BigDecimal getFridayBilledHours() {
        return fridayBilledHours;
    }

    public void setFridayBilledHours(BigDecimal fridayBilledHours) {
        this.fridayBilledHours = fridayBilledHours;
    }

    public BigDecimal getSaturdayPaidHours() {
        return saturdayPaidHours;
    }

    public void setSaturdayPaidHours(BigDecimal saturdayPaidHours) {
        this.saturdayPaidHours = saturdayPaidHours;
    }

    public BigDecimal getSaturdayBilledHours() {
        return saturdayBilledHours;
    }

    public void setSaturdayBilledHours(BigDecimal saturdayBilledHours) {
        this.saturdayBilledHours = saturdayBilledHours;
    }

    public BigDecimal getSundayPaidHours() {
        return sundayPaidHours;
    }

    public void setSundayPaidHours(BigDecimal sundayPaidHours) {
        this.sundayPaidHours = sundayPaidHours;
    }

    public BigDecimal getSundayBilledHours() {
        return sundayBilledHours;
    }

    public void setSundayBilledHours(BigDecimal sundayBilledHours) {
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
        return "TimeSheet{" + "timeSheetCategory=" + timeSheetCategory + ", timeSheetStatus=" + timeSheetStatus + ", paidRate=" + paidRate + ", billedRate=" + billedRate + ", mondayPaidHours=" + mondayPaidHours + ", mondayBilledHours=" + mondayBilledHours + ", tuesdayPaidHours=" + tuesdayPaidHours + ", tuesdayBilledHours=" + tuesdayBilledHours + ", wednesdayPaidHours=" + wednesdayPaidHours + ", wednesdayBilledHours=" + wednesdayBilledHours + ", thursdayPaidHours=" + thursdayPaidHours + ", thursdayBilledHours=" + thursdayBilledHours + ", fridayPaidHours=" + fridayPaidHours + ", fridayBilledHours=" + fridayBilledHours + ", saturdayPaidHours=" + saturdayPaidHours + ", saturdayBilledHours=" + saturdayBilledHours + ", sundayPaidHours=" + sundayPaidHours + ", sundayBilledHours=" + sundayBilledHours + ", notes=" + notes + '}';
    }
}
