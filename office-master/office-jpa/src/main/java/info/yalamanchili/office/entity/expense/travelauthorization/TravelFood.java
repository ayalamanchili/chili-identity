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
    protected ExpensePaymentType foodExpensePaymentMode;
     /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.pay.type.not.empty.msg}")
    protected ExpensePaymentType conferenceExpensePaymentMode;
     /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.pay.type.not.empty.msg}")
    protected ExpensePaymentType banquetExpensePaymentMode;
     /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.transportation.pay.type.not.empty.msg}")
    protected ExpensePaymentType otherExpensePaymentMode;

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

    public ExpensePaymentType getFoodExpensePaymentMode() {
        return foodExpensePaymentMode;
    }

    public void setFoodExpensePaymentMode(ExpensePaymentType foodExpensePaymentMode) {
        this.foodExpensePaymentMode = foodExpensePaymentMode;
    }

    public ExpensePaymentType getConferenceExpensePaymentMode() {
        return conferenceExpensePaymentMode;
    }

    public void setConferenceExpensePaymentMode(ExpensePaymentType conferenceExpensePaymentMode) {
        this.conferenceExpensePaymentMode = conferenceExpensePaymentMode;
    }

    public ExpensePaymentType getBanquetExpensePaymentMode() {
        return banquetExpensePaymentMode;
    }

    public void setBanquetExpensePaymentMode(ExpensePaymentType banquetExpensePaymentMode) {
        this.banquetExpensePaymentMode = banquetExpensePaymentMode;
    }

    public ExpensePaymentType getOtherExpensePaymentMode() {
        return otherExpensePaymentMode;
    }

    public void setOtherExpensePaymentMode(ExpensePaymentType otherExpensePaymentMode) {
        this.otherExpensePaymentMode = otherExpensePaymentMode;
    }

    @Override
    public String toString() {
        return "TravelFood{" + "totalCostOfFood=" + totalCostOfFood + ", conferenceFee=" + conferenceFee + ", totalCostOfBanquet=" + totalCostOfBanquet + ", otherExpences=" + otherExpences + ", foodExpensePaymentMode=" + foodExpensePaymentMode + ", conferenceExpensePaymentMode=" + conferenceExpensePaymentMode + ", banquetExpensePaymentMode=" + banquetExpensePaymentMode + ", otherExpensePaymentMode=" + otherExpensePaymentMode + '}';
    }
}
