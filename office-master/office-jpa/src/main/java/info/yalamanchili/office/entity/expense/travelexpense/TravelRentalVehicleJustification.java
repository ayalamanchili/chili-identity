/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.travelexpense;

import java.math.BigDecimal;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TravelRentalVehicleJustification {
    private BigDecimal estimatedCostOfOtherTransportation;
    @Lob
    private String rentalVehicleJustification;
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.rentalvehicle.type.not.empty.msg}")
    private TravelRentalVehicleType travelRentalVehicleType;
    @Lob
    private String otherVehicleTypeJustification;

    public BigDecimal getEstimatedCostOfOtherTransportation() {
        return estimatedCostOfOtherTransportation;
    }

    public void setEstimatedCostOfOtherTransportation(BigDecimal estimatedCostOfOtherTransportation) {
        this.estimatedCostOfOtherTransportation = estimatedCostOfOtherTransportation;
    }

    public String getRentalVehicleJustification() {
        return rentalVehicleJustification;
    }

    public void setRentalVehicleJustification(String rentalVehicleJustification) {
        this.rentalVehicleJustification = rentalVehicleJustification;
    }

    public TravelRentalVehicleType getTravelRentalVehicleType() {
        return travelRentalVehicleType;
    }

    public void setTravelRentalVehicleType(TravelRentalVehicleType travelRentalVehicleType) {
        this.travelRentalVehicleType = travelRentalVehicleType;
    }

    public String getOtherVehicleTypeJustification() {
        return otherVehicleTypeJustification;
    }

    public void setOtherVehicleTypeJustification(String otherVehicleTypeJustification) {
        this.otherVehicleTypeJustification = otherVehicleTypeJustification;
    }
    
    
}
