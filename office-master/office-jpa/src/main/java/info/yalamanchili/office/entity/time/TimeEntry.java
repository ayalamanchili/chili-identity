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
    /**
     *
     */
    protected String location;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
