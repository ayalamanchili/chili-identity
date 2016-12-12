/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.travelauthorization;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author Madhu.Badiginchala
 */
@Embeddable
@Audited
@XmlType
public class TravelTransportation implements Serializable {

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
    protected BigDecimal totalTransportationCost;
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
    @Embedded
    protected TravelRentalVehicleJustification travelRentalVehicleJustification;
    /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.pay.type.not.empty.msg}")
    protected ExpensePaymentType expensePaymentType;

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

    public BigDecimal getTotalTransportationCost() {
        return totalTransportationCost;
    }

    public void setTotalTransportationCost(BigDecimal totalTransportationCost) {
        this.totalTransportationCost = totalTransportationCost;
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

    public ExpensePaymentType getExpensePaymentType() {
        return expensePaymentType;
    }

    public void setExpensePaymentType(ExpensePaymentType expenseTransPaymentType) {
        this.expensePaymentType = expenseTransPaymentType;
    }

    @Override
    public String toString() {
        return "TravelTransportation{" + "travelTransportationType=" + travelTransportationType + ", totalTransportationcost=" + totalTransportationCost + ", totalMiles=" + totalMiles + ", costPerMile=" + costPerMile + ", travelRentalVehicleJustification=" + travelRentalVehicleJustification + ", travelTransportationPayType=" + expensePaymentType + '}';
    }

}
