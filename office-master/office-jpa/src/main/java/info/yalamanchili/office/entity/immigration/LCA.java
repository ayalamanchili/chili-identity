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
import info.yalamanchili.office.entity.profile.Address;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
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
public class LCA extends AbstractHandleEntity {

    private static final long serialVersionUID = 11L;

    @OneToOne(cascade = CascadeType.ALL)
    protected Address lcaAddress1;

    @OneToOne(cascade = CascadeType.ALL)
    protected Address lcaAddress2;

    @Enumerated(EnumType.STRING)
    protected LCAWageLevels lcaPrevWageLvl;

    protected BigDecimal lcaPrevMinWage;

    protected BigDecimal lcaPrevMaxWage;

    @Enumerated(EnumType.STRING)
    protected LCAWageLevels lcaCurrWageLvl;

    protected BigDecimal lcaCurrMinWage;

    protected BigDecimal lcaCurrMaxWage;

    protected String jobTitle;

    @org.hibernate.annotations.Index(name = "LCA_NBR")
    protected String lcaNumber;

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

    public Address getLcaAddress1() {
        return lcaAddress1;
    }

    public void setLcaAddress1(Address lcaAddress1) {
        this.lcaAddress1 = lcaAddress1;
    }

    public Address getLcaAddress2() {
        return lcaAddress2;
    }

    public void setLcaAddress2(Address lcaAddress2) {
        this.lcaAddress2 = lcaAddress2;
    }

    public LCAWageLevels getLcaPrevWageLvl() {
        return lcaPrevWageLvl;
    }

    public void setLcaPrevWageLvl(LCAWageLevels lcaPrevWageLvl) {
        this.lcaPrevWageLvl = lcaPrevWageLvl;
    }

    public BigDecimal getLcaPrevMinWage() {
        return lcaPrevMinWage;
    }

    public void setLcaPrevMinWage(BigDecimal lcaPrevMinWage) {
        this.lcaPrevMinWage = lcaPrevMinWage;
    }

    public BigDecimal getLcaPrevMaxWage() {
        return lcaPrevMaxWage;
    }

    public void setLcaPrevMaxWage(BigDecimal lcaPrevMaxWage) {
        this.lcaPrevMaxWage = lcaPrevMaxWage;
    }

    public LCAWageLevels getLcaCurrWageLvl() {
        return lcaCurrWageLvl;
    }

    public void setLcaCurrWageLvl(LCAWageLevels lcaCurrWageLvl) {
        this.lcaCurrWageLvl = lcaCurrWageLvl;
    }

    public BigDecimal getLcaCurrMinWage() {
        return lcaCurrMinWage;
    }

    public void setLcaCurrMinWage(BigDecimal lcaCurrMinWage) {
        this.lcaCurrMinWage = lcaCurrMinWage;
    }

    public BigDecimal getLcaCurrMaxWage() {
        return lcaCurrMaxWage;
    }

    public void setLcaCurrMaxWage(BigDecimal lcaCurrMaxWage) {
        this.lcaCurrMaxWage = lcaCurrMaxWage;
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

    @Override
    public String toString() {
        return "LCA{" + "lcaNumber=" + lcaNumber + ", lcaFiledDate=" + lcaFiledDate + ", lcaValidFromDate=" + lcaValidFromDate + ", lcaValidToDate=" + lcaValidToDate + '}';
    }

}
