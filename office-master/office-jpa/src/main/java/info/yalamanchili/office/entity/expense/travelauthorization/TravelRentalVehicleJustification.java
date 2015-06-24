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
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TravelRentalVehicleJustification extends AbstractEntity {

    private static long serialVersionUID = 1L;
    /**
     *
     *
     */
    protected BigDecimal estimatedCostOfOtherTransportation;
    /**
     *
     *
     */
    @Lob
    protected String rentalVehicleJustification;
    /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.rentalvehicle.type.not.empty.msg}")
    protected TravelRentalVehicleType travelRentalVehicleType;
    /**
     *
     *
     */
    @Lob
    protected String otherVehicleTypeJustification;
    /**
     *
     *
     */
    public TravelRentalVehicleJustification() {
    }

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

    @Override
    public String toString() {
        return "TravelRentalVehicleJustification{" + "estimatedCostOfOtherTransportation=" + estimatedCostOfOtherTransportation + ", rentalVehicleJustification=" + rentalVehicleJustification + ", travelRentalVehicleType=" + travelRentalVehicleType + ", otherVehicleTypeJustification=" + otherVehicleTypeJustification + '}';
    }
    
}
