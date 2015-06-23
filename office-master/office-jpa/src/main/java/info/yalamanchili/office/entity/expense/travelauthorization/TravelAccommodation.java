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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TravelAccommodation extends AbstractEntity {

    private static long serialVersionUID = 1L;
    /**
     *
     *
     */
    private BigDecimal numberOfLodgingNights;
    /**
     *
     *
     */
    private BigDecimal lodgingCostPerNight;
    /**
     *
     *
     */
    private BigDecimal totalLodgingCost;
    /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.pay.type.not.empty.msg}")
    private TravelTransportationPayType travelTransportationPayType;

    /**
     *
     *
     */
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
}
