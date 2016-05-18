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
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Ramana.Lukalapu
 */
@Indexed
@Entity
@XmlRootElement
public class OutOfOfficeRequest extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    protected Employee employee;
   
    protected Date startDate;
    
    protected Date endDate;
    
    protected String notes;
    
    protected String time;
    
    protected String contactNo;
    
    @Enumerated(EnumType.STRING)
    protected OutOfOfficeType outOfOffice;
    
    protected String recuuringNotes;
    
    @Enumerated(EnumType.STRING)
    private OutOfOfficeRequestStatus status;
    
    
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public OutOfOfficeType getOutOfOffice() {
        return outOfOffice;
    }

    public void setOutOfOffice(OutOfOfficeType outOfOffice) {
        this.outOfOffice = outOfOffice;
    }

    public String getRecuuringNotes() {
        return recuuringNotes;
    }

    public void setRecuuringNotes(String recuuringNotes) {
        this.recuuringNotes = recuuringNotes;
    }

    public OutOfOfficeRequestStatus getStatus() {
        return status;
    }

    public void setStatus(OutOfOfficeRequestStatus status) {
        this.status = status;
    }
}
