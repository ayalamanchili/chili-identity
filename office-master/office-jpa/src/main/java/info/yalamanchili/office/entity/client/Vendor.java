/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.chili.jpa.AbstractEntity;
import info.chili.jpa.validation.Unique;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author raghu
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"name"}))
@Unique(entity = Vendor.class, fields = {"name"}, message = "{vendor.name.not.unique.msg}")
public class Vendor extends AbstractEntity {
    
    @NotEmpty(message = "{vendor.not.empty.msg}")
    protected String name;

    protected String description;
    
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Address> locations;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    protected List<Client> clients;

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }
    
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Contact> contacts;
    
     public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocations(List<Address> locations) {
        this.locations = locations;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Address> getLocations() {
        return locations;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
    
    @Override
    public String toString() {
        return "Vendor{" + "name=" + name + ", description=" + description + '}';
    }
}
