/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import info.yalamanchili.office.client.expensereports.ExpensePaymentMode;
import static info.yalamanchili.office.client.expensereports.ExpensePaymentMode.values;

/**
 *
 * @author Madhu.Badiginchala
 */
public enum InvoiceFrequency {

    WEEKLY,
    WEEKLY_ENDING_FRIDAY,
    WEEKLY_ENDING_SUNDAY,
    WEEKLY_MON_TO_SUN,
    BI_WEEKLY,
    MONTHLY,
    MONTHLY_LAST_FRIDAY,
    MONTHLY_LAST_SATURDAY,
    MONTHLY_FIRST_SUNDAY,
    SEMI_MONTHLY,
    NOT_REQUIRED;

    public static String[] names() {
        InvoiceFrequency[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

}
