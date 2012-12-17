/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.client.StatementOfWork;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
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

            

    protected String notes;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_TimeSheetPeriod_TimeSheets")
    protected TimeSheetPeriod timeSheetPeriod;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_TimeSheets")
    protected Employee employee;

    
    protected BigDecimal quickBooksRate;
    
    @NotNull 
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal quickBooksHours;
    
    protected BigDecimal adpRate;
    
    @NotNull 
    @Digits(integer = 2, fraction = 2, message = "{tmesheet.hours.format.invalid.msg}")
    protected BigDecimal adpHours;
     
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{endDate.not.empty.msg}")
    protected Date endDate;
    
     
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "TimeSheet{" + "adpHours=" + adpHours + ", adpRate=" + adpRate + ", quickBooksHours=" + quickBooksHours + ", quickBooksRate=" + quickBooksRate +  ", timeSheetPeriod=" + timeSheetPeriod +", notes=" + notes + '}';
    }
    

    public void setAdpHours(BigDecimal adpHours) {
        this.adpHours = adpHours;
    }

    public void setQuickBooksHours(BigDecimal quickBooksHours) {
        this.quickBooksHours = quickBooksHours;
    }

    public void setAdpRate(BigDecimal adpRate) {
        this.adpRate = adpRate;
    }

    public void setQuickBooksRate(BigDecimal quickBooksRate) {
        this.quickBooksRate = quickBooksRate;
    }

    public BigDecimal getAdpHours() {
        return adpHours;
    }

    public BigDecimal getQuickBooksHours() {
        return quickBooksHours;
    }

    public BigDecimal getAdpRate() {
        return adpRate;
    }

    public BigDecimal getQuickBooksRate() {
        return quickBooksRate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
     
}
