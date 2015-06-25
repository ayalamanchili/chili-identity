/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorizationtransactions;

/**
 *
 * @author prasanthi.p
 */
public enum TravelAuthorizationStatus {

    PENDING_MANAGER_APPROVAL,
    PENDING_CEO_APPROVAL,
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
