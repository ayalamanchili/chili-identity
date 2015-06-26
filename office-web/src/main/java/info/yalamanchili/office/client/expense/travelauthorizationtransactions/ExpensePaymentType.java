/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorizationtransactions;

/**
 *
 * @author prasanthi.p
 */
public enum ExpensePaymentType {

    EMPLOYEE_EXPENSE,
    PURCHASING_CARD,
    PO;

    public static String[] names() {
        ExpensePaymentType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
