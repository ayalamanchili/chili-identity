/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.Relationship;
import info.yalamanchili.office.entity.profile.ext.Salutation;
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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement(name = "Dependent")
@XmlType
public class DependentDto implements Serializable {

    protected Long id;
    
    /**
     * Title
     */
    @Enumerated(EnumType.STRING)
    protected Salutation salutation;
    
    @NotEmpty(message = "{firstName.not.empty.msg}")
    private String dfirstName;

    @NotEmpty(message = "{lastName.not.empty.msg}")
    private String dlastName;
    
     /**
     *Middle Name
     */
    protected String dmiddleName;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @NotNull(message = "{dateOfBirth.not.empty.msg}")
    private Date ddateOfBirth;

    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{relation.not.empty.msg}")
    private Relationship relationship;
    
    /**
     *Gender
     */
    @Enumerated(EnumType.STRING)
    protected Sex gender;

    /**
     *Email
     */
    @Email(message = "Enter a valid email address ")
    protected String email;
    
    /**
     *Phone number
     */
    protected String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Salutation getSalutation() {
        return salutation;
    }

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }

    public String getDfirstName() {
        return dfirstName;
    }

    public void setDfirstName(String dfirstName) {
        this.dfirstName = dfirstName;
    }
    
    public String getDmiddleName() {
        return dmiddleName;
    }
    
    public void setDmiddleName(String dmiddleName) {
        this.dmiddleName = dmiddleName;
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
    
    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "DependentDto{" + "id=" + id + ", salutation=" + salutation +", dfirstName=" + dfirstName +", dmiddleName=" + dmiddleName + ", dlastName=" + dlastName + ", ddateOfBirth=" + ddateOfBirth + ", relationship=" + relationship + ", gender=" + gender + ", email=" + email + ", phoneNumber=" + phoneNumber +'}';
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