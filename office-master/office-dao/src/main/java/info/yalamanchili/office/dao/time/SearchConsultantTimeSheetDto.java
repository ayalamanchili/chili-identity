/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class SearchConsultantTimeSheetDto implements Serializable {

    protected Date startDate;
    protected Date endDate;
    protected List<TimeSheetStatus> status;
    protected List<TimeSheetCategory> category;
    protected String employee;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
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

    public List<TimeSheetStatus> getStatus() {
        return status;
    }

    public void setStatus(List<TimeSheetStatus> status) {
        this.status = status;
    }

    public List<TimeSheetCategory> getCategory() {
        return category;
    }

    public void setCategory(List<TimeSheetCategory> category) {
        this.category = category;
    }
}
