/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

/**
 *
 * @author prasanthi.p
 */
public enum TravelAuthorizationStatus {

    PENDING_MANAGER_APPROVAL,
    PENDING_CEO_APPROVAL,
    PENDING_TRAVEL_BOOKING,
    APPROVED,
    REJECTED;

    public static String[] names() {
        TravelAuthorizationStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
