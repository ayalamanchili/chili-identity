/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.Feedback;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author raghu
 */
@Entity
@XmlRootElement
public class Feedback extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;
    @Field
    @NotEmpty(message = "{feedbackmsg.not.empty.msg}")
    @Lob
    protected String feedbackmsg;
    @Field
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "SUB_TM_STMP")
    protected Date submitteddate;
    @Field
    protected String submittedby;

    public void setFeedbackmsg(String feedbackmsg) {
        this.feedbackmsg = feedbackmsg;
    }

    public void setSubmitteddate(Date submitteddate) {
        this.submitteddate = submitteddate;
    }

    public void setSubmittedby(String submittedby) {
        this.submittedby = submittedby;
    }

    public String getFeedbackmsg() {
        return feedbackmsg;
    }

    public Date getSubmitteddate() {
        return submitteddate;
    }

    public String getSubmittedby() {
        return submittedby;
    }

    @PrePersist
    @PreUpdate
    protected void populateAuditData() {
        this.setSubmitteddate(new Date());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        this.setSubmittedby(auth.getName());
    }
}
