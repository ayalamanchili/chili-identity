/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

/**
 *
 * @author ayalamanchili
 */
public interface TravelAuthConstants {

    int DEFAULT_FIELD_WIDTH = 340;
    int DEFAULT_PMT_TYPE_WIDTH = 290;
    // Travel Transportation Panel
    String TRAVEL_TRANSPORTATION_TYPE="travelTransportationType";
    String TOTAL_MILES="totalMiles";
    String COST_PER_MILE = "costPerMile";
    String TOTAL_TRANSPORTATION_COST = "totalTransportationCost";
    String ESTIMATED_COST_OF_OTHER_TRANSPORTATION = "estimatedCostOfOtherTransportation";
    String RENTAL_VEHICLE_JUSTIFICATION = "rentalVehicleJustification";
    String TRAVEL_RENTAL_VEHICLE_TYPE = "travelRentalVehicleType";                        
    String OTHER_VEHICLE_TYPE_JUSTIFICATION = "otherVehicleTypeJustification";
    String EXPENSE_PAYMENT_TYPE = "expensePaymentType";  
    // Travel Accommodation Panel
    String NUM_OF_LODGING_NIGHTS="numberOfLodgingNights";
    String LODGING_COST_PER_NIGHT="lodgingCostPerNight";
    String TOTAL_LODGING_COST = "totalLodgingCost";
    // Travel Food Panel
    String TOTAL_COST_OF_FOOD = "totalCostOfFood";
    String CONFERENCE_FEE = "conferenceFee";
    String TOTAL_COST_OF_BANQUET = "totalCostOfBanquet";
    String OTHER_EXPENCES = "otherExpences";
    String FOOD_EXPENSE_PAYMENT_TYPE="foodExpensePaymentMode";
    String CONFERENCE_EXPENSE_PAYMENT_TYPE="conferenceExpensePaymentMode";
    String BANQUET_EXPENSE_PAYMENT_TYPE="banquetExpensePaymentMode";
    String OTHER_EXPENSE_PAYMENT_TYPE="otherExpensePaymentMode";
}
