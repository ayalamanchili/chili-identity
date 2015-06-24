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
import javax.persistence.Table;
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
public class TravelTransportation extends AbstractEntity {

    private static long serialVersionUID = 1L;
    /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.type.not.empty.msg}")
    protected TravelTransportationType travelTransportationType;
    /**
     *
     *
     */
    protected BigDecimal totalTransportationcost;
    /**
     *
     *
     */
    protected BigDecimal totalMiles;
    /**
     *
     *
     */
    protected BigDecimal costPerMile;
    /**
     *
     *
     */
    protected TravelRentalVehicleJustification travelRentalVehicleJustification;
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
    public TravelTransportation() {
    }

    public TravelTransportationType getTravelTransportationType() {
        return travelTransportationType;
    }

    public void setTravelTransportationType(TravelTransportationType travelTransportationType) {
        this.travelTransportationType = travelTransportationType;
    }

    public BigDecimal getTotalTransportationcost() {
        return totalTransportationcost;
    }

    public void setTotalTransportationcost(BigDecimal totalTransportationcost) {
        this.totalTransportationcost = totalTransportationcost;
    }

    public BigDecimal getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(BigDecimal totalMiles) {
        this.totalMiles = totalMiles;
    }

    public BigDecimal getCostPerMile() {
        return costPerMile;
    }

    public void setCostPerMile(BigDecimal costPerMile) {
        this.costPerMile = costPerMile;
    }

    public TravelRentalVehicleJustification getTravelRentalVehicleJustification() {
        return travelRentalVehicleJustification;
    }

    public void setTravelRentalVehicleJustification(TravelRentalVehicleJustification travelRentalVehicleJustification) {
        this.travelRentalVehicleJustification = travelRentalVehicleJustification;
    }

    public TravelTransportationPayType getTravelTransportationPayType() {
        return travelTransportationPayType;
    }

    public void setTravelTransportationPayType(TravelTransportationPayType travelTransportationPayType) {
        this.travelTransportationPayType = travelTransportationPayType;
    }

    @Override
    public String toString() {
        return "TravelTransportation{" + "travelTransportationType=" + travelTransportationType + ", totalTransportationcost=" + totalTransportationcost + ", totalMiles=" + totalMiles + ", costPerMile=" + costPerMile + ", travelRentalVehicleJustification=" + travelRentalVehicleJustification + ", travelTransportationPayType=" + travelTransportationPayType + '}';
    }
    
}
