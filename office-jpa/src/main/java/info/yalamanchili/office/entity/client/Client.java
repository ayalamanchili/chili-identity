/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.client;

import info.yalamanchili.jpa.AbstractEntity;
import javax.persistence.Entity;

/**
 *
 * @author ayalamanchili
 */
@Entity
public class Client extends AbstractEntity {

    protected String name;
    protected String description;
    //TODO
//    protected List<Contact> contacts;

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

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", description=" + description + '}';
    }
}
