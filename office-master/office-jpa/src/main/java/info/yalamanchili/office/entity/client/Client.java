/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import info.chili.jpa.validation.Unique;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
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
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"name"}))
@Unique(entity = Client.class, fields = {"name"}, message = "{client.name.not.unique.msg}")
public class Client extends AbstractEntity {

    @NotEmpty(message = "{client.not.empty.msg}")
    protected String name;
    protected String description;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    protected List<Project> projects;
    @ManyToMany
    protected List<Address> locations;
    @ManyToMany
    protected List<Contact> contacts;

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

    /**
     * @generated
     */
    @XmlTransient
    public List<Project> getProjects() {
        if (this.projects == null) {
            this.projects = new ArrayList<Project>();
        }
        return this.projects;
    }

    /**
     * @generated
     */
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project entity) {
        if (entity == null) {
            return;
        }
        getProjects().add(entity);
        entity.setClient(this);
    }

    public List<Address> getLocations() {
        return locations;
    }

    public void setLocations(List<Address> locations) {
        this.locations = locations;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }


    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", description=" + description + '}';
    }
}
