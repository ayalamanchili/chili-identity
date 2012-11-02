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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Prashanthi
 */
@Indexed
@Entity
@Audited
public class Message extends AbstractEntity {

    @Field
    protected String subject;
    @Field
    protected String message;
    @Field
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date messageTs;
    @OneToMany
    protected List<Employee> tos;
    @OneToMany
    protected List<Message> replies;
    @ManyToOne
    @ForeignKey(name = "FK_Employee_Messages")
    protected Employee from;

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
        this.tos.add(fromEmp);
    }

    public List<Message> getReplies() {
        return replies;
    }

    public void setReplies(List<Message> replies) {
        this.replies = replies;
    }

    public Employee getFrom() {
        return from;
    }

    public void setFrom(Employee from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Message{" + "subject=" + subject + ", message=" + message + ", messageTs=" + messageTs + ", tos=" + tos + ", replies=" + replies + ", from=" + from + '}';
    }
}
