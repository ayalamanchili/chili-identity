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
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ayalamanchili
 */
@Document(collection = "timerecords")
@XmlRootElement
@XmlType
public class TimeRecord extends AbstractDocument {

    /**
     *
     */
    @Indexed
    protected String employeeId;
    /**
     *
     */
    @Indexed
    protected Date startDate;
    /**
     *
     */
    @Indexed
    protected Date endDate;
    /**
     *
     */
    protected BigDecimal hours;
    /**
     *
     */
    protected TimeRecordStatus status;
    /**
     *
     */
    protected TimeRecordCategory category;
    /**
     *
     */
    protected String notes;
    /**
     *
     */
    protected Map<String, BigDecimal> tags;

    public TimeRecord() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public TimeRecordStatus getStatus() {
        return status;
    }

    public void setStatus(TimeRecordStatus status) {
        this.status = status;
    }

    public TimeRecordCategory getCategory() {
        return category;
    }

    public void setCategory(TimeRecordCategory category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Map<String, BigDecimal> getTags() {
        if (tags == null) {
            this.tags = new HashMap<>();
        }
        return tags;
    }

    public void setTags(Map<String, BigDecimal> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TimeRecord{" + "employeeId=" + employeeId + ", startDate=" + startDate + ", endDate=" + endDate + ", hours=" + hours + ", status=" + status + ", category=" + category + ", notes=" + notes + ", tags=" + tags + '}';
    }

    @XmlRootElement
    @XmlType
    public static class TimeRecordsTable implements java.io.Serializable {

        protected Long size;
        protected List<TimeRecord> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<TimeRecord> getEntities() {
            return entities;
        }

        public void setEntities(List<TimeRecord> entities) {
            this.entities = entities;
        }
    }
}
