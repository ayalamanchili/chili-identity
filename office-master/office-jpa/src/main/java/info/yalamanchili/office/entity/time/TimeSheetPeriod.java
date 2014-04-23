/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class TimeSheetPeriod extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 1L;
    
    @NotEmpty(message = "{name.not.empty.msg}")
    @Field
    protected String name;
    @Temporal(javax.persistence.TemporalType.DATE)
    @org.hibernate.annotations.Index(name = "TME_PRD_STRT_DT")
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{endDate.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "TME_PRD_END_DT")
    protected Date endDate;
    @OneToMany(mappedBy = "timeSheetPeriod")
    protected List<TimeSheet> timeSheets;

    @org.hibernate.annotations.Index(name = "TME_PRD_NM")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @XmlTransient
    public List<TimeSheet> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<TimeSheet> timeSheets) {
        this.timeSheets = timeSheets;
    }

    @Override
    public String toString() {
        return "TimeSheetPeriod{" + "name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
}
