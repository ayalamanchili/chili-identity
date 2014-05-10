/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense;

import info.chili.jpa.AbstractHandleEntity;
import info.yalamanchili.office.entity.profile.Address;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(name = "OCheck")
public class Check extends AbstractHandleEntity {

    private static final long serialVersionUID = 1L;
    /**
     * payableTo
     */
    protected String payableTo;
    /**
     * amount
     */
    protected BigDecimal amount;
    /**
     * check Mailing Address
     */
    @OneToOne(cascade = CascadeType.ALL)
    protected Address checkMalingAddress;
    /**
     * notes
     */
    @Lob
    protected String notes;
    /**
     * checkImageUrl
     */
    protected String checkImageUrl;

    public String getPayableTo() {
        return payableTo;
    }

    public void setPayableTo(String payableTo) {
        this.payableTo = payableTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @XmlElement
    public Address getCheckMalingAddress() {
        return checkMalingAddress;
    }

    public void setCheckMalingAddress(Address checkMalingAddress) {
        this.checkMalingAddress = checkMalingAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCheckImageUrl() {
        return checkImageUrl;
    }

    public void setCheckImageUrl(String checkImageUrl) {
        this.checkImageUrl = checkImageUrl;
    }

}
