/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ayalamanchili
 */
public class TimeEntry {

    /**
     *
     */
    protected String employeeId;
    /**
     *
     */
    protected Date entryDate;
    /**
     *
     */
    protected Date entryTimeStamp;
    
    public TimeEntry() {
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public Date getEntryDate() {
        return entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    
    public Date getEntryTimeStamp() {
        return entryTimeStamp;
    }
    
    public void setEntryTimeStamp(Date entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.employeeId);
        hash = 37 * hash + Objects.hashCode(this.entryDate);
        hash = 37 * hash + Objects.hashCode(this.entryTimeStamp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeEntry other = (TimeEntry) obj;
        if (!Objects.equals(this.employeeId, other.employeeId)) {
            return false;
        }
        if (!Objects.equals(this.entryDate, other.entryDate)) {
            return false;
        }
        if (!Objects.equals(this.entryTimeStamp, other.entryTimeStamp)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "TimeEntry{" + "employeeId=" + employeeId + ", entryDate=" + entryDate + ", entryTimeStamp=" + entryTimeStamp + '}';
    }
    SimpleDateFormat printFormat = new SimpleDateFormat("HH:mm:ss");
    
    public String describe() {
        
        return "TimeEntry{" + ", entryDate=" + entryDate + ", entryTime=" + printFormat.format(entryTimeStamp) + '}';
    }
}
