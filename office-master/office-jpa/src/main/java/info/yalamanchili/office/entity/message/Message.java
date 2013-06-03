/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.message;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Prashanthi
 */
@Indexed
@Entity
@Audited
public class Message extends AbstractEntity {

    @Field
    @NotEmpty(message = "{subject.not.empty.msg}")
    protected String subject;
    @Field
    protected String message;
    @Field
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Index(name="MSG_TM_STMP")
    protected Date messageTs;
    @ManyToMany
//    @NotEmpty(message = "{tos.not.empty.msg}")
    protected List<Employee> tos;
    @OneToMany
    protected List<Message> replies;
    @ManyToOne
    @ForeignKey(name = "FK_Employee_Messages")
    protected Employee fromEmp;

    public Message() {
        super();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageTs() {
        return messageTs;
    }

    public void setMessageTs(Date messageTs) {
        this.messageTs = messageTs;
    }

    @XmlElement
    public List<Employee> getTos() {
        if (this.tos == null) {
            this.tos = new ArrayList<Employee>();
        }
        return tos;
    }

    public void setTos(List<Employee> tos) {
        this.tos = tos;
    }

    public void addTo(Employee fromEmp) {
        this.getTos().add(fromEmp);
    }

    @XmlTransient
    public List<Message> getReplies() {
        return replies;
    }

    public void setReplies(List<Message> replies) {
        this.replies = replies;
    }

    @XmlElement
    public Employee getFromEmp() {
        return fromEmp;
    }

    public void setFromEmp(Employee fromEmp) {
        this.fromEmp = fromEmp;
    }

    @Override
    public String toString() {
        return "Message{" + "subject=" + subject + ", message=" + message + ", messageTs=" + messageTs + ", tos=" + tos + ", replies=" + replies + ", from=" + fromEmp + '}';
    }
}
