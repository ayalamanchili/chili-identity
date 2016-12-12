/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.selfserv;

import info.chili.commons.HtmlUtils;
import info.chili.jpa.AbstractEntity;
import info.chili.security.domain.CRole;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class ServiceTicket extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 99993L;
    /**
     * service ticket subject/title/name
     */
    @NotEmpty(message = "{serviceticket.subject.not.empty.msg}")
    protected String subject;
    /**
     * Ticket description
     */
    @Lob
    protected String description;
    /**
     * Service ticket type
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{serviceticket.type.not.empty.msg}")
    protected TicketType type;
    /**
     * Service ticket status
     */
    @Enumerated(EnumType.STRING)
    protected TicketStatus status;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name = "SRV_TKT_CRT_TM_STMP")
    protected Date createdTimeStamp;
    /**
     * Department who is responsible/working on this ticket
     */
    @OneToOne
    protected CRole departmentAssigned;
    /**
     * employee in the dept who is working/assigned on the ticket
     */
    @OneToOne
    @ForeignKey(name = "FK_SRV_TKT_ASSIGN_TO")
    protected Employee assignedTo;
    /**
     * employee who created the ticket
     */
    @ManyToOne
    @ForeignKey(name = "FK_Employee_SRV_TKTS")
    protected Employee employee;
    /**
     * BPM create service ticket processId
     */
    protected String bpmProcessId;
    /**
     * Ticket comments
     */
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    protected List<TicketComment> comments;

    /**
     * Getters and setters
     */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    @XmlElement
    public CRole getDepartmentAssigned() {
        return departmentAssigned;
    }

    public void setDepartmentAssigned(CRole departmentAssigned) {
        this.departmentAssigned = departmentAssigned;
    }

    @XmlElement
    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getBpmProcessId() {
        return bpmProcessId;
    }

    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    @XmlTransient
    public List<TicketComment> getComments() {
        return comments;
    }

    public void setComments(List<TicketComment> comments) {
        this.comments = comments;
    }

    public String descriptionToText() {
        return HtmlUtils.htmlToText(getDescription());
    }
    /**
     *
     */
    @Transient
    protected String ticketNumber;

    public String getTicketNumber() {
        return "SST-" + String.format("%04d", getId());
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

}
