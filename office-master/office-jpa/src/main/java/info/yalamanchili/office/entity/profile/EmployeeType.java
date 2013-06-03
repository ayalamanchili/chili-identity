/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.validation.Unique;
import info.chili.jpa.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Indexed
@XmlRootElement
@Entity
@Audited
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"name"}))
@Unique(entity = EmployeeType.class, fields = {"name"}, message = "{employeetype.name.not.unique.msg}")
public class EmployeeType extends AbstractEntity {

    @NotEmpty(message = "{employeetype.name.not.empty.msg}")
    protected String name;
    protected String description;

    public EmployeeType() {
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
        return "EmployeeType{" + "name=" + name + ", description=" + description + '}';
    }
}
