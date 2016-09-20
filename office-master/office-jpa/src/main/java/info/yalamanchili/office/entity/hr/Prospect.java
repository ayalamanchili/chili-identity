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
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Contact;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
    @org.hibernate.annotations.Index(name = "PRSPCT_STRT_DT")
    protected Date startDate;

    protected String screenedBy;

    @NotEmpty(message = "{referredBy.not.empty.msg}")
    protected String referredBy;

    protected Long assigned;

    protected Long manager;

    protected String bpmProcessId;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date processDocSentDate;

    @Enumerated(EnumType.STRING)
    protected ProspectStatus status;

    @Enumerated(EnumType.STRING)
    protected PetitionFor petitionFiledFor;

    @Enumerated(EnumType.STRING)
    protected TransferEmployeeType trfEmpType;

    @Enumerated(EnumType.STRING)
    protected PlacedBy placedBy;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateOfJoining;

    @OneToMany(mappedBy = "prospect", cascade = CascadeType.ALL)
    protected Set<Resume> resumeURL;

    @OneToOne
    @ForeignKey(name = "FK_Company_Prospect")
    protected Company company;

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

    public ProspectStatus getStatus() {
        return status;
    }

    public PetitionFor getPetitionFiledFor() {
        return petitionFiledFor;
    }

    public void setPetitionFiledFor(PetitionFor petitionFiledFor) {
        this.petitionFiledFor = petitionFiledFor;
    }

    public TransferEmployeeType getTrfEmpType() {
        return trfEmpType;
    }

    public void setTrfEmpType(TransferEmployeeType trfEmpType) {
        this.trfEmpType = trfEmpType;
    }

    public PlacedBy getPlacedBy() {
        return placedBy;
    }

    public void setPlacedBy(PlacedBy placedBy) {
        this.placedBy = placedBy;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Long getAssigned() {
        return assigned;
    }

    public void setAssigned(Long assigned) {
        this.assigned = assigned;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    @XmlTransient
    public Set<Resume> getResumeURL() {
        if (this.resumeURL == null) {
            this.resumeURL = new HashSet();
        }
        return resumeURL;
    }

    public void setResumeURL(Set<Resume> resumeURL) {
        this.resumeURL = resumeURL;
    }

    public void addResume(Resume entity) {
        if (entity == null) {
            return;
        }
        getResumeURL().add(entity);
        entity.setProspect(this);
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    @XmlElement
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("</br>");
        description.append("<b>First Name    &nbsp;&nbsp;:</b> ").append(this.getContact().getFirstName()).append("</br>");
        description.append("<b>Last Name     &nbsp;&nbsp;:</b> ").append(this.getContact().getLastName()).append("</br>");
        description.append("<b>Referred By   :</b> ").append(this.getReferredBy()).append("</br>");
        description.append("<b>Status        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;:</b> ").append(this.getStatus()).append("</br>");
        return description.toString();
    }

    @Override
    public String toString() {
        return "Prospect{" + "contact=" + contact + ", startDate=" + startDate + ", screenedBy=" + screenedBy + ", referredBy=" + referredBy + ", processDocSentDate=" + processDocSentDate + ", status=" + status + ", petitionFiledFor=" + petitionFiledFor + ", trfEmpType=" + trfEmpType + ", placedBy=" + placedBy + ", dateOfJoining=" + dateOfJoining + '}';
    }
}
