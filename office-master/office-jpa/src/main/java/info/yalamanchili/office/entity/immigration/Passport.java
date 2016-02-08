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
    protected String passportNumber;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date passportIssuedDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date passportExpiryDate;

    protected String passportCountryOfIssuance;

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

    @Override
    public String toString() {
        return "Passport{" + "passportNumber=" + passportNumber + ", passportIssuedDate=" + passportIssuedDate + ", passportExpiryDate=" + passportExpiryDate + ", passportCountryOfIssuance=" + passportCountryOfIssuance + '}';
    }

}
