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
public class TravelAccommodation implements Serializable {

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
    protected ExpensePaymentType expenseAccommodationPaymentType;
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

    public ExpensePaymentType getExpenseAccommodationPaymentType() {
        return expenseAccommodationPaymentType;
    }

    public void setExpenseAccommodationPaymentType(ExpensePaymentType expenseAccommodationPaymentType) {
        this.expenseAccommodationPaymentType = expenseAccommodationPaymentType;
    }

    @Override
    public String toString() {
        return "TravelAccommodation{" + "numberOfLodgingNights=" + numberOfLodgingNights + ", lodgingCostPerNight=" + lodgingCostPerNight + ", totalLodgingCost=" + totalLodgingCost + ", travelTransportationPayType=" + expenseAccommodationPaymentType + '}';
    }
    
}
