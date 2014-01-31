/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.yalamanchili.office.entity.time.TimeSheetCategory;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class CorpEmpLeaveRequest implements Serializable {

    protected Date startDate;
    protected Date endDate;
    protected BigDecimal horus;
    protected TimeSheetCategory category;
    protected String leaveRequestNotes;

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

    public BigDecimal getHorus() {
        return horus;
    }

    public void setHorus(BigDecimal horus) {
        this.horus = horus;
    }

    public TimeSheetCategory getCategory() {
        return category;
    }

    public void setCategory(TimeSheetCategory category) {
        this.category = category;
    }

    public String getLeaveRequestNotes() {
        return leaveRequestNotes;
    }

    public void setLeaveRequestNotes(String leaveRequestNotes) {
        this.leaveRequestNotes = leaveRequestNotes;
    }
    
    
    
}
