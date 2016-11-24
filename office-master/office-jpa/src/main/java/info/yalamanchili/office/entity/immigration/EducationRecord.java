/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.chili.jpa.AbstractHandleEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Sudha
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Indexed
@XmlRootElement
@Entity
@Audited

public class EducationRecord extends AbstractHandleEntity {

    private static final long serialVersionUID = 4L;

    @NotEmpty(message = "{degreeOfStudy.not.empty.msg}")
    protected String degreeOfStudy;

    protected String fieldOfStudy;

    protected String nameOfSchool;

    protected String address;

    @NotNull(message = "{dateDegreeAwarded.not.empty.msg}")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateDegreeAwarded;

    public String getDegreeOfStudy() {
        return degreeOfStudy;
    }

    public void setDegreeOfStudy(String degreeOfStudy) {
        this.degreeOfStudy = degreeOfStudy;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getNameOfSchool() {
        return nameOfSchool;
    }

    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateDegreeAwarded() {
        return dateDegreeAwarded;
    }

    public void setDateDegreeAwarded(Date dateDegreeAwarded) {
        this.dateDegreeAwarded = dateDegreeAwarded;
    }

    @Override
    public String toString() {
        return "EducationRecord{" + "degreeOfStudy=" + degreeOfStudy + ", fieldOfStudy=" + fieldOfStudy + ", nameOfSchool=" + nameOfSchool + ", address=" + address + ", dateDegreeRewarded=" + dateDegreeAwarded + '}';
    }
}
