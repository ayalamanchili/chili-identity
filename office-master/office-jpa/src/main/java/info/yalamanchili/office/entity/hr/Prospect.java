/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.hr;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Contact;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author radhika.mukkala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class Prospect extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_Contact_Prospect")
    @Valid
    protected Contact contact;
       
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date startDate;

    protected String screenedBy;
    
    @NotEmpty(message="{referredBy.not.empty.msg}")
    protected String referredBy;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date processDocSentDate;

    @NotEmpty(message = "{resumeUrl.not.empty.msg}")
    protected String resumeURL;

    @Enumerated(EnumType.STRING)
    protected ProspectStatus status;

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setScreenedBy(String screenedBy) {
        this.screenedBy = screenedBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public void setProcessDocSentDate(Date processDocSentDate) {
        this.processDocSentDate = processDocSentDate;
    }

    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }

    public void setStatus(ProspectStatus status) {
        this.status = status;
    }

    @XmlElement
    public Contact getContact() {
        return contact;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getScreenedBy() {
        return screenedBy;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public Date getProcessDocSentDate() {
        return processDocSentDate;
    }

    public String getResumeURL() {
        return resumeURL;
    }

    public ProspectStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Prospect{" + "contact=" + contact + ", startDate=" + startDate + ", screenedBy=" + screenedBy + ", referredBy=" + referredBy + ", processDocSentDate=" + processDocSentDate + ", resumeURL=" + resumeURL + ", status=" + status + '}';
    }
    
}
