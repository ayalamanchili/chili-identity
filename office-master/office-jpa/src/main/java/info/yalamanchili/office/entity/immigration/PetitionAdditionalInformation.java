/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.hr.PetitionFor;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Madhu.Badiginchala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class PetitionAdditionalInformation extends AbstractEntity {

    private static final long serialVersionUID = 2L;

    @Enumerated(EnumType.STRING)
    protected Polar h4Applicability;

    @Enumerated(EnumType.STRING)
    protected PetitionFor project;

    @Enumerated(EnumType.STRING)
    protected Polar sisterCompanyLetterUsed;

    @org.hibernate.annotations.Index(name = "PET_ADD_TRK_NUM")
    protected String petitionTrackingNumber;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date petitionFolderMailedDate;

    @org.hibernate.annotations.Index(name = "PET_ADD_MAIL_TRK_NUM")
    protected String petitionFolderMailTrkNbr;

    @OneToOne(cascade = CascadeType.MERGE)
    protected Petition petition;

    public Polar getH4Applicability() {
        return h4Applicability;
    }

    public void setH4Applicability(Polar h4Applicability) {
        this.h4Applicability = h4Applicability;
    }

    public PetitionFor getProject() {
        return project;
    }

    public void setProject(PetitionFor project) {
        this.project = project;
    }

    public Polar getSisterCompanyLetterUsed() {
        return sisterCompanyLetterUsed;
    }

    public void setSisterCompanyLetterUsed(Polar sisterCompanyLetterUsed) {
        this.sisterCompanyLetterUsed = sisterCompanyLetterUsed;
    }

    public String getPetitionTrackingNumber() {
        return petitionTrackingNumber;
    }

    public void setPetitionTrackingNumber(String petitionTrackingNumber) {
        this.petitionTrackingNumber = petitionTrackingNumber;
    }

    public Date getPetitionFolderMailedDate() {
        return petitionFolderMailedDate;
    }

    public void setPetitionFolderMailedDate(Date petitionFolderMailedDate) {
        this.petitionFolderMailedDate = petitionFolderMailedDate;
    }

    public String getPetitionFolderMailTrkNbr() {
        return petitionFolderMailTrkNbr;
    }

    public void setPetitionFolderMailTrkNbr(String petitionFolderMailTrkNbr) {
        this.petitionFolderMailTrkNbr = petitionFolderMailTrkNbr;
    }

    @XmlTransient
    public Petition getPetition() {
        return petition;
    }

    public void setPetition(Petition petition) {
        this.petition = petition;
    }

    @Override
    public String toString() {
        return "PetitionAdditionalInformation{" + "petitionTrackingNumber=" + petitionTrackingNumber + ", petitionFolderMailedDate=" + petitionFolderMailedDate + ", petitionFolderMailTrkNbr=" + petitionFolderMailTrkNbr + '}';
    }

}
