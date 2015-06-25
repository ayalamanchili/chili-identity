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
public class TravelFood implements Serializable {

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
    protected ExpensePaymentType expensePaymentType;

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

    public ExpensePaymentType getExpensePaymentType() {
        return expensePaymentType;
    }

    public void setExpensePaymentType(ExpensePaymentType expensePaymentType) {
        this.expensePaymentType = expensePaymentType;
    }

    @Override
    public String toString() {
        return "TravelFood{" + "totalCostOfFood=" + totalCostOfFood + ", conferenceFee=" + conferenceFee + ", totalCostOfBanquet=" + totalCostOfBanquet + ", otherExpences=" + otherExpences + ", travelTransportationPayType=" + expensePaymentType + '}';
    }

}
