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
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Kishore.Chigurupati
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class StayPeriodInfo extends AbstractHandleEntity {

    @NotEmpty(message = "{immigration.name.not.empty.msg}")
    protected String name;

    @Temporal(TemporalType.DATE)
    protected Date fromDate;

    @Temporal(TemporalType.DATE)
    private Date toDate;

    protected String immigrantStatus;

    protected String purpose;

    /**
     *
     */
    protected Boolean otherCitizenship;

    protected String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getImmigrantStatus() {
        return immigrantStatus;
    }

    public void setImmigrantStatus(String immigrantStatus) {
        this.immigrantStatus = immigrantStatus;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Boolean getOtherCitizenship() {
        return otherCitizenship;
    }

    public void setOtherCitizenship(Boolean otherCitizenship) {
        this.otherCitizenship = otherCitizenship;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "StayPeriodInfo{" + "name=" + name + ", fromDate=" + fromDate + ", toDate=" + toDate + ", immigrantStatus=" + immigrantStatus + ", purpose=" + purpose + ", otherCitizenship=" + otherCitizenship + ", country=" + country + '}';
    }
}
