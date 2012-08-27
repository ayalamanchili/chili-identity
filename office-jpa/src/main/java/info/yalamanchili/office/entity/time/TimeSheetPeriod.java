/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import info.yalamanchili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author ayalamanchili
 */
@Entity
public class TimeSheetPeriod extends AbstractEntity {

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull
    protected Date startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull
    protected Date endDate;
    @OneToMany(mappedBy = "timeSheetPeriod")
    protected List<TimeSheet> timeSheets;

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

    public List<TimeSheet> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<TimeSheet> timeSheets) {
        this.timeSheets = timeSheets;
    }

    @Override
    public String toString() {
        return "TimeSheetPeriod{" + "startDate=" + startDate + ", endDate=" + endDate + ", timeSheets=" + timeSheets + '}';
    }
}
