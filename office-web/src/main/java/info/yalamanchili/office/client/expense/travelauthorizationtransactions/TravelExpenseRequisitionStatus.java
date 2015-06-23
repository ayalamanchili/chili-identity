/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorizationtransactions;

/**
 *
 * @author prasanthi.p
 */
public enum TravelExpenseRequisitionStatus {

    PENDING_INITIAL_APPROVAL,
    PENDING_FINAL_APPROVAL,
    APPROVED,
    REJECTED;

    public static String[] names() {
        TravelExpenseRequisitionStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
