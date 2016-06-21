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
import javax.persistence.Temporal;
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

    
    protected Boolean doYouHoldAValidPassport;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date passportIssuedDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date passportExpiryDate;
    
   
    protected Boolean passportExpirationAlertIndicator;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateOfBirth;
    
    @Type(type = "encryptedString")
    protected String stateOfBirth;
    
    @Type(type = "encryptedString")
    protected String placeOfBirth;
    
    @Type(type = "encryptedString")
    protected String countryOfBirth;
    
    @Type(type = "encryptedString")
    protected String nationalityIs;
    
    @Type(type = "encryptedString")
    protected String countryOfNationality;
    
    @Type(type = "encryptedString")
    protected String passportCountryOfIssuance;
    
    @Type(type = "encryptedString")
    protected String passportStateOfIssuance;
    
    @Type(type = "encryptedString")
    protected String identificationMarks;
            
    @Type(type = "encryptedString")
    protected String haveYouEverLostPassport; 
    
    @Type(type = "encryptedString")
    protected String travelDocumentNumber;
    
    @Type(type = "encryptedString")
    protected String commentS;

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    
    public Boolean getDoYouHoldAValidPassport() {
        return doYouHoldAValidPassport;
    }

    public void setDoYouHoldAValidPassport(Boolean doYouHoldAValidPassport) {
        this.doYouHoldAValidPassport = doYouHoldAValidPassport;
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
    
    public Boolean getPassportExpirationAlertIndicator() {
        return passportExpirationAlertIndicator;
    }

    public void setPassportExpirationAlertIndicator(Boolean passportExpirationAlertIndicator) {
        this.passportExpirationAlertIndicator = passportExpirationAlertIndicator;
    }
    
    public String getPassportCountryOfIssuance() {
        return passportCountryOfIssuance;
    }

    public void setPassportCountryOfIssuance(String passportCountryOfIssuance) {
        this.passportCountryOfIssuance = passportCountryOfIssuance;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
    
    public String getCountryOfBirth() {
        return countryOfBirth;
    }
    
    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }
    
    public String getNationalityIs() {
        return nationalityIs;
    }
    
    public void setNationalityIs(String nationalityIs) {
        this.nationalityIs = nationalityIs;
    }
    
    public String getCountryOfNationality() {
        return countryOfNationality;
    }
    
    public void setCountryOfNationality(String countryOfNationality) {
        this.countryOfNationality = countryOfNationality;
    }
    
    public String getPassportStateOfIssuance() {
        return passportStateOfIssuance;
    }

    public void setPassportStateOfIssuance(String passportStateOfIssuance) {
        this.passportStateOfIssuance = passportStateOfIssuance;
    }

    public String getIdentificationMarks() {
        return identificationMarks;
    }

    public void setIdentificationMarks(String identificationMarks) {
        this.identificationMarks = identificationMarks;
    }
    
    public String getHaveYouEverLostPassport() {
        return haveYouEverLostPassport;
    }

    public void setHaveYouEverLostPassport(String haveYouEverLostPassport) {
        this.haveYouEverLostPassport = haveYouEverLostPassport;
    }
    
    public String getTravelDocumentNumber() {
        return travelDocumentNumber;
    }

    public void setTravelDocumentNumber(String travelDocumentNumber) {
        this.travelDocumentNumber = travelDocumentNumber;
    }
    
    public String getCommentS() {
        return commentS;
    }

    public void setCommentS(String commentS) {
        this.commentS = commentS;
    }
    
    @Override
    public String toString() {
        return "Passport{" + "passportNumber=" + passportNumber + ", doYouHoldAValidPassport=" + doYouHoldAValidPassport + ", passportIssuedDate=" + passportIssuedDate + ", passportExpiryDate=" + passportExpiryDate + ", passportExpirationAlertIndicator=" + passportExpirationAlertIndicator + ", passportCountryOfIssuance=" + passportCountryOfIssuance + ", dateOfBirth=" + dateOfBirth + ",stateOfBirth=" + stateOfBirth + ", placeOfBirth=" + placeOfBirth + ", countryOfBirth=" + countryOfBirth + ", nationalityIs=" + nationalityIs + ", countryOfNationality=" + countryOfNationality + ", passportStateOfIssuance=" + passportStateOfIssuance + ", identificationMarks=" + identificationMarks + ", haveYouEverLostPassport=" + haveYouEverLostPassport + ", travelDocumentNumber=" + travelDocumentNumber + ", commentS=" + commentS + '}';
    }

}
