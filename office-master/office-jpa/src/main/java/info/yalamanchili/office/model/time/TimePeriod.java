/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.model.time;

import info.chili.document.AbstractDocument;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ayalamanchili
 */
@Document(collection = "timeperiods")
@XmlRootElement
@XmlType
public class TimePeriod extends AbstractDocument {

    @XmlType
    public enum TimePeriodType {

        Month, Week, Year
    }

    @Indexed
    protected Date startDate;
    @Indexed
    protected Date endDate;
    @Indexed
    protected TimePeriodType type;

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

    public TimePeriodType getType() {
        return type;
    }

    public void setType(TimePeriodType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TimePeriod{" + "startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    public String describe() {
        return new SimpleDateFormat("dd-MMM-yyyy").format(startDate) + " - " + new SimpleDateFormat("dd-MMM-yyyy").format(endDate);
    }

}
