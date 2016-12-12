/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.ext;

import info.chili.commons.StringUtils;
import info.chili.jpa.AbstractHandleEntity;
import info.chili.service.jrs.types.Entry;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class Comment extends AbstractHandleEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    protected Double rating;
    /**
     *
     *
     */
    @Lob
    protected String comment;
    /**
     *
     */
    protected String updatedBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "COMNT_TM_STMP")
    protected Date updatedTS;

    /**
     *
     */
    @Transient
    protected List<Entry> notifyEmployees;

    protected String stage;

    public Comment() {
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTS() {
        return updatedTS;
    }

    public void setUpdatedTS(Date updatedTS) {
        this.updatedTS = updatedTS;
    }

    public List<Entry> getNotifyEmployees() {
        return notifyEmployees;
    }

    public void setNotifyEmployees(List<Entry> notifyEmployees) {
        this.notifyEmployees = notifyEmployees;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @PrePersist
    @PreUpdate
    public void clean() {
        if (comment != null && (!comment.isEmpty())) {
            this.comment = StringUtils.convertToUTF8(comment);
        }
    }
}
