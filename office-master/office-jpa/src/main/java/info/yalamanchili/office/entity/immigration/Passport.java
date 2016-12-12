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
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Madhu.Badiginchala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class Passport extends AbstractHandleEntity {

    private static final long serialVersionUID = 11L;

    @NotEmpty(message = "{passportNumber.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "PASSPORT_NBR")
    @Type(type = "encryptedString")
    protected String passportNumber;

   
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{passportIssuedDate.not.empty.msg}")
    protected Date passportIssuedDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{passportExpiryDate.not.empty.msg}")
    protected Date passportExpiryDate;
   
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{dateOfBirth.not.empty.msg}")
    protected Date dateOfBirth;
    
    
    protected String countryOfBirth;
    
    
    protected String stateOfBirth;
    
   
    protected String placeOfBirth;
    
    
    protected String nationality;
    
    
    protected String countryOfNationality;
    
    @NotEmpty(message = "{passportCountryOfIssuance.not.empty.msg}")
    protected String passportCountryOfIssuance;
    
    
    protected String passportStateOfIssuance;
    
    @Lob
    protected String identificationMarks;
            
    
    protected Boolean haveYouEverLostPassport; 
    
    protected String reason;
    
    protected String travelDocumentNumber;
    

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    
    public Date getPassportIssuedDate() {
        return passportIssuedDate;
    }

    public void setPassportIssuedDate(Date passportIssuedDate) {
        this.passportIssuedDate = passportIssuedDate;
    }

    public Date getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public void setPassportExpiryDate(Date passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
    }
   
    public String getPassportCountryOfIssuance() {
        return passportCountryOfIssuance;
    }

    public void setPassportCountryOfIssuance(String passportCountryOfIssuance) {
        this.passportCountryOfIssuance = passportCountryOfIssuance;
    }
    
    public String getPassportStateOfIssuance() {
        return passportStateOfIssuance;
    }

    public void setPassportStateOfIssuance(String passportStateOfIssuance) {
        this.passportStateOfIssuance = passportStateOfIssuance;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getCountryOfBirth() {
        return countryOfBirth;
    }
    
    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }
    
    public String getStateOfBirth() {
        return stateOfBirth;
    }
    
    public void setStateOfBirth(String stateOfBirth) {
        this.stateOfBirth = stateOfBirth;
    }
    
    public String getPlaceOfBirth() {
        return  placeOfBirth;
    }
    
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    } 
        
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getCountryOfNationality() {
        return countryOfNationality;
    }
    
    public void setCountryOfNationality(String countryOfNationality) {
        this.countryOfNationality = countryOfNationality;
    }
    
    public String getIdentificationMarks() {
        return identificationMarks;
    }

    public void setIdentificationMarks(String identificationMarks) {
        this.identificationMarks = identificationMarks;
    }
    
    public Boolean getHaveYouEverLostPassport() {
        return haveYouEverLostPassport;
    }

    public void setHaveYouEverLostPassport(Boolean haveYouEverLostPassport) {
        this.haveYouEverLostPassport = haveYouEverLostPassport;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getTravelDocumentNumber() {
        return travelDocumentNumber;
    }
    
    public void setTravelDocumentNumber(String travelDocumentNumber) {
        this.travelDocumentNumber = travelDocumentNumber;
    }
    
    @Override
    public String toString() {
        return "Passport{" + "passportNumber=" + passportNumber + ", passportIssuedDate=" + passportIssuedDate + ", passportExpiryDate=" + passportExpiryDate + ", passportCountryOfIssuance=" + passportCountryOfIssuance + ", passportStateOfIssuance=" + passportStateOfIssuance + ", dateOfBirth=" + dateOfBirth + ", countryOfBirth=" + countryOfBirth + ",stateOfBirth=" + stateOfBirth + ", placeOfBirth=" + placeOfBirth  + ", nationality=" + nationality + ", countryOfNationality=" + countryOfNationality +  ", identificationMarks=" + identificationMarks + ", haveYouEverLostPassport=" + haveYouEverLostPassport + ", reason=" + reason + ", travelDocumentNumber=" + travelDocumentNumber + '}';
    }

}
