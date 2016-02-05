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
import info.chili.jpa.AbstractHandleEntity;
import info.yalamanchili.office.entity.profile.Address;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
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
public class LCA extends AbstractHandleEntity {

    @Transient
    private static final long serialVersionUID = 11L;

    @OneToOne(cascade = CascadeType.ALL)
    protected Address lcaAddresse1;
    
    @OneToOne(cascade = CascadeType.ALL)
    protected Address lcaAddresse2;

    protected String prevPetitionLCAWages;

    protected String currPetitionLCAWages;

    protected String jobTitle;

    @org.hibernate.annotations.Index(name = "LCA_NBR")
    protected String lcaNumber;

    @org.hibernate.annotations.Index(name = "WTH_DRAWN_LCA_NBR")
    protected String withdrawnLCANumber;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaFiledDate;

    @org.hibernate.annotations.Index(name = "LCA_VALID_FROM_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaValidFromDate;

    @org.hibernate.annotations.Index(name = "LCA_VALID_TO_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lcaValidToDate;

    @OneToMany(mappedBy = "lca", cascade = CascadeType.MERGE)
    protected List<Petition> petitions;

    public Address getLcaAddresse1() {
        return lcaAddresse1;
    }

    public void setLcaAddresse1(Address lcaAddresse1) {
        this.lcaAddresse1 = lcaAddresse1;
    }

    public Address getLcaAddresse2() {
        return lcaAddresse2;
    }

    public void setLcaAddresse2(Address lcaAddresse2) {
        this.lcaAddresse2 = lcaAddresse2;
    }

    public String getPrevPetitionLCAWages() {
        return prevPetitionLCAWages;
    }

    public void setPrevPetitionLCAWages(String prevPetitionLCAWages) {
        this.prevPetitionLCAWages = prevPetitionLCAWages;
    }

    public String getCurrPetitionLCAWages() {
        return currPetitionLCAWages;
    }

    public void setCurrPetitionLCAWages(String currPetitionLCAWages) {
        this.currPetitionLCAWages = currPetitionLCAWages;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLcaNumber() {
        return lcaNumber;
    }

    public void setLcaNumber(String lcaNumber) {
        this.lcaNumber = lcaNumber;
    }

    public String getWithdrawnLCANumber() {
        return withdrawnLCANumber;
    }

    public void setWithdrawnLCANumber(String withdrawnLCANumber) {
        this.withdrawnLCANumber = withdrawnLCANumber;
    }

    public Date getLcaFiledDate() {
        return lcaFiledDate;
    }

    public void setLcaFiledDate(Date lcaFiledDate) {
        this.lcaFiledDate = lcaFiledDate;
    }

    public Date getLcaValidFromDate() {
        return lcaValidFromDate;
    }

    public void setLcaValidFromDate(Date lcaValidFromDate) {
        this.lcaValidFromDate = lcaValidFromDate;
    }

    public Date getLcaValidToDate() {
        return lcaValidToDate;
    }

    public void setLcaValidToDate(Date lcaValidToDate) {
        this.lcaValidToDate = lcaValidToDate;
    }

    @XmlTransient
    public List<Petition> getPetitions() {
        if (this.petitions == null) {
            this.petitions = new ArrayList<>();
        }
        return petitions;
    }

    public void setPetitions(List<Petition> petitions) {
        this.petitions = petitions;
    }

    public void addPetitions(Petition petition) {
        if (petition == null) {
            return;
        }
        getPetitions().add(petition);
    }

}
