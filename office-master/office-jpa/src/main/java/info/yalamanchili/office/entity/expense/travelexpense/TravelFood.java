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
public class TravelFood {
    
    private BigDecimal totalCostOfFood;
    private BigDecimal conferenceFee;
    private BigDecimal totalCostOfBanquet;
    private BigDecimal otherExpences;
    
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.pay.type.not.empty.msg}")
    private TravelTransportationPayType travelTransportationPayType;

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
    
    
    
}
