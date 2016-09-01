/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile.insurance;

import info.chili.jpa.AbstractHandleEntity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author prasanthi.p
 */
@Indexed
@XmlRootElement
@XmlType
@Entity
@Audited
public class InsuranceEnrollment extends AbstractHandleEntity {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    protected InsuranceType insuranceType;

    protected String comments;
    
    @NotEmpty(message = "{insuranceEnrollment.year.not.empty.msg}")
    protected String year;

    /**
     * @return the insuranceType
     */
    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    /**
     * @param insuranceType the insuranceType to set
     */
    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "InsuranceEnrollment{" + "insuranceType=" + insuranceType + ", comments=" + comments + ", year=" + year + '}';
    }
}
