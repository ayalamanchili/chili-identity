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
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Kishore.Chigurupati
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class ImmigrationCaseAdditionalDetails extends AbstractHandleEntity {

    protected String currentOccupation;
    
    protected String nameOfEmployer;
    
    protected Integer noOfDependents;
    
    protected String countryOfCitizenship;

    public String getCurrentOccupation() {
        return currentOccupation;
    }

    public void setCurrentOccupation(String currentOccupation) {
        this.currentOccupation = currentOccupation;
    }

    public Integer getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(Integer noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    public String getNameOfEmployer() {
        return nameOfEmployer;
    }

    public void setNameOfEmployer(String nameOfEmployer) {
        this.nameOfEmployer = nameOfEmployer;
    }

    public String getCountryOfCitizenship() {
        return countryOfCitizenship;
    }

    public void setCountryOfCitizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    @Override
    public String toString() {
        return "ImmigrationCaseAdditionalDetails{" + "currentOccupation=" + currentOccupation + ", nameOfEmployer=" + nameOfEmployer + ", noOfDependents=" + noOfDependents + ", countryOfCitizenship=" + countryOfCitizenship + '}';
    }
}