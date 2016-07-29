/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractHandleEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Ramana.Lukalapu
 */
@Indexed
@XmlRootElement
@Entity
@XmlType
@Audited
public class InvoiceSchedule extends AbstractHandleEntity {

    private static final long serialVersionUID = 1L;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.cannot.be.empty}")
    private Date startDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{endDate.cannot.be.empty}")
    private Date endDate;

    @NotNull(message = "{reminderdays.cannot.be.empty}")
    private Integer reminderDays;

    @NotNull(message = "{notifyEmployees.cannot.be.empty}")
    private String notifyEmployees;

    @Lob
    protected String notes;

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

    public String getNotifyEmployees() {
        return notifyEmployees;
    }

    public void setNotifyEmployees(String notifyEmployees) {
        this.notifyEmployees = notifyEmployees;
    }

    @Override
    public String toString() {
        return "InvoiceSchedule{" + "startDate=" + startDate + ", endDate=" + endDate + ", reminderDays=" + reminderDays + ", notifyEmployees=" + notifyEmployees + ", notes=" + notes + '}';
    }

}
