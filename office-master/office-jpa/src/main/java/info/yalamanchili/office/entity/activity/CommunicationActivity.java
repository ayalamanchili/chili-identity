/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.activity;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class CommunicationActivity extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{type.not.empty.msg}")
    protected CommunicationType type;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{mode.not.empty.msg}")
    protected CommunicationMode mode;
    @NotEmpty(message = "{subject.not.empty.msg}")
    protected String subject;
    @Lob
    protected String notes;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "COMM_ACT_TM_STMP")
    protected Date updatedTimeStamp;
    /*
     * activity created by empId
     */
    protected String createdBy;
    /*
     * Issue type
     */
    @ManyToOne
    @ForeignKey(name = "FK_IssueType_Activity")
    @NotNull(message = "{issueType.not.empty.msg}")
    protected IssueType issueType;
    /*
     * employee the activity is related to 
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_COMM_ACT")
    protected Employee employee;
    /* 
     * comments
     */
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    protected List<Comment> comments;

    public CommunicationType getType() {
        return type;
    }

    public void setType(CommunicationType type) {
        this.type = type;
    }

    public CommunicationMode getMode() {
        return mode;
    }

    public void setMode(CommunicationMode mode) {
        this.mode = mode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public void setUpdatedTimeStamp(Date updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @XmlTransient
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @PrePersist
    @PreUpdate
    protected void populateAuditData() {
        this.setUpdatedTimeStamp(new Date());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        this.setCreatedBy(auth.getName());
    }
}
