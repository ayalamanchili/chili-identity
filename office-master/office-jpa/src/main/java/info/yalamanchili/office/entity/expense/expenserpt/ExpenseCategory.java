/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.expenserpt;

import info.chili.jpa.AbstractEntity;
import info.chili.jpa.validation.Unique;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Prashanthi
 */
@Indexed
@XmlRootElement
@Entity
@Audited
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = ExpenseCategory.class, fields = {"name"}, message = "{expensecategory.name.not.unique.msg}")
public class ExpenseCategory extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "{expensecategory.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "EXPC_NM")
    protected String name;
    protected String description;

    public ExpenseCategory() {
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
        return "ExpenseCategory{" + "name=" + name + ",description=" + description + '}';
    }
}
