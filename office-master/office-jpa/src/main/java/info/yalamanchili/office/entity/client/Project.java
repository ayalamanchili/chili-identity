/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class Project extends AbstractEntity {

    @NotEmpty(message = "{project.not.empty.msg}")
    protected String name;
    protected String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{startDate.not.empty.msg}")
    protected Date startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{endDate.not.empty.msg}")
    protected Date endDate;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Client_Projects")
    protected Client client;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    protected List<StatementOfWork> SOWS;

    @org.hibernate.annotations.Index(name = "PRJ_NM")
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

    public void setSOWS(List<StatementOfWork> SOWS) {
        this.SOWS = SOWS;
    }

    @XmlTransient
    public List<StatementOfWork> getSOWS() {
        if (this.SOWS == null) {
            this.SOWS = new ArrayList<StatementOfWork>();
        }
        return this.SOWS;
    }

    public void addSOW(StatementOfWork entity) {
        if (entity == null) {
            return;
        }
        getSOWS().add(entity);
        entity.setProject(this);
    }

    @Override
    public String toString() {
        return "Project{" + "name=" + name + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", client=" + client + '}';
    }
}
