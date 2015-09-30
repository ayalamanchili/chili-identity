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
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
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
public class Prospect extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    
    @OneToOne(cascade = CascadeType.ALL)
    @ForeignKey(name="FK_Contact_Prospect")
    protected Contact contact;
       
     
    @NotEmpty(message = "{firstName.not.empty.msg}")
    @Field
    @org.hibernate.annotations.Index(name = "PROSPECT_FST_NM")
    protected String firstName;
   
    @NotEmpty(message = "{lastName.not.empty.msg}")
    @Field
    @org.hibernate.annotations.Index(name = "PROSPECT_LST_NM")
    protected String lastName;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date startDate;
    
    /*//@OneToMany(mappedBy = "prospect", cascade = CascadeType.ALL)
    protected String email;
    
    //@OneToMany(mappedBy = "prospect", cascade = CascadeType.ALL)
    protected int phone;*/
    
    protected String screenedBy;
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
     public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

 }
