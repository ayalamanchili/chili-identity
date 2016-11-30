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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
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
public class i94Record extends AbstractHandleEntity {

    private static final long serialVersionUID = 11L;

    @NotEmpty(message = "{i94RecordNumber.not.empty.msg}")
    @org.hibernate.annotations.Index(name = "i94_RECORD_NBR")
    protected String i94RecordNumber;
    //Added new fields for I-94 by Sudha #SSTO-3063 and added getter setter methods
    protected String fullName;
    
    @NotNull(message = "{dateofEntry.not.empty.msg}")    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateofEntry;
    
    @NotEmpty(message = "{portOfEntry.not.empty.msg}")    
    protected String portOfEntry;
    
    protected String arrivalMethod;
    protected String modeOfTravel;

    @NotNull(message = "{i94ValidFromDate.not.empty.msg}")        
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date i94ValidFromDate;
        
    @NotNull(message = "{admitUntilDate.not.empty.msg}")            
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date admitUntilDate;

    protected Boolean durationValidityInd;
    
    protected Boolean expirationAlertInd;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date reentryExpiryDate;

    protected String coApplicantTravel;
    
    @NotEmpty(message = "{classOfAdmission.not.empty.msg}")                 
    protected String classOfAdmission;
    
    protected String comments;

    @Field
    protected String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPortOfEntry() {
        return portOfEntry;
    }

    public void setPortOfEntry(String portOfEntry) {
        this.portOfEntry = portOfEntry;
    }

    public String getClassOfAdmission() {
        return classOfAdmission;
    }

    public void setClassOfAdmission(String classOfAdmission) {
        this.classOfAdmission = classOfAdmission;
    }

    public String getI94RecordNumber() {
        return i94RecordNumber;
    }

    public void setI94RecordNumber(String i94RecordNumber) {
        this.i94RecordNumber = i94RecordNumber;
    }

    public Date getDateofEntry() {
        return dateofEntry;
    }

    public void setDateofEntry(Date dateofEntry) {
        this.dateofEntry = dateofEntry;
    }

    public Date getAdmitUntilDate() {
        return admitUntilDate;
    }

    public void setAdmitUntilDate(Date admitUntilDate) {
        this.admitUntilDate = admitUntilDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getArrivalMethod() {
        return arrivalMethod;
    }

    public void setArrivalMethod(String arrivalMethod) {
        this.arrivalMethod = arrivalMethod;
    }

    public String getModeOfTravel() {
        return modeOfTravel;
    }

    public void setModeOfTravel(String modeOfTravel) {
        this.modeOfTravel = modeOfTravel;
    }

    public Date getI94ValidFromDate() {
        return i94ValidFromDate;
    }

    public void setI94ValidFromDate(Date i94ValidFromDate) {
        this.i94ValidFromDate = i94ValidFromDate;
    }

    public Boolean getDurationValidityInd() {
        return durationValidityInd;
    }

    public void setDurationValidityInd(Boolean durationValidityInd) {
        this.durationValidityInd = durationValidityInd;
    }

    public Boolean getExpirationAlertInd() {
        return expirationAlertInd;
    }

    public void setExpirationAlertInd(Boolean expirationAlertInd) {
        this.expirationAlertInd = expirationAlertInd;
    }

    public Date getReentryExpiryDate() {
        return reentryExpiryDate;
    }

    public void setReentryExpiryDate(Date reentryExpiryDate) {
        this.reentryExpiryDate = reentryExpiryDate;
    }

    public String getCoApplicantTravel() {
        return coApplicantTravel;
    }

    public void setCoApplicantTravel(String coApplicantTravel) {
        this.coApplicantTravel = coApplicantTravel;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "i94Record{" + "i94RecordNumber=" + i94RecordNumber + ", dateofEntry=" + dateofEntry + ", admitUntilDate=" + admitUntilDate + ", portOfEntry=" + portOfEntry + ", classOfAdmission=" + classOfAdmission + ", imageURL=" + imageURL + '}';
    }
}
