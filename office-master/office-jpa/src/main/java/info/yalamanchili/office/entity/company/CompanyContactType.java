/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.company;

import info.chili.jpa.AbstractEntity;
import info.chili.jpa.validation.Unique;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"name"}))
@Unique(entity = CompanyContactType.class, fields = {"name"}, message = "{companycontacttype.name.not.unique.msg}")
public class CompanyContactType extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 1L;
    
    @Field
    @NotEmpty(message = "{companycontacttype.name.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "CMP_CNT_TP_NM")
    protected String name;
    protected String description;

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
        return "CompanyContactType{" + "name=" + name + ", desctiption=" + description + '}';
    }
}
