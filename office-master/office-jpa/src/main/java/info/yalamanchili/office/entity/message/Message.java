/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.message;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Prashanthi
 */
@Indexed
@XmlRootElement
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
    @OneToMany(mappedBy = "employee")
    protected List<Employee> tos;
    @OneToMany(mappedBy = "employee")
    protected List<Employee> replies;
    @ManyToOne
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

    @XmlElement
    public List<Employee> getTos() {
        return tos;
    }

    public void setTos(List<Employee> tos) {
        this.tos = tos;
    }

    @XmlElement
    public List<Employee> getReplies() {
        return replies;
    }

    public void setReplies(List<Employee> replies) {
        this.replies = replies;
    }

    @XmlElement
    public Employee getFrom() {
        return from;
    }

    public void setFrom(Employee from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Messages{" + "subject=" + subject + ", message=" + message + ", messsageTs=" + messageTs + " , tos=" + tos + ", replies=" + replies + ", from=" + from + '}';
    }
}
