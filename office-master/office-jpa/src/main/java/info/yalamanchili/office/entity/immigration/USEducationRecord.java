/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author radhika.mukkala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class USEducationRecord extends EducationRecord {

    private String typeOfUSDegree;
    
    private String highestLevelOfEdu;

    public USEducationRecord() {
        super();
    }

    public String getTypeOfUSDegree() {
        return typeOfUSDegree;
    }

    public void setTypeOfUSDegree(String typeOfUSDegree) {
        this.typeOfUSDegree = typeOfUSDegree;
    }

    public String getHighestLevelOfEdu() {
        return highestLevelOfEdu;
    }

    public void setHighestLevelOfEdu(String highestLevelOfEdu) {
        this.highestLevelOfEdu = highestLevelOfEdu;
    }
}