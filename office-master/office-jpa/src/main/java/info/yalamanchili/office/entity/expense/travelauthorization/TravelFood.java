/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.travelauthorization;

import info.chili.jpa.AbstractEntity;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author Madhu.Badiginchala
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class TravelFood extends AbstractEntity {

    private static long serialVersionUID = 1L;
    /**
     *
     *
     */
    protected BigDecimal totalCostOfFood;
    /**
     *
     *
     */
    protected BigDecimal conferenceFee;
    /**
     *
     *
     */
    protected BigDecimal totalCostOfBanquet;
    /**
     *
     *
     */
    protected BigDecimal otherExpences;
    /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.pay.type.not.empty.msg}")
    protected TravelTransportationPayType travelTransportationPayType;
    /**
     *
     *
     */
    public TravelFood() {
    }

    public BigDecimal getTotalCostOfFood() {
        return totalCostOfFood;
    }

    public void setTotalCostOfFood(BigDecimal totalCostOfFood) {
        this.totalCostOfFood = totalCostOfFood;
    }

    public BigDecimal getConferenceFee() {
        return conferenceFee;
    }

    public void setConferenceFee(BigDecimal conferenceFee) {
        this.conferenceFee = conferenceFee;
    }

    public BigDecimal getTotalCostOfBanquet() {
        return totalCostOfBanquet;
    }

    public void setTotalCostOfBanquet(BigDecimal totalCostOfBanquet) {
        this.totalCostOfBanquet = totalCostOfBanquet;
    }

    public BigDecimal getOtherExpences() {
        return otherExpences;
    }

    public void setOtherExpences(BigDecimal otherExpences) {
        this.otherExpences = otherExpences;
    }

    public TravelTransportationPayType getTravelTransportationPayType() {
        return travelTransportationPayType;
    }

    public void setTravelTransportationPayType(TravelTransportationPayType travelTransportationPayType) {
        this.travelTransportationPayType = travelTransportationPayType;
    }

    @Override
    public String toString() {
        return "TravelFood{" + "totalCostOfFood=" + totalCostOfFood + ", conferenceFee=" + conferenceFee + ", totalCostOfBanquet=" + totalCostOfBanquet + ", otherExpences=" + otherExpences + ", travelTransportationPayType=" + travelTransportationPayType + '}';
    }
    
}
