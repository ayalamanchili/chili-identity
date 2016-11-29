/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Ramana.Lukalapu
 */
@XmlRootElement
@XmlType
public class EducationDto implements Serializable {

    private String fieldOfStudy;
    private String highestLevelOfEdu;
    private Integer noOfDependents;

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getHighestLevelOfEdu() {
        return highestLevelOfEdu;
    }

    public void setHighestLevelOfEdu(String highestLevelOfEdu) {
        this.highestLevelOfEdu = highestLevelOfEdu;
    }
    
    public Integer getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(Integer noOfDependents) {
        this.noOfDependents = noOfDependents;
    }
}