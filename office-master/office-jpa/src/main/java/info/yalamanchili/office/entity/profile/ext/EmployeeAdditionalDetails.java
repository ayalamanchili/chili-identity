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
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author Madhu.Badiginchala
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class EmployeeAdditionalDetails extends AbstractHandleEntity {
    
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @NotNull(message = "{referredBy.not.empty.msg}")
    protected String referredBy;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{maritalstatus.not.empty.msg}")
    protected MaritalStatus maritalStatus;
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected Ethnicity ethnicity;

    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected Ethnicity veteranStatus;
    
    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected Ethnicity disability;
    
    @Lob
    protected String rolesAndResponsibilities;

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }
    public Ethnicity getVeteranStatus() {
        return veteranStatus;
    }

    public void setVeteranStatus(Ethnicity veteranStatus) {
        this.veteranStatus = veteranStatus;
    }

    public Ethnicity getDisability() {
        return disability;
    }

    public void setDisability(Ethnicity disability) {
        this.disability = disability;
    }
    
    public String getRolesAndResponsibilities() {
        return rolesAndResponsibilities;
    }

    public void setRolesAndResponsibilities(String rolesAndResponsibilities) {
        this.rolesAndResponsibilities = rolesAndResponsibilities;
    }
}
