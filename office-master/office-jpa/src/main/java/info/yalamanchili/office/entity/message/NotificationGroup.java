/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.message;

import info.chili.jpa.AbstractEntity;
import info.chili.jpa.validation.Unique;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = NotificationGroup.class, fields = {"name"}, message = "{notificationgroup.name.not.unique.msg}")
@XmlRootElement
public class NotificationGroup extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    @Field
    @NotEmpty(message = "{name.not.empty.msg}")
    protected String name;
    @ManyToMany
    @ForeignKey(name = "FK_Employees_NotificationGroup")
    protected List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Employee> getEmployees() {
        if (this.employees == null) {
            this.employees = new ArrayList<Employee>();
        }

        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "NotificationGroup{" + "name=" + name + '}';
    }

}
