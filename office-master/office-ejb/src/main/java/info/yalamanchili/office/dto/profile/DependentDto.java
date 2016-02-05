/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.Relationship;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement(name = "Dependent")
@XmlType
public class DependentDto implements Serializable {

    protected Long id;
    
    @NotEmpty(message = "{firstName.not.empty.msg}")
    private String dfirstName;

    @NotEmpty(message = "{lastName.not.empty.msg}")
    private String dlastName;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @NotNull(message = "{dateOfBirth.not.empty.msg}")
    private Date ddateOfBirth;

    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{relation.not.empty.msg}")
    private Relationship relationship;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "DependentDto{" + "id=" + id + ", dfirstName=" + dfirstName + ", dlastName=" + dlastName + ", ddateOfBirth=" + ddateOfBirth + ", relationship=" + relationship + '}';
    }

    //TODO move this to seperate class?
    public static DependentDto map(Mapper mapper, Dependent entity) {
        DependentDto dependent = mapper.map(entity, DependentDto.class);
        mapper.map(entity, dependent);
        if (entity.getRelationship() != null) {
            dependent.setRelationship(entity.getRelationship());
        }
        dependent.setId(entity.getId());
        return dependent;
    }
}