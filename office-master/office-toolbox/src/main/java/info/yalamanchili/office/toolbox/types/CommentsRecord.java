/**
* System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
*/
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package info.yalamanchili.office.toolbox.types;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author Madhu.Badiginchala
*/
public class CommentsRecord {
    
    protected Long clientInfoId;
    protected String updatedBy;
    protected Date updatedDate;
    protected String comment;
    @Temporal(TemporalType.DATE)
    protected Date fromDate;
    @Temporal(TemporalType.DATE)
    protected Date toDate;

    public Long getClientInfoId() {
        return clientInfoId;
    }

    public void setClientInfoId(Long clientInfoId) {
        this.clientInfoId = clientInfoId;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    
    
    
}

