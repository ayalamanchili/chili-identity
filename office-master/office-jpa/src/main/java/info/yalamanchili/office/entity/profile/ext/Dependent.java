/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.ext;

import info.chili.jpa.AbstractHandleEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Madhu.Badiginchala
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class Dependent extends AbstractHandleEntity {

    private static final long serialVersionUID = 1L;
    
    @NotEmpty(message = "{firstName.not.empty.msg}")
    private String dfirstName;
   
    @NotEmpty(message = "{lastName.not.empty.msg}")
    private String dlastName;

    @Past
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{dateOfBirth.not.empty.msg}")
    private Date ddateOfBirth;

    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{relation.not.empty.msg}")
    private Relationship relationship;

    public String getDfirstName() {
        return dfirstName;
    }

    public void setDfirstName(String dfirstName) {
        this.dfirstName = dfirstName;
    }

    public String getDlastName() {
        return dlastName;
    }

    public void setDlastName(String dlastName) {
        this.dlastName = dlastName;
    }

    public Date getDdateOfBirth() {
        return ddateOfBirth;
    }

    public void setDdateOfBirth(Date ddateOfBirth) {
        this.ddateOfBirth = ddateOfBirth;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }
}