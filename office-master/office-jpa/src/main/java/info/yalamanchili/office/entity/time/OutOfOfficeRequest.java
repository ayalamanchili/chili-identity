/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import info.chili.jpa.AbstractEntity;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ramana.Lukalapu
 */
@XmlType
@Indexed
@Entity
@Audited
@XmlRootElement
public class OutOfOfficeRequest extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @ForeignKey(name = "FK_Emp_OutOfOfficeReqs")
    protected Employee employee;

    @NotNull(message = "{outofoffice.startDate.not.empty.msg}")
    @Temporal(TemporalType.DATE)
    protected Date startDate;

    @NotNull(message = "{outofoffice.endDate.not.empty.msg}")
    @Temporal(TemporalType.DATE)
    protected Date endDate;

    @Lob
    @NotEmpty(message = "{outofoffice.reason.not.empty.msg}")
    protected String reason;

    protected String time;

    protected String notes;

    @NotNull(message = "{outofoffice.type.not.empty.msg}")
    @Enumerated(EnumType.STRING)
    protected OutOfOfficeType outOfOfficeType;

    protected Boolean recurring;

    protected String bpmProcessId;

    @Enumerated(EnumType.STRING)
    @Field
    private OutOfOfficeRequestStatus status;

    @Transient
    protected List<Entry> notifyEmployees;

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public OutOfOfficeType getOutOfOfficeType() {
        return outOfOfficeType;
    }

    public void setOutOfOfficeType(OutOfOfficeType outOfOfficeType) {
        this.outOfOfficeType = outOfOfficeType;
    }

    public Boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    public OutOfOfficeRequestStatus getStatus() {
        return status;
    }

    public void setStatus(OutOfOfficeRequestStatus status) {
        this.status = status;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    @XmlElement
    public List<Entry> getNotifyEmployees() {
        return notifyEmployees;
    }

    public void setNotifyEmployees(List<Entry> notifyEmployees) {
        this.notifyEmployees = notifyEmployees;
    }

    @Override
    public String toString() {
        return "OutOfOfficeRequest{" + "employee=" + employee + ", startDate=" + startDate + ", endDate=" + endDate + ", reason=" + reason + ", time=" + time + ", notes=" + notes + ", outOfOfficeType=" + outOfOfficeType + ", recurring=" + recurring + ", bpmProcessId=" + bpmProcessId + ", status=" + status + '}';
    }
    
    public String describe() {
        return "Employee=" + employee.getFirstName() + " " + employee.getLastName() + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", time=" + time;
    }
}
