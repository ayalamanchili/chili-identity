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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Madhu.Badiginchala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class Petition extends AbstractHandleEntity {

    private static final long serialVersionUID = 11L;

    //@NotEmpty(message = "{firstName.not.empty.msg}")
    @Field
    protected String firstName;

    //@NotEmpty(message = "{lastName.not.empty.msg}")
    @Field
    protected String lastName;

    @org.hibernate.annotations.Index(name = "PET_USR_NME")
    protected String userName;

//    @ElementCollection
//    @CollectionTable(name="WorkedBy", joinColumns=@JoinColumn(name="id"))
//    @Column(name="workedBy")
    @org.hibernate.annotations.Index(name = "PET_WRK_BY")
    protected String workedBy;

    protected String attorneyName;

    @Enumerated(EnumType.STRING)
    protected VisaClassificationType visaClassification;

    @Enumerated(EnumType.STRING)
    protected VisaProcessingType visaProcessing;

    @Enumerated(EnumType.STRING)
    protected VisaStatus previousVisaStatus;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date previousStatusExpiry;

    @Enumerated(EnumType.STRING)
    protected Polar i140ApprovalStatus;

    @org.hibernate.annotations.Index(name = "PET_FILE_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date petitionFileDate;

    @org.hibernate.annotations.Index(name = "PET_RCPT_NUM")
    protected String receiptNumber;

    @Enumerated(EnumType.STRING)
    protected PetitionStatus petitionStatus;

    @org.hibernate.annotations.Index(name = "PET_APPR_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date petitionApprovalDate;

    @org.hibernate.annotations.Index(name = "PET_VALID_FROM_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date petitionValidFromDate;

    @org.hibernate.annotations.Index(name = "PET_VALID_TO_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date petitionValidToDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Petition_LCA")
    protected LCA lca;

    @OneToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_Petition_AddInfo")
    protected PetitionAdditionalInformation petitionaddinfo;

    @OneToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Petition_Passport")
    protected Passport passport;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAttorneyName() {
        return attorneyName;
    }

    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }

    public VisaClassificationType getVisaClassification() {
        return visaClassification;
    }

    public void setVisaClassification(VisaClassificationType visaClassification) {
        this.visaClassification = visaClassification;
    }

    public VisaProcessingType getVisaProcessing() {
        return visaProcessing;
    }

    public void setVisaProcessing(VisaProcessingType visaProcessing) {
        this.visaProcessing = visaProcessing;
    }

    public VisaStatus getPreviousVisaStatus() {
        return previousVisaStatus;
    }

    public void setPreviousVisaStatus(VisaStatus previousVisaStatus) {
        this.previousVisaStatus = previousVisaStatus;
    }

    public Date getPreviousStatusExpiry() {
        return previousStatusExpiry;
    }

    public void setPreviousStatusExpiry(Date previousStatusExpiry) {
        this.previousStatusExpiry = previousStatusExpiry;
    }

    public Polar getI140ApprovalStatus() {
        return i140ApprovalStatus;
    }

    public void setI140ApprovalStatus(Polar i140ApprovalStatus) {
        this.i140ApprovalStatus = i140ApprovalStatus;
    }

    public Date getPetitionFileDate() {
        return petitionFileDate;
    }

    public void setPetitionFileDate(Date petitionFileDate) {
        this.petitionFileDate = petitionFileDate;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public PetitionStatus getPetitionStatus() {
        return petitionStatus;
    }

    public void setPetitionStatus(PetitionStatus petitionStatus) {
        this.petitionStatus = petitionStatus;
    }

    public Date getPetitionApprovalDate() {
        return petitionApprovalDate;
    }

    public void setPetitionApprovalDate(Date petitionApprovalDate) {
        this.petitionApprovalDate = petitionApprovalDate;
    }

    public Date getPetitionValidFromDate() {
        return petitionValidFromDate;
    }

    public void setPetitionValidFromDate(Date petitionValidFromDate) {
        this.petitionValidFromDate = petitionValidFromDate;
    }

    public Date getPetitionValidToDate() {
        return petitionValidToDate;
    }

    public void setPetitionValidToDate(Date petitionValidToDate) {
        this.petitionValidToDate = petitionValidToDate;
    }

    public LCA getLca() {
        return lca;
    }

    public void setLca(LCA lca) {
        this.lca = lca;
    }

    public PetitionAdditionalInformation getPetitionaddinfo() {
        return petitionaddinfo;
    }

    public void setPetitionaddinfo(PetitionAdditionalInformation petitionaddinfo) {
        this.petitionaddinfo = petitionaddinfo;
    }

    public String getWorkedBy() {
        return workedBy;
    }

    public void setWorkedBy(String workedBy) {
        this.workedBy = workedBy;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Petition{" + "firstName=" + firstName + ", lastName=" + lastName + ", workedBy=" + workedBy + ", attorneyName=" + attorneyName + ", visaClassification=" + visaClassification + ", visaProcessing=" + visaProcessing + ", petitionFileDate=" + petitionFileDate + ", receiptNumber=" + receiptNumber + ", petitionStatus=" + petitionStatus + ", petitionApprovalDate=" + petitionApprovalDate + ", petitionValidFromDate=" + petitionValidFromDate + ", petitionValidToDate=" + petitionValidToDate + '}';
    }

}
