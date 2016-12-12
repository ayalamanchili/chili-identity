/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author raghu
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class Todo extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;
    @Field
    @NotEmpty(message = "{todo.name.not.empty.msg}")
    protected String name;
    @Field
    protected String description;
    @Field
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date tododate;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_Todo")
    protected Employee employee;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getTododate() {
        return tododate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTododate(Date tododate) {
        this.tododate = tododate;
    }

    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Todo{" + "name=" + name + ", description=" + description + ", tododate=" + tododate + '}';
    }
}
