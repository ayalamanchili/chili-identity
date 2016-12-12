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
import info.yalamanchili.office.entity.profile.Sex;
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
import org.hibernate.validator.constraints.Email;
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

    @Past
    @Temporal(javax.persistence.TemporalType.DATE)
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

    public String getDlastName() {
        return dlastName;
    }

    public void setDlastName(String dlastName) {
        this.dlastName = dlastName;
    }

    
    public String getDmiddleName() {
        return dmiddleName;
    }
    
    public void setDmiddleName(String dmiddleName) {
        this.dmiddleName = dmiddleName;
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
        return "Dependent{" + "salutation=" + salutation +", dfirstName=" + dfirstName +", dmiddleName=" + dmiddleName + ", dlastName=" + dlastName + ", ddateOfBirth=" + ddateOfBirth + ", relationship=" + relationship + ", gender=" + gender + ", email=" + email + ", phoneNumber=" + phoneNumber +'}';
    }   
}