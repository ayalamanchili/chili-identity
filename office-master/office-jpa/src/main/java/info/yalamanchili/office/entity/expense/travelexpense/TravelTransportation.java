/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.travelexpense;

import java.math.BigDecimal;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TravelTransportation {
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.type.not.empty.msg}")
    private TravelTransportationType travelTransportationType;
   
    @NotNull(message = "{amount.not.empty.msg}")
    private BigDecimal totalTransportationcost;
    
    private BigDecimal totalMiles;
    private BigDecimal costPerMile;
    
    private TravelRentalVehicleJustification travelRentalVehicleJustification;
    
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.pay.type.not.empty.msg}")
    private TravelTransportationPayType travelTransportationPayType;

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
    
   
}
