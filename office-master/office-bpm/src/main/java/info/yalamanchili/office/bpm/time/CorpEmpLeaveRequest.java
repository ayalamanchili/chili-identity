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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class CorpEmpLeaveRequest implements Serializable {

    @NotNull(message = "{corpemp.leave.request.startDate.not.null.msg}")
//    @Future(message = "{corpemp.leave.request.startDate.future.msg}")
    protected Date startDate;
    @NotNull(message = "{corpemp.leave.request.endDate.not.null.msg}")
//    @Future(message = "{corpemp.leave.request.endDate.future.msg}")
    protected Date endDate;
    @NotNull(message = "{corpemp.leave.request.hours.not.null.msg}")
    @DecimalMin("1")
    protected BigDecimal hours;
    @NotNull(message = "{corpemp.leave.request.category.not.null.msg}")
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

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
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
