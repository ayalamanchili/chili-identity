/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.validation.Unique;
import info.yalamanchili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.security.CUser;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"name"}))
@Unique(entity = Skill.class, fields = {"name"}, message = "{skill.name.not.unique.msg}")
public class Skill extends AbstractEntity {

    @NotEmpty(message = "{skill.not.empty.msg}")
    protected String name;
    protected String description;

    public Skill() {
    }

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
        return "Skill{" + "name=" + name + ", description=" + description + '}';
    }
}
