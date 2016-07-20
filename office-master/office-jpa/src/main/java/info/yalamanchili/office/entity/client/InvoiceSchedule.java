/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Ramana.Lukalapu
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class InvoiceSchedule extends AbstractEntity {

    private static final long serialVersionUID = 11L;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.cannot.be.empty}")
    private Date startDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{endDate.cannot.be.empty}")
    private Date endDate;

    @NotNull(message = "{reminderdays.cannot.be.empty}")
    private Integer reminderDays;

    @Lob
    protected String notes;

    public InvoiceSchedule() {
        super();
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

    public Integer getReminderDays() {
        return reminderDays;
    }

    public void setReminderDays(Integer reminderDays) {
        this.reminderDays = reminderDays;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "InvoiceSchedule{" + "startDate=" + startDate + ", endDate=" + endDate + ", reminderDays=" + reminderDays + ", notes=" + notes + '}';
    }
}
