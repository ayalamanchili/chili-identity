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
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Sudha
 */
@Indexed
@XmlRootElement
@Entity
@Audited

public class EducationRecord  extends AbstractHandleEntity {
    
    @Transient
    private static final long serialVersionUID = 4L;
        
    @NotEmpty(message = "{degreeOfStudy.not.empty.msg}")
    protected String degreeOfStudy;

    protected String fieldOfStudy;

    protected String nameOfSchool;
    
    protected String address;
    
    protected String graduationYear;
    
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

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }    
    
    @Override
    public String toString() {
        return "EducationRecord{" + "degreeOfStudy=" + degreeOfStudy + ", fieldOfStudy=" + fieldOfStudy + ", nameOfSchool=" + nameOfSchool + ", address=" + address + ", graduationYear=" + graduationYear + '}';
    }    
    
}
