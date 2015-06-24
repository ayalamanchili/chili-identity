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
public class TravelAccommodation extends AbstractEntity {

    private static long serialVersionUID = 1L;
    /**
     *
     *
     */
    protected BigDecimal numberOfLodgingNights;
    /**
     *
     *
     */
    protected BigDecimal lodgingCostPerNight;
    /**
     *
     *
     */
    protected BigDecimal totalLodgingCost;
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
    public TravelAccommodation() {
    }

    public BigDecimal getNumberOfLodgingNights() {
        return numberOfLodgingNights;
    }

    public void setNumberOfLodgingNights(BigDecimal numberOfLodgingNights) {
        this.numberOfLodgingNights = numberOfLodgingNights;
    }

    public BigDecimal getLodgingCostPerNight() {
        return lodgingCostPerNight;
    }

    public void setLodgingCostPerNight(BigDecimal lodgingCostPerNight) {
        this.lodgingCostPerNight = lodgingCostPerNight;
    }

    public BigDecimal getTotalLodgingCost() {
        return totalLodgingCost;
    }

    public void setTotalLodgingCost(BigDecimal totalLodgingCost) {
        this.totalLodgingCost = totalLodgingCost;
    }

    public TravelTransportationPayType getTravelTransportationPayType() {
        return travelTransportationPayType;
    }

    public void setTravelTransportationPayType(TravelTransportationPayType travelTransportationPayType) {
        this.travelTransportationPayType = travelTransportationPayType;
    }

    @Override
    public String toString() {
        return "TravelAccommodation{" + "numberOfLodgingNights=" + numberOfLodgingNights + ", lodgingCostPerNight=" + lodgingCostPerNight + ", totalLodgingCost=" + totalLodgingCost + ", travelTransportationPayType=" + travelTransportationPayType + '}';
    }
    
}
