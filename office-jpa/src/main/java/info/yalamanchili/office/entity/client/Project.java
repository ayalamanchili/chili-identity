/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.yalamanchili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author ayalamanchili
 */
@Entity
@XmlRootElement
@XmlType
public class Project extends AbstractEntity {

    protected String name;
    protected String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date endDate;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Client_Projects")
    protected Client client;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Project{" + "name=" + name + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", client=" + client + '}';
    }
}
