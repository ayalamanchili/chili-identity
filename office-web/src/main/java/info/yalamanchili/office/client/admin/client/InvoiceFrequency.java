/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

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
    SCHEDULED,
    MONTHLY,
    MONTHLY_LAST_FRIDAY,
    MONTHLY_LAST_SATURDAY,
    MONTHLY_EVERY_4_WEEKS,
    WEEKLY_CSV_EXCEL_SHEET,
    MONTHLY_FIRST_SUNDAY,
    WEEKLY_TO_BE_UPLOADED,
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
